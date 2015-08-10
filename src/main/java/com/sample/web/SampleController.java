/*******************************************************************************************
 * (C) COPYRIGHT IBM Corporation 2009, 2010, 2011, 2012
 * All Rights Reserved. 
 *
 * Licensed Materials-Property of IBM																				
 ******************************************************************************************/
package com.sample.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author guangqingzhong
 *
 */
@Controller
public class SampleController {

	 @RequestMapping("/jsp/sample")
	 public String getSampleJsp() {
		 return "SampleJsp";
	 }
	 
	 @RequestMapping("/config/sample.config")
	 public String getSampleConfig() {
		 return "SampleConfig.config";
	 }
	 
	 
	 @RequestMapping("/swf/sample.swf")
	 public String getSampleSwf() {
		 return "SampleSwf.swf";
	 }
	 
}
