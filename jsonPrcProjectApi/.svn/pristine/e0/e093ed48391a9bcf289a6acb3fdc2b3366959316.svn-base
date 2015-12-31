package com.zx.tianjing.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.zx.tianjing.bean.PaymentManagementModel;
import com.zx.tianjing.dao.util.JxSqlServer2008DbConnection;

public class PaymentManagementDao {
	private JxSqlServer2008DbConnection db_back = new JxSqlServer2008DbConnection();

	// 缴费管理接口
	public Map<String, Object> findByPayManList(int p_no) {
		int num = 0;
		String msg = "查无当前记录";
		List<PaymentManagementModel> managementModels = new ArrayList<PaymentManagementModel>();

		Map<String, Object> values = new HashMap<String, Object>();

		try {
			String sql = "select P_ID,P_HID,P_MONEY,P_DATE,P_HNAMW,P_STATE,P_NO from paymentmanagement where P_NO ="
					+ p_no + "";
			// PAY_ID,
			ResultSet rs = null;
			System.out.println(sql);
			try {
				rs = db_back.executeQuery(sql);
				while (rs.next()) {
					PaymentManagementModel model = new PaymentManagementModel();
					// model.setPay_id(rs.getInt("PAY_ID"));
					model.setP_hid(rs.getInt("p_hid"));
					model.setP_id(rs.getInt("p_id"));
					model.setP_money(rs.getInt("p_money"));
					model.setP_no(rs.getString("p_no"));
					model.setP_date(rs.getString("p_date"));
					model.setP_hnamw(rs.getString("p_hnamw"));
					model.setP_state(rs.getString("p_state"));
					managementModels.add(model);
				}
			} catch (Exception e) {
				e.printStackTrace();
				// db.rollback();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			num = -1;
			msg = "查无当前记录";
			// msg="\u67E5\u65E0\u5F53\u524D\u8BB0\u5F55";
			// e.printStackTrace();
		}

		if (managementModels.size() != 0) {
			num = 1;
			msg = "有当前记录";
			// msg = "\u6709\u5F53\u524D\u8BB0\u5F55";
		}
		values.put("request", num);
		values.put("managementModels", managementModels);
		values.put("msg", msg);
		return values;
	}

	// 手机端查询当前费用
	public Map<String, Object> findByPayManNow(String p_no) {
		int num = 0;
		String msg = "查无当前记录";
		List<PaymentManagementModel> managementModels = new ArrayList<PaymentManagementModel>();

		Map<String, Object> values = new HashMap<String, Object>();

		PaymentManagementModel model = new PaymentManagementModel();
		try {
			String sql = "select P_MONEY from paymentmanagement where P_NO = "
					+ p_no;
			// PAY_ID,
			ResultSet rs = null;
			System.out.println(sql);
			try {
				rs = db_back.executeQuery(sql);
				while (rs.next()) {
					// model.setPay_id(rs.getInt("PAY_ID"));
					model.setP_money(rs.getInt("p_money"));
					managementModels.add(model);
				}
			} catch (Exception e) {
				e.printStackTrace();
				// db.rollback();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			num = -1;
			msg = "查无当前记录";
			// msg="\u67E5\u65E0\u5F53\u524D\u8BB0\u5F55";
			// e.printStackTrace();
		}

		if (managementModels.size() != 0) {
			num = 1;
			msg = "查有当前记录";
			// msg = "\u6709\u5F53\u524D\u8BB0\u5F55";
		}
		values.put("request", num);
		values.put("cost", model.getP_money());
		values.put("msg", msg);
		return values;
	}

	// 欠费关断应用 (current_state = 0:欠费 / 1:正常)(王芙蓉)
	public Map<String, Object> paymentStateOff(int p_no) {
		Map<String, Object> map = new HashMap<String, Object>();
		String sql = "UPDATE paymentmanagement set P_STATE = '0' where P_NO = "
				+ p_no;
		try {
			db_back.executeUpdate(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * rs = db_back.executeQuery(sql); if (rs != null) { try { if(rs.next())
		 * { current_state = rs.getString("p_state"); } } catch (SQLException e)
		 * { e.printStackTrace(); } }
		 */
		map.put("dst", p_no);
		map.put("p_state", 0);
		return map;
	}

	// 欠费关断应用 (current_state = 0:欠费 / 1:正常)(王芙蓉)
	public Map<String, Object> paymentStateOn(int p_no) {
		Map<String, Object> map = new HashMap<String, Object>();
		String sql = "UPDATE paymentmanagement set P_STATE = '1' where P_NO = "
				+ p_no;
		try {
			db_back.executeUpdate(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * rs = db_back.executeQuery(sql); if (rs != null) { try { if(rs.next())
		 * { current_state = rs.getString("p_state"); } } catch (SQLException e)
		 * { e.printStackTrace(); } }
		 */
		map.put("dst", p_no);
		map.put("p_state", 1);
		return map;
	}

	// 打开欠费应用 ：返回欠费主机信息列表(王芙蓉)
	public List paymentStateOpen(int p_no) {
		String flag = null;
		ResultSet rs = null;
		List list = new ArrayList();

		String sql = "select * from paymentmanagement where p_no =" + p_no + "";
		rs = db_back.executeQuery(sql);
		if (rs != null) {
			try {
				if (rs.next()) {
					PaymentManagementModel pm = new PaymentManagementModel();
					pm.setP_id(rs.getInt(1));
					pm.setP_hid(rs.getInt(2));
					pm.setP_money(rs.getInt(3));
					pm.setP_date(rs.getString(4));
					pm.setP_hnamw(rs.getString(5));
					pm.setP_state(rs.getString(6));
					pm.setP_no(rs.getString(7));
					list.add(pm);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;

	}

	
}
