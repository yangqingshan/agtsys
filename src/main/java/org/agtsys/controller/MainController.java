package org.agtsys.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.agtsys.Contants.WebContants;
import org.agtsys.domain.EasyUINode;
import org.agtsys.domain.Function;
import org.agtsys.domain.Role;
import org.agtsys.domain.User;
import org.agtsys.service.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("main/")
public class MainController {
	@Autowired
	private FunctionService functionService;
	
	@RequestMapping(value="tree")
	public @ResponseBody Object getTree(HttpSession session)throws Exception{
		User user=(User) session.getAttribute(WebContants.SESSION_LOGIN_KEY);
		Role role=new Role();
		role.setId(user.getRoleid());
		List<Function> functions=functionService.getFunctionByRole(role);
		List<EasyUINode> nodes=new ArrayList<EasyUINode>();
		functionToEasyuinode(functions,nodes,0);
		return nodes;
	}

	private void functionToEasyuinode(List<Function> functions,List<EasyUINode> nodes, int parentId) {
		if(functions!=null){
			for(Function fun:functions){
				EasyUINode node=new EasyUINode();
				if(fun.getParentid().intValue()==parentId){
					node=fun.toEasyUINode();
					functionToEasyuinode(functions,node.getChildren(),fun.getId().intValue());
					nodes.add(node);
				}
			}
		}
	}
}
