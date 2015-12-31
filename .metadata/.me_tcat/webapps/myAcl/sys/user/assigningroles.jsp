<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%String root=request.getContextPath();%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>角色授权</title>
<script src="<%=root%>/js/jquery.min.js"></script>
<script src="<%=root%>/js/check.js"></script>
<link href="<%=root %>/images/skin.css" rel="stylesheet" type="text/css" />
<link href="<%=root %>/css/css.css" rel="stylesheet" type="text/css" />
<link href="<%=root %>/css/style.css" rel="stylesheet" type="text/css" />
</head>

<script type="text/javascript">
	

	
	//分配角色
	function addOrUpdateUR(field){
		//alert("进来了");
		//alert(field.value);
		var userid=<s:property value="id"/>;
		var roleid=field.value;
		var orderNo=$("#"+roleid+"_order").val();
/* 		alert(userid);
		alert(roleid);
		alert(orderNo); */
		
		var actionname = null;
		if(field.checked){
			//选中
			actionname="<%=root%>/addUserRole?userId="+userid+"&roleId="+roleid+"&orderNo="+orderNo;
		}else{
			//不选中
			actionname="<%=root%>/deluserRole?userId="+userid+"&roleId="+roleid;
		}
/* 		alert(actionname); */
		$.post(actionname,null,function(resultData){
			$("#"+roleid+"_font").html("");
		})
	
	}
	
	//修改优先级
	function changenum(field){
		var userid=<s:property value="id"/>;
		var orderNo=field.value;
		var roleid=field.id.substr(0,field.id.indexOf("_"));
		//alert(roleid);
		//判断优先级是否正整数，
		if(!isNumber(orderNo)){
			//非正整数
			$("#"+roleid+"_order").focus();
			$("#"+roleid+"_font").html("只允许输入正整数");
			return;					
		}else{
			$("#"+roleid+"_font").html("");
		}
		
/* 		alert(userid);
				alert(orderNo);
						alert(roleid); */
		//再判断是否先中该行
		
		if($("#"+roleid+"_role").attr("checked")){
			//alert("OK");选中再处理其值
			var actionname="<%=root%>/updateUserRoleNo?userId="+userid+"&roleId="+roleid+"&orderNo="+orderNo;
			//alert(actionname);
			$.post(actionname,null,function(resultData){
				$("#"+roleid+"_font").html("");
			})
			
		}		
		
	}
	
	
	//初始化
	function initTable(){
		
		var actionname='<%=root%>/userRoleList?id=<s:property value="id"/>';
		$.post(actionname,null,function(resultData){
			var datas =resultData;
			if(datas!=null){
				for(var i=0; i < datas.length; i++){
					
					$("#"+datas[i].role.id+"_role").attr("checked", true);//选中
					$("#"+datas[i].role.id+"_order").val(datas[i].orderNo);
				
				
				}
			}
			
		})
	}
</script>

<body onload="initTable()" >

<form action="" id="editForm">
<!-- 这里加内容 start-->



<!-- 这里加内容 start-->
<table width="100%" border="0"  cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">
	<thead>
		<tr>
			<td colspan="3" style="text-align: center; height: 30px; background-color: #C9C9C9; font-size: 18px;">
			请给用户【<s:property value="data.username"/>】分配角色
			</td>
		</tr>
		<tr  class="CTitle">
			<td width="50px">&nbsp;</td>
			<td width="100px">角色名称</td>			
			<td width="50px">优先级：1~(数字越小级别越高)</td>
		</tr>
   	</thead>
   	<tbody>
   		<s:iterator value="list" status="rowstatus">
	   		<tr bgcolor="#FFFFFF">
	   			<td  bgcolor="#f2f2f2" class="left_txt">
		       		<input type="checkbox" id="<s:property value="id"/>_role" value="<s:property value="id"/>" onclick="addOrUpdateUR(this)"/>
				</td>
		   		<td  bgcolor="#f2f2f2" class="left_txt2">
		      		<s:property value="name"/>
		    	</td>
				<td  bgcolor="#f2f2f2" class="left_txt">
		       		<input type="text" id='<s:property value="id"/>_order'  num='<s:property value="id"/>' value="<s:property value="id"/>" onblur="changenum(this)" />
		       		<font id='<s:property value="id"/>_font' color="red"> </font>
				</td>
		 	</tr>
   		</s:iterator>
   	</tbody>
    
</table>
            			
        				
</form>  
							
</body>
</html>
