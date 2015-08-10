package com.sample.view.annotation;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.AbstractUrlBasedView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 
 * @author guangqingzhong
 * 
 */
@Component
public class SwfFileView extends AbstractUrlBasedView {

	// default content type
	private final static String CONTENT_TYPE = "application/x-shockwave-flash";

	//content of http response
	private String responseContent;

	public SwfFileView() {
		super();
		setContentType(CONTENT_TYPE);
	}


	@Override
	protected void renderMergedOutputModel(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType(getContentType());
		response.getWriter().write(this.responseContent);
		response.getWriter().close();
	}

	/**
	 * Set http request content
	 * @param responseContent
	 */
	public void setResponseContent(String responseContent) {
		this.responseContent = responseContent;
	} 

}
