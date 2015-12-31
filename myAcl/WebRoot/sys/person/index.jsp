<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%String root=request.getContextPath();%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>管理员列表</title>



<link href="<%=root %>/images/skin.css" rel="stylesheet" type="text/css" />
<link href="<%=root %>/css/css.css" rel="stylesheet" type="text/css" />
<link href="<%=root %>/css/style.css" rel="stylesheet" type="text/css" />
<link href="<%=root %>/css/pagecss.css" rel="stylesheet" type="text/css" />

<link media="screen" rel="stylesheet" href="<%=root%>/css/colorbox.css" />
<script src="<%=root%>/js/jquery.min.js"></script>
<script src="<%=root%>/js/jquery.colorbox.js"></script>
<script src="<%=root%>/js/table.js"></script>
<script src="<%=root%>/js/SecurityFunctions.js"></script>
<link rel="stylesheet" href="<%=root %>/tree/css/demo.css" type="text/css">
<link rel="stylesheet" href="<%=root %>/tree/css/zTreeStyle/zTreeStyle.css" type="text/css">
<script type="text/javascript" src="<%=root %>/tree/js/jquery.ztree.core-3.5.js"></script>


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
	var resourceSn="salesman";							//当前模块SN
	hasPermission("addbuttom",userId,resourceSn,<s:property value="@com.gcflower.util.Permission@CREATE" />);	
	hasPermission("updateimg",userId,resourceSn,<s:property value="@com.gcflower.util.Permission@UPDATE" />);
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
	$("a[name='add_iframe']").colorbox({width:'650px',height:'500px'}); 
	$("a[name='update_iframe']").colorbox({width:'650px',height:'500px'}); 
});	



	//手输分页
	function dochange(){
		var v=$("#pageTotal").val();
		//alert(v);
		var totalPage='<s:property value="page.pageTotal" />';
			 
		if(parseInt(totalPage,10)>=parseInt(v,10)){
			changepage(v);
		}else{
			changepage(totalPage);
		}
			
	}
	
	//分页
	function changepage(pageval){
		//alert("分页了");
		var maxResults=$('#maxResults').children('option:selected').val();
		//alert(maxResults);
		if(maxResults==undefined){
			maxResults=10;
		}
		var userName=$("#userName").val();
		
/* 		var code=$("#hcode").val();
		var name=$("#hname").val();
		alert(code);
		alert(name); */
		var actionName='searchPerson?page.page='+pageval+'&page.maxResults='+maxResults;
		//alert(actionName);
		actionName = encodeURI(actionName);
    	actionName = encodeURI(actionName);    //两次，很关键
		window.location.href=actionName;
			
	}


	//删除
	function deleteModule(id,columindex){
		
 		if(confirm("你确定要取消该条数据？")){
			/*$.post("delPerson?id="+id,null,function(resultData){
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
			}) */
			
			window.location.href="delPerson.action?id="+id;
		}
			
	}
	
</script>

<script type='text/javascript'>




		var setting = {
			view: {
				dblClickExpand: false
			},
			
			data: {
				simpleData: {
					enable: true
				}
			},
			callback: {
				beforeClick: beforeClick,
				onClick: onClick
			}
		};


		function beforeClick(treeId, treeNode) {
			//var check = (treeNode && !treeNode.isParent);
			//if (!check) alert("只能选择城市...");
			
			//去掉上面代码，以便可先父级
			var check=true;
			return check;
		}
		
		function onClick(e, treeId, treeNode) {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
			nodes = zTree.getSelectedNodes(),
			v = "";
			var code="";
			nodes.sort(function compare(a,b){return a.id-b.id;});
			for (var i=0, l=nodes.length; i<l; i++) {
				v += nodes[i].name + ",";
				code+=nodes[i].code+",";
			}
			if (v.length > 0 ) v = v.substring(0, v.length-1);
			if (code.length > 0 ) code = code.substring(0, code.length-1);
			
			var cityObj = $("#citySel");
			cityObj.attr("value", v);
			
			$("#hcode").val(code);
			$("#hname").val(v);
			
			changepage(1);
		}

		function showMenu() {
			var cityObj = $("#citySel");
			var cityOffset = $("#citySel").offset();
			$("#menuContent").css({left:cityOffset.left + "px", top:cityOffset.top + cityObj.outerHeight() + "px"}).slideDown("fast");

			$("body").bind("mousedown", onBodyDown);
		}
		function hideMenu() {
			$("#menuContent").fadeOut("fast");
			$("body").unbind("mousedown", onBodyDown);
		}
		function onBodyDown(event) {
			if (!(event.target.id == "menuBtn" || event.target.id == "menuContent" || $(event.target).parents("#menuContent").length>0)) {
				hideMenu();
			}
		}

		/*$(document).ready(function(){
			
			$.post("searchOrgJson",null,function(resultData){
				$.fn.zTree.init($("#treeDemo"), setting, resultData);
				//全展开
				$.fn.zTree.getZTreeObj("treeDemo").expandAll(true);
			})			
		}); */
		
	//全选，反选	
	function checkAll(my){
	
		if ($(my).attr("checked") == "checked") {
			$(".newfont03 [name=check]").attr("checked",$(my).attr("checked"));	
			
		}
		 else {
		 	$(".newfont03 [name=check]").removeAttr("checked");	
		 }
	}
	
	//批量删除
	function  deletePerAll(){
	var str="";
	
	var selects=document.getElementsByName("check");
	
	for(var i=0;i<selects.length;i++){
	
		if(selects[i].checked){	
			var vale=selects[i].value;		
			str+=selects[i].value+","; 							 		
		}		
	}
	//'alert(str);
	//window.location.href="deletePerAll.action?ids="+str;
	if(str!=""){
	if(confirm("你确定要取消该条数据？")){
			$.post("deletePerAll.action?ids="+str,null,function(resultData){
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
	}else{
		alert("至少选择一条记录");
	}
}	


	
</script>


<body>



<table width="100%" border="0" cellpadding="0" cellspacing="0">
	<tr>
    	<td width="17" height="29" valign="top" background="<%=root %>/images/mail_leftbg.gif">
    		<img src="<%=root %>/images/left-top-right.gif" width="17" height="29" />
    	</td>
    	<td width="935" height="29" valign="top" background="<%=root %>/images/content-bg.gif">
    		<table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
      			<tr>
        			<td height="31"><div class="titlebt">管理员管理</div></td>
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
            					<td class="left_txt">当前位置：管理员管理&nbsp;
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
	                							 	<a name="add_iframe" href="<%=root %>/sys/person/add.jsp" title="" class="iframe">
	                									<img src="<%=root %>/images/icon/8_48x48.png" width="54" height="55" title="" />
	                								</a>
                								</div>
                							</td>
                							<td width="70%" valign="top">
                								<span class="left_txt2">在这里，您可以根据您的网站要求，对人员进行操作</span>
                								<span class="left_txt3"></span>
                								<span class="left_txt2">！</span><br />
                          						<span class="left_txt2">包括</span>
                          						<span class="left_txt3">添加管理员信息，修改管理员信息，删除管理员信息</span>
                          						<!-- <span class="left_txt2">等以及</span>
                          						<span class="left_txt3">根据组织机构进行查询</span> -->
                          						<span class="left_txt2">。 </span>
                          					</td>
                          					<%-- <td width="20%" valign="top">
                          						所在部门：
                          						<input type="text" id="citySel" style="width:100px" readonly="true" value='<s:property value="name"/>' onfocus="showMenu(); return false;"/>
												&nbsp;<a id="menuBtn" href="#" onclick="showMenu(); return false;">选择</a>
                          						<s:hidden id="hcode" name="code" />
                          						<s:hidden id="hname" name="name" />
                          						
                          						<div id="menuContent" class="menuContent" style="display:none; position: absolute;">
													<ul id="treeDemo" class="ztree" style="margin-top:0; width:160px;"></ul>
												</div> 
                          					</td> --%>
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
            								<td height="37" width="50px" align="center">
            									<input type="checkbox" id="all" onclick="checkAll(this);"/>全选</td>
										      	<td  height="37" width="28px"><b>序号</b></td>
											    <td  height="37" width="100px"><b>姓名</b></td>
											    <td  height="37" width="50px"><b>性别</b></td>
											    <td  height="37" width="50px" ><b>年龄</b></td>
											    <td  height="37" width="100px" ><b>电话</b></td>
											    <td  height="37" width="150px"><b>所属机构</b></td>
									            <td  height="37" ><b>操作</b></td>
							          		</tr>
            							</thead>
            							<s:iterator value="page.datas" status="rowstatus">
	            							<tr bgcolor="#FFFFFF">
	            							<td bgcolor="#f2f2f2" class="left_txt" align="center"><input type="checkbox" name="check" value=<s:property value="id"/> /></td>
	                							<td  bgcolor="#f2f2f2" class="left_txt2">
	                								<s:property value="#rowstatus.count+(page.page-1)*page.maxResults"/>
	                							</td>
	               	 							<td  bgcolor="#f2f2f2">
	               	 								<s:property value="name"/>
	               	 							</td>
	                							<td	 bgcolor="#f2f2f2"><s:property value="sex"/> </td>
	                							<td  bgcolor="#f2f2f2" class="left_txt"><s:property value="age"/> </td>
	                							<td  bgcolor="#f2f2f2" class="left_txt"><s:property value="phone"/> </td>
	                							<td  bgcolor="#f2f2f2" class="left_txt">
	                								<s:property value="tearm.name"/>
	                							</td>
	                							<td  bgcolor="#f2f2f2" class="left_txt">
	                								<a name="update_iframe" class="updateimg" href='<%=root %>/loadPerson?id=<s:property value="id"/>&t=<%=System.currentTimeMillis() %>' title="" class="iframe">
	                									<img  class="updateimg"  src="<%=root %>/images/icon/edit.gif" title="" />&nbsp;
													</a>
													<img class="deleteimg"  src="<%=root %>/images/icon/dele.png" title="删除" onclick='deleteModule(<s:property value="id"/>,<s:property value="#rowstatus.count+(page.page-1)*page.maxResults"/>)'/>
	                							</td>
	              							</tr>
            							</s:iterator>
            							<tr  class="CTitle">
	              								<td bgcolor="#f2f2f2" class="left_txt" align="left" colspan="8">
	              								<img class="deleteimg"  src="<%=root %>/images/icon/dele.png" title="删除" onclick="deletePerAll()"/>批量删除
	              								</td>
	              							</tr>
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