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
	

	
	//授权
	function addOrUpdatePermission(field){
		
		//CRUD哪个选中，其可用性必将选 中
		
		if(!field.checked){
				var moduleId=field.attributes["moduleId"].value;
				//如果不选，则判断对应行CRUD是否都不选
				//判断是否选中if ($("#checkbox2").is(":checked")) 
				if(!!$("#"+moduleId+"_C").attr("checked")==false && !!$("#"+moduleId+"_R").attr("checked")==false && !!$("#"+moduleId+"_U").attr("checked")==false && !!$("#"+moduleId+"_D").attr("checked")==false && !!$("#"+moduleId+"_P").attr("checked")==false && !!$("#"+moduleId+"_E").attr("checked")==false && !!$("#"+moduleId+"_B").attr("checked")==false && !!$("#"+moduleId+"_F").attr("checked")==false){
					$("#"+moduleId+"_USE").attr("checked",false);
				}
		}else{
			$("#"+field.attributes["moduleId"].value+"_USE").attr("checked",true);
			
		}
		
		var principalId=<s:property value="role.id"/>;
		var actionname="<%=root%>/addOrUpdatePermission?principalType=Role&principalId="+principalId+"&moduleId="+field.attributes["moduleId"].value+"&permission="+field.attributes["permission"].value+"&ischeck="+field.checked;
	

		$.post(actionname,null,function(resultData){
			var datas =resultData;//eval(eval("("+resultData+")"));
		})
	}
	
	//调整可用性
	function addEnable(field){
		
		var moduleId=field.attributes["moduleId"].value;
		var principalId=<s:property value="role.id"/>;
		var principalType="Role";
		
		
		if(field.checked){
			//如果是分别调用CRUD方法
			var actionname="<%=root%>/addOrUpdatePermission?principalType=Role&principalId="+principalId+"&moduleId="+moduleId+"&permission=0"+"&ischeck="+false;
			$.post(actionname,null,function(resultData){
				var datas =resultData;//eval(eval("("+resultData+")"));
			})
		
		}else{
			
			//如果是不可用性，调用delete方法
			//先把其他勾选去掉
			$("#"+moduleId+"_C").attr("checked",false);
			$("#"+moduleId+"_R").attr("checked",false);
			$("#"+moduleId+"_U").attr("checked",false);
			$("#"+moduleId+"_D").attr("checked",false);
			$("#"+moduleId+"_P").attr("checked",false);
			$("#"+moduleId+"_E").attr("checked",false);
			$("#"+moduleId+"_B").attr("checked",false);
			$("#"+moduleId+"_F").attr("checked",false);
			$.post("<%=root%>/delPermission?principalType="+principalType+"&principalId="+principalId+"&moduleId="+moduleId,null,function(resultData){
				var datas =resultData;//eval(eval("("+resultData+")"));
				
			})
		}
		
		
		
		
	}
	
	//初始化
	function initTable(){
		
		var actionname='<%=root%>/searchAclRecord?principalType=Role&principalId=<s:property value="role.id"/>';
		$.post(actionname,null,function(resultData){
			var datas =resultData;//eval(eval("("+resultData+")"));
			
			for(var i=0; i < datas.length; i++){
				var moduleId = datas[i][0];
				var cState = datas[i][1];			//C
				var rState = datas[i][2];			
				var uState = datas[i][3];
				var dState = datas[i][4];
				var pState = datas[i][5];
				var eState = datas[i][6];
				var BSate = datas[i][7];
				var FState = datas[i][8];
				var extState = datas[i][9];			//可用性
					
					
				$("#"+moduleId+"_C").attr("checked",cState == 0 ? false : true);	//复选框是否选中
				$("#"+moduleId+"_R").attr("checked", rState == 0 ? false : true);
				$("#"+moduleId+"_U").attr("checked", uState == 0 ? false : true);
				$("#"+moduleId+"_D").attr("checked",dState == 0 ? false : true);
				$("#"+moduleId+"_P").attr("checked",pState == 0 ? false : true);
				$("#"+moduleId+"_E").attr("checked",eState == 0 ? false : true);
				$("#"+moduleId+"_B").attr("checked",BSate == 0 ? false : true);
				$("#"+moduleId+"_F").attr("checked",FState == 0 ? false : true);
				
				
				$("#"+moduleId+"_USE").attr("checked", true);
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
			<td colspan="4" style="text-align: center; height: 30px; background-color: #C9C9C9; font-size: 18px;">
			请给角色【<s:property value="role.name"/>】授权
			
			</td>
		</tr>
		<tr  class="CTitle">
			<td width="80px">顶级模块</td>			
			<td width="120px">二级模块</td>
			<td width="280px">权限</td>
			<td width="40px">启用</td>
		</tr>
   	</thead>
   	<tbody>
   		<s:iterator value="modulelist" status="rowstatus">
	   		<tr bgcolor="#FFFFFF">
		   		<td  bgcolor="#f2f2f2" class="left_txt2">
		      		<s:property value="name"/>
		    	</td>
		    	<td  bgcolor="#f2f2f2">
					&nbsp;
				</td>
		   	 	<td  bgcolor="#f2f2f2" class="left_txt">
		       		<input type="checkbox" id='<s:property value="id"/>_C'  onclick="addOrUpdatePermission(this)" moduleId='<s:property value="id"/>' permission="0" />增加
					<input type="checkbox" id='<s:property value="id"/>_R'  onclick="addOrUpdatePermission(this)" moduleId='<s:property value="id"/>' permission="1" />读取
<%-- 					<input type="checkbox" id='<s:property value="id"/>_U'  onclick="addOrUpdatePermission(this)" moduleId='<s:property value="id"/>' permission="2" />修改
					<input type="checkbox" id='<s:property value="id"/>_D'  onclick="addOrUpdatePermission(this)" moduleId='<s:property value="id"/>' permission="3" />删除
					<input type="checkbox" id='<s:property value="id"/>_P'  onclick="addOrUpdatePermission(this)" moduleId='<s:property value="id"/>' permission="4" />打印
					<input type="checkbox" id='<s:property value="id"/>_E'  onclick="addOrUpdatePermission(this)" moduleId='<s:property value="id"/>' permission="5" />导出
					<input type="checkbox" id='<s:property value="id"/>_B'  onclick="addOrUpdatePermission(this)" moduleId='<s:property value="id"/>' permission="6" />备用1
					<input type="checkbox" id='<s:property value="id"/>_F'  onclick="addOrUpdatePermission(this)" moduleId='<s:property value="id"/>' permission="7" />备用2 --%>
				</td>
				<td  bgcolor="#f2f2f2" class="left_txt">
		       		<input type="checkbox" id="<s:property value="id"/>_USE" moduleId='<s:property value="id"/>' onclick="addEnable(this)"/>
				</td>
		 	</tr>
		 	<s:if test="children!=null">
		 		<s:iterator value="children" status="rowstatus">
			 		<tr bgcolor="#FFFFFF">
				   		<td  bgcolor="#f2f2f2" class="left_txt2">
				      		&nbsp;
				    	</td>
				    	<td  bgcolor="#f2f2f2">
							<s:property value="name"/>
						</td>
				   	 	<td  bgcolor="#f2f2f2" class="left_txt">
							<input type="checkbox" id='<s:property value="id"/>_C'  onclick="addOrUpdatePermission(this)" moduleId='<s:property value="id"/>' permission="0" />增加
							<input type="checkbox" id='<s:property value="id"/>_R'  onclick="addOrUpdatePermission(this)" moduleId='<s:property value="id"/>' permission="1" />读取
							<input type="checkbox" id='<s:property value="id"/>_U'  onclick="addOrUpdatePermission(this)" moduleId='<s:property value="id"/>' permission="2" />修改
							<input type="checkbox" id='<s:property value="id"/>_D'  onclick="addOrUpdatePermission(this)" moduleId='<s:property value="id"/>' permission="3" />删除
							<input type="checkbox" id='<s:property value="id"/>_P'  onclick="addOrUpdatePermission(this)" moduleId='<s:property value="id"/>' permission="4" />打印
							<input type="checkbox" id='<s:property value="id"/>_E'  onclick="addOrUpdatePermission(this)" moduleId='<s:property value="id"/>' permission="5" />导出
							<input type="checkbox" id='<s:property value="id"/>_B'  onclick="addOrUpdatePermission(this)" moduleId='<s:property value="id"/>' permission="6" />备用1
							<input type="checkbox" id='<s:property value="id"/>_F'  onclick="addOrUpdatePermission(this)" moduleId='<s:property value="id"/>' permission="7" />备用2
						</td>
						<td  bgcolor="#f2f2f2" class="left_txt">
				       		<input type="checkbox" id="<s:property value="id"/>_USE" moduleId='<s:property value="id"/>' onclick="addEnable(this)" />
						</td>
				 	</tr>
		 		</s:iterator>
		 	</s:if>
   		</s:iterator>
   	</tbody>
    
</table>
            			
        				
</form>  
							
</body>
</html>
