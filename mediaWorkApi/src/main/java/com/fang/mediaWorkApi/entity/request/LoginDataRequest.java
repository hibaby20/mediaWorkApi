package com.fang.mediaWorkApi.entity.request;

public class LoginDataRequest extends CommonSearch {
	/**
	 * OAid
	 **/
	private String oAid;
	/**
	 * 查看列表类型（1：按集团维度，2：按城市维度，3：按团队维度，4：按销售维度，5：按角色维度）
	 */
	private String watchType;
	/**
	 * 日期类型（本年 = 2, 本月 = 4, 本周 = 6, 昨天 = 8, 今天 = 9 ,自定义 = 10）
	 */
	private String dateType;
	/**
	 * 自定义开始日期（如：2018-03-12）
	 */
	private String startDate;
	/**
	 * 自定义结束日期（如：2018-03-12）
	 */
	private String endDate;
	/**
	 * 分页大小
	 */
	private int pageSize = 10;
	/**
	 * 页号
	 */
	private int page = 1;
	/**
	 * @return the oAid
	 */
	public String getoAid() {
		return oAid;
	}
	/**
	 * @param oAid the oAid to set
	 */
	public void setoAid(String oAid) {
		this.oAid = oAid;
	}
	/**
	 * @return the watchType
	 */
	public String getWatchType() {
		return watchType;
	}
	/**
	 * @param watchType the watchType to set
	 */
	public void setWatchType(String watchType) {
		this.watchType = watchType;
	}
	/**
	 * @return the dateType
	 */
	public String getDateType() {
		return dateType;
	}
	/**
	 * @param dateType the dateType to set
	 */
	public void setDateType(String dateType) {
		this.dateType = dateType;
	}
	/**
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}
	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	/**
	 * @return the page
	 */
	public int getPage() {
		return page;
	}
	/**
	 * @param page the page to set
	 */
	public void setPage(int page) {
		this.page = page;
	}
}
