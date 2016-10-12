package org.agtsys.service;

import java.util.List;

import org.agtsys.domain.Systemconfig;

public interface SystemconfigService {
	List<Systemconfig> selectSystemconfigByConfigType(Systemconfig systemconfig)throws Exception;
	Systemconfig selectSystemconfigById(Systemconfig systemconfig)throws Exception;
	int insertSystemconfig(Systemconfig systemconfig)throws Exception;
	Integer selectMaxTypeValueByConfigType(Systemconfig systemconfig)throws Exception;
	Integer deleteSystemconfig(Systemconfig systemconfig)throws Exception;
}