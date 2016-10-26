package org.agtsys.dao;

import java.util.List;

import org.agtsys.domain.Function;
import org.agtsys.domain.Role;

public interface FunctionMapper {
	List<Function> getFunctionByRole(Role role) throws Exception;
}