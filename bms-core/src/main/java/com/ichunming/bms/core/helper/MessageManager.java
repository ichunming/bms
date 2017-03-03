/**
 * @author ming
 * @date 2017年2月7日 下午4:52:52
 */
package com.ichunming.bms.core.helper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ichunming.bms.constant.MessageType;
import com.ichunming.bms.entity.Message;
import com.ichunming.common.util.PropUtil;
import com.ichunming.common.util.StringUtil;

public class MessageManager {
	private MessageManager(){}
	
	private final static Logger logger = LoggerFactory.getLogger(MessageManager.class);
	
	private static Map<String, String> messages = null;
	
	public static void init(String msgPath) {
		if(StringUtil.isEmpty(msgPath) || messages != null || !(new File(msgPath).exists())) {
			return;
		}
		try {
			logger.debug("load message.properties:" + msgPath);
			messages = new PropUtil().read(msgPath);
		} catch (IOException e) {
			logger.error("load message.properties fail.");
		}
	}
	
	public static void destory() {
		if(messages != null) {
			logger.debug("destory messages...");
			messages.clear();
			messages = null;
		}
	}
	
	public static Message getSucc(String code) {
		return getMsg(code.toString(), MessageType.SUCC);
	}
	
	public static Message getInfo(String code) {
		return getMsg(code.toString(), MessageType.INFO);
	}
	
	public static Message getWarn(String code) {
		return getMsg(code.toString(), MessageType.WARN);
	}
	
	public static Message getError(String code) {
		return getMsg(code.toString(), MessageType.ERROR);
	}
	
	public static Message getMsg(String code) {
		Message message = MessageManager.getWarn(code);
		if(!StringUtil.isEmpty(message.getContent())) {
			return message;
		}
		
		message = MessageManager.getInfo(code);
		if(!StringUtil.isEmpty(message.getContent())) {
			return message;
		}
		
		message = MessageManager.getError(code);
		if(!StringUtil.isEmpty(message.getContent())) {
			return message;
		}
		
		message = MessageManager.getSucc(code);
		if(!StringUtil.isEmpty(message.getContent())) {
			return message;
		}
		
		return null;
	}
	
	private static Message getMsg(String code, MessageType type) {
		if(null == messages || messages.isEmpty()) {
			return null;
		}
		Message message = new Message(type.getClazz(), messages.get(type.getCode() + code));
		return message;
	}
}
