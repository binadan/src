<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String root = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>添加人员</title>
<script src="<%=root%>/js/jquery.min.js"></script>
<script src="<%=root%>/js/check.js"></script>
<link href="<%=root%>/images/skin.css" rel="stylesheet" type="text/css" />
<link href="<%=root%>/css/css.css" rel="stylesheet" type="text/css" />
<link href="<%=root%>/css/style.css" rel="stylesheet" type="text/css" />

<link rel="stylesheet" href="<%=root%>/tree/css/demo.css"
	type="text/css">
<link rel="stylesheet"
	href="<%=root%>/tree/css/zTreeStyle/zTreeStyle.css" type="text/css">
<script type="text/javascript"
	src="<%=root%>/tree/js/jquery.ztree.core-3.5.js"></script>

</head>

<script type="text/javascript">
	//增加
	function addData() {

		if ($('#citySel').val() == "") {
			//验证
				alert("请选择您的所属机构！");
				return;
		}
		if ($('#age').val() != "") {
			//验证
			if (!isNumber($('#age').val())) {
				alert("年龄只允许输入整数！");
				return;
			}
		}
		if ($('#tel').val() != "") {
			//验证
			if (!isNumber($('#tel').val())) {
				alert("电话号码只允许输入整数！");
				return;
			}
		}

		var data = $("#editForm").serialize();
		$.post("addPerson", data, function(resultData) {
			var result = eval(eval("(" + resultData + ")"));

			if (result == 1) {

				window.parent.$.colorbox.close();
				parent.location.reload();
			} else {
				alert("添加失败，请重新添加或与管理员联系");
			}
		})

	}

	function showorg() {
		$('#orgdiv').css({
			"display" : "block"
		});
	}

	function closediv() {
		$('#orgdiv').css({
			"display" : "none"
		});
	}
</script>


<script type='text/javascript'>
	//<!--
	var setting = {
		view : {
			dblClickExpand : false
		},

		data : {
			simpleData : {
				enable : true
			}
		},
		callback : {
			beforeClick : beforeClick,
			onClick : onClick
		}
	};

	function beforeClick(treeId, treeNode) {
		//var check = (treeNode && !treeNode.isParent);
		//if (!check) alert("只能选择城市...");

		//去掉上面代码，以便可先父级
		var check = true;
		return check;
	}

	function onClick(e, treeId, treeNode) {
		var zTree = $.fn.zTree.getZTreeObj("treeDemo"), nodes = zTree
				.getSelectedNodes(), v = "";
		var code = "";
		nodes.sort(function compare(a, b) {
			return a.id - b.id;
		});
		for ( var i = 0, l = nodes.length; i < l; i++) {
			v += nodes[i].name + ",";
			code += nodes[i].id + ",";
		}
		if (v.length > 0)
			v = v.substring(0, v.length - 1);
		if (code.length > 0)
			code = code.substring(0, code.length - 1);

		var cityObj = $("#citySel");
		cityObj.attr("value", v);
		$("#orgid").val(code);
		hideMenu();
	}

	function showMenu() {
		var cityObj = $("#citySel");
		var cityOffset = $("#citySel").offset();
		$("#menuContent").css({
			left : cityOffset.left + "px",
			top : cityOffset.top + cityObj.outerHeight() + "px"
		}).slideDown("fast");

		$("body").bind("mousedown", onBodyDown);
	}
	function hideMenu() {
		$("#menuContent").fadeOut("fast");
		$("body").unbind("mousedown", onBodyDown);
	}
	function onBodyDown(event) {
		if (!(event.target.id == "menuBtn" || event.target.id == "menuContent" || $(
				event.target).parents("#menuContent").length > 0)) {
			hideMenu();
		}
	}

	$(document).ready(function() {

		$.post("searchOrgJson", null, function(resultData) {
			$.fn.zTree.init($("#treeDemo"), setting, resultData);

			//全展开
			$.fn.zTree.getZTreeObj("treeDemo").expandAll(true);
		})

	});
//-->
</script>

<body>

	<div id="orgdiv" style="display: none;">
		<font style="float: right; width: 10px; cursor: hand"> <img
			id="closeimg" src="<%=root%>/images/icon/dele.png" alt="取消"
			onclick="closediv()" /> </font>

		<div class="st_tree" style="width: 100%;float: left;">
			<ul id="product_tree" class="filetree"></ul>
		</div>
	</div>

	<form action="" id="editForm">
		<!-- 这里加内容 start-->
		<table width="100%" border="0" cellspacing="0" cellpadding="1">
			<thead>
				<tr>
					<td colspan="2"
						style="text-align: center; height: 30px; background-color: #C9C9C9; font-size: 18px;">添加人员</td>
				</tr>
			</thead>
			<tr>
				<td width="30%" height="30" align="right" bgcolor="#f2f2f2"
					class="left_txt2">所属机构：</td>
				<td height="30" bgcolor="#f2f2f2"><input id="citySel"
					name="data.tearm.name" type="text" size="30" readonly="true"
					onfocus="showMenu(); return false;" /> <input id="orgid"
					name="data.tearm.id" type="hidden" /> <input value="选择"
					type="button" onclick="showMenu(); return false;" /><font class="ERROR_No" style="color: red;">*此为必填项</font>
					<div id="menuContent" class="menuContent"
						style="display:none; position: absolute;height: 100px;">
						<ul id="treeDemo" class="ztree"
							style="margin-top:0; width:200px;height: 300px;"></ul>
					</div>
				</td>
			</tr>
			<tr>
				<td height="30" align="right" bgcolor="#f2f2f2" class="left_txt2">
					姓名：</td>
				<td height="30" bgcolor="#f2f2f2"><input name="data.name"
					type="text" id="title" size="30" />
				</td>
			</tr>
			<tr>
				<td height="30" align="right" bgcolor="#f2f2f2" class="left_txt2">
					性别：</td>
				<td height="30" bgcolor="#f2f2f2"><input type="radio" value="男"
					checked="checked" name="data.sex" />男 <input type="radio"
					value="女" name="data.sex" />女</td>
			</tr>
			<tr>
				<td height="30" align="right" bgcolor="#f2f2f2" class="left_txt2">
					年龄：</td>
				<td height="30" bgcolor="#f2f2f2"><input name="data.age"
					type="text" maxlength="3" id="age" size="30" />
				</td>
			</tr>
			<tr>
				<td height="30" align="right" bgcolor="#f2f2f2" class="left_txt2">
					电话：</td>
				<td height="30" bgcolor="#f2f2f2"><input name="data.phone"
					type="text" maxlength="12" id="tel" size="30" />
				</td>
			</tr>
			<tr>
				<td height="30" align="right" bgcolor="#f2f2f2" class="left_txt2">
					地址：</td>
				<td height="30" bgcolor="#f2f2f2"><input name="data.address"
					type="text" id="orderNo" size="30" />
				</td>
			</tr>

			<tr>
				<td colspan="2" align="center" style="padding-top:  50px;"><input
					type="button" value=" 添 加 " onclick="addData()" /> <input
					type="reset" value=" 重 置 " />
				</td>
			</tr>
		</table>
	</form>

</body>
</html>
