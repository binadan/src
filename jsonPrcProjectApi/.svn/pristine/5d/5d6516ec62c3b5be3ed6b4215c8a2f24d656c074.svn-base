package com.action;

import java.util.HashMap;
import java.util.Map;

import com.zx.tianjing.dao.PaymentManagementDao;

public class PaymentStateOffAction {
	
	private int dst;
	
	public int getDst() {
		return dst;
	}
	public void setDst(int dst) {
		this.dst = dst;
	}
	private String src;

	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	private Integer p_state;
	
	public Integer getP_state() {
		return p_state;
	}
	public void setP_state(Integer p_state) {
		this.p_state = p_state;
	}
	/*	<dst=主机id，src=3000000,poweroff>*/
	Map<String, Object> map = null;
	public String paymentStateOff(){
		PaymentManagementDao managementDao = new PaymentManagementDao();
		try {
			map = new HashMap<String, Object>();
			map = managementDao.paymentStateOff(dst);
			dst = (Integer) map.get("dst");
			p_state = (Integer) map.get("p_state");
/*			map.put("dst", p_no);
			map.put("P_STATE", 0);*/
		}catch (Exception e) {
			// TODO: handle exception
		}
		return "success";
	}
}
