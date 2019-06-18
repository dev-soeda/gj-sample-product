<%@page import="javax.servlet.http.HttpSession"
        import="kagoyume.UserDataBeans"
        import="kagoyume.KagoyumeHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% 
    KagoyumeHelper kh = KagoyumeHelper.getInstance();
    HttpSession hs = request.getSession();
    UserDataBeans udb = null;
    boolean reinput = false;
    if(request.getParameter("mode") != null && request.getParameter("mode").equals("REINPUT")){
        reinput = true;
        udb = (UserDataBeans)hs.getAttribute("udb");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>新規会員登録</title>
    </head>
    <body>
        <form action="RegistrationConfirm" method="POST">

        名前<br><input type="text" name="name" value="<% if(reinput){out.print(udb.getName());}%>"><br>
        パスワード<br><input type="password" name="password" value="<% if(reinput){out.print(udb.getPassword());}%>"><br>
        メールアドレス<br><input type="email" name="mail" value="<% if(reinput){out.print(udb.getMail());}%>"><br>
        住所<br><input type="text" name="address" value="<% if(reinput){out.print(udb.getAddress());}%>"><br>
        
        <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
        <input type="submit" name="btnSubmit" value="確認画面へ">       
        </form>
        <%=kh.home()%>
    </body>
</html>
