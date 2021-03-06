<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%String root=request.getContextPath();%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>修改帐号</title>
<script src="<%=root%>/js/jquery.min.js"></script>
<script src="<%=root%>/js/check.js"></script>
<link href="<%=root %>/images/skin.css" rel="stylesheet" type="text/css" />
<link href="<%=root %>/css/css.css" rel="stylesheet" type="text/css" />
<link href="<%=root %>/css/style.css" rel="stylesheet" type="text/css" />
<script type='text/javascript' src='<%=root%>/js/jquery.contextmenu.r2-min.js'></script>
<script type="text/javascript" src="<%=root%>/js/WdatePicker.js"></script>

</head>

<script type="text/javascript">

	//修改
	function addData(){
		//验证
		if($('.error_username').html()!=""){
			alert("请先完善数据！");
			return;
		}
		if ($.trim($("#password").val()) == "") {
			alert("密码不允许为空！");
			return;
		}
		
		var data= $("#editForm").serialize();
		$.post("updateUser",data,function(resultData){
			var result =eval(eval("("+resultData+")"));
			
			if(result==1){
				
				window.parent.$.colorbox.close();
				parent.location.reload();
			}else{
				alert("修改失败，请重新添加或与管理员联系");
			}		
		});
			
	}
	
	//检查用户名是否唯 一
	function checkusername(name){
		
		//因为是修改，所以如果现在的值和原先的值是一样，则不需要判断
		var oldname='<s:property value="data.username"/>';
		
		if(oldname==name){
			return;
		}
		var actionname="checkUserName?username="+name;
		actionname = encodeURI(actionname);
		actionname = encodeURI(actionname);    //两次，很关键
		
		$.post(actionname,null,function(resultData){
			
			
			var result = resultData;//eval(eval("("+resultData+")"));
			
			if(result!=null){
				//存在，不唯一
				
				$(".error_username").html("该帐号已存在，请重新输入");
			}else{
				//不存在
				$(".error_username").html("");
			}		
		});
	}
	
</script>


<body >


<form action="" id="editForm">

<!--  隐藏域 -->
<input type="hidden" id="person" name="data.person.id" value='<s:property value="data.person.id"/>' />
<input type="hidden" id="id" name="data.id" value='<s:property value="data.id"/>' />
<input type="hidden" id="createTime" name="data.createTime" value='<s:property value="data.createTime"/>' />

<!-- 这里加内容 start-->
<table width="100%" border="0" cellspacing="0" cellpadding="1" >
	<thead>
		<tr>
			<td colspan="3" style="text-align: center; height: 30px; background-color: #C9C9C9; font-size: 18px;">修改帐号</td>
		</tr>
	</thead>
     <tr>
    	<td width="20%" height="30" align="right" bgcolor="#f2f2f2" class="left_txt2">
			用户帐号：
       	</td>
       
        <td width="32%" height="30" bgcolor="#f2f2f2">
            <input  name="data.username" type="text" id="title" size="30" onblur="checkusername(this.value)" value='<s:property value="data.username"/>' />
        </td>
        <td width="45%" height="30" bgcolor="#f2f2f2" class="left_txt"><font class="error_username" color="red"></font></td>
     </tr>
     <tr>
    	<td width="20%" height="30" align="right" bgcolor="#f2f2f2" class="left_txt2">
			登陆密码：
       	</td>
        <td width="32%" height="30" bgcolor="#f2f2f2">
            <input name="data.password" type="password" id="password"  size="30" value='<s:property value="data.password"/>'/>
        </td>
        <td width="45%" height="30" bgcolor="#f2f2f2" class="left_txt"></td>
     </tr>
     <tr>
    	<td width="20%" height="30" align="right" bgcolor="#f2f2f2" class="left_txt2">
			失效时间：
       	</td>
        <td width="32%" height="30" bgcolor="#f2f2f2">
            <input class="Wdate"  size="30" name="data.expireTime" value='<s:date name="data.expireTime" format="yyyy-MM-dd"/>'  type="text"   onfocus="WdatePicker({isShowClear:false,readOnly:true})"/>
        </td>
        <td width="45%" height="30" bgcolor="#f2f2f2" class="left_txt"></td>
     </tr> 
     <tr >
     	<td colspan="3" align="center" style="padding-top:  50px;">
     		<input type="button" value=" 确 认 " onclick="addData()"/>
     		<input type="reset" value=" 重 置 "/>
     	</td>
     </tr>  
</table>   
</form>  
							
</body>

</html>