package com.gcflower.entity;

import java.io.Serializable;

/**
 * 
 * com.gcflower.entityLaruminfo1.java
 * 
 * 2015-6-10
 * 
 * @author James
 * 
 * 
 */
public class Laruminfo1 implements Serializable {
	/**
	 * 个蝙蝠侠
	 */
	private static final long serialVersionUID = 1L;
	private int l_id;// 报警ID
	private String l_mid;// 报警主机id
	private String l_hid;// 报警房屋
	private String l_type;// 报警类型
	private String l_personid;// 处理人员
	private String l_date;// 报警时间
	private String l_pdate;// 处理时间
	private String l_remark;// 处理说明
	private String l_state;// 报警状态
	private String h_name;//业主姓名
	private String h_tel;//业主电话
	private int m_houseid;//房间编号
	private String h_no;//房屋编号
	private String startTime;// 开始时间
	private String endTime;// 结束时间
	private String l_vhoeid;//设备编号

	
	public String getL_vhoeid() {
		return l_vhoeid;
	}

	public void setL_vhoeid(String l_vhoeid) {
		this.l_vhoeid = l_vhoeid;
	}

	/**
	 * 重写toString方法
	 */
	@Override
	public String toString() {
		return "Laruminfo1 [l_id=" + l_id + ", l_mid=" + l_mid + ", l_hid="
				+ l_hid + ", l_type=" + l_type + ", l_personid=" + l_personid
				+ ", l_date=" + l_date + ", l_pdate=" + l_pdate + ", l_remark="
				+ l_remark + ", l_state=" + l_state + ", h_name=" + h_name
				+ ", h_tel=" + h_tel + ", m_houseid=" + m_houseid + ", h_no="
				+ h_no + ", startTime=" + startTime + ", endTime=" + endTime
				+ "]";
	}

	/**
	 * get/set方法
	 * @return
	 */
	public int getL_id() {
		return l_id;
	}

	public void setL_id(int l_id) {
		this.l_id = l_id;
	}

	

	public String getL_mid() {
		return l_mid;
	}

	public void setL_mid(String l_mid) {
		this.l_mid = l_mid;
	}

	public String getL_hid() {
		return l_hid;
	}

	public void setL_hid(String l_hid) {
		this.l_hid = l_hid;
	}

	public String getL_type() {
		return l_type;
	}

	public void setL_type(String l_type) {
		this.l_type = l_type;
	}

	

	public String getL_personid() {
		return l_personid;
	}

	public void setL_personid(String l_personid) {
		this.l_personid = l_personid;
	}

	public String getL_date() {
		return l_date;
	}

	public void setL_date(String l_date) {
		this.l_date = l_date;
	}

	public String getL_pdate() {
		return l_pdate;
	}

	public void setL_pdate(String l_pdate) {
		this.l_pdate = l_pdate;
	}

	public String getL_remark() {
		return l_remark;
	}

	public void setL_remark(String l_remark) {
		this.l_remark = l_remark;
	}

	public String getL_state() {
		return l_state;
	}

	public void setL_state(String l_state) {
		this.l_state = l_state;
	}

	public String getH_name() {
		return h_name;
	}

	public void setH_name(String h_name) {
		this.h_name = h_name;
	}

	public String getH_tel() {
		return h_tel;
	}

	public void setH_tel(String h_tel) {
		this.h_tel = h_tel;
	}

	public int getM_houseid() {
		return m_houseid;
	}

	public void setM_houseid(int m_houseid) {
		this.m_houseid = m_houseid;
	}

	public String getH_no() {
		return h_no;
	}

	public void setH_no(String h_no) {
		this.h_no = h_no;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Laruminfo1() {
		super();
		// TODO Auto-generated constructor stub
	}

}
