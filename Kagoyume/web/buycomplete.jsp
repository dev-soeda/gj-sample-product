<%@page import="kagoyume.SearchDataBeans"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.fasterxml.jackson.databind.JsonNode"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="kagoyume.KagoyumeHelper"
        import="kagoyume.UserDataDTO"
        import="com.fasterxml.jackson.core.*"
        import="com.fasterxml.jackson.databind.*"%>
<%
KagoyumeHelper kh = KagoyumeHelper.getInstance();
HttpSession hs = request.getSession();
Integer userID = 0;
if(!(hs.getAttribute("userID") == null || hs.getAttribute("userID").equals(""))){userID = (Integer)hs.getAttribute("userID");}
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>買い物かご</title>
    </head>
    <body>
        <%=kh.loginLink(userID)%>
        <br>
        <br>
        購入が完了しました。<br>
        購入総額は<%=request.getAttribute("Total")%>円です。
        <br>
        <br>
        <%=kh.home()%>
    </body>
</html>
