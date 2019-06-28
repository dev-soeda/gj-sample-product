/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kagoyume;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * ページで入出力されるユーザー情報を持ちまわるJavaBeans。DTOと違い画面表示系への結びつきが強い
 * @author fukatsu-s
 */
public class UserDataBeans implements Serializable {
    private String name;
    private String password;
    private String mail;
    private String address;
    
    UserDataBeans(){
        this.name = "";
        this.password = "";
        this.mail = "";
        this.address = "";
    }
 
    public String getName(){
        return name;
    }
    public void setName(String name){
        //空文字(未入力)の場合空文字をセット
        if(name.trim().length()==0){
            this.name = "";
        }else{
            this.name = name;
        }
    }
    
    
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        //空文字(未入力)の場合空文字をセット
        if(password.trim().length()==0){
            this.password = "";
        }else{
            this.password = password;
        }
    }
    
    
    public String getMail(){
        return mail;
    }
    public void setMail(String mail){
        //空文字(未入力)の場合空文字をセット
        if(mail.trim().length()==0){
            this.mail = "";
        }else{
            this.mail = mail;
        }
    }
    
    
    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        //空文字(未入力)の場合空文字をセット
        if(address.trim().length()==0){
            this.address = "";
        }else{
            this.address = address;
        }
    }

    public ArrayList<String> chkproperties(){
        ArrayList<String> chkList = new ArrayList<String>();
        if(this.name.equals("")){
            chkList.add("name");
        }
        if(this.password.equals("")){
            chkList.add("password");
        }
        if(this.mail.equals("")){
            chkList.add("mail");
        }        
        if(this.address.equals("")){
            chkList.add("address");
        }        
        return chkList;
    }   
    
    //DTOに格納する時のメソッド
    public void UD2DTOMapping(UserDataDTO udd){
        udd.setName(this.name);
        udd.setPassword(this.password);
        udd.setMail(this.mail);
        udd.setAddress(this.address);
    }

}
