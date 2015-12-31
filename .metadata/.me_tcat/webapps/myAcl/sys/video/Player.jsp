<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>视频播放界面</title>
	<meta http-equiv="pragma" content="no-cache">
    <script charset="utf-8" src="<%=basePath %>/kindeditor/plugins/insertVideo/ckplayer/ckplayer.js"></script>
    <script charset="utf-8" src="<%=basePath %>/kindeditor/plugins/insertVideo/callCkplayer.js"></script>
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body>
    <!-- <button onclick="playVid()" type="button">播放视频</button>
	&nbsp;
    <button onclick="pauseVid()" type="button">暂停视频</button>
    <br/>
    <video id="videolist"> -->
   <!-- <source src="/example/html5/mov_bbb.mp4" type="video/mp3">
   <source src="/example/html5/mov_bbb.ogg" type="video/ogg"> -->
  <!--  <video src="myAcl\photo\upload\" controls="controls">
              您的浏览器不支持 video 标签。
   </video>
 </video> -->
 <object classid="" id="Slider1">
 	<param name="BorderStyle" value="1"/>
 	<param name="MousePointer" value="0"/>
 	<param name="Enabled" value="1"/>
 	<param name="Min" value="0"/>
 	<param name="Max" value="10"/>
 	<object id="mPlayer1" width=300 height=300 classid="CLSID:6BF52A52-394A-11D3-B153-00C04F79FAA6">
<param name="URL" value="<%=url%>">
<param name="rate" value="1">
<!--播放速率控制,1为正常,允许小数 -->
<param name="balance" value="0">
<!--左右声道平衡,最左-9640,最右9640 -->
<param name="currentPosition" value="0">
<!--当前播放进度 -1 表示不变,0表示开头 单位是秒,比如10表示从第10秒处开始播放,值必须是-1.0或大于等于0-->
<param name="defaultFrame" value>
<param name="playCount" value="100">
<!--重复播放次数,0为始终重复-->
<param name="autoStart" value="1">
<!--是否自动播放-->
<param name="currentMarker" value="0">
<param name="invokeURLs" value="1">
<param name="baseURL" value>
<param name="volume" value="100">
<!--音量大小,负值表示是当前音量的减值,值自动会取绝对值,最大为0,最小为-9640-->
<param name="mute" value="0">
<!--是否静音-->
<param name="uiMode" value="full">
<param name="stretchToFit" value="0">
<param name="windowlessVideo" value="0">

<!--如果是0可以允许全屏,否则只能在窗口中查看-->

<param name="enabled" value="1">

<param name="enableContextMenu" value="1">

<!--是否用右键弹出菜单控制-->

<param name="fullScreen" value="0">

<param name="SAMIStyle" value>

<!--SAMI样式-->

<param name="SAMILang" value>

<!--SAMI语言-->

<param name="SAMIFilename" value>

<!--字幕ID-->

<param name="captioningID" value>

<param name="enableErrorDialogs" value="0">

<param name="_cx" value="7779">

<param name="_cy" value="1693">

</object>
 </object>
<script>
var myVideo=document.getElementById("video1");

     function playVid(){
          demo.play();
  }

     function pauseVid(){
          demo.pause();
  }
</script>
    
  </body>
</html>
