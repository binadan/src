<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script type="text/javascript">
/* 	function test(){
		var date = new Date();
		var str = date.getFullYear()+"_"+(date.getMonth()+1)+"_"+date.getDate()+"_"+date.getTime();
		//var strs = str.replace(/:/g, "_");
		alert(str);
	} */


</script>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'index.jsp' starting page</title>
  </head>
  
  <body>
	<input type="button" value="提交" onclick="window.location.href='TestServlet'">
  </body>
</html>
