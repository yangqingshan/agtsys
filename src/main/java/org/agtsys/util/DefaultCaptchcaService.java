package org.agtsys.util;

import java.awt.Color;

import com.github.bingoohuang.patchca.background.SingleColorBackgroundFactory;
import com.github.bingoohuang.patchca.color.SingleColorFactory;
import com.github.bingoohuang.patchca.filter.predefined.CurvesRippleFilterFactory;
import com.github.bingoohuang.patchca.font.RandomFontFactory;
import com.github.bingoohuang.patchca.service.AbstractCaptchaService;
import com.github.bingoohuang.patchca.text.renderer.BestFitTextRenderer;
import com.github.bingoohuang.patchca.word.RandomWordFactory;

public class DefaultCaptchcaService extends AbstractCaptchaService {
	public  DefaultCaptchcaService(){
		RandomFontFactory font=new RandomFontFactory();
		font.setMaxSize(20);
		font.setMinSize(20);
		fontFactory=font;
		RandomWordFactory word=new RandomWordFactory();
		word.setMaxLength(4);
		word.setMinLength(4);
		wordFactory=word;
		colorFactory=new SingleColorFactory(Color.BLUE);
		backgroundFactory=new SingleColorBackgroundFactory();
		textRenderer=new BestFitTextRenderer();
		filterFactory=new CurvesRippleFilterFactory(colorFactory);
		width=60;
		height=22;
	}
}
