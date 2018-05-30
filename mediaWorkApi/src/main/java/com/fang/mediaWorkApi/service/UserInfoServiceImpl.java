package com.fang.mediaWorkApi.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fang.mediaWorkApi.bean.UserInfo;
import com.fang.mediaWorkApi.dao.IUserInfoDao;
import com.fang.mediaWorkApi.service.IUserInfoService;

@Service("userInfoService")
public class UserInfoServiceImpl implements IUserInfoService {

	@Resource
	private IUserInfoDao userInfoDao;

	public UserInfo getUserInfoById(Integer id) {
		return this.userInfoDao.selectByPrimaryKey(id);
	}

	public UserInfo getUserInfoByOAid(Integer oaid) {
		return this.userInfoDao.selectByOAid(oaid);
	}

	public String GetPositionByOAUserID(Integer oaid) {
		String performstandard = "-1";

		if (oaid != null) {
			
			UserInfo userInfo = this.userInfoDao.selectByOAid(oaid);
			
			if(userInfo!=null && userInfo.getUserid()>0){
				
			}
			
		}

		return performstandard;
	}	

}
