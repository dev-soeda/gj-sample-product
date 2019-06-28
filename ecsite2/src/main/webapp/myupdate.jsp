<%@page import="kagoyume.KagoyumeHelper"
        import="kagoyume.UserDataDTO"%>
<%
KagoyumeHelper kh = KagoyumeHelper.getInstance();
HttpSession hs = request.getSession();
Integer userID = 0;
if(!(hs.getAttribute("userID") == null || hs.getAttribute("userID").equals(""))){userID = (Integer)hs.getAttribute("userID");}

UserDataDTO udd = (UserDataDTO)request.getAttribute("resultData");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>登録情報変更画面</title>
    </head>
    <body>
        
                <%=kh.loginLink(userID)%>
    <form action="MyUpdateResult" method="POST">
        UserID：<%= udd.getUserID()%><br><br>
        <input type="hidden" name="id" value="<%= udd.getUserID()%>">
        
        名前:
        <input type="text" name="name" value="<%= udd.getName()%>">

        パスワード<br>
        <input type="password" name="password" value="<%=udd.getPassword()%>"><br>
        メールアドレス<br><input type="email" name="mail" value="<%=udd.getMail()%>"><br>
        住所<br><input type="text" name="address" value="<%=udd.getAddress()%>"><br>
        <input type="submit" name="btnSubmit" value="確認画面へ">
    </form>
        <form action="MyData" method="POST">
        <input type="submit" name="no" value="詳細画面に戻る">
        <input type="hidden" name="id" value="<%= udd.getUserID()%>">
        </form>
        
        <br>
        <%=kh.home()%>
    </body>
</html>
