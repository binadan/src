<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String root = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>添加住戶</title>
<script src="<%=root%>/js/jquery.min.js"></script>
<script src="<%=root%>/js/check.js"></script>
<link href="<%=root%>/images/skin.css" rel="stylesheet" type="text/css" />
<link href="<%=root%>/css/css.css" rel="stylesheet" type="text/css" />
<link href="<%=root%>/css/style.css" rel="stylesheet" type="text/css" />
</head>
<script type="text/javascript">

	
	//增加
	function addPay() {
		var id = parent.jQuery("#hid").val();
		var data = $("#editForm").serialize();
		$.post("addPay?id=" + id, data, function(resultData) {
			var result = eval(eval("(" + resultData + ")"));
			if (result == 1) {
				window.parent.$.colorbox.close();
				parent.location.reload();
			} else {
				alert("添加失败，请重新添加或与管理员联系");
			}
		})
	
}
	
</script>


<body>

	<form action="" method="post" id="editForm">
		<!-- 这里加内容 start-->
		<table width="100%" border="0" cellspacing="0" cellpadding="1">
			<thead>
				<tr>
					<td colspan="3"
						style="text-align: center; height: 30px; background-color: #C9C9C9; font-size: 18px;">添加住户信息</td>
				</tr>
			</thead>
			<tr>
				<td width="30%" height="30" align="right" bgcolor="#f2f2f2"
					class="left_txt2">主机编号：</td>
				<td width="32%" height="30" bgcolor="#f2f2f2"><input
					name="paymentmanagement.PNo" type="text" id="PHid" size="30"/>
				</td>
				<td width="45%" height="30" bgcolor="#f2f2f2" class="left_txt"><div id="HName_prompt"><font class="ERROR_No" style="color: red;">*此为必填项</font></div></td>
			</tr>
			<tr>
				<td width="30%" height="30" align="right" bgcolor="#f2f2f2"
					class="left_txt2">住户房间号：</td>
				<td width="32%" height="30" bgcolor="#f2f2f2"><input
					name="paymentmanagement.PHid" type="text" id="PHid" size="30"/>
				</td>
				<td width="45%" height="30" bgcolor="#f2f2f2" class="left_txt"><div id="HName_prompt"><font class="ERROR_No" style="color: red;">*此为必填项</font></div></td>
			</tr>
			<tr>
				<td width="30%" height="30" align="right" bgcolor="#f2f2f2"
					class="left_txt2">缴费金额：</td>
				<td width="32%" height="30" bgcolor="#f2f2f2"><input
					name="paymentmanagement.PMoney" type="text" id="PMoney" size="30" />
				</td>
				<td width="45%" height="30" bgcolor="#f2f2f2" class="left_txt"><div id="HTel_prompt" ><font class="ERROR_No" style="color: red;">*此为必填项</font></div></td>
			</tr>
			
			<tr>
				<td colspan="3" align="center" style="padding-top:  15px;"><input
					type="button" value="添 加 " onclick="addPay();" /> <input
					type="reset" value=" 重 置 " /></td>
			</tr>
		</table>
	</form>

</body>
</html>
