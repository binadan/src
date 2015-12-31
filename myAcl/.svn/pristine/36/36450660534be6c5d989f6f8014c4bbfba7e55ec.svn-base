<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%String root=request.getContextPath();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>修改版本信息</title>
<script src="<%=root%>/js/jquery.min.js"></script>
<script src="<%=root%>/js/check.js"></script>
<link href="<%=root %>/images/skin.css" rel="stylesheet" type="text/css" />
<link href="<%=root %>/css/css.css" rel="stylesheet" type="text/css" />
<link href="<%=root %>/css/style.css" rel="stylesheet" type="text/css" />
</head>

<script type="text/javascript">
	
/* 
	//检查
	function checkModuleSN(v,oldv){
		
		
		
		if(v==oldv){
			//与原来的相同，不用再做判断
			$(".ERROR_SN").html("");
			return;
		}
		
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
	function checkModuleNum(v,oldv){
		//验证
		if(!isNumber($('#orderNo').val())){
			alert("排序只允许输入整数！");
			return;
		}
		
		if(v==oldv){
			//与原来的相同，不用再做判断
			$(".ERROR_No").html("");
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
			
	} */
	
	//修改
	function updateVersion(){
	/* 	//验证
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
			 */
			 
		if ($("#banbenId").val() == "") {
			alert("版本号不能为空");
			return false;
		} 
		var id=parent.jQuery("#hid").val();
		
		var data= $("#editForm").serialize();
		
		$.post("updVersion?id="+id,data,function(resultData){
			var result =eval(eval("("+resultData+")"));
			
			if(result==1){
				
				window.parent.$.colorbox.close();
				parent.location.reload();
			}else{
				alert("修改失败，请重新添加或与管理员联系");
			}		
		})
			
	}
	
		
</script>

<body >

<form action="" id="editForm" method="post">
<!-- 隐藏字段 start-->
<!--  <s:hidden id="v_id" name="version.v_id"/>  -->
<!-- <s:hidden id="parent" name="data.parent.id"/> -->

<!-- end -->


<table width="100%" border="0" cellspacing="0" cellpadding="1" >
	<thead>
		<tr>
			<td colspan="3" style="text-align: center; height: 30px; background-color: #C9C9C9; font-size: 18px;">
				修改版本信息
			</td>
		</tr>
	</thead>
	<tr>
    	<td width="20%" height="30" align="right" bgcolor="#f2f2f2" class="left_txt2">
			
       	</td>
        <td width="32%" height="30" bgcolor="#f2f2f2">
        
         <!--  <s:textfield name="version.v_id" size="30"></s:textfield> -->
          <s:hidden id="v_id" name="version.v_id"/>
          <%--   <input name="v_id" type="text" id="v_id" size="30" value='<s:property value="version.v_id"/>' readonly="readonly"/> --%>
        </td>
        <td width="45%" height="30" bgcolor="#f2f2f2" class="left_txt"></td>
     </tr>
     <tr>
    	<td width="20%" height="30" align="right" bgcolor="#f2f2f2" class="left_txt2">
			版本号
       	</td>
        <td width="32%" height="30" bgcolor="#f2f2f2">
        <s:textfield name="version.v_no" id="banbenId" size="30"></s:textfield>
        <%--     <input name="v_no" type="text" id="v_no" size="30" value='<s:property value="version.v_no"/>' /> --%>
        </td>
        <td width="45%" height="30" bgcolor="#f2f2f2" class="left_txt"><font class="ERROR_No" style="color: red;">*此为必填项</font></td>
     </tr>
     <tr>
    	<td width="20%" height="30" align="right" bgcolor="#f2f2f2" class="left_txt2">
			时间
       	</td>
        <td width="32%" height="30" bgcolor="#f2f2f2">
       	<s:textfield name="version.v_time" readonly="true" size="30"></s:textfield> 
       	<input type="hidden" name="version.v_time" value="<s:property value='version.v_time'/>"/>
          <%--   <input name="v_time" type="text" id="v_time" size="30" value='<s:date name="v_time" format="yyyy-MM-dd"/>'  />  --%>
            
        </td>
        <td width="45%" height="30" bgcolor="#f2f2f2" class="left_txt"><font class="ERROR_SN" style="color: red;">时间(2001-01-01)</font></td>
     </tr> 
     <tr>
    	<td width="20%" height="30" align="right" bgcolor="#f2f2f2" class="left_txt2">
			版本链接
       	</td>
        <td width="32%" height="30" bgcolor="#f2f2f2">
        	<s:textfield name="version.v_url" readonly="true" size="30"></s:textfield>
        	<%-- <input type="hidden" name="version.v_url" value="<s:property value='version.v_url'/>"/> --%>
           <%--  <input name="v_url" type="text" id="v_url" size="30" value='<s:property value="version.v_url"/>'  /> --%>
        </td>
        <td width="45%" height="30" bgcolor="#f2f2f2" class="left_txt"></td>
     </tr> 
     <tr >
     	<td colspan="3" align="center" style="padding-top:  50px;">
     		<input type="button" value=" 修 改 " onclick="updateVersion();"/>
     		<input type="reset" value=" 重 置 "/>
     	</td>
     </tr>  
</table>   
</form>  
							
</body>
</html>
