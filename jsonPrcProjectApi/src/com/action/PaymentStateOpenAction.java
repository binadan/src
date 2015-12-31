package com.action;

import java.util.HashMap;
import java.util.Map;

import com.zx.tianjing.dao.PaymentManagementDao;

public class PaymentStateOpenAction {
	
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
	private String p_state;
	
	public String getP_state() {
		return p_state;
	}
	public void setP_state(String p_state) {
		this.p_state = p_state;
	}
	Map<String, Object> map = null;
	public String paymentStateOpen(){
		PaymentManagementDao managementDao = new PaymentManagementDao();
		try {
			map = new HashMap<String, Object>();
			map = managementDao.paymentStateOn(dst);
			dst = (Integer) map.get("dst");
			p_state = (String) map.get("P_STATE");
			/*			map.put("dst", p_no);
			map.put("P_STATE", 0);*/
		}catch (Exception e) {
			// TODO: handle exception
		}
		return "success";
		
	}
}
