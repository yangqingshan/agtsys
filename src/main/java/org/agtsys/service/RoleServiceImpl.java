package org.agtsys.service;

import java.util.List;

import org.agtsys.dao.RoleMapper;
import org.agtsys.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleMapper roleMapper;
	
	public List<Role> selectRoles() throws Exception {
		return roleMapper.selectRoles();
	}

	public Role selectRoleByRole(Role role) throws Exception {
		return roleMapper.selectRoleByRole(role);
	}

	public int addRole(Role role) throws Exception {
		return roleMapper.addRole(role);
	}

	public int updateRole(Role role) throws Exception {
		return roleMapper.updateRole(role);
	}

	public int deleteRole(Role role) throws Exception {
		return roleMapper.deleteRole(role);
	}

}
