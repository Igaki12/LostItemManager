<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*"
%>

<%File fs = new File("/Search"); 
  String pathS = fs.getName();
  File fr = new File("/Register");
  String pathR = fr.getName();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style_searchCheck.css">
<title>条件をつけて検索</title>
</head>
<body>
  <header>
    <h3>さがす</h3>
  </header>

  <div class="full-page">
    <h1>おとしものがみつかりました。</h1>
    ,<p>A校</p><h1>でうけとってください！</h1>
    <div class="list-grid">
      <img src="img/sample1.jpg" alt="写真" class="list-grid-photo" width="auto" height="100%">
      <h4>その他</h4>
      <div class="list-where">郊外</div>
      <div class="list-time">11/16</div>
    </div>
    <section class="check-box">
      <h2>種類</h2>
      <p>その他</p>
      <h2>場所</h2>
      <p>郊外</p>
      <h2>拾った日</h2>
      <p>11/16</p>
    </section>
    <button id="back_button" class="btn" type="button" onclick="">さいしょにもどる</button>
  </div>

  <footer>2021 (c)IgatatApps All Rights Resereved.</footer>
</body>
</html>