package com.zx.tianjing.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.zx.tianjing.bean.LarumInfosModel;
import com.zx.tianjing.dao.util.JxSqlServer2008DbConnection;

public class LarumInfoDao {

	//连接数据库
	private JxSqlServer2008DbConnection db_back=new JxSqlServer2008DbConnection();
	
	//报警
	public String LarumInfoState(int L_ID, String L_Type) {
		
		String flag = null;		
		ResultSet rs = null;
		String current_Type = null;
		int temp = 0;
		
		String sql = "select * from laruminfo where L_MID ="+L_ID+"" ;
		rs = db_back.executeQuery(sql);
		if (rs != null) {			
			try {
				if(rs.next()) {					
					current_Type = rs.getString("L_TYPE");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (!L_Type.equals(current_Type)) {
			
			String sql_update="update laruminfo set L_Type='"+L_Type+"' where L_MID="+L_ID+"";
			temp=db_back.executeUpdate(sql_update);
			if(temp>0){
				flag="平台数据已更新";				
			} 
		}else {
			flag = "警报状态一致";
		}
		return flag;
	}
	
	
	
		/**
		 * 
		 * @param pay_no
		 * @return
		 */
		public Map<String, Object> exigency(LarumInfosModel laruminfo) {
			int num = 0 ;
			String msg = "成功";
			//List<LarumInfosModel> laruminfoModel = new ArrayList<LarumInfosModel>();
			Map<String, Object> values = new HashMap<String, Object>(); 
			//ResultSet rs = null;
			
			try {
					String sql_insert = "insert into laruminfo values('"+laruminfo.getL_ID()+"','"+laruminfo.getL_MID()+"','"+laruminfo.getL_HID()+"','"+laruminfo.getL_VHOEID()+"','"+laruminfo.getL_TYPE()+"','"+laruminfo.getL_PERSONID()+"','"+laruminfo.getL_DATE()+"','"+laruminfo.getL_PDATE()+"','"+laruminfo.getL_REMARK()+"','"+laruminfo.getL_STATE()+"')";
					try{
						//'" + laruminfo.getL_ID()+ "','" + laruminfo.getL_MID() + "','" + laruminfo.getL_HID() + "','" + laruminfo.getL_VHOEID() + "','" + laruminfo.getL_TYPE() + "','"+ laruminfo.getL_PERSONID() + "','" + laruminfo.getL_DATE()+ "','" + laruminfo.getL_PDATE() + "','"+ laruminfo.getL_REMARK() + "','" + laruminfo.getL_STATE()+ "'
						db_back.executeUpdate(sql_insert);
						System.out.println(sql_insert);
					}catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					
				
			} catch (Exception e) {
				num = -1;
				msg = "添加主机报警信息失败";
			  	System.out.println("djakshdjahsdkjjjjjjjjjjjjjjjjjjjjjjjjjjjjjashdjshjdh"+laruminfo);
			}
			
			values.put("request", num);
			values.put("laruminfo", laruminfo);
			values.put("msg", msg);
			return values;
		}
		
	

}
