package com.fang.mediaWorkApi.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fang.mediaWorkApi.bean.UserInfo;
import com.fang.mediaWorkApi.service.IUserInfoService;

@Controller
@RequestMapping("/userInfo")
public class UserInfoController {
	@Resource
	private IUserInfoService userInfoService;
	
	@RequestMapping("/showUserInfo")
	public String showUserInfo(Integer userid,Model model){
		
		UserInfo userInfo=userInfoService.getUserInfoById(userid);
		model.addAttribute("userInfo",userInfo);
		
		return "showUserInfo";
	}
	
	
}
