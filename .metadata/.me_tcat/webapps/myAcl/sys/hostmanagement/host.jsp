<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String root = request.getContextPath();
%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>主机信息列表</title>

<link href="<%=root%>/images/skin.css" rel="stylesheet" type="text/css" />
<link href="<%=root%>/css/css.css" rel="stylesheet" type="text/css" />
<link href="<%=root%>/css/style.css" rel="stylesheet" type="text/css" />
<link href="<%=root%>/css/pagecss.css" rel="stylesheet" type="text/css" />

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

img {
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
	var resourceSn="Hostmanagement";						//当前模块SN
	hasPermission("addbuttom",userId,resourceSn,<s:property value="@com.gcflower.util.Permission@CREATE" />);	
	hasPermission("updateimg",userId,resourceSn,<s:property value="@com.gcflower.util.Permission@UPDATE" />);
	hasPermission("deleteimg",userId,resourceSn,<s:property value="@com.gcflower.util.Permission@DELETE" />);
	hasPermission("deleteimg",userId,resourceSn,<s:property value="@com.gcflower.util.Permission@DELETE" />);
});



$(function(){

	//下拉分页
	$('#maxResults').change(function(){
		changepage(1);
	});
	
})

$(document).ready(function(){ 
	
	//选择所有的name属性等于'updateimgsn'的A元素  
	$("a[name='add_iframe']").colorbox({width:'600px',height:'400px'}); 
	$("a[name='update_iframe']").colorbox({width:'600px',height:'400px'}); 
});	
	
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
		var m_state=$("#m_state").val();
		var p_state=$("#p_state").val();
		
		/* var id=<s:property value="id"/>; */
		var id=<s:property value="page.page"/>;
		//alert(m_state);
		//alert(p_state);

		var actionName='selectHostManagement?page.page='+pageval+'&page.maxResults='+maxResults+"&id="+id+"&m_state="+m_state+"&p_state="+p_state;
		actionName = encodeURI(actionName);
    	actionName = encodeURI(actionName);    //两次，很关键
		window.location.href=actionName;
			
	}

	function showHostManagement(id){
	
	}

	//删除
	function deleteHostManagement(id,columindex){
		if(confirm("你确定要取消该条数据？")){
			$.post("delHostManagement?id="+id,null,function(resultData){
				var result =resultData;// eval(eval("("+resultData+")"));
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
	
	function del(id){
		if(confirm("确定要删除吗？")){
			window.location.href="del.action?M_ID="+id;
		}
		
	}
	//全选，反选
	function selectAll(opt){
	if($(opt).attr("checked")=="checked"){
		$(".newfont03 [name=check]").attr("checked",$(opt).attr("checked"));		
	}else{
		$(".newfont03 [name=check]").removeAttr("checked");
	}
	
	}
	
	//批量删除
	function delHosts(){
	var str="";
	var sel=$(".newfont03 [name=check]");
	for(var i=0;i<sel.length;i++){
		if(sel[i].checked){
			str+=sel[i].value;
		}	
	}
	if(str!=""){
		if(confirm("确定要删除吗？")){
			window.location.href="delHosts?ids="+str;	
		}
		}else{
			alert("至少选择一条记录");
		}	
	}
</script>



<body>

	<input type="hidden" id="hid" value='<s:property value="id"/>' />

	<table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td width="17" height="29" valign="top"
				background="<%=root%>/images/mail_leftbg.gif"><img
				src="<%=root%>/images/left-top-right.gif" width="17" height="29" />
			</td>
			<td width="935" height="29" valign="top"
				background="<%=root%>/images/content-bg.gif">
				<table width="100%" height="31" border="0" cellpadding="0"
					cellspacing="0" class="left_topbg" id="table2">
					<tr>
						<td height="31"><div class="titlebt">主机信息管理</div></td>
					</tr>
				</table>
			</td>
			<td width="16" valign="top"
				background="<%=root%>/images/mail_rightbg.gif"><img
				src="<%=root%>/images/nav-right-bg.gif" width="16" height="29" /></td>
		</tr>
		<tr>
			<td height="71" valign="middle"
				background="<%=root%>/images/mail_leftbg.gif">&nbsp;</td>
			<td valign="top" bgcolor="#F7F8F9">
				<table width="100%" height="138" border="0" cellpadding="0"
					cellspacing="0">
					<tr>
						<td height="13" valign="top">&nbsp;</td>
					</tr>
					<tr>
						<td valign="top">
							<table width="98%" border="0" align="center" cellpadding="0"
								cellspacing="0">
								<tr>
									<td class="left_txt">当前位置：主机管理&nbsp; <font
										style="float: right;">
											<%--  <a
											href='<%=root%>/searchHostManagement?id=0'>返回</a> </font></td> --%>
								</tr>
								<tr>
									<td height="20">
										<table width="100%" height="1" border="0" cellpadding="0"
											cellspacing="0" bgcolor="#CCCCCC">
											<tr>
												<td></td>
											</tr>
										</table>
									</td>
								</tr>
								<tr>
									<td>
										<table width="100%" height="55" border="0" cellpadding="0"
											cellspacing="0">
											<tr>
												<td width="10%" height="55">
													<div class="addbuttom">
														<a name="add_iframe"
															href="<%=root%>/sys/hostmanagement/add.jsp" title=""
															class="iframe"> <img
															src="<%=root%>/images/icon/8_48x48.png" width="54"
															height="55" title="">
														</a>
													</div>
												</td>
												<td width="90%" valign="top"><span class="left_txt2">在这里，您可以根据您的网站要求，修改设置网站的</span>
													<span class="left_txt3">主机信息</span> <span class="left_txt2">！</span><br>
														<span class="left_txt2">包括</span> <span class="left_txt3">添加主机信息、修改主机信息、删除主机信息</span>
														<span class="left_txt2">等</span> <span class="left_txt3">设置</span>
														<span class="left_txt2">。 </span>
												</td>
											</tr>
										</table>
									</td>
								</tr>
								<tr>
									<td width="100%" colspan="2">
										<form action="<%=root%>/selectHostManagement" method="post"
											id="searchForm">
											主机状态: <select name="hostManagement1.M_STATE" id="m_state" />
											<option value="">&ndash;全部 &ndash;</option>
											<option value="1"
												<c:if test="${hostManagement1.mstate == '1'}">selected</c:if>>布防</option>
											<option value="2"
												<c:if test="${hostManagement1.mstate == '2'}">selected</c:if>>撤防</option>
											</select> 欠费信息: <select name="hostManagement1.P_STATE" id="p_state" />
											<option value="">&ndash; 全部 &ndash;</option>
											<option value="1"
												<c:if test="${hostManagement1.pstate == '1'}">selected</c:if>>正常</option>
											<option value="0"
												<c:if test="${hostManagement1.pstate == '0'}">selected</c:if>>欠费</option>
											</select> &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; <input type="submit"
												value="查询" />
										</form>
									</td>
								</tr>
								<tr>
									<td>&nbsp;</td>
								</tr>
								<tr>
									<td>
										<!-- 这里加内容 start-->
										<table width="100%" border="0" cellpadding="4" cellspacing="1"
											bgcolor="#464646" class="newfont03">
											<thead>
												<tr class="CTitle">
													<td height="37" width="50px" align="center"><input
														type="checkbox" id="all" onclick="selectAll(this);" />全选</td>
													<td height="37" width="28px" align="center"><b>序号</b>
													</td>
													<td height="37" width="50px" align="center"><b>客服账号</b>
													</td>
													<td height="37" width="100px" align="center"><b>客服姓名</b>
													</td>
													<td height="37" width="100px" align="center"><b>客服电话</b>
													</td>
													<td height="37" width="50px" align="center"><b>主机编号</b>
													</td>
													<td height="37" width="100px" align="center"><b>房屋编号</b>
													</td>
													<td height="37" width="100px" align="center"><b>当前IP</b>
													</td>
													<td height="37" width="100px" align="center"><b>状态</b>
													</td>
													<td height="37" width="100px" align="center"><b>欠费信息</b>
													</td>
													<td height="37"><b>操作</b></td>
												</tr>
											</thead>
											<s:iterator value="page.datas" status="rowstatus">
												<tr bgcolor="#FFFFFF">
													<td bgcolor="#f2f2f2" class="left_txt2" align="center">
														<input type="checkbox" name="check"
														value=<s:property value="M_ID"/> /></td>
													<td bgcolor="#f2f2f2" class="left_txt2" align="center"><s:property
															value="#rowstatus.count+(page.page-1)*page.maxResults" />
													</td>
													<td bgcolor="#f2f2f2" align="center"><s:property
															value="M_KEFUZHANGHAO" />
													</td>
													<td bgcolor="#f2f2f2" align="center"><s:property
															value="M_KEFUNAME" />
													</td>
													<td bgcolor="#f2f2f2" align="center"><s:property
															value="M_KEFUTEL" />
													</td>
													<td bgcolor="#f2f2f2" align="center"><s:property
															value="M_MANUAL" />
													</td>
													<td bgcolor="#f2f2f2" align="center"><s:property
															value="M_HOUSEID" /></td>
													<td bgcolor="#f2f2f2" align="center"><s:property
															value="M_IP" /> <s:hidden value="M_IP"></s:hidden>
													</td>
													<td bgcolor="#f2f2f2" class="left_txt" align="center"><s:if
															test="M_STATE==1">布防</s:if> <s:if test="M_STATE==2">撤防</s:if>
													</td>

													<td bgcolor="#f2f2f2" class="left_txt" align="center">
														<s:if test="P_STATE==1">正常</s:if> <s:if test="P_STATE==0">欠费</s:if>

													</td>
													<td bgcolor="#f2f2f2" class="left_txt"><a
														name="update_iframe"
														href='<%=root%>/findByIdHost.action?M_ID=<s:property value="M_ID"/>&t=<%=System.currentTimeMillis() %>'
														title="" class="updateimg"> <img class="updateimg"
															src="<%=root%>/images/icon/edit.gif" title="修改" />
													</a> <%-- <img class="deleteimg"  src="<%=root %>/images/icon/dele.png" title="删除" onclick='deleteHostManagement(<s:property value="M_ID"/>,<s:property value="#rowstatus.count+(page.page-1)*page.maxResults"/>)'/> --%>
														&nbsp; <img src="<%=root%>/images/icon/dele.png"
														class="deleteimg" title="删除"
														onclick='del(<s:property value="M_ID"/>)' />
													</td>
												</tr>
											</s:iterator>
											<tr bgcolor="#FFFFFF">
												<td colspan="11" bgcolor="#f2f2f2" class="left_txt2"
													align="left"><img src="<%=root%>/images/icon/dele.png"
													class="deleteimg" title="删除" onclick="delHosts();" />批量删除
												</td>
											</tr>
											<s:if test="page.datas==null || page.datas.size<1">
												<tr>
													<td colspan="13" bgcolor="#f2f2f2">没有相关记录</td>
												</tr>
											</s:if>
										</table> <!-- 这里加内容 end-->
									</td>
								</tr>
							</table>
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td height="30" colspan="3">
										<div class="navigation" style="padding-top:10px;">
											<s:if test="page.recordTotal > 0">

												<div class="list_info fr"
													style="width:340px;float:left;text-align:left;">
													每页显示
													<s:select id="maxResults" name="page.maxResults"
														list="#{'5':'5','10':'10','20':'20','50':'50','100':'100','500':'500'}"></s:select>
													条当前第
													<s:textfield id="pageTotal" name="page.page"
														cssStyle="width:30px;" onblur="dochange()"></s:textfield>
													页, 共 <span><s:property value="page.pageTotal" /> </span>页
												</div>

												<div class="scott"
													style="width:60%;float:right;text-align:right">

													<a onclick="changepage(1);" href="#"
														<s:if test="page.page==1">disabled="disabled"</s:if>>第一页</a>
													<a
														onclick="changepage(<s:property value="page.previous" />);"
														href="#"
														<s:if test="page.page==page.previous">disabled="disabled"</s:if>>上一页</a>

													<s:bean name="org.apache.struts2.util.Counter" id="counter">
														<s:param name="first" value="page.startpage" />
														<s:param name="last" value="page.endpage" />
														<s:iterator>
															<a onclick='changepage(<s:property />);' href="#"
																<s:if test="page.page==current-1">disabled="disabled" class="current" </s:if>>
																<s:property /> </a>
														</s:iterator>
													</s:bean>

													<a onclick="changepage(<s:property value="page.next" />);"
														href="#"
														<s:if test="page.page==page.next">disabled="disabled"</s:if>>下一页</a>
													<a
														onclick="changepage(<s:property value="page.pageTotal" />);"
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
			<td background="<%=root%>/images/mail_rightbg.gif">&nbsp;</td>
		</tr>
		<tr>
			<td valign="middle" background="<%=root%>/images/mail_leftbg.gif">
				<img src="<%=root%>/images/buttom_left2.gif" width="17" height="17" />
			</td>
			<td height="17" valign="top"
				background="<%=root%>/images/buttom_bgs.gif"><img
				src="<%=root%>/images/buttom_bgs.gif" width="17" height="17" />
			</td>
			<td background="<%=root%>/images/mail_rightbg.gif"><img
				src="<%=root%>/images/buttom_right2.gif" width="16" height="17" />
			</td>
		</tr>
	</table>


</body>
</html>