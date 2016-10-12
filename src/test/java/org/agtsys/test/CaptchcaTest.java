package org.agtsys.test;


import java.io.FileOutputStream;

import org.agtsys.util.DefaultImageCaptchca;
import org.junit.Before;
import org.junit.Test;

public class CaptchcaTest {
	private DefaultImageCaptchca dic;
	@Before
	public void setUp() throws Exception{
		dic=new DefaultImageCaptchca();
	}
	
	@Test
	public void test() throws Exception{
		FileOutputStream fos=new FileOutputStream("patcha_demo.png");
		String cs=dic.generate_captchca(fos);
		System.out.println(cs);
	}
}
