package com.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.zx.tianjing.bean.PayInfoModel;
import com.zx.tianjing.dao.PayInfoDao;

public class PayInfosAction {

	private int id;
	List<PayInfoModel> infoModel = new ArrayList<PayInfoModel>();
	
	private String msg;
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public List<PayInfoModel> getInfoModel() {
		return infoModel;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private Integer state;
	
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	
	@SuppressWarnings("unchecked")
	public String payhistory(){
		PayInfoDao dao = new PayInfoDao();
		Map<String, Object> map = new HashMap<String, Object>();
		map = dao.payhistory(id);
		state = (Integer) map.get("request");
		msg = (String) map.get("msg");
		if (map.get("infoModel") != null) {
			infoModel = (List<PayInfoModel>) map.get("infoModel");
		}
		return "success";
	}
	
}
