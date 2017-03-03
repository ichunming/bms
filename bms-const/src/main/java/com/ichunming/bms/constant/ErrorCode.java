package com.ichunming.bms.constant;

public class ErrorCode {

	public static final Long SUCCESS = 0L;
	
	// 系统级错误码
	public static final Long ERR_SYS_INTERNAL_ERROR = 1000L;
	public static final Long ERR_SYS_REQUEST_MISSING_PARAMETER = 1001L;
	public static final Long ERR_SYS_REQUEST_INVALID_PARAMETER = 1002L;
	
	// 用户级错误码
	public static final Long ERR_USER_NO_SESSION = 2000L;
	public static final Long ERR_USER_ACCOUNT_ERROR = 2001L;
	
	// 管理级错误码
}
