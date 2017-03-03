/**
 * @author ming
 * @date 2017年2月7日 上午10:08:41
 */
package com.ichunming.bms.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ichunming.bms.constant.ErrorCode;
import com.ichunming.bms.entity.ApiConfiguration;
import com.ichunming.bms.service.IBmsUserService;
import com.ichunming.bms.vo.BaseResult;
import com.ichunming.bms.vo.BmsUserForm;
import com.ichunming.common.util.EncryptionUtil;

@Service
public class BmsUserServiceImpl implements IBmsUserService {
	private static final Logger logger = LoggerFactory.getLogger(BmsUserServiceImpl.class);

	@Autowired
	ApiConfiguration config;
	
	/* (non-Javadoc)
	 * @see com.ichunming.bms.service.IUserService#login(com.ichunming.bms.vo.UserForm)
	 */
	@Override
	public BaseResult login(BmsUserForm userForm) {

		// check user exist
		if(!config.getAdminName().equals(userForm.getUsername())) {
			logger.debug("user not exist.");
			return new BaseResult(ErrorCode.ERR_USER_ACCOUNT_ERROR, "User Not Exist");
		}
		
		// check password
		logger.debug("check password...");
		if(!EncryptionUtil.match(userForm.getPassword(), config.getAdminPassword())) {
			// unmatch
			logger.debug("password not match...");
			return new BaseResult(ErrorCode.ERR_USER_ACCOUNT_ERROR, "Password Not Match");
		}

		BaseResult result = new BaseResult(ErrorCode.SUCCESS);
		result.setData(data);
		return result;
	}
}