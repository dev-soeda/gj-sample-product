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
int price = 0;
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
            </tr>
            
            <tr>
                <% for(SearchDataBeans item: cart){%>
	        <td><img src="<%= item.getImage()%>"></td>
                <td width="300"><%= item.getName()%></td>
                <td><%= item.getPrice()%>円</td>
                </tr><% price += Integer.parseInt(item.getPrice());}%>            
        </table><%}%>
        <br>
        <h2>合計金額：<%=price%>円</h2><br>
        <form action="BuyComplete" method="post">
            配送方法<br>
            手渡し<input type="radio" name="shipping" value="1" checked><br>
            郵送<input type="radio" name="shipping" value="2"><br>
            
            <input type="submit" name="cart" value="購入する">
            <input type="hidden" name="price" value="<%=price%>"><br>
        </form>
        <%=kh.home()%>
    </body>
</html>
