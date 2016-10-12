package org.agtsys.util;

import java.io.OutputStream;

import com.github.bingoohuang.patchca.service.CaptchaService;
import com.github.bingoohuang.patchca.utils.encoder.EncoderHelper;

public class DefaultImageCaptchca implements Captchca {
	private CaptchaService cs;
	public DefaultImageCaptchca(){
		cs=new DefaultCaptchcaService();
	}
	public String generate_captchca(OutputStream out) throws Exception {
		String captchca=EncoderHelper.getChallangeAndWriteImage(cs, "png", out);
		out.close();
		return captchca;
	}
	public CaptchaService getCs() {
		return cs;
	}
	public void setCs(CaptchaService cs) {
		this.cs = cs;
	}

}
