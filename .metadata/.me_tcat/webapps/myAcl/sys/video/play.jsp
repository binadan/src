<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <base href="<%=basePath%>">
    <title>视频播放界面</title>
	<meta http-equiv="pragma" content="no-cache">
   <%--  <script charset="utf-8" src="<%=basePath %>/kindeditor/plugins/insertVideo/ckplayer/ckplayer.js"></script> --%>
    <%-- <script charset="utf-8" src="<%=basePath %>/kindeditor/plugins/insertVideo/callCkplayer.js"></script> --%>
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  <script type="text/javascript" src="../../kindeditor/plugins/insertVideo/ckplayer/ckplayer.js"></script>
  <script type="text/javascript" src="../../kindeditor/plugins/insertVideo/callCkplayer.js"></script></head>
  
  <script type="text/javascript">
    var myVideo=document.getElementById("video1");


     function playVid(){
          demo.play();
  }

     function pauseVid(){
          demo.pause();
  }
  

</script>

<body>
<object classid="clsid:22D6F312-B0F6-11D0-94AB-0080C74C7E95" codebase="http://activex.microsoft.com/activex/controls/mplayer
/en/nsmp2inf.cab#Version=6,1,5,217"
id="video1" type="application/x-oleobject" width="900" height="400" standby="Loading Microsoft Windows Media Player components..." VIEWASTEXT align="MIDDLE" >
<!--音频流  -->
<param name="AudioStream" value="-1">
<!--自动大小  -->
<param name="AutoSize" value="0">
<!--自动播放  -->
<param name=AutoStart value="0">
<!--动画处理-->
<param name="AnimationAtStart" value="0">
<!--是否允许浏览-->
<param name="AllowScan" value="-1">
<!--允许改变显示尺寸大小-->
<param name="AllowChangeDisplaySize" value=0>
<!-- 自动倒回 -->
<param name= "AutoRewind " value="1">
<!-- 平衡 -->
<param name= "Balance " value="0">
<!--  基础链接-->
<param name= "BaseURL " value="">
<!-- 缓冲时间 -->
<param name= "BufferingTime" value="5">
<!-- 字幕ID -->
<param name= "CaptioningID " value="">
<!-- 点击播放 -->
<param name= "ClickToPlay " value="1">
<!-- 指针类型 -->
<param name= "CursorType " value="0 ">
<!-- 当前位置 -->
<param name= "CurrentPosition " value="1">
<!-- 当前标记 -->
<param name= "CurrentMarker " value="1">
<!--  默认的帧-->
<param name= "DefaultFrame " value="">
<!--  显示背景颜色-->
<param name= "DisplayBackColor " value="0">
<!-- 显示前的颜色 -->
<param name="DisplayForeColor" value="16777215">
<!-- 显示方式 -->
<param name="DisplayMode" value="0">
<!--  显示大小-->
<param name="DisplaySize" value="0">
<!-- 激活 -->
<param name="Enabled" value="-1">
<!-- 上下文菜单 -->
<param name="EnableContextMenu" value="-1">
<!--  位置控制-->
<param name="EnablePositionControls" value="0">
<!-- 是否显示控制菜单 -->
<param name="EnableFullScreenControls" value="0">
<!-- 显示追踪 -->
<param name="EnableTracker" value="1">
<!--  文件-->
<param name="Filename" value="<s:property value='vide.Vadd'/>">
<!-- 调用的url -->
<param name="InvokeURLs" value="-1">
<!--  语言-->
<param name="Language" value="-1">
<!-- 静音-->
<param name="Mute" value="0">
<!-- 播放次数-->
<param name="PlayCount" value="1">
<!-- 检查方式-->
<param name="PreviewMode" value="0">
<!-- 比率-->
<param name="Rate" value="1">
<!--  -->
<param name="SAMILang" value="">
<!--  -->
<param name="SAMIStyle" value="">
<!--  -->
<param name="SAMIFileName" value="">
<!-- 选择开始 -->
<param name="SelectionStart" value="0">
<!-- 选择结束 -->
<param name="SelectionEnd" value="true">
<!-- 发送开放状态变化事件 -->
<param name="SendOpenStateChangeEvents" value="-1">
<!--  发送警告事件-->
<param name="SendWarningEvents" value="-1">
<!--  发送错误事件-->
<param name="SendErrorEvents" value="-1">
<!--  发送键盘事件-->
<param name="SendKeyboardEvents" value="0">
<!--  发送鼠标点击事件-->
<param name="SendMouseClickEvents" value="0">
<!--  发送鼠标移动事件-->
<param name="SendMouseMoveEvents" value="0">
<!-- 发送状态变化的事件 -->
<param name="SendPlayStateChangeEvents" value="-1">
<!-- 显示字幕 -->
<param name="ShowCaptioning" value="0">
<!--  显示控制-->
<param name="ShowControls" value="1">
<!--  显示音频控制-->
<param name="ShowAudioControls" value="1">
<!--  -->
<param name="ShowDisplay" value="1">
<!--显示Goto栏-->
<param name="ShowGotoBar" value="1">
<!--  显示位置控制-->
<param name="ShowPositionControls" value="1">
<!-- 显示状态栏 -->
<param name="ShowStatusBar" value="1">
<!-- 显示追踪 -->
<param name="ShowTracker" value="1">
<!--  -->
<param name="TransparentAtStart" value="0">
<!--  视频边框宽度-->
<param name="VideoBorderWidth" value="0">
<!-- 视频边框颜色 -->
<param name="VideoBorderColor" value="0">
<!--  3 d视频边界-->
<param name="VideoBorder3D" value="0">
<!--  体积-->
<param name="Volume" value="-1070">
<!-- 没有窗户的视频 -->
<param name="WindowlessVideo" value="1">
 </object>
</body>


<%-- 
 <object id="video1" width="900" height="400" border="0" classid="clsid:CFCDAA03-8BE4-11cf-B84B-0020AFBBCCFA">
<param name="ShowDisplay" value="true">
<param name="ShowControls" value="true">
<param name="AutoStart"   value="false">
<param name="AutoRewind" value="true">
<param name="PlayCount" value="true">
<param name="fullScreen" value="true">
  <!--是否显示当前播放跟踪条,即当前的播放进度条-->
 <param name="TransparentAtStart" value="true">
<param name="Appearance" value="0" value="">
<param name="BorderStyle" value="0" value="">
<param name="MovieWindowHeight" value="240">
<param name="MovieWindowWidth" value="320">
<!--是否显示控制,比如播放,停止,暂停-->
 <param name="ShowAudioControls" value="true"> 
<param name="FileName" value="<s:property value='vide.Vadd'/>">
		<embed pluginspage="http://www.videolan.org"
			type="application/x-vlc-plugin" version="VideoLAN.VLCPlugin.2"
			width="900" height="400" border="true" showdisplay="true" AutoStart="false"
			showcontrols="true" autostart="false" autorewind="true" playcount="true"
			moviewindowheight="400" moviewindowwidth="900"
			filename="<s:property value='vide.Vadd'/>"
			src="<s:property value='vide.Vadd'/>">
		</embed>
	</object>  --%>

</html>