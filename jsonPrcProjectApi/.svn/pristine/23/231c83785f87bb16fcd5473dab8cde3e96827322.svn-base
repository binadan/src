package com.action;


import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import org.apache.http.HttpRequest;
import org.apache.http.client.methods.HttpGet;
import org.apache.struts2.ServletActionContext;
import com.zx.tianjing.bean.LarumInfosModel;
import com.zx.tianjing.bean.LaruminfoModel;
import com.zx.tianjing.dao.LarumInfoDao;
import com.zx.tianjing.dao.util.JxSqlServer2008DbConnection;
public class LarumInfosAction{
	private JxSqlServer2008DbConnection db_back=new JxSqlServer2008DbConnection();
	private String L_TYPE;//报警类别
	private String L_DATE;//报警时间
	private String L_MID;//报警主机ID
	private String L_HID;//报警住户编号
	private String L_STATE;//处理状态
	private Integer result ;
	private String msg = new String();
    Map<String, Object> map1  = null;

	public String getL_MID() {
		return L_MID;
	}
	public String getL_HID() {
		return L_HID;
	}
	public void setL_HID(String l_HID) {
		L_HID = l_HID;
	}
	public void setL_MID(String l_MID) {
		L_MID = l_MID;
	}

	public String getL_TYPE() {
		return L_TYPE;
	}
	public void setL_TYPE(String l_TYPE) {
		L_TYPE = l_TYPE;
	}
	public String getL_DATE() {
		return L_DATE;
	}
	public void setL_DATE(String l_DATE) {
		L_DATE = l_DATE;
	}
	
	public String getL_STATE() {
		return L_STATE;
	}
	public void setL_STATE(String l_STATE) {
		L_STATE = l_STATE;
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

	HttpGet httpgets = null;
	static Map<String, String> map = new HashMap<String, String>();
	
	
	static Timer timer = new Timer();
	HttpServletRequest request = ServletActionContext.getRequest();
	public String exigency() throws UnsupportedEncodingException {
		LarumInfosModel laruminfo = new LarumInfosModel();
		
		
		String sql2  = "select L_TYPE from laruminfo where L_MID='"+L_MID+"'";
		ResultSet rs2 = db_back.executeQuery(sql2);
		
		
	
			try {
				if(rs2.next()){
					if(L_TYPE.equals("0")){
						msg = exigencys();
					}else{
						try {
							Thread.sleep(1000 * 10);
							msg = exigencys();
						} catch (InterruptedException e1) {
							e1.printStackTrace();
						}
					}
					
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		
			return "success"; 
	}
	
	public String exigencys() throws UnsupportedEncodingException{
		LarumInfoDao dao = new LarumInfoDao();
		LarumInfosModel laruminfo = new LarumInfosModel();
		String L_MID = request.getParameter("L_MID");
		String L_DATE = request.getParameter("L_DATE");
		String L_TYPE = request.getParameter("L_TYPE");
		String L_HID = request.getParameter("L_HID");
		String L_VHOEID = request.getParameter("L_VHOEID");
		String L_STATE = request.getParameter("L_STATE");
		laruminfo.setL_STATE(L_STATE);
		laruminfo.setL_MID(L_MID);
		laruminfo.setL_TYPE(L_TYPE);
		laruminfo.setL_DATE(L_DATE);
		laruminfo.setL_HID(L_HID);
	
		try {
			String Sql = "select * from hostManageMent where M_HOUSEID ='"+laruminfo.getL_HID()+"'";
			ResultSet rs1 = db_back.executeQuery(Sql);
			if(rs1.next()){
			
			
		    String sql ="select * from laruminfo where L_MID='"+laruminfo.getL_MID()+"' and L_TYPE='"+laruminfo.getL_TYPE()+"' and  L_STATE='"+laruminfo.getL_STATE()+"'";
			
			ResultSet rs2 = db_back.executeQuery(sql);
			
				if(rs2.next()){
					//map1 = dao.exigency(laruminfo);
					String sql_query = "select H_USERNAME,H_NAME,H_TEL,H_EMERGENCNAME,H_EMERGENCTEL" +
							",H_EMERGENCNAME1,H_EMERGENCTEL1,H_EMERGENCNAME2," +
							"H_EMERGENCTEL2,H_NO,L_TYPE,L_DATE from household as h ," +
							"laruminfo as l where h.H_NO = l.L_HID AND L_MID='"+laruminfo.getL_MID()+"'";
						ResultSet rs = db_back.executeQuery(sql_query);
						String h_username = "";
						String h_name = "";  
						String h_tel = "";
					    String h_emergencname="";
						String h_emergenctel="";
						String h_emergencname1="";
						String h_emergenctel1="";
						String h_emergencname2="";
					    String h_emergenctel2="";
					    String h_no="";
					    String l_type="";
					    String l_date ="";
					    while(rs.next()){
							h_username = rs.getString(1);
							h_name = java.net.URLEncoder.encode(rs.getString(2),"utf-8");
							h_tel = rs.getString(3);
							h_emergencname =java.net.URLEncoder.encode(rs.getString(4),"utf-8");
							h_emergenctel = rs.getString(5);
							h_emergencname1 = java.net.URLEncoder.encode(rs.getString(6),"utf-8");
							h_emergenctel1 = rs.getString(7);
							h_emergencname2 =java.net.URLEncoder.encode(rs.getString(8),"utf-8");
							h_emergenctel2 = rs.getString(9);
							h_no = java.net.URLEncoder.encode(rs.getString(10),"utf-8");
							l_type = rs.getString(11);
							l_date = rs.getString(12);
						}	
					    String str = "?action=start&h_username="+h_username+"&h_name="+h_name+"&h_tel="+h_tel+"&h_emergencname="+h_emergencname+"&h_emergenctel="+h_emergenctel+"&h_emergencname1="+h_emergencname1+"&h_emergenctel1="
							    +h_emergenctel1+"&h_emergencname2="+h_emergencname2+"&h_emergenctel2="+h_emergenctel2+"&h_no="+h_no+"&l_type="+L_TYPE+"&l_date="+L_DATE+"&l_mid="+L_MID;
					   // str = java.net.URLEncoder.encode(str, "utf-8");
						Process pro = Runtime.getRuntime().
										exec("rundll32 url.dll,FileProtocolHandler " +
												"http://localhost:8080/jsonPrcProjectApi/viewInfo.jsp" +  str);
					map.put(String.valueOf(L_MID),String.valueOf(L_MID));
				
					
					msg = "该房间正在紧急响铃";
					result = 0;
				}else{
					
					msg = "该房间已经紧急响铃";
					result = 0;
				}
				
			}
			else{
				result = -1;
				msg = "该房间不存在";
			}
			
			
			/*}*/
		} catch (Exception e) {
			
			
			e.printStackTrace();
		}
		
		return msg;
	}
}
