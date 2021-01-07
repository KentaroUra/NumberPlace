<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String message = (String)request.getAttribute("message");
String message1 = (String)request.getAttribute("message1");
%>
<!DOCTYPE html>
<head>
<style type="text/css">
           <%@include file="WEB-INF/css/style_b.css" %>
           <%@include file="WEB-INF/css/sample.css" %>
    </style>

	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<meta name="generator" content="HeTeMuLu Creator Ver.1.10a">
	<META NAME="GOOGLEBOT" CONTENT="NOINDEX, NOFOLLOW,NOARCHIVE">
	<META NAME="ROBOTS" CONTENT="NOARCHIVE,NOINDEX,NOFOLLOW">
	<title>＼ Number Place ／</title>
</head>
<body>

<div id="wrapper">

<h1>Welcome to NumberPlace!</h1>

<div id="navi">

<div class="menu"> -- Login --</div><br>
<%if(message != null){ %>
<p class="sample"><%=message %></p>
<%} %>
<%if(message1 != null){ %>
<p class="sample"><%=message1 %></p>
<%} %>
<form action= "/kino_NumberPlace/Login" method = "post">
<div class="menu">ユーザー名：<input type = "text" name = "user_name"><br> </div>
<div class="menu">パスワード：<input type = "password" name = "password"> </div><br>
<div class="menu"><input type = "submit" value = "Login" class="button"> </div><br>
</form>
<br>
<div class="menu"><a href = "/kino_NumberPlace/UserCreate">ユーザー登録</a></div>
</div>
<!-- navi end end end end end end end end end -->

<div id="txt">
<h2>introduction</h2>

このアプリはNumberPlace<br>
(ナンプレや数独とも言う)ゲーム専用アプリです。<br>
<br>
※ナンプレ・数独とは、数字を使ったパズルゲームの一種で、<br>
規則に従って9×9のマスに1から9までの数字を並べ、マスを全て埋めるゲームのこと。<br>
<br>
NumberPlaceは以下の機能を備えています。<br>
・ゲームを行う際のメンバー新規登録、およびログイン機能<br>
・数独ゲーム<br>
・ゲーム終了後のスコアをランキングにて掲載する機能<br>
<br>
<br>
<br>
<br>
<h2>about me</h2>
Numberplace | http://localhost:8080/kino_NumberPlace/ |<br>
<br>
<br>


</div>
<!-- txt end -->

<div class="dash"></div>

<div id="foot" align="center">design and material by <a href="http://www43.tok2.com/home/rome0/">Romeo</a></div>

</div>
<!-- wrapper end -->

</body>

</html>
