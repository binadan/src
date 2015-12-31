<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String root = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>添加版本信息</title>
<script src="<%=root%>/js/jquery.min.js"></script>
<script src="<%=root%>/js/check.js"></script>
<link href="<%=root%>/images/skin.css" rel="stylesheet" type="text/css" />
<link href="<%=root%>/css/css.css" rel="stylesheet" type="text/css" />
<link href="<%=root%>/css/style.css" rel="stylesheet" type="text/css" />
</head>

<script type="text/javascript">
	//增加
	/*
	function addVersion(){

		var id=parent.jQuery("#hid").val();
		var data= $("#editForm").serialize();
		$.post("addVersion?v_id="+id,data,function(resultData){
			var result =eval(eval("("+resultData+")"));
			
			if(result==1){
				
				window.parent.$.colorbox.close();
				parent.location.reload();
			}else{
				alert("添加失败，请重新添加或与管理员联系");
			}		
		})
			
	}*/

	//关闭当前的二级页面，显示父页面
	mySubmit = function() {

		if ($("#banbenId").val() == "") {
			alert("版本号不能为空");
			//clearInterval(s);
			return false;
		} else {
			if ($("#orderNo").val() == "") {
				alert("版本链接不能为空");
				//clearInterval(s);
				return false;
			}else{
				$("#editForm").submit();
			}
		}		
	};
</script>

<body>

	<form action="addVersion.action" id="editForm"
		enctype="multipart/form-data" method="post">
		<!-- 这里加内容 start-->
		<table width="100%" border="0" cellspacing="0" cellpadding="1">
			<thead>
				<tr>
					<td colspan="3"
						style="text-align: center; height: 30px; background-color: #C9C9C9; font-size: 18px;">添加版本信息</td>
				</tr>
			</thead>
			<tr>
				<td width="20%" height="30" align="right" bgcolor="#f2f2f2"
					class="left_txt2"></td>
				<td width="32%" height="30" bgcolor="#f2f2f2">
					<!--    <input name="version.v_id" type="text" id="v_id" size="30" /> -->
				</td>
				<td width="45%" height="30" bgcolor="#f2f2f2" class="left_txt"></td>
			</tr>
			<tr>
				<td width="20%" height="30" align="right" bgcolor="#f2f2f2"
					class="left_txt2">版本号</td>
				<td width="32%" height="30" bgcolor="#f2f2f2"><input
					name="version.v_no" type="text" id="banbenId" size="30" />
				</td>
				<td width="45%" height="30" bgcolor="#f2f2f2" class="left_txt"><font class="ERROR_No" style="color: red;">*此为必填项</font></td>
			</tr>
			<!--  <tr>
    	<td width="20%" height="30" align="right" bgcolor="#f2f2f2" class="left_txt2">
			时间
       	</td>
        <td width="32%" height="30" bgcolor="#f2f2f2">
            <input name="version.v_time" type="text" id="title" size="30" />
        </td>
        <td width="45%" height="30" bgcolor="#f2f2f2" class="left_txt"><font class="ERROR_SN" style="color: red;">时间(2001-01-01)</font></td>
     </tr>  -->
			<tr>
				<td width="20%" height="30" align="right" bgcolor="#f2f2f2"
					class="left_txt2">版本链接</td>
				<td width="32%" height="30" bgcolor="#f2f2f2"><input
					name="upload" type="file" id="orderNo" size="30" />
				</td>
				<td width="45%" height="30" bgcolor="#f2f2f2" class="left_txt"><font class="ERROR_No" style="color: red;">*此为必选项</font></td>
			</tr>
			<tr>
				<td colspan="3" align="center" style="padding-top:  50px;"><input
					type="button" value=" 添 加 " onClick=mySubmit() /> <input
					type="reset" value=" 重 置 " />
				</td>
			</tr>
		</table>
	</form>

</body>
</html>
