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

SearchDataBeans sdb = (SearchDataBeans)request.getAttribute("Item");

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>商品詳細ページ</title>
    </head>
    <%=kh.loginLink(userID)%><br>
    <body>
        <a href="Add?code=<%= sdb.getCode()%>">カートに追加</a>
         <table border=1>
            <tr>
                <td><img src="<%= sdb.getImage()%>"></td>
                <td width="300"><a href="Item?code=<%= sdb.getCode()%>"><%= sdb.getName()%></a></td>
                <th>値段</th>
                <th>レビュー</th>
            </tr>
            <tr>
                <td>説明</td>
                <td><%= sdb.getDescrition()%></td>
                <td><%= sdb.getPrice()%>円</td>
                <td><%= sdb.getRate()%></td>
            </tr>
            <tr>

            </tr>
        </table> <br>
        <%=kh.home()%>
    </body>
</html>
