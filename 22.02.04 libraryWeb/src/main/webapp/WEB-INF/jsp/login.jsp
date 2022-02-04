<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
  <head>
<link href="../css/login.css" rel="stylesheet">
<script src="../js/jquery-3.6.0.min.js"></script>
<script src="../js/login.js"></script>
  </head>
  <body width="100%" height="100%">
  <form id="login_form" onsubmit="return login();" class="loginForm">
      <h2>Login</h2>
      <div class="idForm">
        <input type="text" class="id" name="uid" id="uid" placeholder="ID">
      </div>
      <div class="passForm">
        <input type="password" class="pw" name="pwd" id="pwd" placeholder="PW">
      </div>
      <button type="submit" class="btn">
        LOG IN
      </button>
      <div class="bottomText">
        Don't you have ID? <a href="/library/signup">sign up</a>
        <br><br><br><br>
        <a href="/library/bookSearch"><h1>search</h1></a>
        <a href="/library/freeBoard"><h1>freeboard</h1></a>
        <a href="/library/photoBoard"><h1>photoboard</h1></a>
        <a href="/library/notice"><h1>notice</h1></a>
      </div>
    </form>
  </body>
</html>
