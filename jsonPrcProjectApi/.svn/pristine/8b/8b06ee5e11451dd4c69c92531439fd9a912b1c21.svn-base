package com.zx.tianjing.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;



import com.zx.tianjing.bean.CategoryModel;
import com.zx.tianjing.bean.FestivalModel;
import com.zx.tianjing.bean.HoreModel;
import com.zx.tianjing.bean.VersionModel;



import com.zx.tianjing.bean.ShortModel;

import com.zx.tianjing.dao.util.JxSqlServer2008DbConnection;
public class CategoryDao {
private JxSqlServer2008DbConnection db_back=new JxSqlServer2008DbConnection();
	
	//查询节日
	public List<FestivalModel> getFestivalCategory(){
		List<FestivalModel> festivalModelList =new LinkedList<FestivalModel>();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		FestivalModel festival=null;
		String sql = "";
			sql = "SELECT * FROM SYST0831 order by gid ";
			ResultSet rs=null;
			System.out.println(sql);
			try {
				rs = db_back.executeQuery(sql);
				while (rs.next()) {
					festival= new FestivalModel();
					festival.setGid(rs.getInt("gid"));
					festival.setCaption(rs.getString("caption"));
					festival.setImage(rs.getString("image"));
					festival.setType(rs.getString("type"));
					festival.setDatebegin(rs.getString("datebegin"));
					festivalModelList.add(festival);
				}
				} catch (Exception e) {
					e.printStackTrace();
					//db.rollback();
				}
				return festivalModelList;
	}
//查询短信类别所对应的短信内容，maxMsgid手机端返回一个短信数，然后根据短信数来取短信内容
	public List<ShortModel> getShortMessage(int maxMsgid, int categoryid,int festivagid) {
		List<ShortModel> shortlist = new ArrayList<ShortModel>();
        String sql = null;
        if(categoryid==3){
			 sql= "select * from MAST0832 where gid > '"
					+ maxMsgid
					+ "'  and festivalid='"+festivagid+"' order by gid";
		}else if(categoryid!=3){
			
			sql = "select * from MAST0832 where gid > '"
					+ maxMsgid
					+ "' and categoryid='"+categoryid+"' order by gid";
		}
		System.out.println(sql);
		ResultSet rs = null;
		rs = db_back.executeQuery(sql);
		int index = 0;
		try {
			if(rs!=null){
			while (rs.next() && index < 20) {
				index++;
				ShortModel shortModel = new ShortModel();
				shortModel.setGid(rs.getInt("gid"));
				shortModel.setCategoryid(rs.getInt("categoryid"));
				shortModel.setFestivalid(rs.getInt("festivalid"));
				shortModel.setContent(rs.getString("content"));
				shortModel.setTotalsend(rs.getInt("totalsend"));
				shortModel.setPopularity(rs.getInt("popularity"));
				shortModel.setUpduser(rs.getString("upduser"));
				shortModel.setUpddate(rs.getString("upddate"));
				shortModel.setCrtuser(rs.getString("crtuser"));
				shortModel.setCrtdate(rs.getString("crtdate"));
				shortModel.setRowstate(rs.getString("rowstate"));
				shortlist.add(shortModel);
			}}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return shortlist;
	}
	
//查询所有类别
public List<CategoryModel> getCategoryList(){
	List<CategoryModel> categoryModelList = new ArrayList<CategoryModel>();
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	CategoryModel category = null;
	ResultSet rs = null;
	String sql = "select * from MAST0831 order by gid";
	System.out.println(sql);
	try {
		rs = db_back.executeQuery(sql);
//		rs = db.select(sql);
		while (rs.next()) {
			category = new CategoryModel();
			category.setGid(rs.getInt("gid"));
			category.setParid(rs.getInt("parid"));
			category.setCaption(rs.getString("caption"));
			category.setImage(rs.getString("image"));
			category.setUpduser(rs.getString("upduser"));
			category.setUpddate(rs.getString("upddate"));
			category.setCrtuser(rs.getString("crtuser"));
			category.setCrtdate(rs.getString("crtdate"));
			category.setRowstate(rs.getString("rowstate"));
			categoryModelList.add(category);
		}
		} catch (Exception e) {
			e.printStackTrace();
			//db.rollback();
		}
	
		return categoryModelList;
}
/*//软件升级
   public List<VersionModel> getHore(){
	   System.out.println("##############111111111111");
	   List<VersionModel> horeModelList=new LinkedList<VersionModel>();
	   VersionModel horeModel=null;
	   String sql=" select * from version";
	   System.out.println(sql);
	   try {
		    ResultSet rs=db_back.executeQuery(sql);
		    System.out.println("####### size="+rs.getFetchSize());
		    while(rs.next()){
		    	horeModel=new VersionModel();
		    	horeModel.setV_id(rs.getInt("V_id"));
		    	horeModel.setV_no(rs.getString("V_no"));
		    	horeModel.setV_time(rs.getDate("V_time"));
		    	horeModel.setV_url(rs.getString("V_url"));
//		    	horeModel.setId(rs.getInt("id"));
//		    	horeModel.setType(rs.getNString("type"));
//		    	horeModel.setVersionName(rs.getString("versionName"));
//		    	horeModel.setVersionCode(rs.getInt("versionCode"));
//		    	horeModel.setDownloadUrl(rs.getNString("downloadUrl"));
//		    	horeModel.setUpdateLog(rs.getString("updateLog"));
		    	horeModelList.add(horeModel);
		    }
	} catch (Exception e) {
		e.printStackTrace();
	}
	return horeModelList;
   }
*/
}