package com.zx.tianjing.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zx.tianjing.bean.VersionModel;
import com.zx.tianjing.dao.util.JxSqlServer2008DbConnection;

public class VersionDao {
      //连接数据库
	private JxSqlServer2008DbConnection db_back=new JxSqlServer2008DbConnection();
	Connection connection=db_back.conn();
	
	//查询所有，返回数据到手机端
	public List findAllVersion(){
	
		List listVersion=new ArrayList();
		ResultSet rs=null;
		String sql="select * from version ";
		rs=db_back.executeQuery(sql);
		if(rs!=null){
			try {
				while(rs.next()){
					VersionModel versionModel=new VersionModel();
					versionModel.setVersion_id(rs.getInt(1));
					versionModel.setVersion_no(rs.getString(2));
					versionModel.setVersion_url(rs.getString(3));
					versionModel.setVersion_time(rs.getDate(4));
										
					listVersion.add(versionModel);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
				
		return listVersion;
	}
	
	/*public VersionModel findVersionModel(int id){
		VersionModel versionModel=null;
		ResultSet rs=null;
		String sql="select * from version where v_id="+id;
		rs=db_back.executeQuery(sql);
		try {
			if(rs.next()){
				return versionModel=new VersionModel(rs.getInt("v_id"),rs.getString("v_no"),rs.getString("v_url"),rs.getDate("v_time"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}*/
}
