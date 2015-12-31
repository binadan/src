package com.action;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.client.methods.HttpGet;
import org.apache.struts2.ServletActionContext;

import com.zx.tianjing.dao.LarumInfoDao;
import com.zx.tianjing.dao.util.JxSqlServer2008DbConnection;

public class LarumAction {
	//连接数据库
	private JxSqlServer2008DbConnection db_back=new JxSqlServer2008DbConnection();
	
	//<src=主机ID,alarmtype =type>
	private int src;
	private String alarmtype;
	private String res;
	private String state;
	private String szdevip;
	private String szauthacc;
	private String szauthpwd;
	private String shebeiname;
	
	


	public String getShebeiname() {
		return shebeiname;
	}
	public void setShebeiname(String shebeiname) {
		this.shebeiname = shebeiname;
	}
	public String getSzdevip() {
		return szdevip;
	}
	public void setSzdevip(String szdevip) {
		this.szdevip = szdevip;
	}
	public String getSzauthacc() {
		return szauthacc;
	}
	public void setSzauthacc(String szauthacc) {
		this.szauthacc = szauthacc;
	}
	public String getSzauthpwd() {
		return szauthpwd;
	}
	public void setSzauthpwd(String szauthpwd) {
		this.szauthpwd = szauthpwd;
	}
	public int getSrc() {
		return src;
	}
	public void setSrc(int src) {
		this.src = src;
	}
	public String getAlarmtype() {
		return alarmtype;
	}
	public void setAlarmtype(String alarmtype) {
		this.alarmtype = alarmtype;
	}
	public String getRes() {
		return res;
	}
	public void setRes(String res) {
		this.res = res;
	}
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	HttpGet httpgets = null;
	static Map<String, String> map = new HashMap<String, String>();
	public String LarumInfoState(){
		Timer timer = new Timer();
		
		LarumInfoDao dao = new LarumInfoDao();
		
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				map = new HashMap<String, String>();
			}
		};
		timer = new Timer();
		timer.schedule(task, 1000 * 60 * 5);
		try {
			if(map.get(String.valueOf(src))==null){
			System.out.println(map.get(String.valueOf(src)));
			String sql = "select b.H_NO,b.H_NAME,b.H_TEL,a.L_MID,a.L_ID,c.V_HOEID,c.V_SHEBEINAME from laruminfo a,household b ,videosave c where a.L_HID = b.H_NO and L_MID = "+src;
			ResultSet rs = db_back.executeQuery(sql);
			//List<String> list = new ArrayList<String>();
			String h_no = "";
			String h_name = "";
			String h_tel = "";
			String l_mid = "";
			Integer l_id = 0;
			String v_hoeid = "";
			String v_shebeiname = "";
				while (rs.next()) {
					h_no = java.net.URLEncoder.encode(rs.getString(1),"utf-8");
					h_name = java.net.URLEncoder.encode(rs.getString(2),"utf-8");
					//h_name = rs.getString(2);
					h_tel = rs.getString(3);
					l_mid = rs.getString(4);
					l_id = Integer.parseInt(rs.getString(5));
					v_hoeid = rs.getString(6);
					v_shebeiname = rs.getString(7);
					
				}
				
			HttpServletRequest request = ServletActionContext.getRequest();
			request.getSession().setAttribute("h_name", h_name);
			String str = request.getRemoteAddr();
			dao.LarumInfoState(src, alarmtype);
			
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String datename = format.format(new Date()).replaceAll("-","-").replaceAll(" ","--").replaceAll(":","-");//+System.currentTimeMillis();
			if(alarmtype != null || alarmtype != ""){
				Process pro = Runtime.getRuntime().
						exec("rundll32 url.dll,FileProtocolHandler " +
								"http://localhost:8080/jsonPrcProjectApi/view.jsp?action=start&h_no="
								+java.net.URLEncoder.encode(h_no,"utf-8")+"&h_name="+java.net.URLEncoder.encode(h_name,"utf-8") +""+"&h_tel="+h_tel+"&l_mid="+l_mid+
								"&v_hoeid="+v_hoeid+"&shebeiName="+java.net.URLEncoder.encode(shebeiname,"utf-8")+"&datename="+datename+"&szDevIP="+szdevip+"&szAuthAcc="+szauthacc+"&szAuthPwd="+szauthpwd);
				map.put(String.valueOf(src),String.valueOf(src));
				//
				res = "ok";
				state = "正在录制监控视频请稍后...";
			}
			
			String sqls = "insert into videosave"+
					"(V_NAME,V_MID,V_LID,V_ADD,V_HOEID,V_SHEBEINAME,V_VIDEOSTART) values"+
						 "('"+datename+"','"+l_mid+"','"+l_id+"','http://"+str+":8080/myAcl/upvideo/"+datename+".avi','"+szdevip+"','"+shebeiname+"','"+datename+"')";
			db_back.executeUpdate(sqls);
			
			}else{
				state = "该房屋正在报警中...";
			}
		} catch (Exception e) {
			res = "error";
			e.printStackTrace();
		}
		
		return "success";
	}
	
	
}
