package com.gcflower.entity;

import java.util.Date;

public class Version {

/**
 * 
 * 序号，版本号，url，时间
 */
	
	//Fields   
	
	private int v_id;
	/**
	 * 序号
	 */
	private String v_no;
	/**
	 * 版本号
	 */
	private String v_url;
	/**
	 * url链接
	 */
	private Date v_time;
	/**
	 * 时间
	 */
	public int getV_id() {
		return v_id;
	}
	public void setV_id(int v_id) {
		this.v_id = v_id;
	}
	public String getV_no() {
		return v_no;
	}
	public void setV_no(String v_no) {
		this.v_no = v_no;
	}
	public String getV_url() {
		return v_url;
	}
	public void setV_url(String v_url) {
		this.v_url = v_url;
	}
	public Date getV_time() {
		return v_time;
	}
	public void setV_time(Date v_time) {
		this.v_time = v_time;
	}
	public Version(int v_id, String v_no, String v_url, Date v_time) {
		super();
		this.v_id = v_id;
		this.v_no = v_no;
		this.v_url = v_url;
		this.v_time = v_time;
	}
	public Version() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Version [v_id=" + v_id + ", v_no=" + v_no + ", v_url=" + v_url
				+ ", v_time=" + v_time + "]";
	}
	
	
	
	
}
