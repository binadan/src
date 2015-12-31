/**
 * Friday
 * 
 * 2013 07 02
 * 
 */


var callId;
var targetId;
		//setting

		var setting = {
			view: {
				dblClickExpand: false,
				showIcon: false,
				showLine: false,
				showTitle: false
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
		
		
		//选中
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
			
			var cityObj =$("#"+callId);
			cityObj.attr("value", v);
			
			$("#"+targetId).val(code);
			hideMenu();
			
		}

		//显示
		function showMenu() {
			var cityObj = $("#"+callId);
			var cityOffset = $("#"+callId).offset();
			$("#menuContent").css({left:cityOffset.left + "px", top:cityOffset.top + cityObj.outerHeight() + "px"}).slideDown("fast");

			$("body").bind("mousedown", onBodyDown);
		}
		
		//隐藏
		function hideMenu() {
			$("#menuContent").fadeOut("fast");
			$("body").unbind("mousedown", onBodyDown);
		}
		
		//隐藏
		function onBodyDown(event) {
			if (!(event.target.id == "menuBtn" || event.target.id == "menuContent" || $(event.target).parents("#menuContent").length>0)) {
				hideMenu();
			}
		}



		
		
	//下拉即时筛选
	function inittree(mycallId,mytargetId,myURL){
		
		callId=mycallId;
	 	targetId=mytargetId;
		
		var actionName=myURL;
		actionName = encodeURI(actionName);
    	actionName = encodeURI(actionName);    //两次，很关键
    	$.post(actionName,null,function(resultData){
    		$.fn.zTree.init($("#treeDemo"), setting, resultData);
				//全展开
				$.fn.zTree.getZTreeObj("treeDemo").expandAll(true);
    		
    	})
	
 		showMenu();
			
	}

	