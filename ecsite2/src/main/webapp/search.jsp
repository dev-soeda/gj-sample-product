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

ArrayList<SearchDataBeans> itemList = (ArrayList<SearchDataBeans>)session.getAttribute("Search");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>検索結果</title>
    </head>
    <body>
        <%=kh.loginLink(userID)%>
        <br>
        検索結果<br>

        <% if(itemList !=null){%>
        <table border=1>
            <tr>
                <th>画像</th>
                <th>商品</th>
                <th>値段</th>
            </tr>

            <tr>
            <% for(int i=0 ; i < 10 ; i++){%>
	        <td><img src="<%= itemList.get(i).getImage()%>"></td>
                <td><a href="Item?code=<%= itemList.get(i).getCode()%>" target=”_blank”><%= itemList.get(i).getName()%></a></td>
                <td><%= itemList.get(i).getPrice()%>円</td>
            </tr><%}%>
        </table><%}%>
        <br>
        <%=kh.home()%>
    </body>
</html>
