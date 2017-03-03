/**
 * @author ming
 * @date 2017年2月7日 上午10:08:01
 */
package com.ichunming.bms.service;

import com.ichunming.bms.vo.BaseResult;
import com.ichunming.bms.vo.BmsUserForm;

public interface IBmsUserService {
	/**
	 * 用户登录
	 * @param userForm
	 */
	public BaseResult login(BmsUserForm userForm);
}