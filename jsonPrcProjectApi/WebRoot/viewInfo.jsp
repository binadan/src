<%@page import="java.net.URLDecoder"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>My JSP 'infos.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="charset" content="UTF-8">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<%@ taglib prefix="s" uri="/struts-tags"%>
<script language="JavaScript" type="text/JavaScript">
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

		remote.ShowToolBar = 1;//whether to show toolbar
		remote.AddDev4(nDevType,bInLan,szDevIP,nPort,szDevName,szAuthAcc,szAuthPwd,1);
		remote.Listen=1;//whether to play soound
		remote.TurnImg = 0;   //whether reverse video
		remote.ConnectAll();
		remote.Start();
			
	
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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
</head>
<body leftmargin="0" topmargin="0" onload="ShowDev()">
	<table width="100%" border="0" align="center">
		<tr>
			<td align="center"></td>
		</tr>
		<tr>
			<td>
				<table width="800" border="0" Align="left">


					<%
					
			 String h_username = request.getParameter("h_username");
			//request.setCharacterEncoding("utf-8");
			String h_name=request.getParameter("h_name");
			h_name= java.net.URLDecoder.decode(h_name,"utf-8"); 
			
		    String h_tel = request.getParameter("h_tel");
		    
		    
		    String h_emergencname= request.getParameter("h_emergencname");
		    h_emergencname = java.net.URLDecoder.decode(h_emergencname,"utf-8");
		    
		   String h_emergenctel= new String(request.getParameter("h_emergenctel").getBytes("iso-8859-1"), "utf-8");
            
            String h_emergencname1= request.getParameter("h_emergencname1");
		    h_emergencname1 = java.net.URLDecoder.decode(h_emergencname1,"utf-8");
		  
            
		    String h_emergenctel1=request.getParameter("h_emergenctel1");
		    
	        String h_emergencname2=request.getParameter("h_emergencname2");
	        h_emergencname2 = java.net.URLDecoder.decode(h_emergencname2,"utf-8"); 
	      
		     String h_emergenctel2=request.getParameter("h_emergenctel2");
		    
		    String h_no=request.getParameter("h_no");  
		    h_no = java.net.URLDecoder.decode(h_no,"utf-8"); 
		    
		    String l_type = request.getParameter("l_type");
		    String l_date = request.getParameter("l_date");
		
				//encodeURI（"url"）转码
				//decodeURI("url")解码
 %>

					<div>

						<tr>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;住户账号:</td>
							<td><input type="text" name="h_username"
								value="<%=h_username %>" /></td>
						</tr>
						<tr>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;住户姓名:</td>
							<td><input type="text" name="h_name" value="<%=h_name %>" />
							</td>
						</tr>
						<tr>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;联系电话:</td>
							<td><input type="text" name="h_tel" value="<%=h_tel %>" />
							</td>
						</tr>
						<tr>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;紧急联系人:</td>
							<td><input type="text" name="h_emergencname"
								value="<%=h_emergencname %>" /></td>
						</tr>
						<tr>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;紧急联系电话:
							</td>
							<td><input type="text" name="h_emergenctel"
								value="<%=h_emergenctel %>" /></td>
						</tr>
						<tr>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;紧急联系人1:
							</td>
							<td><input type="text" name="h_emergencname1"
								value="<%=h_emergencname1 %>" /></td>
						</tr>
						<tr>
							<td>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;紧急联系电话1:</td>
							<td><input type="text" name="h_emergenctel1"
								value="<%=h_emergenctel1 %>" /></td>
						</tr>
						<tr>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;紧急联系人2:
							</td>
							<td><input type="text" name="h_emergencname2"
								value="<%=h_emergencname2 %>" /></td>
						</tr>
						<tr>
							<td>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;紧急联系电话2:</td>
							<td><input type="text" name="h_emergenctel2"
								value="<%=h_emergenctel2 %>" /></td>
						</tr>
						<tr>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;家庭住址:</td>
							<td><input type="text" name="h_no" value="<%=h_no %>" /></td>
						</tr>
						<tr>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;报警时间:</td>
							<td><input type="text" name="l_date" value="<%=l_date %>" />
							</td>

						</tr>
						<tr>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;报警类别:</td>

							<%--  <input type="text" name="l_type" value="<%=l_type %>" /> --%>
							<td>
								<%
								 if(l_type.equals("0")){
								    %> <input type="text" name="l_type" value="无线紧急按钮" /> <% }else if(l_type.equals("1")){
								       %> <input type="text" name="l_type" value="红外入侵探测器" /> <%}
								else if(l_type.equals("2")){
								       %> <input type="text" name="l_type" value="门磁" /> <%}else if(l_type.equals("3")){
								       %> <input type="text" name="l_type" value="无线可燃气泄漏探测器" />
								<%}else if(l_type.equals("4")){
								       %> <input type="text" name="l_type" value="无线烟雾（火警）探测器" />
								<%}else if(l_type.equals("5")){
										%> <input type="text" name="l_type" value="主机失联" /> <% }
								 %>
							</td>
						</tr>



					</div>
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
				</table>
			</td>
		</tr>
		<tr>
			<td align="center"></td>
		</tr>
	</table>
	</td>
	<td width="18" background="images/rightline.gif">&nbsp;</td>
	</tr>
	<tr>
		<td width="16" height="20" background="images/corner_bl.gif">&nbsp;
		</td>
		<td background="images/bottomline.gif">&nbsp;</td>
		<td width="18" background="images/corner_br.gif">&nbsp;</td>
	</tr>
	</table>
	<script language="jscript" FOR="remote" event="OnClick">   
 	//alert("clicked on Activex");   
  </script>
</body>
</body>
</html>
