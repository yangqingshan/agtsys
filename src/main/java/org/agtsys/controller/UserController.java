package org.agtsys.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.agtsys.Contants.WebContants;
import org.agtsys.ValidataGroups.LoginValidataGroup;
import org.agtsys.domain.Role;
import org.agtsys.domain.User;
import org.agtsys.service.RoleService;
import org.agtsys.service.UserService;
import org.agtsys.util.MySqlPageTool;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("user/")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private static Logger logger=Logger.getLogger(UserController.class);
	//跳转登录页面
	@RequestMapping(value="login",method=RequestMethod.GET)
	public String login(){
		return "login";
	}
	
	//返回用户管理页面
	@RequestMapping("manage")
	public String manage(Model model)throws Exception{
		List<Role> roles=roleService.selectRoles();
		if(logger.isDebugEnabled()){
			logger.debug("-------加载角色列表："+roles+"----------");
		}
		model.addAttribute("roles", roles);
		return "user_manage";
	}
	//返回用户管理页面
	@RequestMapping("list")
	public @ResponseBody Object  list(User user,Integer page,Integer rows)throws Exception{
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("total", userService.getCount(user));
		map.put("rows", userService.getPageUserByUser(user, new MySqlPageTool(page, rows)));
		return map;
	}
	
	//登录提交
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String dologin(String captchca,@Validated(value={LoginValidataGroup.class}) User user,BindingResult results,HttpServletRequest request ){
		String captchca_session=(String) request.getSession().getAttribute(WebContants.SESSION_CAPTCHCA_KEY);
		if(!captchca_session.equalsIgnoreCase(captchca)){
			request.setAttribute("captchca_errors", WebContants.CAPTCHCA_ERROR_MESSAGE);
			return "login";
		}
		if(results.hasErrors()){
			List<ObjectError> errors=results.getAllErrors();
			request.setAttribute("user_validate_errors", errors);
			return "login";
		}else{
			user=userService.getUserByUser(user);
			if(user!=null){
				request.getSession().setAttribute(WebContants.SESSION_LOGIN_KEY, user);
				return "main";
			}else{
				request.setAttribute("user_login_errors", WebContants.USER_LOGIN_ERROR);
				return "login";
			}
		}
	}
	//登出系统
	@RequestMapping(value="logout",method=RequestMethod.GET)
	public String logout(HttpSession session){
		session.removeAttribute(WebContants.SESSION_CAPTCHCA_KEY);
		return "redirect:login";
	}
	//返回修改密碼頁面
		@RequestMapping(value="pwd/update",method=RequestMethod.GET)
		public String updatePwdPage(){
			return "update_pwd";
		}
	//返回修改密碼頁面
	@RequestMapping(value="pwd/update",method=RequestMethod.POST)
	public @ResponseBody String doUpdatePwd(String userpassword,HttpSession session) throws Exception{
		User user=(User)session.getAttribute(WebContants.SESSION_LOGIN_KEY);
		user.setLastupdatetime(new Date());
		user.setUserpassword(userpassword);
		if(userService.updateUser(user)==1){
			return WebContants.OPERATION_MESSAGE_SUCCESS;
		}else{
			return WebContants.OPERATION_MESSAGE_FAIL;
		}
	}
	//返回修改密碼頁面
	@RequestMapping(value="pwd/check",method=RequestMethod.POST)
	public @ResponseBody String checkpwd(String pwd,HttpSession session){
		User user=(User)session.getAttribute(WebContants.SESSION_LOGIN_KEY);
		user.setUserpassword(pwd);
		//验证用户名和密码是否正确
		if(userService.getUserByUser(user)!=null){
			return WebContants.OPERATION_MESSAGE_SUCCESS;
		}else{
			return WebContants.OPERATION_MESSAGE_FAIL;
		}
	}
	
	//返回用户新增页面
	@RequestMapping(value="add",method=RequestMethod.GET)
	public  String  add(Model model)throws Exception{
		List<Role> roles=roleService.selectRoles();
		model.addAttribute("roles", roles);
		return "user_add";
	}
	
	//返回用户校验页面
	@RequestMapping(value="check",method=RequestMethod.POST)
	public @ResponseBody String checkUsercode(String usercode){
		User user=new User();
		user.setUsercode(usercode);
		//验证用户名和密码是否正确
		if(userService.getUserByUser(user)==null){
			return WebContants.OPERATION_MESSAGE_SUCCESS;
		}else{
			return WebContants.OPERATION_MESSAGE_FAIL;
		}
	}
	
	//进入主页面，仅测试用，上线前删除
	@RequestMapping(value="main",method=RequestMethod.GET)
	public String main(HttpSession session){
		User user=new User();
		user.setRoleid(1L);
		user.setUsercode("admin");
		user.setUserpassword("123456");
		user.setCreatedby("admin");
		session.setAttribute(WebContants.SESSION_LOGIN_KEY, user);
		return "main";
	}
}