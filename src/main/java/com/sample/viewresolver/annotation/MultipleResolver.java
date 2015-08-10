package com.sample.viewresolver.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.AbstractCachingViewResolver;

import javax.annotation.PostConstruct;
import java.util.Locale;
import java.util.Map;

@Component
public class MultipleResolver extends AbstractCachingViewResolver implements Ordered {

	@Autowired
	private ConfigFileResolver configFileResolver;
	@Autowired
	private SwfFileResolver swfFileResolver;

	private int order = 0;

	public int getOrder() {
		return order;
	}

	private Map<String, ViewResolver> resolvers;

	@PostConstruct
	public void afterInit(){
		resolvers.put("config", configFileResolver);
		resolvers.put("swf", swfFileResolver);
	}


	@Override
	protected View loadView(String viewName, Locale locale) throws Exception {
		String fileExtension = StringUtils.getFilenameExtension(viewName);
		// return null to invoke next resolver if no extension found
		if (fileExtension == null) {
			return null;
		}
		// get resolver by extension
		ViewResolver resolver = resolvers.get(fileExtension);
		//return null to invoke next resolver if no resolver found
		return resolver == null ? null : resolver.resolveViewName(viewName, locale);
	}

}
