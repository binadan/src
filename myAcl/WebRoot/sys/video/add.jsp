<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%String root=request.getContextPath();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>添加视频信息</title>
<script src="<%=root%>/js/jquery.min.js"></script>
<script src="<%=root%>/js/check.js"></script>
<link href="<%=root %>/images/skin.css" rel="stylesheet" type="text/css" />
<link href="<%=root %>/css/css.css" rel="stylesheet" type="text/css" />
<link href="<%=root %>/css/style.css" rel="stylesheet" type="text/css" />
</head>

<script type="text/javascript">



	//增加
	function addHostManagement(){
	
        
		var id=parent.jQuery("#hid").val();
		var data= $("#editForm").serialize();
		$.post("addvideo?id="+id,data,function(resultData){
			var result =eval(eval("("+resultData+")"));
			//alert("*****");
			if(result==1){
				
				window.parent.$.colorbox.close();
				parent.location.reload();
			}else{
				alert("添加失败，请重新添加或与管理员联系");
			}		
		})
			
	}
	function panduan(){
		return yanzheng();
	}
/* 	flv、wmv、swf、rm、avi */
	function yanzheng(){
		   var fileId = $("#fileId").val();
		   if (fileId == "") {   
	       		alert("请上传视频");   
	        	return false;   
		   } else {   
		       if (!/\.(avi)$/.test(fileId)) {   
		          alert("上传视频的格式为AVI");   
		          return false;   
		        }   
		   }   
	       return true;
	}
	
	
	
</script>

<body >

<form action="addvideo.action" id="editForm" enctype="multipart/form-data" method="post">
<!-- 这里加内容 start-->
<table width="100%" border="0" cellspacing="0" cellpadding="1" >
	<thead>
		<tr>
			<td colspan="3" style="text-align: center; height: 30px; background-color: #C9C9C9; font-size: 18px;">添加视频信息</td>
		</tr>
	</thead>
	<tr>
    	<td width="20%" height="30" align="right" bgcolor="#f2f2f2" class="left_txt2">
			上传视频：
       	</td>
        <td width="32%" height="30" bgcolor="#f2f2f2">
        <!-- <s:file name="upload"></s:file> --> 
         <input name="upload" type="file" id="fileId" size="30" />
        </td>
        <td width="45%" height="30" bgcolor="#f2f2f2" class="left_txt"><font class="ERROR_No" style="color: red;">*此为必选项，格式为avi</font></td>
     </tr>
     
     <tr >
     	<td colspan="3" align="center" style="padding-top:  50px;">
     		<input type="submit" value=" 添 加 " /> 
     		<input type="reset" value=" 重 置 "/>
     	</td>
     </tr>  
</table>   <!-- onclick="return panduan();" -->
</form>    
							
</body>
</html>
