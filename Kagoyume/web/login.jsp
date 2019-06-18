<%-- 
    Document   : login
    Created on : 2018/08/10, 15:23:36
    Author     : fukatsu-s
--%>
<%@page import="kagoyume.KagoyumeHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
KagoyumeHelper kh = KagoyumeHelper.getInstance();
HttpSession hs = request.getSession();
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
      
        <h1>ログイン情報を入力してください</h1>
        <form action="LoginCheck" method="POST">
        名前：<input type="text" name="name" value="" ><br>
        パスワード：<input type="password" name="password" value="" ><br>
        <input type="hidden" name="login" value="<%=hs.getAttribute("referer")%>">
        <input type="submit" name="submit" value="ログイン">
        </form>
        <br>
            <a href="Registration" >新規会員登録</a><br>
            <%=kh.home()%>
    </body>
</html>
