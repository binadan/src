<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String root = request.getContextPath();
%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>修改警报信息</title>
<script src="<%=root%>/js/jquery.min.js"></script>
<script src="<%=root%>/js/check.js"></script>
<link href="<%=root%>/images/skin.css" rel="stylesheet" type="text/css" />
<link href="<%=root%>/css/css.css" rel="stylesheet" type="text/css" />
<link href="<%=root%>/css/style.css" rel="stylesheet" type="text/css" />
<script type='text/javascript'
	src='<%=root%>/js/jquery.contextmenu.r2-min.js'></script>
<script type="text/javascript" src="<%=root%>/js/WdatePicker.js"></script>
<script type="text/javascript">
	//增加
	function updateLaruminfo() {
		if ($('#houseId').val() == "") {
			//验证
			alert("房屋编号不能为空");
			return false;
		}
		if ($('#zhujiId').val() == "") {
			//验证
			alert("主机ID不能为空");
			return false;
		}
		var id = parent.jQuery("#hid").val();
		var data = $("#editForm").serialize();
		$.post("updateLaruminfo?id=" + id, data, function(resultData) {
			var result = eval(eval("(" + resultData + ")"));
			//alert("*****");
			if (result == 1) {

				window.parent.$.colorbox.close();
				parent.location.reload();
			} else {
				alert("修改失败，请重新添加或与管理员联系");
			}
		})

	}
</script>
<body>

	<form action="" id="editForm">
		<!-- 隐藏字段 start-->
		<s:hidden id="l_id" name="laruminfo.l_id" />
		<!-- 这里加内容 start-->
		<table width="100%" border="0" cellspacing="0" cellpadding="1">
			<thead>
				<tr>
					<td colspan="3"
						style="text-align: center; height: 30px; background-color: #C9C9C9; font-size: 18px;">修改报警信息</td>
				</tr>
			</thead>
			<tr>
				<td width="32%" height="30" align="right" bgcolor="#f2f2f2"
					class="left_txt2">报警房屋：</td>
				<td width="32%" height="30" bgcolor="#f2f2f2"><s:textfield
						name="laruminfo.l_hid" readonly="true"></s:textfield></td>
				</td>
				<td width="45%" height="30" bgcolor="#f2f2f2" class="left_txt"><font class="ERROR_No" style="color: red;">*此为必填项</font></td>
			</tr>
			<tr>
				<td width="32%" height="30" align="right" bgcolor="#f2f2f2"
					class="left_txt2">主机ID：</td>
				<td width="32%" height="30" bgcolor="#f2f2f2"><s:textfield
						name="laruminfo.l_mid" readonly="true"></s:textfield></td>
				</td>
				<td width="45%" height="30" bgcolor="#f2f2f2" class="left_txt"><font class="ERROR_No" style="color: red;">*此为必填项</font></td>
			</tr>

			<tr>
				<td width="32%" height="30" align="right" bgcolor="#f2f2f2"
					class="left_txt2">警报类别：</td>
				<td width="32%" height="30" bgcolor="#f2f2f2"><s:if
						test="laruminfo.l_type==0">
						<s:set name="templ_type" value="'无线紧急按钮'"></s:set>
					</s:if> <s:if test="laruminfo.l_type==1">
						<s:set name="templ_type" value="'红外入侵探测器'"></s:set>
					</s:if> <s:if test="laruminfo.l_type==2">
						<s:set name="templ_type" value="'门磁'"></s:set>
					</s:if> <s:if test="laruminfo.l_type==3">
						<s:set name="templ_type" value="'无线可燃气泄漏探测器'"></s:set>
					</s:if> <s:if test="laruminfo.l_type==4">
						<s:set name="templ_type" value="'无线烟雾（火警）探测器'"></s:set>
					</s:if><s:if test="laruminfo.l_type==5">
						<s:set name="templ_type" value="'主机失联'"></s:set>
					</s:if>
					 <input type="text" value="${templ_type}" readonly="readonly" /></td>

				<td width="45%" height="30" bgcolor="#f2f2f2" class="left_txt"></td>
			</tr>
			<tr>
				<td width="32%" height="30" align="right" bgcolor="#f2f2f2"
					class="left_txt2">警报时间：</td>
				<td width="32%" height="30" bgcolor="#f2f2f2"><input size="20"
					name="laruminfo.l_date" value="${laruminfo.l_date}"
					readonly="readonly" size="20" />
				</td>
				<td width="45%" height="30" bgcolor="#f2f2f2" class="left_txt"></td>
			</tr>
			<tr>
				<td width="20%" height="30" align="right" bgcolor="#f2f2f2"
					class="left_txt2">处理说明：</td>
				<td width="32%" height="30" bgcolor="#f2f2f2"><textarea
						cols="23" rows="8" name="laruminfo.l_remark" id="l_remark">${laruminfo.l_remark}</textarea>
				</td>
				<td width="45%" height="30" bgcolor="#f2f2f2" class="left_txt"></td>
			</tr>
			<tr>
				<td colspan="3" align="center" style="padding-top:  50px;"><input
					type="button" value="修 改 " onclick="updateLaruminfo()" /> <input
					type="reset" value=" 重 置 " /></td>
			</tr>
		</table>
	</form>

</body>
</html>
