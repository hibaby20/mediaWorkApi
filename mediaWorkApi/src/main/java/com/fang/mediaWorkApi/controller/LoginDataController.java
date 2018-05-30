package com.fang.mediaWorkApi.controller;

import java.util.Calendar;

import javax.annotation.Resource;
import javax.json.JsonObject;
import javax.print.attribute.standard.DateTimeAtCompleted;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.fang.mediaWorkApi.bean.UserInfo;
import com.fang.mediaWorkApi.common.Common;
import com.fang.mediaWorkApi.common.DateTime;
import com.fang.mediaWorkApi.entity.request.LoginDataRequest;
import com.fang.mediaWorkApi.service.IUserInfoService;

@Controller
@RequestMapping("/LoginData")
public class LoginDataController {

	@Resource
	private IUserInfoService userInfoService;

	@RequestMapping("/GetLoginDetailData")
	@ResponseBody
	public JSONObject GetLoginDetailData(LoginDataRequest request) {
		String startMonth = "";
		String endMonth = "";
		String performstandard = userInfoService.GetPositionByOAUserID(Integer.parseInt(request.getoAid()));

		String salerid = "";
		String subid = "";
		String city = "";
		String group = "";
		String searchType = "";
		// JObject jsonOb = null;
		JSONObject data = null;

		if (performstandard != "-1") {
			Calendar calendar = Calendar.getInstance();

			if (request.getDateType() == "2") {

				startMonth = DateTime.now().toDateTimeString();// .ToString("yyyy-01-01");
			} else if (request.getDateType() == "4") {
				startMonth = DateTime.now().toDateTimeString();// DateTime.Now.ToString("yyyy-MM-01");
			} else if (request.getDateType() == "6") {
				if (DateTime.now().toDateTimeString() != null)// DateTime.now().DayOfWeek
																// == 0
				{
					startMonth = DateTime.now().toDateTimeString();// DateTime.Now.AddDays(-6).ToString("yyyy-MM-dd");
				} else {
					startMonth = DateTime.now().toDateTimeString();// DateTime.Now.AddDays(1
																	// -
																	// Convert.ToInt32(DateTime.Now.DayOfWeek)).ToString("yyyy-MM-dd");
				}
			} else if (request.getDateType() == "8") {
				startMonth = DateTime.now().toDateTimeString();// DateTime.Now.AddDays(-1).ToString("yyyy-MM-dd");
			}

			endMonth = DateTime.now().toDateTimeString();// DateTime.Now.ToString("yyyy-MM-dd");

			if (request.getDateType() == "10") {
				startMonth = request.getStartDate();
				endMonth = request.getEndDate();
			}

			UserInfo user = userInfoService.getUserInfoByOAid(Integer.parseInt(request.getoAid()));

			if (performstandard == "0") {
				if (!Common.IsNullOrEmpty(request.getGroupName()) && request.getGroupName() != "全部") {
					group = request.getGroupName();
				} else {
					group = user.getCorpname();
				}
				if (!Common.IsNullOrEmpty(request.getCity()) && request.getCity() != "全部") {
					city = request.getCity();
				}
				if (!Common.IsNullOrEmpty(request.getSubId()) && request.getSubId() != "-1") {
					subid = request.getSubId();
				}
				if (!Common.IsNullOrEmpty(request.getSubId())) {
					salerid = request.getSubId();
				} else {
					salerid = request.getoAid();
				}
			} else if (performstandard == "1") {
				if (!Common.IsNullOrEmpty(request.getGroupName()) && request.getGroupName() != "全部") {
					group = request.getGroupName();
				} else {
					group = user.getCorpname();
				}
				if (!Common.IsNullOrEmpty(request.getCity()) && request.getCity() != "全部") {
					city = request.getCity();
				}
				if (!Common.IsNullOrEmpty(request.getSubId())) {
					subid = request.getSubId();
				} else {
					subid = request.getoAid();
				}

				if (!Common.IsNullOrEmpty(request.getSalerId()) && request.getSalerId() != "-1"
						&& request.getSalerId() != "全部") {
					salerid = request.getSalerId();
				}
			} else if (performstandard == "2") {
				if (!Common.IsNullOrEmpty(request.getGroupName()) && request.getGroupName() != "全部") {
					group = request.getGroupName();
				} else {
					group = user.getCorpname();
				}
				if (!Common.IsNullOrEmpty(request.getCity()) && request.getCity() != "全部") {
					city = request.getCity();
				} else {
					city = user.getCityname();
				}

				if (!Common.IsNullOrEmpty(request.getGroupName())) {
					group = request.getGroupName();
				} else {
					group = user.getCorpname();
				}

				if (!Common.IsNullOrEmpty(request.getSubId()) && request.getSubId() != "-1"
						&& request.getSubId() != "全部") {
					subid = request.getSubId();
				} else {
					subid = "";
				}

				if (!Common.IsNullOrEmpty(request.getSalerId()) && request.getSalerId() != "-1"
						&& request.getSalerId() != "全部") {
					salerid = request.getSalerId();
				} else {
					salerid = "";
				}
			} else if (performstandard == "3") {
				if (!Common.IsNullOrEmpty(request.getGroupName()) && request.getGroupName() != "全部") {
					group = request.getGroupName();
				} else {
					/*
					 * List<groupResponse> grouplist =
					 * ApiBusiness.GetDeptName(request.OAid, user.UserID);
					 * 
					 * if (grouplist[0].getGroupName() == "全部") {
					 * grouplist.RemoveAt(0); }
					 * 
					 * String[] groupList = { };
					 * 
					 * if (grouplist != null && grouplist.Count > 0) { groupList
					 * = grouplist.Select(i => i.getGroupName()).ToArray(); }
					 * 
					 * group = String.join(",", groupList);
					 */
				}

				if (!Common.IsNullOrEmpty(request.getCity()) && request.getCity() != "全部") {
					city = request.getCity();
				} else {
					city = "";
				}

				if (!Common.IsNullOrEmpty(request.getSubId()) && request.getSubId() != "-1"
						&& request.getSubId() != "全部") {
					subid = request.getSubId();
				} else {
					subid = "";
				}

				if (!Common.IsNullOrEmpty(request.getSalerId()) && request.getSalerId() != "-1"
						&& request.getSalerId() != "全部") {
					salerid = request.getSalerId();
				} else {
					salerid = "";
				}
			}

			String path = "http://10.16.134.134:8302/fwdgzt/searchloginlist?";

			if (request.getWatchType() == "1") {
				searchType = "0";
			} else if (request.getWatchType() == "2") {
				searchType = "1";
			} else if (request.getWatchType() == "3") {
				searchType = "2";
			} else if (request.getWatchType() == "5") {
				searchType = "0";
				path = "http://10.16.134.134:8302/fwdgzt/searchloginlistforrole?";
			} else if (request.getWatchType() == "4") {
				searchType = "0";
				path = "http://10.16.134.134:8302/fwdgzt/searchloginlistforsingleemp?";
			}

			String strUrl = "{8}supsubcompany={0}&locationname={1}&managerid={2}&dayfrom={3}&dayto={4}&searchtype={5}&pageNo={6}&pageSize={7}";
			strUrl = String.format(strUrl, group, city, subid, startMonth, endMonth, searchType, request.getPage(),
					request.getPageSize(), path);

			try {
				data = Common.doGetObjectByUrl(strUrl);
			} catch (Exception ex) {
				String message = "{\"errorMsg\": { \"erorcode\": \"0\",\"errmsg\": \"系统错误，请联系管理员\" }}";
				data = (JSONObject) JSONObject.parse(message);
			}

		} else {
			String message = "{\"errorMsg\": { \"erorcode\": \"0\",\"errmsg\": \"无权限查看，请联系管理员\" }}";
			data = (JSONObject) JSONObject.parse(message);
		}

		return data;
	}

}
