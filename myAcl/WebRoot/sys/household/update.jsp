<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String root = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>修改住户信息</title>
<script src="<%=root%>/js/jquery.min.js"></script>
<script src="<%=root%>/js/check.js"></script>
<link href="<%=root%>/images/skin.css" rel="stylesheet" type="text/css" />
<link href="<%=root%>/css/css.css" rel="stylesheet" type="text/css" />
<link href="<%=root%>/css/style.css" rel="stylesheet" type="text/css" />
<script src="../js/jquery.colorbox.js"></script>
<link media="screen" rel="stylesheet" href="<%=root%>/css/colorbox.css" />
</head>
<script type="text/javascript">
	//修改
	function updHouser() {
		//验证住户账号
		if ($.trim($("#HUsername").val()) == "") {
			alert("住户账号不允许为空！");
			return;
		}
		//验证住户密码
		if ($.trim($("#HUserpwd").val()) == "") {
			alert("住户密码不允许为空！");
			return;
		}
		//验证住户邮箱
		if ($.trim($("#HEmail").val()) == "") {
			alert("住户邮箱不允许为空！");
			return;
		}
		//验证住户姓名
		if ($.trim($("#HName").val()) == "") {
			alert("住户姓名不允许为空！");
			return;
		}
		//
		if ($.trim($("#householdId").val()) == "") {
			alert("房屋编号不允许为空");
			return;
		} else {

		}
		//验证住户电话号码
		if (!isNumber($('#HTel').val())) {
			alert("住户电话号码不能为空并且只允许输入数字！");
			return;
		}
		//验证紧急联系人姓名
		if ($.trim($("#HEmergencname").val()) == "") {
			alert("紧急联系人姓名不允许为空！");
			return;
		}
		//验证紧急联系人电话号码
		if (!isNumber($('#HEmergenctel').val())) {
			alert("紧急联系人电话号码不能为空并且只允许输入数字！");
			return;
		}
		if ($.trim($("#jte1").val()) != "") {
			if (!isNumber($('#jte1').val())) {
				alert("紧急联系人1电话号码只允许输入数字！");
				return;
			}
		}
		if ($.trim($("#jte2").val()) != "") {
			if (!isNumber($('#jte2').val())) {
				alert("紧急联系人2电话号码只允许输入数字！");
				return;
			}
		}
		 
		var id = $("#HId").val();
		var data = $("#editForm").serialize();
		$.post("updHouser?id=" + id, data, function(resultData) {
		
			var result = eval(eval("(" + resultData + ")"));
			if (result == 1) {
				window.close();
				window.location.href = "searchHousehold";
			
			} else {
				alert("添加失败，请重新添加或与管理员联系");
			}
		})
	}
</script>

<body>
	<form action="" id="editForm" method="post">
		<!-- 隐藏字段 start-->
		<s:hidden id="HId" name="household.HId" />
		<!-- end -->
		<table width="100%" border="0" cellspacing="0" cellpadding="1">
			<thead>
				<tr>
					<td colspan="3"
						style="text-align: center; height: 30px; background-color: #C9C9C9; font-size: 18px;">
						修改住戶信息</td>
				</tr>
			</thead>
			<tr>
				<td width="20%" height="30" align="right" bgcolor="#f2f2f2"
					class="left_txt2">住户账号：</td>
				<td width="32%" height="30" bgcolor="#f2f2f2"><s:textfield
						name="household.HUsername" id="HUsername" size="30" readonly="true"></s:textfield>
				</td>
				<td width="45%" height="30" bgcolor="#f2f2f2" class="left_txt"><div
						id="HName_prompt">
						<font class="ERROR_No" style="color: red;"></font>
					</div></td>
			</tr>
			<tr>
				<%-- <td width="20%" height="30" align="right" bgcolor="#f2f2f2"
					class="left_txt2">住户密码：</td>
				<td width="32%" height="30" bgcolor="#f2f2f2">
				<s:textfield name="household.HUserpwd" id="HUserpwd" size="30" type="password"></s:textfield>
				<input name="household.HUserpwd" id="HUserpwd" size="30" type="password"/>
				 <input name="household.HUserpwd" type="hidden" id="HUserpwd"  size="30" value='<s:property value="household.HUserpwd"/>'/>
				</td>
				<td width="45%" height="30" bgcolor="#f2f2f2" class="left_txt"><div
						id="HName_prompt">
						<font class="ERROR_No" style="color: red;"></font>
					</div></td> --%>
					 <input name="household.HUserpwd" type="hidden" id="HUserpwd"  size="30" value='<s:property value="household.HUserpwd"/>'/>
		</tr>
			<tr>
				<td width="20%" height="30" align="right" bgcolor="#f2f2f2"
					class="left_txt2">电子邮箱：</td>
				<td width="32%" height="30" bgcolor="#f2f2f2"><s:textfield
						name="household.HEmail" id="HEmail" size="30"></s:textfield>
				</td>
				<td width="45%" height="30" bgcolor="#f2f2f2" class="left_txt"><div
						id="HEmail_prompt">
						<font class="ERROR_No" style="color: red;"></font>
					</div></td>
			</tr>
			<tr>
				<td width="20%" height="30" align="right" bgcolor="#f2f2f2"
					class="left_txt2">住户姓名：</td>
				<td width="32%" height="30" bgcolor="#f2f2f2"><s:textfield
						name="household.HName" id="HName" size="30"></s:textfield>
				</td>
				<td width="45%" height="30" bgcolor="#f2f2f2" class="left_txt"><div
						id="HName_prompt">
						<font class="ERROR_No" style="color: red;"></font>
					</div></td>
			</tr>
			<%-- <input type="hidden" name="household.HNo" id="householdId" value="${household.HNo }"/> --%>
			<tr>
				<td width="20%" height="30" align="right" bgcolor="#f2f2f2"
					class="left_txt2" type="hidden">房间编号：</td>
				<td width="32%" height="30" bgcolor="#f2f2f2"><s:textfield
						name="household.HNo" size="30" id="householdId"></s:textfield></td>
				<td width="45%" height="30" bgcolor="#f2f2f2" class="left_txt"><div
						id="HName_prompt">
						<font class="ERROR_No" style="color: red;"></font>
					</div></td>
			</tr>
			<tr>
				<td width="20%" height="30" align="right" bgcolor="#f2f2f2"
					class="left_txt2">联系电话：</td>
				<td width="32%" height="30" bgcolor="#f2f2f2"><s:textfield
						name="household.HTel" maxlength="12" id="HTel" size="30"></s:textfield></td>
				<td width="45%" height="30" bgcolor="#f2f2f2" class="left_txt"><div
						id="HName_prompt">
						<font class="ERROR_No" style="color: red;"></font>
					</div></td>
			</tr>
			<tr>
				<td width="20%" height="30" align="right" bgcolor="#f2f2f2"
					class="left_txt2">紧急联系人：</td>
				<td width="32%" height="30" bgcolor="#f2f2f2"><s:textfield
						name="household.HEmergencname" id="HEmergencname" size="30"></s:textfield></td>
				<td width="45%" height="30" bgcolor="#f2f2f2" class="left_txt"><div
						id="HName_prompt">
						<font class="ERROR_No" style="color: red;"></font>
					</div></td>
			</tr>
			<tr>
				<td width="30%" height="30" align="right" bgcolor="#f2f2f2"
					class="left_txt2">紧急联系人电话：</td>
				<td width="32%" height="30" bgcolor="#f2f2f2"><s:textfield
						name="household.HEmergenctel" maxlength="12" id="HEmergenctel" size="30"></s:textfield></td>
				<td width="45%" height="30" bgcolor="#f2f2f2" class="left_txt"><div
						id="HName_prompt">
						<font class="ERROR_No" style="color: red;"></font>
					</div></td>
			</tr>
			<tr>
				<td width="20%" height="30" align="right" bgcolor="#f2f2f2"
					class="left_txt2">紧急联系人1：</td>
				<td width="32%" height="30" bgcolor="#f2f2f2"><s:textfield
						name="household.HEmergencname1" size="30"></s:textfield></td>
				<td width="45%" height="30" bgcolor="#f2f2f2" class="left_txt"></td>

			</tr>
			<tr>
				<td width="20%" height="30" align="right" bgcolor="#f2f2f2"
					class="left_txt2">紧急联系人电话1：</td>
				<td width="32%" height="30" bgcolor="#f2f2f2"><s:textfield
						name="household.HEmergenctel1" maxlength="12" id="jte1" size="30"></s:textfield></td>
				<td width="45%" height="30" bgcolor="#f2f2f2" class="left_txt"></td>
			</tr>


			<tr>
				<td width="20%" height="30" align="right" bgcolor="#f2f2f2"
					class="left_txt2">紧急联系人2：</td>
				<td width="32%" height="30" bgcolor="#f2f2f2"><s:textfield
						name="household.HEmergencname2" size="30"></s:textfield></td>
				<td width="45%" height="30" bgcolor="#f2f2f2" class="left_txt"></td>
			</tr>
			<tr>
				<td width="20%" height="30" align="right" bgcolor="#f2f2f2"
					class="left_txt2">紧急联系人电话2：</td>
				<td width="32%" height="30"  bgcolor="#f2f2f2"><s:textfield
						name="household.HEmergenctel2" maxlength="12" size="30"></s:textfield></td>
				<td width="45%" height="30" bgcolor="#f2f2f2" class="left_txt"></td>
			</tr>

			<tr>
				<td colspan="3" align="center" style="padding-top:  15px;"><input
					type="button" value=" 修 改" onclick="updHouser();" /> <input
					type="reset" value=" 重 置 " />
				</td>
			</tr>
		</table>
	</form>

</body>
</html>
