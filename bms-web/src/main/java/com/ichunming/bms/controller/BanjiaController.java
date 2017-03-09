/**
 * @author ming
 * @date 2017年3月3日 上午10:09:24
 */
package com.ichunming.bms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/banjia")
public class BanjiaController {
	private static final Logger logger = LoggerFactory.getLogger(BanjiaController.class);
	
	@RequestMapping(value = "list", method = {RequestMethod.GET})
	public String index() {
		logger.debug("table list request...");
		
		return "table/list";
	}
}