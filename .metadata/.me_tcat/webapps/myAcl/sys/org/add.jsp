<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%String root=request.getContextPath();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>添加部门</title>
<script src="<%=root%>/js/jquery.min.js"></script>
<script src="<%=root%>/js/jquery.colorbox.js"></script>
</head>

<script type="text/javascript">



	//增加
	function CUOrg(){

				
		var data= $("#addForm").serialize();
	
		$.post("updateOrg",data,function(resultData){
			var result =eval(eval("("+resultData+")"));
			
			if(result==1){
				window.parent.$.colorbox.close();
				parent.location.reload();
			}else{
				alert("添加失败，请重新添加或与管理员联系");
			}		
		})
			
	}

</script>

<body >

<div id="editDiv" >
	<form action="" id="addForm">

		<input type="hidden" id="hid" name="data.id" value='<s:property value="data.id"/>'/>
        <input type="hidden" id="hcode" name="data.code" value='<s:property value="data.code"/>'/>	
        
        <!-- 这里加内容 start-->
        <table width="100%" border="0"  cellpadding="4" cellspacing="1" bgcolor="#6795b4" class="newfont03">
        	<thead>
            	<tr  class="CTitle">
					<td  height="37" colspan="3" ><font id="optitle">添加组织架构</font></td>
				</tr>
            </thead>
            	<tr bgcolor="#FFFFFF">
	                <td  bgcolor="#f2f2f2" class="left_txt2">
	                	机构名称：
	                </td>
	               	<td  bgcolor="#f2f2f2">
	               	
	               	 	<input type="text" id="name" name="data.name" value='<s:property value="data.name"/>'/>
	               	</td>
	                <td	 bgcolor="#f2f2f2">&nbsp; </td>
	            </tr>
            	<tr bgcolor="#FFFFFF">
	                <td  bgcolor="#f2f2f2" class="left_txt2">
	                	上级机构：
	                </td>
	               	<td  bgcolor="#f2f2f2">
		               	<s:select cssStyle="width:150px;" id="pid" name="data.parent.id" list="list"
							listKey="id" listValue="name" headerKey="0" headerValue="顶级分类" >
					  	</s:select>
	               	 	
	               	</td>
	                	<td	 bgcolor="#f2f2f2">&nbsp; </td>
	            </tr>
				<tr bgcolor="#FFFFFF">
					<td	 bgcolor="#f2f2f2" colspan="3" align="center">
	                	<input id="orgbtn" type="button" value=" 提	交 " onclick="CUOrg()"/>
	                </td>
	            </tr>
		</table>
	</form>
</div>				
</body>
</html>
