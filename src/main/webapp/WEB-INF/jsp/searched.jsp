<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*" import="model.Item"
%>

<%File fs = new File("/Search"); 
  String pathS = fs.getName();
  File ft = new File("/Top");
  String pathT = ft.getName();
%>

<%HttpSession sess = request.getSession();
  sess.getAttribute("searched_item");
  String item_kind = (String)request.getAttribute("item_kind");
  String found_place = (String)request.getAttribute("found_place");
  String found_at = (String)request.getAttribute("found_at");
  String photo = (String)request.getAttribute("photo");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
<link rel="stylesheet" href="css/style_searchCheck.css">
<title>条件をつけて検索</title>
</head>
<body>
<div class="background">
  <div class="main-screen">
      <header>
    <h3>さがす</h3>
  </header>

  <div class="full-page">
    <h1>おとしものがみつかりました。</h1>
      <p>A校</p><h1>でうけとってください！</h1>
    <div class="list-grid">
      <img src="https://lostitemmanager.s3.ap-northeast-1.amazonaws.com/dir/<%=photo %>.png" alt="写真" class="list-grid-photo" width="90px" height="90px">
      <h4><%=item_kind %></h4>
      <div class="list-where"><%=found_place %></div>
      <div class="list-time"><%=found_at %></div>
    </div>
    <section class="check-box">
      <h2>種類</h2>
      <p><%=item_kind %></p>
      <h2>場所</h2>
      <p><%=found_place %></p>
      <h2>拾った日</h2>
      <p><%=found_at %></p>
    </section>
    <button id="back_button" class="btn" type="button" onclick="location.href='./<%=pathT %>'">さいしょにもどる</button>
  </div>

  <footer>2021 (c)IgatatApps All Rights Resereved.</footer>
  </div>
</div>


</body>
</html>