<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="org.apache.struts2.ServletActionContext"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%

	String action = request.getParameter("action");
	String szDevIP= request.getParameter("szDevIP");
	String szAuthAcc = request.getParameter("szAuthAcc");
	String szAuthPwd = request.getParameter("szAuthPwd");
	String datename = request.getParameter("datename");
	
 %>
 <%
            String h_no=request.getParameter("h_no");  
		    h_no = java.net.URLDecoder.decode(h_no,"utf-8"); 
			String h_name=request.getParameter("h_name");
			h_name= java.net.URLDecoder.decode(h_name,"utf-8");
			String h_tel = request.getParameter("h_tel"); 
			String l_mid = request.getParameter("l_mid");
			String v_hoeid =request.getParameter("v_hoeid");
			String v_shebeiname =request.getParameter("shebeiName");
			String shebeiName =request.getParameter("shebeiName");
				//encodeURI（"url"）转码
				//decodeURI("url")解码
 %>
<html>
<!-- http://localhost:8080/testDemo/view.jsp -->
<head>
<script language="JavaScript" type="text/JavaScript">
	var VER_AX_LOCALE = "1.1.15.174";//the version of the ActiveX
	var szDevIP="<%=szDevIP%>"; //serial ID or ip of ip camera
	var nPort = 81; //the HTTP port of ip camera, if the szDevIP is serial ID, this whill be ignore
	var szAuthAcc="<%=szAuthAcc%>",szAuthPwd="<%=szAuthPwd%>";//account of ip camera
	var nImgW=500,nImgH=500;//the window size of ip camera.
	var szDevName="SDK网页测试";//the caption shown on the video
	var nDevType=922;//F series is 902,M series is 903
	var bInLan=1;//whether in LAN,1:LAN, 0：WAN
	
	function	ShowDev()
	{
		try{
			remote.ClearDevs();
		}
		catch(exception){
			return;			
		}		
		
//		remote.ShowTitle = 0;
		remote.Lan = "cn";  //language cn:chinese en:english jp:japanese
		remote.ShowOSDName = 1;//whether to show ipcam caption on the video
		remote.SwitchLayout("3 x 3");
		remote.Width=nImgW;  //width of the window
		remote.Height=nImgH; //height of the window
//AddDev4(IP Camera mode (903:M; 902:F; 901:E; 904:V; 905:A),LAN,serial ID or IP, HTTP port, display name, account,password,channel)   	
		remote.ShowToolBar = 1;//whether to show toolbar
		remote.AddDev4(nDevType,bInLan,szDevIP,nPort,szDevName,szAuthAcc,szAuthPwd,1);
		remote.Listen=1;//whether to play soound
		remote.TurnImg = 0;   //whether reverse video
		remote.ConnectAll();
		remote.Start();
			
			<%
				if(action.equals("start")){
			%>
				var date = new Date();
			    var path = "D:/tomcat/apache-tomcat-1/webapps/myAcl/upvideo/<%=datename %>"+".avi";
				//alert(strs);
				var sta = remote.StartRec(path);
				window.setTimeout(stop, 1000*60*5);
				
				//var test = remote.StartRec("E:\\"+mydata.toLocaleString()+".avi");
			<%
				}
			%>
		
	}
	
var preActTime = 0;
var bNeedStop = false;	
function	StopAction()
{
//	alert("a");
  remote.PTZ(1,1,-1,0,0,0);
  bNeedStop = false;  
}

//set action and send to ipcam
function setAction(action, time){
  if((action == -1)&&(!bNeedStop))
  	return 0;
  	  
	var now_time=new Date();
	//alert(now_time - preActTime);
	if((preActTime > 0)&&(now_time-preActTime<300)){
		//alert(now_time-preActTime);
		if(action == -1){
//			alert(now_time-preActTime);
			setTimeout('StopAction();', 500); 	
			return 0;
		}
		else
			return 0;
	}

  	remote.PTZ(1,1,action,time,0,0);
//Set pause time  
  	bNeedStop = action != -1;
	preActTime = now_time;	    
}	
//<src=10000000,alarmtype=4>
function stop(){
	var sto = remote.StopRec();
<%-- 	$.ajax({
	url: "LarumInfoState?src=<%=src %>+"&"+alarmtype=<%=alarmtype %>",
	success: function(){
       
    }}); --%>
    window.opener = null;
	window.open("","_self") ;
	window.close();
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-1.3.2.min.js"></script></head>
<body leftmargin="0" topmargin="0" onload="ShowDev()">
      <table width="100%"  border="0" align="center">
        <tr>
          <td align="center"></td>
        </tr>
        <tr>
          <td>
            <table width="800" border="0" Align="left">
              <tr>
                <td  align="center">
                  <OBJECT id="remote" name="remote" classid="clsid:1E125331-B4E3-4EE3-B3C1-24AD1A3E5DEB" WIDTH="320" HEIGHT="311">
                    <FONT COLOR=red SIZE=5> Not installed plugin,Please click<a href='http://cn-download.eyecloud.so/download/application/ipcamax.exe'>here</a>download and install.</FONT>
                  </OBJECT>
                </td>
              </tr>
              <tr>
                <td>
                  <table width="285" border="0" align="center" id="tbPTZ" name="tbPTZ">
                    <tr>
                      <td width="101"><table width="55" border="0" align="center">
                       <tr><input type="button" value="开始" onclick="starts();" /><input type="button" value="停止" onclick="stop();" /> </tr>
                          <tr>
                            <td width="31%">&nbsp;</td>
                            <td width="18%"><input type="button" name="Up" value="UP"  onMouseDown="setAction(0,31)" onMouseUp="setAction(-1,0)" onMouseOut="setAction(-1,0)""></td>
                            <td width="51%">&nbsp;</td>
                          </tr>
                          <tr>
                            <td><input type="button" name="Left" value="Left" onMouseDown="setAction(1,31)" onMouseUp="setAction(-1,0)" onMouseOut="setAction(-1,0)" ></td>
                            <td align="center" valign="middle">&nbsp;</td>
                            <td><input type="button" name="Right" value="Right" onMouseDown="setAction(2,31)" onMouseUp="setAction(-1,0)" onMouseOut="setAction(-1,0)" ></td>
                          </tr>
                          <tr>
                            <td>&nbsp;</td>
                            <td><input type="button" name="Down" value="Down" onMouseDown="setAction(3,31)" onMouseUp="setAction(-1,0)" onMouseOut="setAction(-1,0)" ></td>
                            <td>&nbsp;</td>
                          </tr>
                      </table></td>
                      <td width="167"><table width="60" border="0" align="center">
                          <tr>
                            <td><input type="button" name="Zoom-" value="Zoom+" onMouseDown="setAction(6, 31)" onMouseUp="setAction(-1, 0)" onMouseOut="setAction(-1,0)"></td>
                            <td><input type="button" name="Zoom+" value="Zoom-" onMouseDown="setAction(7, 31)" onMouseUp="setAction(-1, 0)" onMouseOut="setAction(-1,0)" ></td>
                          </tr>
                          <tr>
                            <td><input type="button" name="Focus-" onMouseDown="setAction(4, 31)" onMouseUp="setAction(-1, 0)" onMouseOut="setAction(-1,0)" value="Focus+"></td>
                            <td><input type="button" name="Focus+" onMouseDown="setAction(5, 31)" onMouseUp="setAction(-1, 0)" onMouseOut="setAction(-1,0)" value="Focus-"></td>
                          </tr>
                      </table></td>
                      <td width="10">&nbsp;</td>
                    </tr>
                </table></td>
              </tr>



<div>
	房屋编号：<%=h_no %> &nbsp;&nbsp;&nbsp;&nbsp;联系人姓名： <%=h_name %>&nbsp;&nbsp;&nbsp;&nbsp;
	联系人电话：<%=h_tel %>&nbsp;&nbsp;&nbsp;&nbsp;主机ID：<%=l_mid %>
         设备ID： <%=v_hoeid %>&nbsp;&nbsp;&nbsp;&nbsp;监控名称： <%=v_shebeiname %>
	<br>

</div>
              <!--
            request.setAttribute("h_no", h_no);
			request.setAttribute("h_name", h_name);
			request.setAttribute("h_tel",h_tel);
			request.setAttribute("l_mid", l_mid);
              -->
<script language="JavaScript" type="text/JavaScript">
			var bInstall,bNewest;
			bNewest = false;
			try{
				remote.ClearDevs();
				bInstall = true;
				
				<%-- bNewest = remote.Ver == "<%=VER_AX_LOCALE%>"; --%>
			}
			catch(exception){
				bInstall = false;
			}
				document.writeln("<tr>");
				document.writeln("<td align='center'><font size='2'><br/><br/>");
				if(bInstall && !bNewest){
					
				}
				
				document.writeln("</font>");
				document.writeln("</td>");
				document.writeln("</tr>");
		 </script>
          </table></td>
        </tr>
        <tr>
          <td align="center"></td>
        </tr>
    </table></td>
    <td width="18" background="images/rightline.gif">&nbsp; </td>
  </tr>
  <tr>
    <td width="16" height="20" background="images/corner_bl.gif">&nbsp; </td>
    <td background="images/bottomline.gif">&nbsp; </td>
    <td width="18" background="images/corner_br.gif">&nbsp; </td>
  </tr>
</table>	
 <script   language="jscript"   FOR="remote"   event="OnClick">   
 	//alert("clicked on Activex");   
  </script>   
</body>