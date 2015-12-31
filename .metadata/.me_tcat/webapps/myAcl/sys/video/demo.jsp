<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String htmlData = request.getParameter("content1") != null ? request.getParameter("content1") : "";
String root=request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+root+"/";%>

<!doctype html>
<html>
<head>
	<meta charset="utf-8" />
	<title>KindEditor JSP</title>
	<link rel="stylesheet" href="<%=basePath %>/kindeditor/themes/default/default.css" />
	<link rel="stylesheet" href="<%=basePath %>/kindeditor/plugins/code/prettify.css" />
	<script charset="utf-8" src="<%=basePath %>/kindeditor/kindeditor.js"></script>
	<script charset="utf-8" src="<%=basePath %>/kindeditor/lang/zh_CN.js"></script>
	<script charset="utf-8" src="<%=basePath %>/plugins/code/prettify.js"></script>
	<script charset="utf-8" src="<%=basePath %>/kindeditor/plugins/insertVideo/jquery-1.9.1.js"></script>
    <script charset="utf-8" src="<%=basePath %>/kindeditor/plugins/insertVideo/ckplayer/ckplayer.js"></script>
    <script charset="utf-8" src="<%=basePath %>/kindeditor/plugins/insertVideo/callCkplayer.js"></script>
	<script>
		KindEditor.ready(function(K) {
			var editor1 = K.create('textarea[name="content1"]', {
				cssPath : '<%=basePath %>plugins/code/prettify.css',
				uploadJson : '<%=basePath %>jsp/upload_json.jsp',
				fileManagerJson : '<%=basePath %>jsp/file_manager_json.jsp',
				allowFileManager : true,
				afterCreate : function() {
					var self = this;
					K.ctrl(document, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
				}
			});
			prettyPrint();
		});
	</script>
</head>
<body>
	<%=htmlData%>
	<form name="example" method="post" action="demo.jsp">
		<textarea name="content1" cols="100" rows="8" style="width:700px;height:200px;visibility:hidden;"><%=htmlspecialchars(htmlData)%></textarea>
		<br />
		<input type="submit" name="button" value="提交内容" /> 
	</form>
</body>
</html>
<%!
private String htmlspecialchars(String str) {
	str = str.replaceAll("&", "&amp;");
	str = str.replaceAll("<", "&lt;");
	str = str.replaceAll(">", "&gt;");
	str = str.replaceAll("\"", "&quot;");
	return str;
}
%>