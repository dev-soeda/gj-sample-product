<%@page import="kagoyume.KagoyumeHelper"
        import="kagoyume.UserDataDTO"%>
<%
KagoyumeHelper kh = KagoyumeHelper.getInstance();
HttpSession hs = request.getSession();
Integer userID = 0;
if(!(hs.getAttribute("userID") == null || hs.getAttribute("userID").equals(""))){userID = (Integer)hs.getAttribute("userID");}

UserDataDTO udd = (UserDataDTO)request.getAttribute("myData");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMSユーザー情報詳細画面</title>
    </head>
    <body>
        
        <%=kh.loginLink(userID)%>
        
        <h1>詳細情報</h1>
        名前:<%= udd.getName()%><br>
        メールアドレス:<%= udd.getMail()%><br>
        住所:<%= udd.getAddress()%><br>
        購入総額:<%= udd.getTotal()%><br>
        登録日時:<%= udd.getNewDate()%><br>
        <form action="MyUpdate" method="POST">
        <input type="hidden" name="id" value="<%= udd.getUserID()%>">
        <input type="submit" name="update" value="変更"style="width:100px">       
        </form>
        <form action="MyDelete" method="POST">
        <input type="submit" name="delete" value="削除"style="width:100px">
        <input type="hidden" name="id" value="<%= udd.getUserID()%>">
        </form>
        <form action="MyHistory" method="POST">
        <input type="submit" name="delete" value="履歴"style="width:100px">
        <input type="hidden" name="id" value="<%= udd.getUserID()%>">
        </form>
    </body>
    <%=kh.home()%>
</html>
