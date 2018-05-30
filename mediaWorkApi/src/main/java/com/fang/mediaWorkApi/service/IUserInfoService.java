package com.fang.mediaWorkApi.service;

import com.fang.mediaWorkApi.bean.UserInfo;

public interface IUserInfoService {
	
	public UserInfo getUserInfoById(Integer id);
	
	public UserInfo getUserInfoByOAid(Integer oaid);
	
	public String GetPositionByOAUserID(Integer oaid);
}
