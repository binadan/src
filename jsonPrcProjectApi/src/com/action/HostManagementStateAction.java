package com.action;

import com.zx.tianjing.dao.HostManagementDao;

public class HostManagementStateAction {
	
	private int routeid;
	private String res;
	private String state;
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	public int getRouteid() {
		return routeid;
	}
	public void setRouteid(int routeid) {
		this.routeid = routeid;
	}
	public String getRes() {
		return res;
	}
	public void setRes(String res) {
		
		this.res = res;
	}
	
	//state 布放 1 撤防2
	public String hostManagementState(){
		HostManagementDao dao = new HostManagementDao();
		if (state.equals("1")) {
			dao.hostManagementStateY(routeid, state);
			res = "ok";
		}else if (state.equals("0")) {
			dao.hostManagementStateN(routeid, state);
			res = "ok";
		}
		return res;
	}
}
