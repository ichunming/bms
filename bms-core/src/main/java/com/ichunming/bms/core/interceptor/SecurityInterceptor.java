package com.ichunming.bms.core.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ichunming.bms.constant.SystemSettings;
import com.ichunming.bms.core.helper.AgentHelper;
import com.ichunming.bms.entity.BmsSessionInfo;
import com.ichunming.common.helper.SessionInfo;
import com.ichunming.common.util.SessionUtil;

public class SecurityInterceptor extends HandlerInterceptorAdapter{
	private static Logger logger = LoggerFactory.getLogger(SecurityInterceptor.class);

	private String noSessionUrl;
	
	public String getNoSessionUrl() {
		return noSessionUrl;
	}

	public void setNoSessionUrl(String noSessionUrl) {
		this.noSessionUrl = noSessionUrl;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		SessionInfo sessionInfo = SessionUtil.getSessionInfo(request);
		// DEBUG MODE
		String agent = request.getHeader("user-agent");
		logger.debug("agent:" + (AgentHelper.isPcDevice(agent) ? "PC" : "Mobile"));
		if(SystemSettings.DEBUG_MODE) {
			sessionInfo = new BmsSessionInfo("0", "test", null);
			
			SessionUtil.setSessionInfo(sessionInfo, request);
		}
		if (null == sessionInfo) {
			logger.debug("No Session." );
			logger.debug("redirect to " + noSessionUrl);
			response.sendRedirect(noSessionUrl);
			return false;
		}
		
		return true;
	}
}