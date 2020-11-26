<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	//リクエストスコープに保存されたメッセージを取得
	String message = (String)request.getAttribute("message");
	%>
<!DOCTYPE html>
<head>
<style type="text/css">
           <%@include file="/WEB-INF/css/style_b.css" %>
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
	<div class="menu"> -- Sign up --</div><br>
		<form action="/kino_NumberPlace/UserCreate" method= "post">
		<div class="menu">ユーザー名：<input type = "text" name = "new_user"> </div><br>
		<div class="menu">パスワード：<input type = "password" name = "new_pass"></div><br>
		<input type = "submit" value = "entry" class="button">
		</form>
		<br>
	<div class="menu"><% if(message != null) { %>
		<p><%= message %></p>
		<% } %></div>
	<div class="menu"><a href="index.jsp">戻る</a></div>
	</div>
<!-- navi end -->

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
