package com.action;

import java.util.HashMap;
import java.util.Map;

import com.zx.tianjing.dao.PaymentManagementDao;

public class PaymentManagementAction {
	//http：//平台软件IP地址：8080/api/querycost?id=家庭主机ID
	private int id ;
	private Integer result ;
	private Integer cost;
	private String msg;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Integer getResult() {
		return result;
	}
	public void setResult(Integer result) {
		this.result = result;
	}
	public Integer getCost() {
		return cost;
	}
	public void setCost(Integer cost) {
		this.cost = cost;
	}
	/*	{
		  "result": 0,   查询结果，0成功，-1为失败
		  "cost": 100,    费用
		  "msg": ""      result为-1时，msg告知原因，例“查无此主机信息”     
		} */
	//手机端查询费用
	Map<String, Object> map = null;
	public String findByPayManNow(){
		PaymentManagementDao managementDao = new PaymentManagementDao();
		try {
			map = new HashMap<String, Object>();
			map =  managementDao.findByPayManNow(String.valueOf(id));
			result = (Integer) map.get("request");
			cost = (Integer) map.get("cost");
			msg = (String) map.get("msg");
			if (msg.equals("查有当前记录")) {
				msg = "\u67E5\u6709\u5F53\u524D\u8BB0\u5F55";
			}else{
				msg = "\u67E5\u65E0\u5F53\u524D\u8BB0\u5F55";
			}
			System.out.println(msg);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}

}
