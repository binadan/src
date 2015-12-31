<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%String root=request.getContextPath();%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>团队列表</title>

<link href="<%=root %>/images/skin.css" rel="stylesheet" type="text/css" />
<link href="<%=root %>/css/css.css" rel="stylesheet" type="text/css" />
<link href="<%=root %>/css/style.css" rel="stylesheet" type="text/css" />
<link href="<%=root %>/css/pagecss.css" rel="stylesheet" type="text/css" />
<link media="screen" rel="stylesheet" href="<%=root%>/css/colorbox.css" />
<script src="<%=root%>/js/jquery.min.js"></script>
<script src="<%=root%>/js/SecurityFunctions.js"></script>
<script type='text/javascript' src='<%=root%>/js/jquery.contextmenu.r2-min.js'></script>
<script src="<%=root%>/js/jquery.colorbox.js"></script>
<script src="<%=root%>/js/table.js"></script>
<link rel="stylesheet" href="<%=root %>/tree/css/demo.css" type="text/css">
<link rel="stylesheet" href="<%=root %>/tree/css/zTreeStyle/zTreeStyle.css" type="text/css">
<script type="text/javascript" src="<%=root %>/tree/js/jquery.ztree.core-3.5.js"></script>
	
</head>	


<script type="text/javascript">

//判断当前权限
$(document).ready(function(){ 
	var userId=${sessionScope.sessionUser.id};		//当前用户ID
	var resourceSn="groupmgr";						//当前模块SN
		
	hasPermission("add_acl",userId,resourceSn,<s:property value="@com.gcflower.util.Permission@CREATE" />);
	hasPermission("update_acl",userId,resourceSn,<s:property value="@com.gcflower.util.Permission@UPDATE" />);
	hasPermission("delete_acl",userId,resourceSn,<s:property value="@com.gcflower.util.Permission@DELETE" />);

});

</script>


<script type='text/javascript'>
		<!--
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

		$(document).ready(function(){
			
			$.post("searchOrgJson",null,function(resultData){
				$.fn.zTree.init($("#treeDemo"), setting, resultData);
				//全展开
				$.fn.zTree.getZTreeObj("treeDemo").expandAll(true);
			})
			
			
			
		});
		//-->


	
</script>


<script type="text/javascript">

	
	//删除
	function delOrg(id){
		 if(confirm("是否删除?")){
			$.post("delOrg?id="+id,null,function(resultData){
				var result =resultData;// eval(eval("("+resultData+")"));
				
				if(result=="SUCCESS"){
					window.location.href="<%=root%>/searchOrg";
				}else{
					alert(result);
				}	
			
			})
		}
	}
	
	//修改
	function updateMsg(id){
		$.colorbox({href:'<%=root %>/loadOrg?id='+id,width:'700px',height:'400px',iframe:true});
	}
	
	//添加
	function addMsg(id){
		$.colorbox({href:'<%=root %>/addreadOrg?id='+id,width:'700px',height:'400px',iframe:true});
				
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
        			<td height="31"><div class="titlebt">部门</div></td>
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
            					<td class="left_txt">当前位置：部门管理&nbsp;
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
                								<div id="addbuttom">
	                								<img src="<%=root %>/images/icon/card.jpg" width="54" height="55" title="列表" />
                								</div>
                							</td>
                							<td width="90%" valign="top">
                								<span class="left_txt2">在这里,通过左边列表进行维护部门,右边区域进行预览</span>
                          						
                          					</td>
              							</tr>
              							
            						</table>
            					</td>
          					</tr>
          					<tr>
            					<td>&nbsp;</td>
          					</tr>
          					<tr>
            					<td >
            					<!-- 内容区开始 -->
									<div style="float: left;width: 700px;">
	            						<table width="100%" border="0"  cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">
	            							<thead>
	            								<tr  class="CTitle">
											      	<td  height="37" width="28px"><b>序号</b></td>
												    <td  height="37" width="100px"><B>名称</B></td>
												    <td  height="37" width="100px" ><b>父模块名称</b></td>
												    <td  height="37" width="280px" ><b>编码</b></td>
										            <td  height="37" >
										            	<b>操作</b>
										            	<%-- <a onclick='addMsg(0)'  class="add_acl">
			                								<img class="updateimg"  src="<%=root %>/images/icon/add.png" title="增加" />&nbsp;
														</a> --%>
										            </td>
								          		</tr>
	            							</thead>
	            							<s:iterator value="page.datas" status="rowstatus">
	            								<s:set var ="total" value="1" /><!-- 定义一个变量 -->
		            							<tr bgcolor="#B0C4DE" class="left_txt">
		                							<td >
		                								<s:property value="#rowstatus.count+(page.page-1)*page.maxResults"/>
		                							</td>
		               	 							<td >
		               	 								<s:property value="name"/>
		               	 							</td>
		                							<td ><s:property value="parent.name"/> </td>
		                							<td ><s:property value="code"/> </td>
		                							<td >
		                								<a onclick='addMsg(<s:property value="id"/>)' class="add_acl">
			                								<img class="updateimg"  src="<%=root %>/images/icon/add.png" title="增加" />&nbsp;&nbsp;
														</a>
															
		                								<a onclick='updateMsg(<s:property value="id"/>)'  class="update_acl">
			                								<img class="updateimg"  src="<%=root %>/images/icon/edit.gif" title="修改" />&nbsp;
														</a>
													
														<a onclick='delOrg(<s:property value="id"/>)' class="delete_acl" >
															<img class="deleteimg"  src="<%=root %>/images/icon/dele.png" title="删除" />
														</a>
														
		                							</td>
		              							</tr>
		              							<s:if test="children!=null">
		              								<s:set var ="total" value="#total+1"/><!-- 对list的值进行求和 -->
													<s:include value="treetable.jsp"></s:include>
												</s:if>
	            							</s:iterator>
	            							
	            							<s:if test="page.datas==null || page.datas.size<1">
	            								<tr>
	            									<td colspan="13" bgcolor="#f2f2f2">没有相关记录</td>
	            								</tr>
	            							</s:if>
	            						</table>
            						</div>
            						
            						<div id="menuContent" class="menuContent" style=" width: 200px;float: left; margin-left: 20px;">
										<ul id="treeDemo" class="ztree" style="margin-top:0; width:160px;"></ul>
									</div> 
            					<!-- 内容区结束 -->	
            					</td>
          					</tr>
        				</table>
          				<table width="100%" border="0" cellspacing="0" cellpadding="0">
            				<tr>
              					<td height="30" colspan="3">
								
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