<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%String root=request.getContextPath();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>修改单位</title>
<script src="<%=root%>/js/jquery.min.js"></script>
<script src="<%=root%>/js/jquery.colorbox.js"></script>
</head>

<script type="text/javascript">



	//修改
	function updateUint(){

		
		if($(".error_name").html()!=""){
			alert("单位名已重复，请重新输入");
			return;
		}
		var data= $("#addForm").serialize();
		
		$.post("updateUnit",data,function(resultData){
			var result =eval(eval("("+resultData+")"));
			
			if(result==1){
				window.parent.$.colorbox.close();
				parent.location.reload();
			}else{
				alert("修改失败，请重新修改或与管理员联系");
			}		
		})
			
	}
	
	//增加
	function checkUnitName(){

		var data= $("#addForm").serialize();
		$.post("checkUnitName",data,function(resultData){
			var result =eval(eval("("+resultData+")"));
		
			if(result==1){
				//重复
				$(".error_name").html("已重复，请重新输入");
			}else{
				//可用
				$(".error_name").html("");
			}		
		})
			
	}
	

</script>

<body >

<div id="editDiv" >
	<form action="" id="addForm">
	
	<s:hidden id="id" name="data.id"></s:hidden>
			
        <!-- 这里加内容 start-->
        <table width="100%" border="0"  cellpadding="4" cellspacing="1" bgcolor="#6795b4" class="newfont03">
        	<thead>
            	<tr  class="CTitle">
					<td  height="37" colspan="3" ><font id="optitle">修改单位</font></td>
				</tr>
            </thead>
            <tr bgcolor="#FFFFFF">
	        	<td  bgcolor="#f2f2f2" class="left_txt2">
					单位名称：
	            </td>
	            <td  bgcolor="#f2f2f2">
	            	<input type="text" id="name" name="data.name" size="30" onblur="checkUnitName()" value='<s:property value="data.name"/>'/>
	            </td>
	            <td	 bgcolor="#f2f2f2"><font class="error_name"  style="color: red;font-size: 12px;">&nbsp;</font> </td>
	        </tr>
	        <tr bgcolor="#FFFFFF">
	            <td	 bgcolor="#f2f2f2" colspan="3" align="center">
	                <input id="orgbtn" type="button" value=" 提	交 "  onclick="updateUint()"/>
	            </td>
	        </tr>
		</table>
	</form>
</div>				
</body>
</html>
