package com.zx.tianjing.bean;

import java.util.Date;

public class VersionModel {

	private int version_id;
	public int getVersion_id() {
		return version_id;
	}
	public void setVersion_id(int version_id) {
		this.version_id = version_id;
	}
	public String getVersion_no() {
		return version_no;
	}
	public void setVersion_no(String version_no) {
		this.version_no = version_no;
	}
	public String getVersion_url() {
		return version_url;
	}
	public void setVersion_url(String version_url) {
		this.version_url = version_url;
	}
	public Date getVersion_time() {
		return version_time;
	}
	public void setVersion_time(Date version_time) {
		this.version_time = version_time;
	}
	/**
	 * 序号
	 */
	private String version_no;
	/**
	 * 版本号
	 */
	private String version_url;
	/**
	 * url链接
	 */
	private Date version_time;
	/**
	 * 时间
	 */
	
	
	
	
	
}
