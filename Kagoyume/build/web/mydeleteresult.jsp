<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="kagoyume.KagoyumeHelper"
        import="kagoyume.UserDataDTO"%>
<%
KagoyumeHelper kh = KagoyumeHelper.getInstance();
HttpSession hs = request.getSession();
Integer userID = 0;
session.removeAttribute("userID");
if(!(hs.getAttribute("userID") == null || hs.getAttribute("userID").equals(""))){userID = (Integer)hs.getAttribute("userID");}

%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>会員情報削除</title>
</head>
<body>
<center>
    <h1>kagoyume</h1><br>
    <%=kh.loginLink(userID)%>

    削除しました。
</body>
    <%=kh.home()%>
</html>