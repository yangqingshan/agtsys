package org.agtsys.controller;

import java.util.List;

import org.agtsys.domain.Systemconfig;
import org.agtsys.service.SystemconfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@RequestMapping("systemconfig/")
public class SystemconfigController {
	@Autowired
	private SystemconfigService systemconfigService;
	
	@RequestMapping(value="manage/{configtype}",method=RequestMethod.GET)
	public String getManage(@PathVariable Integer configtype,Model model)throws Exception{
		model.addAttribute("configtype", configtype);
		return "systemconfig_manage";
	}
	
	@RequestMapping(value="list/{configtype}")
	public @ResponseBody Object getList(@PathVariable Integer configtype)throws Exception{
		 Systemconfig  systemconfig=new  Systemconfig();
		 systemconfig.setConfigtype(configtype);
		 List<Systemconfig> scs=systemconfigService.selectSystemconfigByConfigType(systemconfig);
		return scs;
	}
}
