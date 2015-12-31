package com.action;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.zx.tianjing.bean.HouseHoldModel;
import com.zx.tianjing.dao.HouseHoldDao;
/**
 * 
 * Title:住户修改密码
 * 
 * 
 * Description:com.action.HouseHoldInfo1Action.java
 * 
 * 
 * date:2015-10-8
 * 
 * 
 * Company: 西安宇明科技
 * 
 * 
 * author: kay
 *
 */
public class HouseHoldInfo1Action{
	
	private String chgpw;
	private String msg;
	private Integer result;
	private HouseHoldModel holdModel;
	
	
	
	public String getChgpw() {
		return chgpw;
	}

	public void setChgpw(String chgpw) {
		this.chgpw = chgpw;
	}

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
	
	/**
	 * 手机修改住户密码
	 * @return
	 */
	public String updpassword(){
		HouseHoldDao dao = new HouseHoldDao();
		Map<String, Object> map = new HashMap<String, Object>();
		String str[]=chgpw.split(",");
		if (str.length==3 && !"".equals(str[0]) && !"".equals(str[1]) && !"".equals(str[2])) {
			/*String h_username = str[0];
			String h_userpwd = str[1];
			String h_userpwd1 = str[2];*/
			map = dao.updpassword(str[0],str[1],str[2]);
			
		}else{
			
		}
				
								
			
			
			
		
		System.out.println("map.size:"+map.size());
		result = (Integer) map.get("request");
	
		msg = (String) map.get("msg");
		if (map.get("holdModel") != null) {
			holdModel = (HouseHoldModel) map.get("holdModel");
		}
		return "success";
	}
	
	
	
}
