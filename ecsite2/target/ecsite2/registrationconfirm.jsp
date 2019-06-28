<%@page import="javax.servlet.http.HttpSession"
        import="kagoyume.UserDataBeans"
        import="java.util.ArrayList"
        import="kagoyume.KagoyumeHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% 
    KagoyumeHelper kh = KagoyumeHelper.getInstance();
    HttpSession hs = request.getSession();
    UserDataBeans udb = (UserDataBeans)hs.getAttribute("udb");
    ArrayList<String> chkList = udb.chkproperties();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>新規会員登録確認</title>
    </head>
    <body>
    <% if(chkList.size()==0){ %>        
        名前:<%=udb.getName() %><br>
        パスワード:<%=udb.getPassword() %><br>
        メールアドレス：<%=udb.getMail() %><br>
        住所：<%=udb.getAddress() %><br>  
        上記の内容で登録します。よろしいですか？
        <form action="RegistrationComplete" method="POST">
            <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
            <input type="submit" name="yes" value="はい">
        </form>
        <%=kh.home()%>    
        
    <% }else{ %>
        <h1>入力が不完全です</h1>
        <%=kh.chkinput(chkList) %>
        <form action="Registration" method="POST">
            <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
            <input type="submit" name="no" value="登録画面に戻る">
            <input type="hidden" name="mode" value="REINPUT">
        </form>       
    <% } %>    
    <%=kh.home()%>
    </body>
</html>
