<%@page import="javax.servlet.http.HttpSession"
        import="kagoyume.KagoyumeHelper"
        import="kagoyume.UserDataBeans" %>
<%
    KagoyumeHelper kh = KagoyumeHelper.getInstance();
    UserDataBeans udb = (UserDataBeans)request.getAttribute("udb");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録結果画面</title>
    </head>
    <body>
        <h1>登録結果</h1><br>
        名前:<%=udb.getName() %><br>
        パスワード:<%=udb.getPassword() %><br>
        メールアドレス：<%=udb.getMail() %><br>
        住所：<%=udb.getAddress() %><br>  
        以上の内容で登録しました。<br>
    </body>
    <%=kh.home()%>
</html>
