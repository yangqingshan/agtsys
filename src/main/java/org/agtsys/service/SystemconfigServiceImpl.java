package org.agtsys.service;

import java.util.List;

import org.agtsys.dao.SystemconfigMapper;
import org.agtsys.domain.Systemconfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class SystemconfigServiceImpl implements SystemconfigService {
	@Autowired
	private SystemconfigMapper systemconfigMapper;
	
	public List<Systemconfig> selectSystemconfigByConfigType(
			Systemconfig systemconfig) throws Exception {
		return systemconfigMapper.selectSystemconfigByConfigType(systemconfig);
	}

	public Systemconfig selectSystemconfigById(Systemconfig systemconfig)
			throws Exception {
		return systemconfigMapper.selectSystemconfigById(systemconfig);
	}

	public int insertSystemconfig(Systemconfig systemconfig) throws Exception {
		return systemconfigMapper.insertSystemconfig(systemconfig);
	}

	public Integer selectMaxTypeValueByConfigType(Systemconfig systemconfig)
			throws Exception {
		return systemconfigMapper.selectMaxTypeValueByConfigType(systemconfig);
	}

	public Integer deleteSystemconfig(Systemconfig systemconfig)
			throws Exception {
		return systemconfigMapper.deleteSystemconfig(systemconfig);
	}

}
