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

ArrayList<SearchDataBeans> cart = (ArrayList<SearchDataBeans>)session.getAttribute("Cart");
long price = 0;
int num = 0;
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
        買い物かご<br>
        
        <% if(cart !=null){%>
        <table border=1>
            <tr>
                <th>画像</th>
                <th>商品</th>
                <th>値段</th>
                <th>削除</th>
            </tr>
            
            <tr>
                <% for(SearchDataBeans item: cart){%>
	        <td><img src="<%= item.getImage()%>"></td>
                <td width="300"><a href="Item?code=<%= item.getCode()%>" target=”_blank”><%= item.getName()%></td>
                <td><%= item.getPrice()%>円</td>
                <td><a href="Cart?del=<%=num%>">削除する</a></td>
                </tr><% price += Integer.parseInt(item.getPrice()); num++;}%>            
        </table><%}%>
        <br>
        <h2>合計金額：<%=price%>円</h2><br>
        <form action="BuyConfirm" method="post">
            <input type="submit" name="cart" value="購入する">
        </form>
        <%=kh.home()%>
    </body>
</html>
