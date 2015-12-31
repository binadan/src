<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%String root=request.getContextPath();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>添加模块</title>
<script src="<%=root%>/js/jquery.min.js"></script>
<script src="<%=root%>/js/check.js"></script>
<link href="<%=root %>/images/skin.css" rel="stylesheet" type="text/css" />
<link href="<%=root %>/css/css.css" rel="stylesheet" type="text/css" />
<link href="<%=root %>/css/style.css" rel="stylesheet" type="text/css" />
</head>

<script type="text/javascript">



	//增加
	function addModule(){
		//验证
		if(!isNumber($('#orderNo').val())){
			alert("排序只允许输入整数！");
			return;
		}
		
		
		if($.trim($("#name").val())==""){
			alert("模块名称不允许为空！");
			return;
		}
		
		if($(".ERROR_SN").html()!=""){
			alert("模块编号已存在，请重新输入！")
			return;
		}
	
		
		var id=parent.jQuery("#hid").val();
		var data= $("#editForm").serialize();
		$.post("addModule?id="+id,data,function(resultData){
			var result =eval(eval("("+resultData+")"));
			
			if(result==1){
				
				window.parent.$.colorbox.close();
				parent.location.reload();
			}else{
				alert("添加失败，请重新添加或与管理员联系");
			}		
		})
			
	}
	
	
	//检查
	function checkModuleSN(){
		
		
		var data= $("#editForm").serialize();
		$.post("checkModuleSN",data,function(resultData){
			var result =eval(eval("("+resultData+")"));
			
			if(result==1){
				$(".ERROR_SN").html("该模块编号已存在，请重新输入");
			
				//存在
			}else{
				//可用
				$(".ERROR_SN").html("");
			}		
		})
			
	}

	//检查
	function checkModuleNum(){
		
		//验证
		if(!isNumber($('#orderNo').val())){
			alert("排序只允许输入整数！");
			return;
		}
		
		var data= $("#editForm").serialize();
		$.post("checkModuleNum",data,function(resultData){
			var result =eval(eval("("+resultData+")"));
			
			if(result==1){
				$(".ERROR_No").html("该模块序号已存在，请重新输入");
			
				//存在
			}else{
				//可用
				$(".ERROR_No").html("");
			}		
		})
			
	}
	
</script>

<body >

<form action="" id="editForm">
<!-- 这里加内容 start-->
<table width="100%" border="0" cellspacing="0" cellpadding="1" >
	<thead>
		<tr>
			<td colspan="3" style="text-align: center; height: 30px; background-color: #C9C9C9; font-size: 18px;">添加模块</td>
		</tr>
	</thead>
	<tr>
    	<td width="20%" height="30" align="right" bgcolor="#f2f2f2" class="left_txt2">
			模块名称：
       	</td>
        <td width="32%" height="30" bgcolor="#f2f2f2">
            <input name="data.name" type="text" id="name" size="30" />
        </td>
        <td width="45%" height="30" bgcolor="#f2f2f2" class="left_txt">模块名称</td>
     </tr>
     <tr>
    	<td width="20%" height="30" align="right" bgcolor="#f2f2f2" class="left_txt2">
			模块编号：
       	</td>
        <td width="32%" height="30" bgcolor="#f2f2f2">
            <input name="data.sn" type="text" id="title" size="30" onblur="checkModuleSN()"/>
            
        </td>
        <td width="45%" height="30" bgcolor="#f2f2f2" class="left_txt"><font class="ERROR_SN" style="color: red;">*</font></td>
     </tr>
     <tr>
    	<td width="20%" height="30" align="right" bgcolor="#f2f2f2" class="left_txt2">
			模块地址：
       	</td>
        <td width="32%" height="30" bgcolor="#f2f2f2">
            <input name="data.url" type="text" id="title" size="30" />
        </td>
        <td width="45%" height="30" bgcolor="#f2f2f2" class="left_txt">模块地址</td>
     </tr> 
     <tr>
    	<td width="20%" height="30" align="right" bgcolor="#f2f2f2" class="left_txt2">
			排序号：
       	</td>
        <td width="32%" height="30" bgcolor="#f2f2f2">
            <input name="data.orderNo" type="text" id="orderNo" size="30" onblur="checkModuleNum()"/>
        </td>
        <td width="45%" height="30" bgcolor="#f2f2f2" class="left_txt"><font class="ERROR_No" style="color: red;">*</font></td>
     </tr> 
     <tr >
     	<td colspan="3" align="center" style="padding-top:  50px;">
     		<input type="button" value=" 添 加 " onclick="addModule()"/>
     		<input type="reset" value=" 重 置 "/>
     	</td>
     </tr>  
</table>   
</form>  
							
</body>
</html>
