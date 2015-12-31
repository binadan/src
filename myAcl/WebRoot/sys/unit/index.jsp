<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%String root=request.getContextPath();%>

<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>单位列表</title>

<link href="<%=root %>/images/skin.css" rel="stylesheet" type="text/css" />
<link href="<%=root %>/css/css.css" rel="stylesheet" type="text/css" />
<link href="<%=root %>/css/style.css" rel="stylesheet" type="text/css" />
<link href="<%=root %>/css/pagecss.css" rel="stylesheet" type="text/css" />

<link media="screen" rel="stylesheet" href="<%=root%>/css/colorbox.css" />
<script src="<%=root%>/js/jquery.min.js"></script>
<script src="<%=root%>/js/jquery.colorbox.js"></script>
<script src="<%=root%>/js/table.js"></script>
<script src="<%=root%>/js/SecurityFunctions.js"></script>
</head>	
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: #F8F9FA;
}
img{
	padding: 0px;
	border: 0px;
	cursor: pointer;
}
-->
</style>
<script type="text/javascript">

//判断当前权限
$(document).ready(function(){ 
	var userId=${sessionScope.sessionUser.id};		//当前用户ID
	var resourceSn="unit";						//当前模块SN
	hasPermission("addbuttom",userId,resourceSn,<s:property value="@com.gcflower.util.Permission@CREATE" />);	
	hasPermission("updateimg",userId,resourceSn,<s:property value="@com.gcflower.util.Permission@UPDATE" />);
	hasPermission("deleteimg",userId,resourceSn,<s:property value="@com.gcflower.util.Permission@DELETE" />);

});


	
	//分页
	function changepage(pageval){
		var actionName='searchUnits';
		actionName = encodeURI(actionName);
    	actionName = encodeURI(actionName);    //两次，很关键
		window.location.href=actionName;
	}


	//删除
	function deleteModule(id,columindex){
		if(confirm("你确定要取消该条数据？")){
			$.post("delUnit?id="+id,null,function(resultData){
				var result =resultData;// eval(eval("("+resultData+")"));
				if(result==1){
					var cp=$("#pageTotal").val();
					changepage(cp);
				}else{
					alert("删除失败");
				}		
			})
		}
			
	}
	
	//到添加窗口
	function addMsg(){
		
		$.colorbox({href:'<%=root%>/sys/unit/add.jsp',width:'600px',height:'300px',iframe:true});
	}
	
	//到修改窗口
	function updateMsg(id){
		$.colorbox({href:'<%=root%>/updateInputUnit?id='+id,width:'600px',height:'300px',iframe:true});
	}
	
</script>



<body>

<input type="hidden" id="hid" value='<s:property value="id"/>'/>

<table width="100%" border="0" cellpadding="0" cellspacing="0">
	<tr>
    	<td width="17" height="29" valign="top" background="<%=root %>/images/mail_leftbg.gif">
    		<img src="<%=root %>/images/left-top-right.gif" width="17" height="29" />
    	</td>
    	<td width="935" height="29" valign="top" background="<%=root %>/images/content-bg.gif">
    		<table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
      			<tr>
        			<td height="31"><div class="titlebt">单位管理</div></td>
      			</tr>
    		</table>
    	</td>
    	<td width="16" valign="top" background="<%=root %>/images/mail_rightbg.gif">
    		<img src="<%=root %>/images/nav-right-bg.gif" width="16" height="29" />
    	</td>
	</tr>
  	<tr>
    	<td height="71" valign="middle" background="<%=root %>/images/mail_leftbg.gif">&nbsp;</td>
    	<td valign="top" bgcolor="#F7F8F9">
    		<table width="100%" height="138" border="0" cellpadding="0" cellspacing="0">
      			<tr>
        			<td height="13" valign="top">&nbsp;</td>
      			</tr>
      			<tr>
        			<td valign="top">
        				<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
          					<tr>
            					<td class="left_txt">当前位置：单位管理&nbsp;
            						
            					</td>
          					</tr>
          					<tr>
            					<td height="20">
            						<table width="100%" height="1" border="0" cellpadding="0" cellspacing="0" bgcolor="#CCCCCC">
              							<tr>
                							<td></td>
              							</tr>
            						</table>
            					</td>
          					</tr>
          					<tr>
            					<td>
            						<table width="100%" height="55" border="0" cellpadding="0" cellspacing="0">
              							<tr>
                							<td width="10%" height="55" >
                								<div class="addbuttom">
	                							 	<a  onclick="addMsg()"  title="添加模块" >
	                									<img src="<%=root %>/images/icon/8_48x48.png" width="54" height="55" title="添加模块">
	                								</a>
                								</div>
                							</td>
                							<td width="90%" valign="top">
                								<span class="left_txt2">在这里，您可以根据您的网站要求，添加单位模板</span>
                								<span class="left_txt3"></span>
                								<span class="left_txt2">！</span><br>
                          						<span class="left_txt2">以方便其他地方</span>
                          						<span class="left_txt3">的调用</span>
                          						<span class="left_txt2">。 </span>
                          					</td>
              							</tr>
            						</table>
            					</td>
          					</tr>
          					<tr>
            					<td>&nbsp;</td>
          					</tr>
          					<tr>
            					<td>
            						<!-- 这里加内容 start-->
            						<table width="800px;" border="0"  cellpadding="4" cellspacing="1" bgcolor="#434343" class="newfont03">
            							<thead>
            								<tr  class="CTitle">
										      	<td  height="37" width="50px"><b>序号</b></td>
											    <td  height="37" width="180px"><B>模块名称</B></td>
									            <td  height="37" ><b>操作</b></td>
									            <td  height="37" width="50px"><b>序号</b></td>
											    <td  height="37" width="180px"><B>模块名称</B></td>
									            <td  height="37" ><b>操作</b></td>
							          		</tr>
            							</thead>
            							<s:iterator value="page.datas" status="rowstatus">
            								<s:if test="#rowstatus.count%2==1">
            									<tr bgcolor="#FFFFFF">
            								</s:if>
	                							<td  bgcolor="#99CCFF" class="left_txt2">
	                								
	                								<s:property value="#rowstatus.count+(page.page-1)*page.maxResults"/>
	                							</td>
	               	 							<td  bgcolor="#f2f2f2">
	               	 								<s:property value="name"/> 
	               	 							</td>
	                							<td  bgcolor="#f2f2f2" class="left_txt">
	                								<a class="updateimg" onclick="updateMsg(<s:property value="id"/>)"   title="修改模块" >
	                									<img   src="<%=root %>/images/icon/edit.gif" title="修改" />&nbsp;
													</a>
													<img class="deleteimg"  src="<%=root %>/images/icon/dele.png" title="删除" onclick='deleteModule(<s:property value="id"/>)'/>
	                							</td>
	                						
	                						<s:if test="#rowstatus.last && page.datas.size()%2==1">
	                							<td  bgcolor="#99CCFF" class="left_txt2">
	                								&nbsp;
	                							</td>
	               	 							<td  bgcolor="#f2f2f2">
	               	 								&nbsp;
	               	 							</td>
	                							<td  bgcolor="#f2f2f2" class="left_txt">
	                								&nbsp;
	                							</td>
	                							
	                						</s:if>	
	                						<s:if test="#rowstatus.count%2==0">
            									</tr>
            								</s:if>
	              							
            							</s:iterator>
            							<s:if test="page.datas==null || page.datas.size<1">
            								<tr>
            									<td colspan="13" bgcolor="#f2f2f2">没有相关记录</td>
            								</tr>
            							</s:if>
            						</table>
            						<!-- 这里加内容 end-->
            					</td>
          					</tr>
        				</table>
          				
          			</td>
      			</tr>
    		</table>
    	</td>
    	<td background="<%=root %>/images/mail_rightbg.gif">&nbsp;</td>
  	</tr>
  	<tr>
    	<td valign="middle" background="<%=root %>/images/mail_leftbg.gif">
    		<img src="<%=root %>/images/buttom_left2.gif" width="17" height="17" />
    	</td>
		<td height="17" valign="top" background="<%=root %>/images/buttom_bgs.gif">
			<img src="<%=root %>/images/buttom_bgs.gif" width="17" height="17" />
		</td>
    	<td background="<%=root %>/images/mail_rightbg.gif">
    		<img src="<%=root %>/images/buttom_right2.gif" width="16" height="17" />
    	</td>
  	</tr>
</table>


</body>
</html>