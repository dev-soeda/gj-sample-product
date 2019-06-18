/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kagoyume;

import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author fukatsu-s
 */
public class KagoyumeHelper {
    
    //トップへのリンクを定数として設定
    private final String homeURL = "top.jsp";
    private final String loginURL = "Login";
    private final String logoutURL = "Logout";
    private final String userURL = "Mydata";
    private final String cartURL = "Cart";
    private String name = "";
    private String userID = "";
    
    public static KagoyumeHelper getInstance(){
        return new KagoyumeHelper();
    }
    
    //トップへのリンクを返却
    public String home(){
        return "<a href=\""+homeURL+"\">トップへ戻る</a>";
    }
    
    
    /**
     * 入力されたデータのうち未入力項目がある場合、チェックリストにしたがいどの項目が
     * 未入力なのかのhtml文を返却する
     * @param chkList　UserDataBeansで生成されるリスト。未入力要素の名前が格納されている
     * @return 未入力の項目に対応する文字列
     */
    public String chkinput(ArrayList<String> chkList){
        String output = "";
        for(String val : chkList){
                if(val.equals("name")){
                    output += "名前";
                }
                if(val.equals("password")){
                    output +="パスワード";
                }
                if(val.equals("mail")){
                    output +="メールアドレス";
                }
                if(val.equals("address")){
                    output +="住所";
                }
                output +="が未記入です<br>";
            }
        return output;
    }
    
    
    //ログインをチェックするメソッド。loginから送られてきたpost情報をDAOと照らし合わせてtrueだった場合trueを返す感じにする。
    public boolean loginChk(int userID){        
        if(userID != 0){
            return true;
        } else {
            return false;
        }                
    }
    
    
    //このメソッドを実行すると、ログインされているかどうかでログインページのリンク表示を変えてくれる。
    public String loginLink(int userID){     
        if(loginChk(userID)){
            
            try{
                UserDataDTO resultData = UserDataDAO .getInstance().searchByID(userID);
                name = resultData.getName();
                userID = resultData.getUserID();
                
            } catch(Exception e) {
                System.out.print(e);
            }
            
            return "ようこそ<a href=\"" + userURL +"?userID="+ userID +"\">" +name + "</a>さん！    <a href=\""+logoutURL+"\">ログアウト</a>　　<a href=\""+ cartURL +"\">買い物かご</a>";
        } else {                    
            return "<a href=\""+loginURL+"\">ログイン</a>";
            
        }   
    }
    
}
