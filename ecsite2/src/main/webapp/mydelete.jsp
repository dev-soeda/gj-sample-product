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
        <title>JUMS更新結果画面</title>
    </head>
    <body>
                        <%=kh.loginLink(userID)%>
        <h1>登録結果</h1><br>
        名前:<%= udd.getName()%><br>
        パスワード:<%= udd.getPassword()%><br>
        メールアドレス:<%= udd.getMail()%><br>
        住所:<%= udd.getAddress()%><br>
        以上の内容を削除しますか？<br>
            <form action="MyDeleteResult" method="POST">
                        <input type="hidden" name="id" value="<%=udd.getUserID()%>">
                        <input type="submit" name="btnSubmit" value="削除">
            </form>
    </body>
    <%=kh.home()%>
</html>
