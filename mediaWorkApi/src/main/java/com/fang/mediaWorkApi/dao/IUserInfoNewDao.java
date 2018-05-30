package com.fang.mediaWorkApi.dao;

import com.fang.mediaWorkApi.bean.UserInfoNew;

public interface IUserInfoNewDao {
    int deleteByPrimaryKey(Integer usernewid);

    int insert(UserInfoNew record);

    int insertSelective(UserInfoNew record);

    UserInfoNew selectByPrimaryKey(Integer usernewid);

    int updateByPrimaryKeySelective(UserInfoNew record);

    int updateByPrimaryKey(UserInfoNew record);
    
    int isLeader(Integer OAUserId);
}