package com.action;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.zx.tianjing.bean.HouseHoldModel;
import com.zx.tianjing.dao.HouseHoldDao;

public class HouseHoldAction{

	private String H_USERNAME;
	private String H_NAME;
	private String H_TEL;
	private String H_SEX;
	private String H_EMERGENCTEL;
	private String H_EMERGENCNAME;
	private String H_EMERGENCTEL1;
	private String H_EMERGENCNAME1;
	private String H_EMERGENCTEL2;
	private String H_NO;
	private String H_EMERGENCNAME2;

	
	
	
	public String getH_NO() {
		return H_NO;
	}

	public void setH_NO(String h_NO) {
		H_NO = h_NO;
	}

	public String getH_TEL() {
		return H_TEL;
	}

	public void setH_TEL(String h_TEL) {
		H_TEL = h_TEL;
	}

	public String getH_SEX() {
		return H_SEX;
	}

	public void setH_SEX(String h_SEX) {
		H_SEX = h_SEX;
	}

	public String getH_EMERGENCTEL() {
		return H_EMERGENCTEL;
	}

	public void setH_EMERGENCTEL(String h_EMERGENCTEL) {
		H_EMERGENCTEL = h_EMERGENCTEL;
	}

	public String getH_EMERGENCNAME() {
		return H_EMERGENCNAME;
	}

	public void setH_EMERGENCNAME(String h_EMERGENCNAME) {
		H_EMERGENCNAME = h_EMERGENCNAME;
	}

	public String getH_EMERGENCTEL1() {
		return H_EMERGENCTEL1;
	}

	public void setH_EMERGENCTEL1(String h_EMERGENCTEL1) {
		H_EMERGENCTEL1 = h_EMERGENCTEL1;
	}

	public String getH_EMERGENCNAME1() {
		return H_EMERGENCNAME1;
	}

	public void setH_EMERGENCNAME1(String h_EMERGENCNAME1) {
		H_EMERGENCNAME1 = h_EMERGENCNAME1;
	}

	public String getH_EMERGENCTEL2() {
		return H_EMERGENCTEL2;
	}

	public void setH_EMERGENCTEL2(String h_EMERGENCTEL2) {
		H_EMERGENCTEL2 = h_EMERGENCTEL2;
	}

	public String getH_EMERGENCNAME2() {
		return H_EMERGENCNAME2;
	}

	public void setH_EMERGENCNAME2(String h_EMERGENCNAME2) {
		H_EMERGENCNAME2 = h_EMERGENCNAME2;
	}

	public String getH_USERNAME() {
		return H_USERNAME;
	}

	public void setH_USERNAME(String h_USERNAME) {
		H_USERNAME = h_USERNAME;
	}

	public String getH_NAME() {
		return H_NAME;
	}

	public void setH_NAME(String h_NAME) {
		H_NAME = h_NAME;
	}

	private String msg;
	private Integer result;
	private HouseHoldModel holdModel;
	
	public HouseHoldModel getHoldModel() {
		return holdModel;
	}

	public void setHoldModel(HouseHoldModel holdModel) {
		this.holdModel = holdModel;
	}



	public Integer getResult() {
		return result;
	}

	public void setResult(Integer result) {
		this.result = result;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public String savehomeinfo() throws UnsupportedEncodingException{
		// beanz组装
		HouseHoldModel model = new HouseHoldModel();
		HttpServletRequest request = ServletActionContext.getRequest();
		model.setH_username(H_USERNAME);
		model.setH_name(H_NAME);
		model.setH_sex(H_SEX);
		model.setH_tel(H_TEL);
		model.setH_emergenctel(H_EMERGENCTEL);
		model.setH_emergencname(H_EMERGENCNAME);
		model.setH_emergenctel1(H_EMERGENCTEL1);
		model.setH_emergencname1(H_EMERGENCNAME1);
		model.setH_emergenctel2(H_EMERGENCTEL2);
		model.setH_emergencname2(H_EMERGENCNAME2);
		model.setH_no(H_NO);
	
		HouseHoldDao dao = new HouseHoldDao();
		Map<String,Object> map = new HashMap<String,Object>();			
		map = dao.savehomeinfo(model);		
		result = (Integer) map.get("request");
		msg = (String) map.get("msg");
		return "success";	
	}
}
