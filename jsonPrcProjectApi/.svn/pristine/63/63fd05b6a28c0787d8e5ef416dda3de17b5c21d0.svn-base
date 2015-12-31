package com.zx.tianjing.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

import java.util.List;



import com.zx.tianjing.bean.FestivalModel;
import com.zx.tianjing.bean.ShortModel;

import com.zx.tianjing.dao.util.JxSqlServer2008DbConnection;
public class ShortDao {
	private static final Collection ShortModel = null;
//	private DbConnection db = new DbConnection();
	private JxSqlServer2008DbConnection db_back=new JxSqlServer2008DbConnection();
//手机端先查询所有短信，然后返回发送次数
	public boolean uploadShortMessageStatics(String msgid, int totalsend) {
		boolean bool = false;
		int temp = 0;
		int total = 0;
		String sql = "select *  from MAST0832 where gid ='"+ msgid + "' ";
		ResultSet rs = null;
		rs = db_back.executeQuery(sql);
		if (rs != null) {
			try {
				while (rs.next()) {
					total = rs.getInt("totalsend");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		total = total + totalsend;

		String sql_update = "update MAST0832 set totalsend='"
				+ total + "' where gid='" + msgid + "'";
		System.out.println(sql_update);
		//db.beginTransaction();
		temp = db_back.executeUpdate(sql_update);
		//db.commit();
		if (temp == 1) {
			bool = true;
		}
		return bool;
	}
       //查询短信类别所对应的短信内容，查询短信类别所对应的短信内容，maxMsgid手机端返回一个短信数，然后根据短信数来取短信内容，实现模糊查询
	public List<ShortModel> getQueryMenberList(int maxMsgid, int categoryid,int festivagid, String keyword){
	List<ShortModel> ShortList = new ArrayList<ShortModel>();
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	ShortModel Shorts = null;
	ResultSet rs = null;
	String sql = null;
	if(categoryid==3){
	sql="select * from MAST0832 where  content like '%"
				+ keyword
				+ "%' and gid > '"
				+ maxMsgid
				+ "' and festivalid='"+festivagid+"' order by gid";
	}else if(categoryid!=3){
		sql="select * from MAST0832 where  content like '%"
				+ keyword
				+ "%' and gid > '"
				+ maxMsgid
				+ "' and categoryid='"+categoryid+"' order by gid";
	}
	/*if (categoryid == -1 && festivagid != -1) {

		sql = "select * from MAST0832 where content like '%"
				+ keyword
				+ "%' and gid > '"
				+ maxMsgid
				+ "' and gid in (select msgid from MAST0832 where  festivagid='"
				+ festivagid + "')";
	} else if (categoryid != -1 && festivagid == -1) {

		sql = "select * from MAST0832 where content like '%"
				+ keyword
				+ "%' and gid > '"
				+ maxMsgid
				+ "' and gid in (select msgid from MAST0832 where categoryid='"
				+ categoryid + "')";
	}*/
	System.out.println(sql);
	int index = 0;
	try {
		rs = db_back.executeQuery(sql);
		if (rs != null) {
			while (rs.next() && index < 20) {
				index++;
				Shorts = new ShortModel();
				Shorts.setGid(rs.getInt("gid"));
				Shorts.setCategoryid(rs.getInt("categoryid"));
				Shorts.setFestivalid(rs.getInt("festivalid"));
				Shorts.setContent(rs.getString("content"));
				Shorts.setTotalsend(rs.getInt("totalsend"));
				Shorts.setPopularity(rs.getInt("popularity"));
				Shorts.setUpduser(rs.getString("upduser"));
				Shorts.setUpddate(rs.getString("upddate"));
				Shorts.setCrtuser(rs.getString("crtuser"));
				Shorts.setCrtdate(rs.getString("crtdate"));
				Shorts.setRowstate(rs.getString("rowstate"));
				ShortList.add(Shorts);
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
		//db.rollback();
	}

	return ShortList;
}

}
