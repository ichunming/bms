/**
 * @author ming
 * @date 2017年2月7日 下午5:47:26
 */
package com.ichunming.bms.entity;

import com.ichunming.bms.constant.MessageType;

public class Message {
	private String clz;
	
	private String content;

	public Message(){}
	
	public Message(String content) {
		this.clz = MessageType.INFO.getClazz();
		this.content = content;
	}
	
	public Message(String clz, String content) {
		this.clz = clz;
		this.content = content;
	}
	
	public String getClz() {
		return clz;
	}

	public void setClz(String clz) {
		this.clz = clz;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}