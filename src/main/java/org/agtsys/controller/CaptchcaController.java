package org.agtsys.controller;

import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.agtsys.Contants.WebContants;
import org.agtsys.service.CaptchcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("captchca/")
public class CaptchcaController {
	@Autowired
	private CaptchcaService captchcaService;
	
	@RequestMapping(value="get",method=RequestMethod.GET)
	public void getCaptchca(HttpServletResponse response,HttpServletRequest request) throws Exception{
		HttpSession session=request.getSession();
		OutputStream os=response.getOutputStream();
		String captchca=captchcaService.generate_captchca(os);
		session.setAttribute(WebContants.SESSION_CAPTCHCA_KEY, captchca);
		os.flush();
		os.close();
	}
	@ResponseBody
	@RequestMapping(value="check",method=RequestMethod.POST)
	public Object checkCaptchca(String captchca,HttpSession session){
		String cs=(String) session.getAttribute(WebContants.SESSION_CAPTCHCA_KEY);
		if(cs.equalsIgnoreCase(captchca)){
			return WebContants.OPERATION_MESSAGE_SUCCESS;
		}else{
			return WebContants.OPERATION_MESSAGE_FAIL;
		}
		
	}
}
