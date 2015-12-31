package com.action;


import java.util.HashMap;
import java.util.Map;
import com.zx.tianjing.dao.PayInfoDao;

public class PayInfoAction {
/*	  "result": 0,   查询结果，0成功，-1为失败
	  "msg": ""      result为-1时，msg告知原因，例“查无此主机信息”，“密钥不正确”等信息。 */  
	
	

	private int id;
	private Integer result;
	private String msg;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
/*	values.put("request", num);
	values.put("infoModels", infoModels);
	values.put("msg", msg);*/
	//http：//平台软件IP地址：8080/api/paycost?id=家庭主机ID,cost=具体金额,time=32656778
	public String findByPayList(){
		PayInfoDao dao = new PayInfoDao();
		Map<String, Object> map = new HashMap<String, Object>();
		map = dao.findByPayList(id);
		result = (Integer) map.get("request");
		msg = (String) map.get("msg");
		return "success";
	}
	
	
	
	
}
