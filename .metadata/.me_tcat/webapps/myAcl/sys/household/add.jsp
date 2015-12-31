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
	function addHouser() {
		/* //验证客服务账号
		if ($.trim($("#HKefuname").val()) == "") {
			alert("客服务账号不允许为空！");
			return;
		} */
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
			//alert($("#householdId").val());
			alert("房屋编号不允许为空");
			return;
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
		var id = parent.jQuery("#hid").val();
		var data = $("#editForm").serialize();
		$.post("addHouser?id=" + id, data, function(resultData) {
			var result = eval(eval("(" + resultData + ")"));
			if (result == 1) {
				window.parent.$.colorbox.close();
				parent.location.reload();
			} 
			else if(result == 2) {
			alert("此账号已存在");
			}
			else {
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
			<!-- <tr>
				<td width="30%" height="30" align="right" bgcolor="#f2f2f2"
					class="left_txt2">客服务账号：</td>
				<td width="32%" height="30" bgcolor="#f2f2f2"><input
					name="household.HKefuname" type="text" id="HKefuname" size="30"
					onFocus="HNameFocus()" onBlur="HNameBlur()" />
				</td>
				<td width="45%" height="30" bgcolor="#f2f2f2" class="left_txt"><div
						id="HUsername_prompt">
						<font class="ERROR_No" style="color: red;">*此为必填项</font>
					</div></td>
			</tr> -->
			<tr>
				<td width="30%" height="30" align="right" bgcolor="#f2f2f2"
					class="left_txt2">住户账号：</td>
				<td width="32%" height="30" bgcolor="#f2f2f2"><input
					name="household.HUsername" type="text" id="HUsername" size="30"
					onFocus="HNameFocus()" onBlur="HNameBlur()" />
				</td>
				<td width="45%" height="30" bgcolor="#f2f2f2" class="left_txt"><div
						id="HUsername_prompt">
						<font class="ERROR_No" style="color: red;">*此为必填项</font>
					</div></td>
			</tr>
			<tr>
				<td width="30%" height="30" align="right" bgcolor="#f2f2f2"
					class="left_txt2">住户密码：</td>
				<td width="32%" height="30" bgcolor="#f2f2f2"><input
					name="household.HUserpwd" type="text" id="HUserpwd" size="30"
					onFocus="HNameFocus()" onBlur="HNameBlur()" />
				</td>
				<td width="45%" height="30" bgcolor="#f2f2f2" class="left_txt"><div
						id="HUserpwd_prompt">
						<font class="ERROR_No" style="color: red;">*此为必填项</font>
					</div></td>
			</tr>
			<tr>
				<td width="30%" height="30" align="right" bgcolor="#f2f2f2"
					class="left_txt2">电子邮箱：</td>
				<td width="32%" height="30" bgcolor="#f2f2f2"><input
					name="household.HEmail" type="text" id="HEmail" size="30"
					onFocus="HEmailFocus()" onBlur="HEmailBlur()" />
				</td>
				<td width="45%" height="30" bgcolor="#f2f2f2" class="left_txt"><div
						id="HEmail_prompt">
						<font class="ERROR_No" style="color: red;">*此为必填项</font>
					</div></td>
			</tr>
			<tr>
				<td width="30%" height="30" align="right" bgcolor="#f2f2f2"
					class="left_txt2">住户姓名：</td>
				<td width="32%" height="30" bgcolor="#f2f2f2"><input
					name="household.HName" type="text" id="HName" size="30"
					onFocus="HNameFocus()" onBlur="HNameBlur()" />
				</td>
				<td width="45%" height="30" bgcolor="#f2f2f2" class="left_txt"><div
						id="HName_prompt">
						<font class="ERROR_No" style="color: red;">*此为必填项</font>
					</div></td>
			</tr>
			<tr>
				<td width="30%" height="30" align="right" bgcolor="#f2f2f2"
					class="left_txt2">房屋编号：</td>
				<td width="32%" height="30" bgcolor="#f2f2f2"><input
					name="household.HNo" type="text" id="householdId" size="30" /></td>
				<td width="45%" height="30" bgcolor="#f2f2f2" class="left_txt"><div
						id="HTel_prompt">
						<font class="ERROR_No" style="color: red;">格式为dd栋xxxx单元ffff房间</font>
					</div></td>
			</tr>
			<tr>
				<td width="30%" height="30" align="right" bgcolor="#f2f2f2"
					class="left_txt2">联系电话：</td>
				<td width="32%" height="30" bgcolor="#f2f2f2"><input
					name="household.HTel" type="text" id="HTel" size="30"
					onFocus="HTelFocus()" maxlength="12" onBlur="HTelBlur()" />
				</td>
				<td width="45%" height="30" bgcolor="#f2f2f2" class="left_txt"><div
						id="HTel_prompt">
						<font class="ERROR_No" style="color: red;">*此为必填项</font>
					</div></td>
			</tr>
			<tr>
				<td width="30%" height="30" align="right" bgcolor="#f2f2f2"
					class="left_txt2">紧急联系人：</td>
				<td width="32%" height="30" bgcolor="#f2f2f2"><input
					name="household.HEmergencname" type="text" id="HEmergencname"
					size="30" onFocus="HEmergencnameFocus()"
					onBlur="HEmergencnameBlur()" />
				</td>
				<td width="45%" height="30" bgcolor="#f2f2f2" class="left_txt"><div
						id="HEmergencname_prompt">
						<font class="ERROR_No" style="color: red;">*此为必填项</font>
					</div></td>
			</tr>
			<tr>
				<td width="30%" height="30" align="right" bgcolor="#f2f2f2"
					class="left_txt2">紧急联系人电话：</td>
				<td width="32%" height="30" bgcolor="#f2f2f2"><input
					name="household.HEmergenctel" maxlength="11"  type="text" id="HEmergenctel"
					size="30" onFocus="HEmergenctelFocus()" onBlur="HEmergenctelBlur()" />
				</td>
				<td width="45%" height="30" bgcolor="#f2f2f2" class="left_txt"><div
						id="HEmergenctel_prompt">
						<font class="ERROR_No" style="color: red;">*此为必填项</font>
					</div></td>

			</tr>
			<tr>
				<td width="30%" height="30" align="right" bgcolor="#f2f2f2"
					class="left_txt2">紧急联系人1：</td>
				<td width="32%" height="30" bgcolor="#f2f2f2"><input
					name="household.HEmergencname1" type="text" id="jr1" size="30" />
				</td>
				<td width="45%" height="30" bgcolor="#f2f2f2" class="left_txt"></td>
			</tr>
			<tr>
				<td width="30%" height="30" align="right" bgcolor="#f2f2f2"
					class="left_txt2">紧急联系人1电话：</td>
				<td width="32%" height="30" bgcolor="#f2f2f2"><input
					name="household.HEmergenctel1" maxlength="11"  type="text" id="jte1" size="30" />
				</td>
				<td width="45%" height="30" bgcolor="#f2f2f2" class="left_txt"></td>
			</tr>
			<tr>
				<td width="30%" height="30" align="right" bgcolor="#f2f2f2"
					class="left_txt2">紧急联系人2：</td>
				<td width="32%" height="30" bgcolor="#f2f2f2"><input
					name="household.HEmergencname2" type="text" id="jr2" size="30" />
				</td>
				<td width="45%" height="30" bgcolor="#f2f2f2" class="left_txt"></td>
			</tr>
			<tr>
				<td width="20%" height="30" align="right" bgcolor="#f2f2f2"
					class="left_txt2">紧急联系人2电话：</td>
				<td width="32%" height="30" bgcolor="#f2f2f2"><input
					name="household.HEmergenctel2" maxlength="11"  type="text" id="jte2" size="30" />
				</td>
				<td width="45%" height="30" bgcolor="#f2f2f2" class="left_txt"></td>
			</tr>
			<tr>
				<td colspan="3" align="center" style="padding-top:  15px;"><input
					type="button" value="添 加 " onclick="addHouser();" /> <input
					type="reset" value=" 重 置 " /></td>
			</tr>
		</table>
	</form>

</body>
</html>
