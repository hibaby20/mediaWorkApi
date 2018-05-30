package com.fang.mediaWorkApi.dao;

import com.fang.mediaWorkApi.bean.UserInfo;

public interface IUserInfoDao {
    int deleteByPrimaryKey(Integer userid);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Integer userid);
    
    UserInfo selectByOAid(Integer oaid);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
}