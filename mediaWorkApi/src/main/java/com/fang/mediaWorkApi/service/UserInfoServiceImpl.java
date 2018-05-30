package com.fang.mediaWorkApi.service;

import java.util.Iterator;

import javax.annotation.Resource;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.fang.mediaWorkApi.bean.UserInfo;
import com.fang.mediaWorkApi.common.Common;
import com.fang.mediaWorkApi.dao.IUserInfoDao;
import com.fang.mediaWorkApi.service.IUserInfoService;

@Service("userInfoService")
public class UserInfoServiceImpl implements IUserInfoService {

	@Resource
	private IUserInfoDao userInfoDao;
	
	@Resource
	private IUserInfoNewService userInfoNewService;

	public UserInfo getUserInfoById(Integer id) {
		return this.userInfoDao.selectByPrimaryKey(id);
	}

	public UserInfo getUserInfoByOAid(Integer oaid) {
		return this.userInfoDao.selectByOAid(oaid);
	}

	public String GetPositionByOAUserID(Integer oaid) {
		String performstandard = "-1";
		String cerUrl = "https://oajk.3g.fang.com/platform/GetUserDetail?user=kehu&pwd=KH3mc8fg9&userid=%d";
		String perUrl = "https://oajk.3g.fang.com/platform/GetUserInfo?user=kehu&pwd=KH3mc8fg9&query=%s";

		if (oaid != null && !oaid.equals("")) {

			UserInfo userInfo = this.userInfoDao.selectByOAid(oaid);
			Document document2=null;
			Element root=null;
			String cer="";
			

			if (userInfo != null && userInfo.getUserid() > 0) {
				cerUrl = String.format(cerUrl, oaid);
				SAXReader reader = new SAXReader();
		        try {
					document2 = reader.read(cerUrl);
					root = document2.getRootElement();																	
					Element user = root.element("user");
					
					if(user!=null){
						
						cer = user.element("certificatenum").getText();
						
						if(cer!=null&&!cer.equals("")){
							perUrl = String.format(perUrl, cer);
							document2=reader.read(perUrl);
							root = document2.getRootElement();																	
							Element record = root.element("record");
							if(user!=null){
								performstandard=record.element("performstandard").getText();
								
								if (performstandard == "562")
	                            {
	                                performstandard = "1";
	                            }
	                            else if (performstandard != "0" && performstandard != "1" && performstandard != "2")
	                            {
	                                if (userInfoNewService.GetSpecialUser(oaid) == "1")
	                                {
	                                    performstandard = "3";
	                                }
	                                else
	                                {
	                                    performstandard = "-1";
	                                }
	                            }
							}
						}
					}
					
				} catch (DocumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
								
				
			}

		}

		return performstandard;
	}

}
