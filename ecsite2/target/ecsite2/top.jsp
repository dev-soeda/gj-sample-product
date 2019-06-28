<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="kagoyume.KagoyumeHelper"
        import="kagoyume.UserDataDTO"%>
<%
KagoyumeHelper kh = KagoyumeHelper.getInstance();
HttpSession hs = request.getSession();
Integer userID = 0;
if(!(hs.getAttribute("userID") == null || hs.getAttribute("userID").equals(""))){userID = (Integer)hs.getAttribute("userID");}
%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>kagoyumeトップ</title>
</head>
<body>
<center>
    <h1>kagoyume</h1><br>
    <form action="Search" method="GET">
        <p>検索したい商品を入力してください<br>
        <input type="text" name="search" size=40 >
        <input type="submit" value="検索">
    </p>
    </form>
    <%=kh.loginLink(userID)%>


    <br>
    <br>
        <h4>ショッピングサイトを使っている時、こんな経験ありませんか？</h4>

            「あれいいな」<br>
            「これいいな」<br>
            「あっ、関連商品のこれもいい」<br>
            「20%オフセールだって！？買わなきゃ！」<br><br>

            そしていざ『買い物かご』を開いたとき、その合計金額に愕然とします。<br>
            「こんなに買ってたのか……しょうがない。いくつか減らそう……」<br><br>

            仕方がありません。無駄遣いは厳禁です。<br>
            でも、一度買うと決めたものを諦めるなんて、ストレスじゃあありませんか？<br>
            できればお金の事なんか考えずに好きなだけ買い物がしたい……。<br><br>

            このサービスは、そんなフラストレーションを解消するために生まれた、<br><br>

            『金銭取引が絶対に発生しない』<br>
            『いくらでも、どんなものでも購入できる(気分になれる)』<br>
            『ECサイト』<br><br>

            です。<br>

</center>

</body>
</html>