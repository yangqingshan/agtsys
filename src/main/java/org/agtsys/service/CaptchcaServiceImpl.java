package org.agtsys.service;

import java.io.OutputStream;

import org.agtsys.util.Captchca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CaptchcaServiceImpl implements CaptchcaService {
	@Autowired
	private Captchca captchca;
	
	public String generate_captchca(OutputStream os) throws Exception {
		// TODO Auto-generated method stub
		return captchca.generate_captchca(os);
	}

}
