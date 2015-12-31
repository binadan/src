<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String root = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>修改主机信息</title>
<script src="<%=root%>/js/jquery.min.js"></script>
<script src="<%=root%>/js/check.js"></script>
<link href="<%=root%>/images/skin.css" rel="stylesheet" type="text/css" />
<link href="<%=root%>/css/css.css" rel="stylesheet" type="text/css" />
<link href="<%=root%>/css/style.css" rel="stylesheet" type="text/css" />
<script src="<%=root%>/js/jquery.colorbox.js"></script>
<link media="screen" rel="stylesheet" href="<%=root%>/css/colorbox.css" />
</head>
<script type="text/javascript">
	//增加
	function updHostManagement(){
	    if($("#M_KEFUZHANGHAO").val()==""){
			alert("客服账号不能为空！");
			return false;
		}if($("#M_KEFUNAME").val()==""){
			alert("客服姓名不能为空！");
			return false;
		}if($("#M_KEFUTEL").val()==""){
			alert("客服电话不能为空！");
			return false;
		}
		if($("#m_id").val()==""){
			alert("房屋编号不能为空！");
			return false;
		}
		 if($("#ipAddress").val()==""){
			alert("ip地址不能为空");
			return false;
		}else{
			var re =/^(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])$/;
		
			if(re.test($("#ipAddress").val())){
		
				var id = $("#hid").val();
					
				var data = $("#editForm").serialize();
				
				$.post("update?id="+id,data,function(resultData) {
				var result = eval(eval("(" + resultData + ")"));
				
				if (result == 1) {
			
					$.colorbox.close();
					//window.parent.$.colorbox.close();
					//parent.location.reload();
					window.location.href = "selectHostManagement";
				} else {
					alert("修改失败，请重新添加或与管理员联系");
				}
			})
			}else{
				alert("请输入正确的IP地址");
				return false;
			} 
		}
		

	}
	
	
</script>

<body>
	<input type="hidden" id="hid" value='<s:property value="id"/>' />
	<form action="" id="editForm">
		<!-- 隐藏字段 start-->
		<s:hidden id="M_ID" name="hostManagement.M_ID" />
		<s:hidden id="" name="hostManagement.M_MANUAL" />
		<!-- 这里加内容 start-->
		<table width="100%" border="0" cellspacing="0" cellpadding="1">
			<thead>
				<tr>
					
					<td colspan="3"
						style="text-align: center; height: 30px; background-color: #C9C9C9; font-size: 18px;">修改主机信息</td>
				</tr>
			</thead>
			
			<tr>
			
				<td width="20%" height="30" align="right" bgcolor="#f2f2f2"
					class="left_txt2">客服账号：</td>
				<td width="32%" height="30" bgcolor="#f2f2f2"><s:textfield
						id="M_KEFUZHANGHAO" name="hostManagement.M_KEFUZHANGHAO" ></s:textfield></td>
				<td width="45%" height="30" bgcolor="#f2f2f2" class="left_txt"><font class="ERROR_No" style="color: red;"></font></td>
			</tr>
			<tr>
			
				<td width="20%" height="30" align="right" bgcolor="#f2f2f2"
					class="left_txt2">客服姓名：</td>
				<td width="32%" height="30" bgcolor="#f2f2f2"><s:textfield
						id="M_KEFUNAME" name="hostManagement.M_KEFUNAME" ></s:textfield></td>
				<td width="45%" height="30" bgcolor="#f2f2f2" class="left_txt"><font class="ERROR_No" style="color: red;">*此为必填项</font></td>
			</tr>
			<tr>
			
				<td width="20%" height="30" align="right" bgcolor="#f2f2f2"
					class="left_txt2">客服电话：</td>
				<td width="32%" height="30" bgcolor="#f2f2f2"><s:textfield
						id="M_KEFUTEL" name="hostManagement.M_KEFUTEL" ></s:textfield></td>
				<td width="45%" height="30" bgcolor="#f2f2f2" class="left_txt"><font class="ERROR_No" style="color: red;">*此为必填项</font></td>
			</tr>
			
			<tr>
			
				<td width="20%" height="30" align="right" bgcolor="#f2f2f2"
					class="left_txt2">房屋编号：</td>
				<td width="32%" height="30" bgcolor="#f2f2f2"><s:textfield
						id="m_id" name="hostManagement.M_HOUSEID"></s:textfield></td>
				<td width="45%" height="30" bgcolor="#f2f2f2" class="left_txt"><font class="ERROR_No" style="color: red;">*此为必填项</font></td>
			</tr>
			<tr>
				<td width="20%" height="30" align="right" bgcolor="#f2f2f2"
					class="left_txt2">当前IP：</td>
				<td width="32%" height="30"  bgcolor="#f2f2f2">
				<s:textfield name="hostManagement.M_IP" id="ipAddress"></s:textfield></td>
				<td width="45%" height="30" bgcolor="#f2f2f2" class="left_txt"><font class="ERROR_No" style="color: red;">*此为必填项</font>
				</td>
			</tr>
			<tr>
				<td width="20%" height="30" align="right" bgcolor="#f2f2f2"
					class="left_txt2">主机状态：</td>
				<td width="32%" height="30" bgcolor="#f2f2f2">
				<!-- <s:textfield name="hostManagement.M_STATE"></s:textfield></td> -->
				<s:select list="#{1:'布防',2:'撤防'}"  name="hostManagement.M_STATE"  id="LState"  class="required">
					</s:select>
				<td width="45%" height="30" bgcolor="#f2f2f2" class="left_txt"></td>
			</tr>
			
			<tr>
				<td width="20%" height="30" align="right" bgcolor="#f2f2f2"
					class="left_txt2">主机名称：</td>
				<td width="32%" height="30"  bgcolor="#f2f2f2"><s:textfield
						name="hostManagement.deviceName" id="deviceName"></s:textfield></td>
				<td width="45%" height="30" bgcolor="#f2f2f2" class="left_txt"><font class="ERROR_No" style="color: red;"></font>
				</td>
			</tr>
			<tr>
				<td width="20%" height="30" align="right" bgcolor="#f2f2f2"
					class="left_txt2">appID：</td>
				<td width="32%" height="30"  bgcolor="#f2f2f2"><s:textfield
						name="hostManagement.appId" readonly="true"></s:textfield></td>
				<td width="45%" height="30" bgcolor="#f2f2f2" class="left_txt"><font class="ERROR_No" style="color: red;"></font>
				</td>
			</tr>
			<tr>
				<td width="20%" height="30" align="right" bgcolor="#f2f2f2"
					class="left_txt2">设备描述：</td>
				<td width="32%" height="30"  bgcolor="#f2f2f2"><s:textfield
						name="hostManagement.deviceDesc" id="deviceDesc"></s:textfield></td>
				<td width="45%" height="30" bgcolor="#f2f2f2" class="left_txt"><font class="ERROR_No" style="color: red;"></font>
				</td>
			</tr>		
			<tr>
				<td width="20%" height="30" align="right" bgcolor="#f2f2f2"
					class="left_txt2">布放学习：</td>
				<td width="32%" height="30" bgcolor="#f2f2f2">
				<s:select list="#{0:'没有学习',1:'已学习'}"  name="hostManagement.bufanglearmed"  id="bufanglearmed"  class="required">
					</s:select>
				<td width="45%" height="30" bgcolor="#f2f2f2" class="left_txt"></td>
			</tr>
			
			<tr>
				<td width="20%" height="30" align="right" bgcolor="#f2f2f2"
					class="left_txt2">撤防学习：</td>
				<td width="32%" height="30" bgcolor="#f2f2f2">
				<s:select list="#{0:'没有学习',1:'已学习'}"  name="hostManagement.chefanglearmed"  id="chefanglearmed"  class="required">
					</s:select>
				<td width="45%" height="30" bgcolor="#f2f2f2" class="left_txt"></td>
			</tr>
			
				
			<tr>
				<td width="20%" height="30" align="right" bgcolor="#f2f2f2"
					class="left_txt2">创建时间：</td>
				<td width="32%" height="30"  bgcolor="#f2f2f2"><s:textfield
						name="hostManagement.createTime" readonly="true"></s:textfield></td>
				<td width="45%" height="30" bgcolor="#f2f2f2" class="left_txt"><font class="ERROR_No" style="color: red;"></font>
				</td>
				
			</tr>
			<tr>
				<td width="20%" height="30" align="right" bgcolor="#f2f2f2"
					class="left_txt2">更新时间：</td>
				<td width="32%" height="30"  bgcolor="#f2f2f2"><s:textfield
						name="hostManagement.updateTime" readonly="true"></s:textfield></td>
				<td width="45%" height="30" bgcolor="#f2f2f2" class="left_txt"><font class="ERROR_No" style="color: red;"></font>
				</td>
				
			</tr>
			<tr>
				<td colspan="3" align="center" style="padding-top:50px;"><input
					type="button" value="修 改 " onclick="updHostManagement()" /> <input
					type="reset" value=" 重 置 " /></td>
			</tr>
		</table>
	</form>

</body>
</html>
