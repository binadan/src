<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%String root=request.getContextPath();%>

<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<link href="images/skin.css" rel="stylesheet" type="text/css" />
<link href="<%=root %>/css/style.css" rel="stylesheet" type="text/css">

<meta http-equiv="Content-Type" content="text/html; charset=uft-8" /><style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: #EEF2FB;
	font-size: 12px;
}
-->
</style>
<SCRIPT language=javascript>
	function secBoard(n)
		{
			for(i=0;i<secTable.cells.length;i++)
				secTable.cells[i].className="sec1";
			
			secTable.cells[n].className="sec2";
			
			for(i=0;i<mainTable.tBodies.length;i++)
				mainTable.tBodies[i].style.display="none";
			
			mainTable.tBodies[n].style.display="block";
		}
</SCRIPT>
          	
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="17" valign="top" background="images/mail_leftbg.gif">
    	<img src="images/left-top-right.gif" width="17" height="29" />
    </td>
    <td valign="top" background="images/content-bg.gif">
    	<table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
      		<tr>
        		<td height="31" ><div class="titlebt">欢迎界面</div></td>
      		</tr>
    	</table>
    </td>
    <td width="16" valign="top" background="images/mail_rightbg.gif">
    	<img src="images/nav-right-bg.gif" width="16" height="29" />
    </td>
  </tr>
  <tr>
    <td valign="middle" background="images/mail_leftbg.gif">&nbsp;</td>
    <td valign="top" bgcolor="#F7F8F9" style="min-height: 400px;">
   		<iframe style="margin-top:10px; border:solid 1px #6495ED; width: 98%" name="weather_inc" src="http://cache.xixik.com.cn/2/xian/" height="100" frameborder="0" marginwidth="0" marginheight="0" scrolling="no"></iframe>
    	
    	<div style="border:solid 1px #7ec8ea;width: 98%; margin-top: 10px;height: 280px;padding-top: 10px; ">
    		
    	</div>
	
    </td>
    <td background="images/mail_rightbg.gif">&nbsp;</td>
  </tr>
  <tr>
    <td valign="bottom" background="images/mail_leftbg.gif"><img src="images/buttom_left2.gif" width="17" height="17" /></td>
    <td background="images/buttom_bgs.gif"><img src="images/buttom_bgs.gif" width="17" height="17"></td>
    <td valign="bottom" background="images/mail_rightbg.gif"><img src="images/buttom_right2.gif" width="16" height="17" /></td>
  </tr>
</table>


            	
</body>
</html>
