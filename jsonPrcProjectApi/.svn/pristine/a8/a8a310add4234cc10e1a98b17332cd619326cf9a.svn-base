package com.action;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.zx.tianjing.bean.HouseHoldModel;
import com.zx.tianjing.dao.HouseHoldDao;

public class HouseHoldInfoAction{
	
	private String h_username;
	private String h_userpwd;
	
	private String msg;
	private Integer result;
	private HouseHoldModel holdModel;
	
	public HouseHoldModel getHoldModel() {
		return holdModel;
	}

	public void setHoldModel(HouseHoldModel holdModel) {
		this.holdModel = holdModel;
	}

	public String getH_username() {
		return h_username;
	}

	public void setH_username(String h_username) {
		this.h_username = h_username;
	}

	public String getH_userpwd() {
		return h_userpwd;
	}

	public void setH_userpwd(String h_userpwd) {
		this.h_userpwd = h_userpwd;
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
	
	/**
	 * 手机请求住户信息
	 * @return
	 */
	public String queryhomeinfo(){
		HouseHoldDao dao = new HouseHoldDao();
		Map<String, Object> map = new HashMap<String, Object>();
		map = dao.findByHouseList(h_username, h_userpwd);
		System.out.println("map.size:"+map.size());
		result = (Integer) map.get("request");
		msg = (String) map.get("msg");
		if (map.get("holdModel") != null) {
			holdModel = (HouseHoldModel) map.get("holdModel");
		}
		return "success";
	}
	
	
	
}
