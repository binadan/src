$(document).ready(function(){ 

$(".stripe_tb tr").mouseover(function(){ 

//如果鼠标移到class为stripe_tb的表格的tr上时，执行函数

$(this).addClass("over");}).mouseout(function(){ 

//给这行添加class值为over，并且当鼠标一出该行时执行函数

$(this).removeClass("over");}) //移除该行的class

$(".stripe_tb tr:even").addClass("alt");

//给class为stripe_tb的表格的偶数行添加class值为alt
$(".nodataarea").html("<table border=0 cellpadding=0 cellspacing=0 width=100% class=nodata><tr><td align=center><br><br>对不起,没有相关记录!<br><br><br></td></tr> </table>");

});
/*colorbox弹出窗口的jq控制代码*/
$(document).ready(function(){
			$(".iframe").colorbox({iframe:true, width:"95%", height:"90%"});	
			$("#click").click(function(){ 
				$('#click').css({"background-color":"#f00", "color":"#fff", "cursor":"inherit"}).text("Open this window again and this message will still be here.");
				return false;
			});
		});
/*是否显示搜索栏的jq代码*/
$(document).ready(function(){

			$(".blocksearch").toggle(
             function(){
			 $(".blocksearch").html("<a href=#><font class=modecolor>+显示搜索</font></a>");
		     $(".searchvisible").css("display","none"); },
			 function(){
			 $(".blocksearch").html("<a href=#><font class=modecolor>+隐藏搜索</a>");
			 $(".searchvisible").css("display","block"); }
			 );
		
		});
/*是否显示搜索栏的jq代码--档案*/
$(document).ready(function(){

			$(".dananblock").toggle(
             function(){
			 $(".dananblock").html("<a href=#><font class=modecolor>+隐藏搜索</font></a>");
		     $("#scroll_div").css("display","block");
			 $(".width-td1").css("width","22%");
			 $(".width-td2").css("width","78%");},
			 function(){
			 $(".dananblock").html("<a href=#><font class=modecolor>+显示搜索</a>");
			 $("#scroll_div").css("display","none"); 
			  $(".width-td1").css("width","0%");
			 $(".width-td2").css("width","100%");}
			 );
		
		});