<%@page import="kagoyume.KagoyumeHelper" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
HttpSession hs = request.getSession();
Integer userID = 0;
if(!(hs.getAttribute("userID") == null || hs.getAttribute("userID").equals(""))){userID = (Integer)hs.getAttribute("userID");}
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add</title>
    </head>
    <body>
        <%=KagoyumeHelper.getInstance().loginLink(userID)%><br>
        <br>
        カートに追加しました<br>
        <br>
        <%=KagoyumeHelper.getInstance().home()%>
        
    </body>
</html>
