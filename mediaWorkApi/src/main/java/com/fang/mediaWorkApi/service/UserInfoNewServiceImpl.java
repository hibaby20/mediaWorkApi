package com.fang.mediaWorkApi.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fang.mediaWorkApi.dao.IUserInfoNewDao;

@Service("userInfoNewService")
public class UserInfoNewServiceImpl implements IUserInfoNewService {

	@Resource
	private IUserInfoNewDao userInfoNewDao;
	
	public String GetSpecialUser(Integer oaid) {
		String type = "0";
		if(oaid!=null&&!oaid.equals("")){
		  Integer tInteger = userInfoNewDao.isLeader(oaid);
		  if(tInteger>0){
			  type="1";
		  }
		}
		
		
		return type;
	}

	

}
