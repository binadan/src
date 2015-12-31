package com.zx.tianjing.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zx.tianjing.bean.PayInfoModel;
import com.zx.tianjing.dao.util.JxSqlServer2008DbConnection;

public class PayInfoDao {
	private JxSqlServer2008DbConnection db_back = new JxSqlServer2008DbConnection();
	/*
	 * { “result”:0 0代表无缴费记录，1代表有缴费记录，-1 失败   "data": [ { "time":
	 * "2015-05-26  09:25", "pay": 100 "state":1 1:代表成功，0代表失败 }, { "time":
	 * "2015-05-26  09:25", "pay": 100 "state":1 }, ], "msg": ""
	 * result为-1时，msg告知原因，例“查无此主机信息” }
	 */
	
	// 手机端返回缴费信息
	public Map<String, Object> findByPayList(int pay_no) {
		int num = 0;
		String msg = "查无缴费记录";
		List<PayInfoModel> infoModels = new ArrayList<PayInfoModel>();
		
		Map<String, Object> values = new HashMap<String, Object>(); 
		
		
		try {
			String sql = "select PAY_MONEY,PAY_DATE,PAY_NO from payinfo where PAY_NO = " + pay_no
					+ " ORDER BY PAY_DATE DESC";
			//PAY_ID,
			ResultSet rs = null;
			System.out.println(sql);
			try {
				rs = db_back.executeQuery(sql);
				while (rs.next()) {
					PayInfoModel model = new PayInfoModel();
					//model.setPay_id(rs.getInt("PAY_ID"));
					model.setPay_money(rs.getInt("PAY_MONEY"));
					model.setPay_date(rs.getString("PAY_DATE"));
					//model.setPay_no(rs.getInt("PAY_NO"));
					infoModels.add(model);
				}
			} catch (Exception e) {
				e.printStackTrace();
				// db.rollback();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			num = -1;
			msg = "查无此主机信息";
			//e.printStackTrace();
		}
		
		if (infoModels.size()!=0) {
			num = 1;
			msg = "查有缴费记录";
		}
		values.put("request", num);
		values.put("infoModel", infoModels);
		values.put("msg", msg);
		return values;
	}
	
	// 手机端返回缴费信息
	public Map<String, Object> payhistory(int pay_no) {
		int num = 0;
		String msg = "查无缴费记录";
		List<PayInfoModel> infoModel = new ArrayList<PayInfoModel>();
		PayInfoModel model = null;
		Map<String, Object> values = new HashMap<String, Object>(); 
		
		
		try {
			String sql = "select PAY_MONEY,PAY_DATE from payinfo where PAY_NO like '%"+pay_no+"%'"
					+ " ORDER BY PAY_DATE DESC";
			//PAY_ID,
			ResultSet rs = null;
			System.out.println(sql);
			try {
				rs = db_back.executeQuery(sql);
				while (rs.next()) {
					 model = new PayInfoModel();
					//model.setPay_id(rs.getInt("PAY_ID"));
					model.setPay_money(rs.getInt("PAY_MONEY"));
					model.setPay_date(rs.getString("PAY_DATE"));
					//model.setPay_no(rs.getInt("PAY_NO"));
					infoModel.add(model);
				}
			} catch (Exception e) {
				e.printStackTrace();
				// db.rollback();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			num = -1;
			msg = "查无此主机信息";
			//e.printStackTrace();
		}
		
		if (infoModel.size()!=0) {
			num = 1;
			msg = "查有缴费记录";
		}
		values.put("request", num);
		values.put("infoModel", infoModel);
		values.put("msg", msg);
		return values;
	}
}
