package org.agtsys.service;

import java.io.OutputStream;

public interface CaptchcaService {
	String generate_captchca(OutputStream os) throws Exception;
}
