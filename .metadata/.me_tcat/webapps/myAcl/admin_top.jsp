<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%String root=request.getContextPath();%>
<html>
<head>
<title> 管理页面</title>
<meta http-equiv=Content-Type content=text/html;charset=gb2312>
<!-- 60刷新一次 -->

<link href="images/skin.css" rel="stylesheet" type="text/css">

<script language=JavaScript>
	function logout(){
		if (confirm("您确定要退出系统吗？")){
			top.location = "<%=root%>/loginOut";
		}else{
			window.parent.location.href="index.jsp";
		}
	}

</script>
<script language=JavaScript1.2>
function showsubmenu(sid) {
	function showsubmenu(sid) {
		var whichEl = eval("submenu" + sid);
		var menuTitle = eval("menuTitle" + sid);
		if (whichEl.style.display == "none"){
			eval("submenu" + sid + ".style.display=\"\";");
		}else{
			eval("submenu" + sid + ".style.display=\"none\";");
		}
	}
}
</script>


<base target="main">

</head>
<body leftmargin="0" topmargin="0">


<div class="panel pa-top">
	<div class="login_nav" >欢迎你！<b>${sessionScope.sessionUser.person.name}</b> </div>
	<ul class="main_menu">
		<li><a href="right.jsp" target="main"  class="home">首页</a></li>
		<li><a href="#" onclick="logout()" class="logoout">退出</a></li>
	</ul>
</div>

</body>
</html>
