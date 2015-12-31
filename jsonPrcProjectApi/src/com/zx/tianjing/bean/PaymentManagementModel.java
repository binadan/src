package com.zx.tianjing.bean;

public class PaymentManagementModel {

	private Integer p_id;//缴费id
	private Integer p_hid;//房屋id
	private Integer p_money;//账号余额
	private String p_date;//缴费时间
	private String p_hnamw;//住户姓名
	private String p_state;//主机状态 （正常  ，欠费）
	private String p_no;//主机id
	public Integer getP_id() {
		return p_id;
	}
	public void setP_id(Integer p_id) {
		this.p_id = p_id;
	}
	public Integer getP_hid() {
		return p_hid;
	}
	public void setP_hid(Integer p_hid) {
		this.p_hid = p_hid;
	}
	public Integer getP_money() {
		return p_money;
	}
	public void setP_money(Integer p_money) {
		this.p_money = p_money;
	}
	public String getP_date() {
		return p_date;
	}
	public void setP_date(String p_date) {
		this.p_date = p_date;
	}
	public String getP_hnamw() {
		return p_hnamw;
	}
	public void setP_hnamw(String p_hnamw) {
		this.p_hnamw = p_hnamw;
	}
	public String getP_state() {
		return p_state;
	}
	public void setP_state(String p_state) {
		this.p_state = p_state;
	}
	public String getP_no() {
		return p_no;
	}
	public void setP_no(String p_no) {
		this.p_no = p_no;
	}
	
	
	
}
