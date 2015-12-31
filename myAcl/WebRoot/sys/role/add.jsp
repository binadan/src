<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%String root=request.getContextPath();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>角色模块</title>
<script src="<%=root%>/js/jquery.min.js"></script>
<script src="<%=root%>/js/check.js"></script>
<link href="<%=root %>/images/skin.css" rel="stylesheet" type="text/css" />
<link href="<%=root %>/css/css.css" rel="stylesheet" type="text/css" />
<link href="<%=root %>/css/style.css" rel="stylesheet" type="text/css" />
</head>

<script type="text/javascript">
	//增加
	function addRole(){
		//验证
		if($(".left_txt").html()!=""){
			alert("请输入角色名！");
			return;
		}
	
		var data= $("#editForm").serialize();
		$.post("addRole",data,function(resultData){
			var result =eval(eval("("+resultData+")"));
			if(result==1){
				window.parent.$.colorbox.close();
				parent.location.reload();
			}else{
				alert("添加失败，请重新添加或与管理员联系");
			}		
		})
			
	}
	
	
	//验证
	function checkRole(rolename){
		
		
		
		var data= $("#editForm").serialize();
		var actionname="checkRoleName?name="+rolename;
		actionname = encodeURI(actionname);
    	actionname = encodeURI(actionname);    //两次，很关键
    	
		$.post(actionname,data,function(resultData){
			var result =resultData;//eval(eval("("+resultData+")"));
			
			if(result!=null){
				
				$(".left_txt").html("该角色名已存在")
			}else{
				$(".left_txt").html("")
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
			<td colspan="3" style="text-align: center; height: 30px; background-color: #C9C9C9; font-size: 18px;">添加角色</td>
		</tr>
	</thead>
	<tr>
    	<td width="20%" height="30" align="right" bgcolor="#f2f2f2" class="left_txt2">
			角色名称：
       	</td>
        <td width="32%" height="30" bgcolor="#f2f2f2">
            <input name="data.name" type="text" id="title" size="30"  onblur="checkRole(this.value)"/>
        </td>
        <td width="45%" height="30" bgcolor="#f2f2f2" class="left_txt" style="color: red;">角色名称唯一</td>
     </tr>
    
     <tr >
     	<td colspan="3" align="center" style="padding-top:  50px;">
     		<input type="button" value=" 添 加 " onclick="addRole()"/>
     		<input type="reset" value=" 重 置 "/>
     	</td>
     </tr>  
</table>   
</form>  
							
</body>
</html>
