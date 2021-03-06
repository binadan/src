<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%String root=request.getContextPath();%>

<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>角色列表</title>

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
	var resourceSn="role";							//当前模块SN
	hasPermission("addbuttom",userId,resourceSn,<s:property value="@com.gcflower.util.Permission@CREATE" />);	
	hasPermission("updateimg",userId,resourceSn,<s:property value="@com.gcflower.util.Permission@UPDATE" />);
	hasPermission("deleteimg",userId,resourceSn,<s:property value="@com.gcflower.util.Permission@DELETE" />);

});




$(document).ready(function(){ 
	
	//弹出框相关配置
	
	$("#addroleSN").colorbox({width:'600px',height:'300px'}); /*这里可以写一些Colorbox的配置*/
	//选择所有的name属性等于'updateimgsn'的A元素  
	
});



$(function(){

	//下拉分页
	$('#maxResults').change(function(){
		changepage(1);
	});
	
})		
	//手输分页
	function dochange(){
		var v=$("#pageTotal").val();
		var totalPage='<s:property value="page.pageTotal" />';
			 
		if(parseInt(totalPage,10)>=parseInt(v,10)){
			changepage(v);
		}else{
			changepage(totalPage);
		}
			
	}
	
	//分页
	function changepage(pageval){
		var maxResults=$('#maxResults').children('option:selected').val();
		if(maxResults==undefined){
			maxResults=10;
		}
	
		var actionName='searchRole?page.page='+pageval+'&page.maxResults='+maxResults;
		actionName = encodeURI(actionName);
    	actionName = encodeURI(actionName);    //两次，很关键
		window.location.href=actionName;
			
	}


	//删除
	function deleteRole(id,columindex){
		
		
		if(confirm("你确定要取消该条数据？")){
			$.post("delRole?id="+id,null,function(resultData){
				var result =resultData;			// eval(eval("("+resultData+")"));
				if(result=="SUCCESS"){
					
					var mr=$("#maxResults").val();
					var cp=$("#pageTotal").val();
					var pagefirst=mr*(cp-1)+1;
					//处理只有一条数据时删除的情况
					if(cp>1 && pagefirst==columindex){
						cp=cp-1;
					}
					changepage(cp);
					
				}else{
					alert(result);
				}		
			})
		}
			
	}
	
	
	
	//修改
	function updateMsg(id){
			
		$.colorbox({href:'<%=root %>/updateInputRole?id='+id,width:'600px',height:'300px',iframe:true});
	}
	
	//授权
	function aclMsg(id){
		$.colorbox({href:'<%=root %>/serachAcl?principalId='+id,width:'800px',height:'500px',iframe:true});
	
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
        			<td height="31"><div class="titlebt">角色管理</div></td>
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
            					<td class="left_txt">当前位置：角色管理&nbsp;
            						
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
	                							 	<a id="addroleSN" href="<%=root %>/sys/role/add.jsp" title="" class="iframe"  >
	                									<img src="<%=root %>/images/icon/8_48x48.png" width="54" height="55" title="" />
	                								</a>
                								</div>
                							</td>
                							<td width="90%" valign="top">
                								<span class="left_txt2">在这里，您可以对角色进行维护</span>
                								<span class="left_txt3"></span>
                								<span class="left_txt2">！</span><br>
                          						<span class="left_txt2">包括</span>
                          						<span class="left_txt3">添加角色，修改角色，分配角色权限</span>
                          						<span class="left_txt2">等以及删除角色</span>
                          						<span class="left_txt3">设置</span>
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
            						<table width="100%" border="0"  cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">
            							<thead>
            								<tr  class="CTitle">
										      	<td  height="37" width="28px"><b>序号</b></td>
											    <td  height="37" width="300px"><b>角色名称</b></td>
									            <td  height="37" ><b>操作</b></td>
							          		</tr>
            							</thead>
            							<s:iterator value="page.datas" status="rowstatus">
	            							<tr bgcolor="#FFFFFF">
	                							<td  bgcolor="#f2f2f2" class="left_txt2">
	                								<s:property value="#rowstatus.count+(page.page-1)*page.maxResults"/>
	                							</td>
	               	 							<td  bgcolor="#f2f2f2">
	               	 									<s:property value="name"/>
	               	 							</td>
	                							<td  bgcolor="#f2f2f2" class="left_txt">
	                								<a  onclick="updateMsg(<s:property value="id"/>)"   class="updateimg" >
	                									<img   src="<%=root %>/images/icon/edit.gif" title="修改" />&nbsp;
													</a>
													<img class="deleteimg"  src="<%=root %>/images/icon/dele.png" title="删除" onclick='deleteRole(<s:property value="id"/>,<s:property value="#rowstatus.count+(page.page-1)*page.maxResults"/>)'/>
													
													&nbsp;&nbsp;
													
													<a  onclick="aclMsg(<s:property value="id"/>)" class="updateimg" >
	                									<font class="aclimg">角色授权</font>
													</a>
													
	                							</td>
	              							</tr>
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
          				<table width="100%" border="0" cellspacing="0" cellpadding="0">
            				<tr>
              					<td height="30" colspan="3">
								<div class="navigation" style="padding-top:10px;">
					        		<s:if test="page.recordTotal > 0">
										
										<div class="list_info fr" style="width:340px;float:left;text-align:left;">
										 	每页显示
										 	<s:select  id="maxResults" name="page.maxResults" list="#{'5':'5','10':'10','20':'20','50':'50','100':'100','500':'500'}" ></s:select>
											条当前第
											<s:textfield id="pageTotal" name="page.page" cssStyle="width:30px;" onblur="dochange()"></s:textfield> 
											页, 共
											<span><s:property value="page.pageTotal" /> </span>页
										</div>
									
										<div class="scott" style="width:60%;float:right;text-align:right">
												
											<a onclick="changepage(1);"
												href="#"
													<s:if test="page.page==1">disabled="disabled"</s:if>>第一页</a>
											<a onclick="changepage(<s:property value="page.previous" />);"
												href="#"
												<s:if test="page.page==page.previous">disabled="disabled"</s:if>>上一页</a>
											
												<s:bean name="org.apache.struts2.util.Counter" id="counter">   
											   		<s:param name="first" value="page.startpage" />   
											   		<s:param name="last" value="page.endpage" />   
											   		<s:iterator>
											   			<a onclick='changepage(<s:property />);'
															href="#" <s:if test="page.page==current-1">disabled="disabled" class="current" </s:if> >
															<s:property />
														</a>   
											   		</s:iterator>   
												</s:bean> 
												
											<a onclick="changepage(<s:property value="page.next" />);"
												href="#"
												<s:if test="page.page==page.next">disabled="disabled"</s:if>>下一页</a>
											<a onclick="changepage(<s:property value="page.pageTotal" />);"
												href="#"
												<s:if test="page.page==page.pageTotal">disabled="disabled"</s:if>>尾页</a>
												
										</div>
									</s:if>	
									</div>
				                  <div class="clear"></div>
								
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