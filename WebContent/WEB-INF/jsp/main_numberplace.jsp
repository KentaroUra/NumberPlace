<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="servlet.Main_numberplace_start, model.NumberPlaceObject, servlet.Main_numberplace_finish
,model.User" %>
<%User user = (User)session.getAttribute("user"); %>
<!-- セッションスコープから取り出し ゲーム判定結果(game_judge) -->
<% String game_judge = (String)session.getAttribute("game_judge");%>

<!-- セッションスコープから取り出し ゲームデータ(q_gamedata) -->
<% NumberPlaceObject play_gamedata = (NumberPlaceObject)session.getAttribute("q_gamedata");  %>

<!-- ゲームデータの配列を作成し格納（81マス分） -->
<% int[] hairetu = new int[81]; %>
<% hairetu[0] = play_gamedata.getBlock01(); %>
<% hairetu[1] = play_gamedata.getBlock02(); %>
<% hairetu[2] = play_gamedata.getBlock03(); %>
<% hairetu[3] = play_gamedata.getBlock04(); %>
<% hairetu[4] = play_gamedata.getBlock05(); %>
<% hairetu[5] = play_gamedata.getBlock06(); %>
<% hairetu[6] = play_gamedata.getBlock07(); %>
<% hairetu[7] = play_gamedata.getBlock08(); %>
<% hairetu[8] = play_gamedata.getBlock09(); %>
<% hairetu[9] = play_gamedata.getBlock10(); %>
<% hairetu[10] = play_gamedata.getBlock11(); %>
<% hairetu[11] = play_gamedata.getBlock12(); %>
<% hairetu[12] = play_gamedata.getBlock13(); %>
<% hairetu[13] = play_gamedata.getBlock14(); %>
<% hairetu[14] = play_gamedata.getBlock15(); %>
<% hairetu[15] = play_gamedata.getBlock16(); %>
<% hairetu[16] = play_gamedata.getBlock17(); %>
<% hairetu[17] = play_gamedata.getBlock18(); %>
<% hairetu[18] = play_gamedata.getBlock19(); %>
<% hairetu[19] = play_gamedata.getBlock20(); %>
<% hairetu[20] = play_gamedata.getBlock21(); %>
<% hairetu[21] = play_gamedata.getBlock22(); %>
<% hairetu[22] = play_gamedata.getBlock23(); %>
<% hairetu[23] = play_gamedata.getBlock24(); %>
<% hairetu[24] = play_gamedata.getBlock25(); %>
<% hairetu[25] = play_gamedata.getBlock26(); %>
<% hairetu[26] = play_gamedata.getBlock27(); %>
<% hairetu[27] = play_gamedata.getBlock28(); %>
<% hairetu[28] = play_gamedata.getBlock29(); %>
<% hairetu[29] = play_gamedata.getBlock30(); %>
<% hairetu[30] = play_gamedata.getBlock31(); %>
<% hairetu[31] = play_gamedata.getBlock32(); %>
<% hairetu[32] = play_gamedata.getBlock33(); %>
<% hairetu[33] = play_gamedata.getBlock34(); %>
<% hairetu[34] = play_gamedata.getBlock35(); %>
<% hairetu[35] = play_gamedata.getBlock36(); %>
<% hairetu[36] = play_gamedata.getBlock37(); %>
<% hairetu[37] = play_gamedata.getBlock38(); %>
<% hairetu[38] = play_gamedata.getBlock39(); %>
<% hairetu[39] = play_gamedata.getBlock40(); %>
<% hairetu[40] = play_gamedata.getBlock41(); %>
<% hairetu[41] = play_gamedata.getBlock42(); %>
<% hairetu[42] = play_gamedata.getBlock43(); %>
<% hairetu[43] = play_gamedata.getBlock44(); %>
<% hairetu[44] = play_gamedata.getBlock45(); %>
<% hairetu[45] = play_gamedata.getBlock46(); %>
<% hairetu[46] = play_gamedata.getBlock47(); %>
<% hairetu[47] = play_gamedata.getBlock48(); %>
<% hairetu[48] = play_gamedata.getBlock49(); %>
<% hairetu[49] = play_gamedata.getBlock50(); %>
<% hairetu[50] = play_gamedata.getBlock51(); %>
<% hairetu[51] = play_gamedata.getBlock52(); %>
<% hairetu[52] = play_gamedata.getBlock53(); %>
<% hairetu[53] = play_gamedata.getBlock54(); %>
<% hairetu[54] = play_gamedata.getBlock55(); %>
<% hairetu[55] = play_gamedata.getBlock56(); %>
<% hairetu[56] = play_gamedata.getBlock57(); %>
<% hairetu[57] = play_gamedata.getBlock58(); %>
<% hairetu[58] = play_gamedata.getBlock59(); %>
<% hairetu[59] = play_gamedata.getBlock60(); %>
<% hairetu[60] = play_gamedata.getBlock61(); %>
<% hairetu[61] = play_gamedata.getBlock62(); %>
<% hairetu[62] = play_gamedata.getBlock63(); %>
<% hairetu[63] = play_gamedata.getBlock64(); %>
<% hairetu[64] = play_gamedata.getBlock65(); %>
<% hairetu[65] = play_gamedata.getBlock66(); %>
<% hairetu[66] = play_gamedata.getBlock67(); %>
<% hairetu[67] = play_gamedata.getBlock68(); %>
<% hairetu[68] = play_gamedata.getBlock69(); %>
<% hairetu[69] = play_gamedata.getBlock70(); %>
<% hairetu[70] = play_gamedata.getBlock71(); %>
<% hairetu[71] = play_gamedata.getBlock72(); %>
<% hairetu[72] = play_gamedata.getBlock73(); %>
<% hairetu[73] = play_gamedata.getBlock74(); %>
<% hairetu[74] = play_gamedata.getBlock75(); %>
<% hairetu[75] = play_gamedata.getBlock76(); %>
<% hairetu[76] = play_gamedata.getBlock77(); %>
<% hairetu[77] = play_gamedata.getBlock78(); %>
<% hairetu[78] = play_gamedata.getBlock79(); %>
<% hairetu[79] = play_gamedata.getBlock80(); %>
<% hairetu[80] = play_gamedata.getBlock81(); %>

<!-- セッションスコープから取り出し 送信した回答済みゲームデータ(input_number) ※初期値は0 -->
<% NumberPlaceObject input_number = (NumberPlaceObject)session.getAttribute("input_number");  %>

<!-- 送信した回答データの配列を作成し格納（81マス分） -->
<% int[] input_num = new int[81]; %>
<% input_num[0] = input_number.getBlock01(); %>
<% input_num[1] = input_number.getBlock02(); %>
<% input_num[2] = input_number.getBlock03(); %>
<% input_num[3] = input_number.getBlock04(); %>
<% input_num[4] = input_number.getBlock05(); %>
<% input_num[5] = input_number.getBlock06(); %>
<% input_num[6] = input_number.getBlock07(); %>
<% input_num[7] = input_number.getBlock08(); %>
<% input_num[8] = input_number.getBlock09(); %>
<% input_num[9] = input_number.getBlock10(); %>
<% input_num[10] = input_number.getBlock11(); %>
<% input_num[11] = input_number.getBlock12(); %>
<% input_num[12] = input_number.getBlock13(); %>
<% input_num[13] = input_number.getBlock14(); %>
<% input_num[14] = input_number.getBlock15(); %>
<% input_num[15] = input_number.getBlock16(); %>
<% input_num[16] = input_number.getBlock17(); %>
<% input_num[17] = input_number.getBlock18(); %>
<% input_num[18] = input_number.getBlock19(); %>
<% input_num[19] = input_number.getBlock20(); %>
<% input_num[20] = input_number.getBlock21(); %>
<% input_num[21] = input_number.getBlock22(); %>
<% input_num[22] = input_number.getBlock23(); %>
<% input_num[23] = input_number.getBlock24(); %>
<% input_num[24] = input_number.getBlock25(); %>
<% input_num[25] = input_number.getBlock26(); %>
<% input_num[26] = input_number.getBlock27(); %>
<% input_num[27] = input_number.getBlock28(); %>
<% input_num[28] = input_number.getBlock29(); %>
<% input_num[29] = input_number.getBlock30(); %>
<% input_num[30] = input_number.getBlock31(); %>
<% input_num[31] = input_number.getBlock32(); %>
<% input_num[32] = input_number.getBlock33(); %>
<% input_num[33] = input_number.getBlock34(); %>
<% input_num[34] = input_number.getBlock35(); %>
<% input_num[35] = input_number.getBlock36(); %>
<% input_num[36] = input_number.getBlock37(); %>
<% input_num[37] = input_number.getBlock38(); %>
<% input_num[38] = input_number.getBlock39(); %>
<% input_num[39] = input_number.getBlock40(); %>
<% input_num[40] = input_number.getBlock41(); %>
<% input_num[41] = input_number.getBlock42(); %>
<% input_num[42] = input_number.getBlock43(); %>
<% input_num[43] = input_number.getBlock44(); %>
<% input_num[44] = input_number.getBlock45(); %>
<% input_num[45] = input_number.getBlock46(); %>
<% input_num[46] = input_number.getBlock47(); %>
<% input_num[47] = input_number.getBlock48(); %>
<% input_num[48] = input_number.getBlock49(); %>
<% input_num[49] = input_number.getBlock50(); %>
<% input_num[50] = input_number.getBlock51(); %>
<% input_num[51] = input_number.getBlock52(); %>
<% input_num[52] = input_number.getBlock53(); %>
<% input_num[53] = input_number.getBlock54(); %>
<% input_num[54] = input_number.getBlock55(); %>
<% input_num[55] = input_number.getBlock56(); %>
<% input_num[56] = input_number.getBlock57(); %>
<% input_num[57] = input_number.getBlock58(); %>
<% input_num[58] = input_number.getBlock59(); %>
<% input_num[59] = input_number.getBlock60(); %>
<% input_num[60] = input_number.getBlock61(); %>
<% input_num[61] = input_number.getBlock62(); %>
<% input_num[62] = input_number.getBlock63(); %>
<% input_num[63] = input_number.getBlock64(); %>
<% input_num[64] = input_number.getBlock65(); %>
<% input_num[65] = input_number.getBlock66(); %>
<% input_num[66] = input_number.getBlock67(); %>
<% input_num[67] = input_number.getBlock68(); %>
<% input_num[68] = input_number.getBlock69(); %>
<% input_num[69] = input_number.getBlock70(); %>
<% input_num[70] = input_number.getBlock71(); %>
<% input_num[71] = input_number.getBlock72(); %>
<% input_num[72] = input_number.getBlock73(); %>
<% input_num[73] = input_number.getBlock74(); %>
<% input_num[74] = input_number.getBlock75(); %>
<% input_num[75] = input_number.getBlock76(); %>
<% input_num[76] = input_number.getBlock77(); %>
<% input_num[77] = input_number.getBlock78(); %>
<% input_num[78] = input_number.getBlock79(); %>
<% input_num[79] = input_number.getBlock80(); %>
<% input_num[80] = input_number.getBlock81(); %>

<!-- ***** ゲーム画面の記述（html） ***** -->
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
           <%@include file="/WEB-INF/css/style_b.css" %>
            <%@include file="/WEB-INF/css/style_numberplace.css" %>
    </style>
<meta http-equiv="content-type" content="text/html; charset=Shift_JIS">
	<meta name="generator" content="HeTeMuLu Creator Ver.1.10a">
	<META NAME="GOOGLEBOT" CONTENT="NOINDEX, NOFOLLOW,NOARCHIVE">
	<META NAME="ROBOTS" CONTENT="NOARCHIVE,NOINDEX,NOFOLLOW">
	<!--   <link rel="stylesheet" href="header.css"> -->
	<link rel="stylesheet" href="style_numberplace.css"> <!-- CSS利用linkタグ (同階層に設置style.css) -->
<title>＼ Number Place ／</title>
</head>



<body>
<div id="wrapper">

<!-- タイトル -->
<div class="menu"><h1>NumberPlace</h1></div>

<div id="navi">

<div class="menu">ユーザー名：<%=user.getUserName() %></div>
<div class="menu">スコア：<%=user.getScore() %>pt</div>
<!-- game_judgeによって変化するコメント -->
<div class="menu"><% if(game_judge == null) { %>
<p><br><br><br>ゲームスタート！空欄を数字で埋めてください。</p></div>
<div class="menu"><%}else if(game_judge.equals("0")){ %>
<p><br><br><br><br>空欄を数字で埋めてください。</p></div>
<div class="menu"><%}else if(game_judge.equals("1")){ %>
<p><br><br><br><br>正解です。</p></div>
<div class="menu"><%}else{ %>
<p><br><br><br><br>不正解です。空欄を数字で埋めてください。</p></div>
<% } %>
</div></div>
<!-- numberplaceのゲーム表示および回答フォーム -->
<form action="/kino_NumberPlace/Main_numberplace_finish" method="post">
<table class="test">
<tr>

<% for(int i = 0; i < hairetu.length; i++){ %>
	<% if(i % 9 == 0){ %>
		</tr>
		<tr>
	<% } %>

	<% if(i == 11 || i == 20 || i == 38 || i == 47 || i == 65 || i == 74 || i == 14 || i == 23 || i == 41 || i == 50 || i == 68 || i == 77){ %>
		<td class="b_r">
	<% }else if(i == 0 || i == 1 || i == 3 || i == 4 || i == 6 || i == 7 || i == 8 ||i == 27 || i == 28 || i == 30 || i == 31 || i == 33 || i == 34 || i == 35 ||  i == 54 || i == 55 || i == 57 || i == 58 || i == 60 || i == 61 || i == 62){ %>
		<td class="b_t">
	<% }else if(i == 2 || i == 5 || i == 29 || i == 32 || i == 56 || i == 59) {%>
		<td class="b_tr">
	<% }else {%>
		<td>
	<% } %>


	<% if(hairetu[i] == 0){ %>
		<% if(input_num[i] == 0){ %>
		<input type="tel" required="required" maxlength="1" class="hoge" name="ans" oninput="value = value.replace(/[^1-9]+/i,'');" />
		<% }else{ %>
		<input type="tel" required="required" maxlength="1" class="hoge" name="ans" oninput="value = value.replace(/[^1-9]+/i,'');" value="<%= input_num[i] %>" />
		<% } %>
	<% }else{ %>
		<input type="hidden" name="ans" value="<%= hairetu[i] %>"><%= hairetu[i] %>
	<% } %>
	</td>
<% } %>
</tr>
</table>
<br><br>
<div id="navi">
<div class="menu"><a href="/kino_NumberPlace/main">Cancel  </a>|| </div>
<div class="menu"><input type="submit" value="Finish" class="button"></div>||
<div class="menu"><a href = "/kino_NumberPlace/Help"> 説明を見る</a></div>
</div>
</form>
<br><br><br>
</body>
</html>