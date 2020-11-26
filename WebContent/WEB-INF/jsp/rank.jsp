<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.util.List, model.User" %>
<%List<User> userList = (List<User>)request.getAttribute("userList"); %>

<!DOCTYPE html>
<head>
<style type="text/css">
           <%@include file="/WEB-INF/css/style_b.css" %>
    </style>
	<meta http-equiv="content-type" content="text/html; charset=Shift_JIS">
	<meta name="generator" content="HeTeMuLu Creator Ver.1.10a">
	<META NAME="GOOGLEBOT" CONTENT="NOINDEX, NOFOLLOW,NOARCHIVE">
	<META NAME="ROBOTS" CONTENT="NOARCHIVE,NOINDEX,NOFOLLOW">
	<link rel="stylesheet" type="text/css" href="style_b.css">
<!-- CSS利用linkタグ (同階層に設置style.css) -->

	<title>＼ Number Place ／</title>
</head>
<body>

<div id="wrapper">
<div id="navi">
<h1>NumberPlace<br> Ranking!</h1>
<div class="menu"><p>現在の順位は....</div>
<%int i=1; %>
<%for(User u : userList){ %>
<div class="menu"><p><%=i %>位：<%=u.getUserName() %>さん   <%=u.getScore() %>pt</p></div>
<%i++;} %>
<div class="menu"><a href = "/kino_NumberPlace/main">戻る</a></div>
<div id="txt">
<br>
<br>
<br>
<br>
<br>

</div>
</div>
<!-- txt end -->
<!-- navi end -->
<div class="dash"></div>

<div id="foot" align="center">design and material by <a href="http://www43.tok2.com/home/rome0/">Romeo</a></div>

</div>
<!-- wrapper end -->

</body>

</html>
