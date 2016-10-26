package org.agtsys.service;

import java.util.List;

import org.agtsys.dao.FunctionMapper;
import org.agtsys.domain.Function;
import org.agtsys.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class FunctionServiceImpl implements FunctionService {
	@Autowired
	private FunctionMapper functionMapper;
	
	public List<Function> getFunctionByRole(Role role) throws Exception {
		
		return functionMapper.getFunctionByRole(role);
	}

}
