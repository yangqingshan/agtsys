package org.agtsys.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.agtsys.Contants.WebContants;
import org.agtsys.domain.Role;
import org.agtsys.domain.User;
import org.agtsys.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("role/")
public class RoleController {
	@Autowired
	private RoleService roleService;
	//返回角色列表页面
	@RequestMapping("manage")
	public String getListPage() {
		return "rolelist";
	}
	//返回角色列表数据
	@RequestMapping("list")
	public @ResponseBody Object getRoles() throws Exception{
		return roleService.selectRoles();
	}
	//返回添加角色表单
		@RequestMapping("add")
		public String add() throws Exception{
			return "roleadd";
		}
		//返回添加角色表单
		@RequestMapping(value="check",method=RequestMethod.POST)
		public @ResponseBody String check(Role role) throws Exception{
			if(roleService.selectRoleByRole(role)==null){
				return WebContants.OPERATION_MESSAGE_SUCCESS;
			}else{
				return WebContants.OPERATION_MESSAGE_FAIL;
			}
		}
		//添加角色
		@RequestMapping(value="add",method=RequestMethod.POST)
		public @ResponseBody String doAdd(Role role,HttpSession session) throws Exception{
			User user=getSessionUser(session);
			role.setCreatedby(user.getUsercode());
			role.setCreationtime(new Date());
			if(roleService.addRole(role)==1){
				return WebContants.OPERATION_MESSAGE_SUCCESS;
			}else{
				return WebContants.OPERATION_MESSAGE_FAIL;
			}
		}
		
		//返回修改角色菜单
		@RequestMapping(value="update/{id}",method=RequestMethod.GET)
		public  String update(@PathVariable(value="id")Long id,Model model) throws Exception{
		Role role=new Role();
		role.setId(id);
		role=roleService.selectRoleByRole(role);
		model.addAttribute("role",role);
		return "roleupdate";
		}
		private User getSessionUser(HttpSession session) {
			return (User)session.getAttribute(WebContants.SESSION_LOGIN_KEY);
		}
		
		//修改角色
		@RequestMapping(value="update",method=RequestMethod.POST)
		public @ResponseBody String doUpdate(Role role) throws Exception{
			role.setLastupdatetime(new Date());
			if(roleService.updateRole(role)==1){
				return WebContants.OPERATION_MESSAGE_SUCCESS;
			}else{
				return WebContants.OPERATION_MESSAGE_FAIL;
			}
		}
		//返回删除角色菜单
		@RequestMapping(value="delete/{id}",method=RequestMethod.GET)
		public  @ResponseBody String delete(@PathVariable(value="id")Long id) throws Exception{
		Role role=new Role();
		role.setId(id);
		if(role.getId()==null)
				throw new Exception("删除角色时id为null。");
			if(roleService.deleteRole(role)==1){
				return WebContants.OPERATION_MESSAGE_SUCCESS;
			}else{
				return WebContants.OPERATION_MESSAGE_FAIL;
			}
		}
	}