/**
 * @author ming
 * @date 2017年3月8日 下午2:33:11
 */
package com.ichunming.bms.entity;

import com.ichunming.common.helper.SessionInfo;

public class BmsSessionInfo extends SessionInfo {
	private Integer agent;

	public BmsSessionInfo() {}
	
	public BmsSessionInfo(String uid, String username, Integer agent) {
		super(uid, username);
		this.agent = agent;
	}
	
	public Integer getAgent() {
		return agent;
	}

	public void setAgent(Integer agent) {
		this.agent = agent;
	}
}
