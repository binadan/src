package com.zx.tianjing.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zx.tianjing.bean.HostManagementModel;
import com.zx.tianjing.dao.util.JxSqlServer2008DbConnection;

public class HostManagementDao {
	
	 //连接数据库
		private JxSqlServer2008DbConnection db_back=new JxSqlServer2008DbConnection();
		
		
		/**
		 * 主机    布放   ， 撤防 。参数(  主机ID，    state=1（布放） )
		 * @param id
		 * @param state
		 * @return
		 */
		public String  hostManagementStateY(int id,String state) {			
			ResultSet rs = null;
			String flag = null;
			String state_current = null;
			int temp = 0;
					
			String sql = "select * from hostmanagement where M_ID ="+id+"";			
			rs = db_back.executeQuery(sql);
			
			if (rs != null) {
				try {
					if(rs.next()){
						state_current = rs.getString("M_STATE");					
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}	
			
			if (!state.equals(state_current)) {
				
					String sql_update="update hostmanagement set M_STATE='1' where M_ID="+id+" ";
					temp=db_back.executeUpdate(sql_update);
					if(temp>0){
						flag="平台数据已更新，目前状态：布防";
					}
								
			}else{
								
				flag="布放状态正常";
			}
       			
			return flag;
		}
		/**
		 * 主机撤防   参数(  主机ID，    state=2（撤防）   )
		 * @param id  
		 * @param state
		 * @return
		 */
		public String  hostManagementStateN(int id,String state) {			
			ResultSet rs = null;
			String flag = null;
			String state_current = null;
			int temp = 0;
			HostManagementModel hostManagement=new HostManagementModel();
			
			String sql = "select * from hostmanagement where M_ID ="+id+"";			
			rs = db_back.executeQuery(sql);
			
			if (rs != null) {
				
				try {	
					if(rs.next()){
						state_current = rs.getString("M_STATE");	
					}
									
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}	
			
			if (!state.equals(state_current)) {
				
					String sql_update="update hostmanagement set M_STATE='0' where M_ID="+id+"";
					temp=db_back.executeUpdate(sql_update);
					if(temp>0){
						flag="平台数据已更新，目前状态：撤防";
					}
								
			}else{
								
				flag="撤防状态正常";
			}
       			
			return flag;
		}
}

