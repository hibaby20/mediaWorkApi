package com.fang.mediaWorkApi.entity.request;

public class CommonSearch {	
	/**
	 * 集团名称(多个集团英文“,”分隔)
	 */
	private String groupName ;
    
	/**
	 * 城市(多个城市英文“,”分隔)
	 */
    private String city ;
    /**
     * 分组ID (多个团队英文“,”分隔)
     */
    private String subId ;
    /**
     * 销售ID（多个销售英文“,”分隔）
     */
    private String salerId ;
	/**
	 * @return groupName
	 */
	public String getGroupName() {
		return groupName;
	}
	/**
	 * @param groupName the groupName to set
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the subId
	 */
	public String getSubId() {
		return subId;
	}
	/**
	 * @param subId the subId to set
	 */
	public void setSubId(String subId) {
		this.subId = subId;
	}
	/**
	 * @return the salerId
	 */
	public String getSalerId() {
		return salerId;
	}
	/**
	 * @param salerId the salerId to set
	 */
	public void setSalerId(String salerId) {
		this.salerId = salerId;
	}
}
