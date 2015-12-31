package com.zx.tianjing.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zx.tianjing.bean.HouseHoldModel;
import com.zx.tianjing.dao.util.JxSqlServer2008DbConnection;

public class HouseHoldDao {
	private JxSqlServer2008DbConnection db_back = new JxSqlServer2008DbConnection();

	// 住户信息管理接口
	public Map<String, Object> findByHouseList(String h_username,
			String h_userpwd) {
		int num = 0;
		String msg = "住户信息";
		List<HouseHoldModel> holdModels = new ArrayList<HouseHoldModel>();
		HouseHoldModel model = null;
		Map<String, Object> values = new HashMap<String, Object>();

		try {
			String sql = "select H_ID,H_USERNAME,H_USERPWD,H_NAME,H_EMAIL,H_TEL"
					+ ",H_SEX,H_EMERGENCTEL,H_EMERGENCNAME,H_EMERGENCTEL1"
					+ ",H_EMERGENCNAME1,H_EMERGENCTEL2,H_NO,H_EMERGENCNAME2"
					+ " from household WHERE H_USERNAME = '"
					+ h_username
					+ "' AND H_USERPWD='" + h_userpwd + "';";
			// PAY_ID,
			ResultSet rs = null;
			System.out.println(sql);
			try {
				rs = db_back.executeQuery(sql);
				System.out.println("rs--------->" + rs);

				if (rs.next()) {
					model = new HouseHoldModel();
					model.setH_id(rs.getInt("h_id"));
					model.setH_name(rs.getString("h_name"));
					model.setH_no(rs.getString("h_no"));
					model.setH_sex(rs.getString("h_sex"));
					model.setH_tel(rs.getString("h_tel"));
					model.setH_username(rs.getString("h_username"));
					model.setH_userpwd(rs.getString("h_userpwd"));
					model.setH_email(rs.getString("h_email"));
					model.setH_emergencname(rs.getString("h_emergencname"));
					model.setH_emergencname1(rs.getString("h_emergencname1"));
					model.setH_emergencname2(rs.getString("h_emergencname2"));
					model.setH_emergenctel(rs.getString("h_emergenctel"));
					model.setH_emergenctel1(rs.getString("h_emergenctel1"));
					model.setH_emergenctel2(rs.getString("h_emergenctel2"));
					// holdModels.add(model);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
		} catch (Exception e) {
			num = -1;
			msg = "无住户信息";
		}

		if (model != null) {
			num = 0;
			msg = "有住户信息";
		} else {
			num = -1;
			msg = "无住户信息";
		}
		values.put("request", num);
		values.put("holdModel", model);
		values.put("msg", msg);
		return values;
	}

	/**
	 * 手机提交住户信息
	 * @param h_username
	 * @return
	 */

	public Map<String, Object> savehomeinfo(HouseHoldModel model) {
		HouseHoldModel models = null;
		int num = 0;
		String msg = "保存";
		Map<String, Object> values = new HashMap<String, Object>();

		try {
			String sql = "select H_ID,H_USERNAME,H_USERPWD,H_NAME,H_EMAIL,H_TEL"
					+ ",H_SEX,H_EMERGENCTEL,H_EMERGENCNAME,H_EMERGENCTEL1"
					+ ",H_EMERGENCNAME1,H_EMERGENCTEL2,H_NO,H_EMERGENCNAME2"
					+ " from household WHERE H_USERNAME = '"
					+ model.getH_username()+ "'";
			// PAY_ID,
			ResultSet rs = null;
			System.out.println(sql);
			try {
				rs = db_back.executeQuery(sql);
				System.out.println("rs--------->" + rs);

				if (rs.next()) {
					models = new HouseHoldModel();
					models.setH_id(rs.getInt("h_id"));
					models.setH_name(rs.getString("h_name"));
					models.setH_no(rs.getString("h_no"));
					models.setH_sex(rs.getString("h_sex"));
					models.setH_tel(rs.getString("h_tel"));
					models.setH_username(rs.getString("h_username"));
					models.setH_userpwd(rs.getString("h_userpwd"));
					models.setH_email(rs.getString("h_email"));
					models.setH_emergencname(rs.getString("h_emergencname"));
					models.setH_emergencname1(rs.getString("h_emergencname1"));
					models.setH_emergencname2(rs.getString("h_emergencname2"));
					models.setH_emergenctel(rs.getString("h_emergenctel"));
					models.setH_emergenctel1(rs.getString("h_emergenctel1"));
					models.setH_emergenctel2(rs.getString("h_emergenctel2"));
					models.setH_emergenctel2(rs.getString("h_no"));
					// holdModels.add(model);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (models != null) {
			num = 0;
			msg = "保存成功";
			try {
				
					String sql_update = "update household set H_NAME='"
							+ model.getH_name() + "',H_TEL='" + model.getH_tel()
							+ "',H_SEX='" + model.getH_sex() + "',H_EMERGENCTEL='"
							+ model.getH_emergenctel() + "',H_EMERGENCNAME='"
							+ model.getH_emergencname() + "',H_EMERGENCTEL1='"
							+ model.getH_emergenctel1() + "',H_EMERGENCNAME1='"
							+ model.getH_emergencname1() + "',H_EMERGENCTEL2='"
							+ model.getH_emergenctel2() + "',H_NO='"+model.getH_no()+"',H_EMERGENCNAME2='"+ model.getH_emergencname2() + "' where H_USERNAME='"
							+ model.getH_username() + "'";
					try {
						db_back.executeUpdate(sql_update);
						System.out.println(sql_update);
					} catch (Exception e) {
						e.printStackTrace();
					}
		
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else {
			num = -1;
			msg = "保存失败---查无此主机信息";
		}
		values.put("request", num);
		// values.put("holdModel", model);
		values.put("msg", msg);
		return values;

	}
	/**
	 * 住户修改密码
	 * 
	 * @param h_username
	 * @param h_userpwd
	 * @param h_userpwd1
	 * @return
	 */
	public Map<String, Object> updpassword(String h_username,String h_userpwd,String h_userpwd1) {
		String flag = null;
		ResultSet rs = null;
		String msg = "修改密码";
		List<HouseHoldModel> holdModels = new ArrayList<HouseHoldModel>();
		HouseHoldModel model = null;
		Map<String, Object> values = new HashMap<String, Object>();

		String sql = "select h_userpwd from household where h_username='"
				+ h_username + "'";
		rs = db_back.executeQuery(sql);
		System.out.println(sql);

		try {
			if (rs.next()) {

				if (h_userpwd.equals(rs.getString(1))) {
					try {
						String sql1 = "update h_userpwd='" + h_userpwd1
								+ "' where h_username='" + h_username + "'";
						int temp = db_back.executeUpdate(sql1);
						msg = "密码修改成功!";
						if (temp==0) {
							msg = "密码修改失败!";
						}

					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
						msg = "密码修改失败!";
					}
				} else {

					msg = "旧密码不正确";
				}

			} else {
				msg = "用户名不存在";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg = "密码修改失败!";
		}

		return null;
	}
	
	public Map<String, Object> login(String h_username,String h_userpwd) {
		//int num = 0;
		String appid = "fail";
		String msg = "登录失败";
		List<HouseHoldModel> householdModel = new ArrayList<HouseHoldModel>();
		HouseHoldModel houseModel = null;
		Map<String, Object> values = new HashMap<String, Object>();

		try {
			String sql = "select H_USERNAME,H_USERPWD from household WHERE H_USERNAME = '"
					+ h_username+ "' AND H_USERPWD='" + h_userpwd + "'";
			ResultSet rs = null;
			System.out.println(sql);
			try {
				rs = db_back.executeQuery(sql);
				System.out.println("rs--------->" + rs);

				while (rs.next()) {
					houseModel = new HouseHoldModel();
					houseModel.setH_username(rs.getString("h_username"));
					houseModel.setH_userpwd(rs.getString("h_userpwd"));
					householdModel.add(houseModel);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
		} catch (Exception e) {
			e.printStackTrace();
			appid.equals("fail");
			msg = "登录失败";
		}

		if (householdModel != null) {
			appid.equals("40000000");
			msg = "登录成功";
		} 
		
		values.put("request", appid);
		values.put("householdModel", householdModel);
		values.put("msg", msg);
	
		return null;
		
	}
	
}
