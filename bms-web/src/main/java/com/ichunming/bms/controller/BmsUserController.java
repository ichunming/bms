/**
 * @author ming
 * @date 2017年2月7日 上午10:09:24
 */
package com.ichunming.bms.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ichunming.bms.constant.ErrorCode;
import com.ichunming.bms.core.helper.MessageManager;
import com.ichunming.bms.entity.BmsSessionInfo;
import com.ichunming.bms.service.IBmsUserService;
import com.ichunming.bms.vo.BaseResult;
import com.ichunming.bms.vo.BmsUserForm;
import com.ichunming.common.util.SessionUtil;
import com.ichunming.common.util.StringUtil;


@Controller
@RequestMapping("/user")
public class BmsUserController {
	private static final Logger logger = LoggerFactory.getLogger(BmsUserController.class);
	
	@Autowired
	private IBmsUserService userService;
	
	/**
	 * 用户登入
	 * @param userForm
	 * @return
	 */
	@RequestMapping(value = "login", method = {RequestMethod.GET, RequestMethod.POST})
	public String login(BmsUserForm userForm, HttpServletRequest request, Model model) {
		logger.debug("login request...");
		
		// check SessionInfo
		BmsSessionInfo sessionInfo = (BmsSessionInfo) SessionUtil.getSessionInfo(request);
		if(null != sessionInfo && null != sessionInfo.getUid()) {
			// already login
			logger.debug("already login.");
			return "redirect:/home/index";
		}
		
		// check parameter
		logger.debug("check parameter...");
		if((StringUtil.isEmpty(userForm.getUsername())) || StringUtil.isEmpty(userForm.getPassword())) {
			return "login";
		}
		
		// login
		logger.debug("parameter:username[" + userForm.getUsername() + "], password[" + userForm.getPassword() + "]");
		BaseResult result = userService.login(userForm);
		
		if(result.getCode().longValue() == ErrorCode.SUCCESS) {
			// success
			logger.debug("login success.");
			// save SessionInfo
			logger.debug("save session info...");
			sessionInfo = new BmsSessionInfo("0", userForm.getUsername(), null);
			SessionUtil.setSessionInfo(sessionInfo, request);
			
			// save cookie -- TODO
			
			return "redirect:/home/index";
		} else {
			// fail
			logger.debug("login fail.");
			model.addAttribute("msg", MessageManager.getMsg(result.getCode().toString()));
			return "login";
		}
	}
	
	/**
	 * 用户登出
	 * @return
	 */
	@RequestMapping(value = "logout", method={RequestMethod.GET, RequestMethod.POST})
	public String logout(HttpServletRequest request) {
		logger.debug("logout request...");
		SessionUtil.setSessionInfoExpired(request);
		
		return "login";
	}
}