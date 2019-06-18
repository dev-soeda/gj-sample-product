/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kagoyume;

/**
 * ユーザー情報を格納するテーブルに対しての操作処理を包括する
 * DB接続系はDBManagerクラスに一任
 * 基本的にはやりたい1種類の動作に対して1メソッド
 * @author hayashi-s
 */
import base.DBManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
public class UserDataDAO {
    
        //インスタンスオブジェクトを返却させてコードの簡略化
    public static UserDataDAO getInstance(){
        return new UserDataDAO();
    }
    
    /**
     * 会員登録処理・Insert
     * 現在時刻は挿入直前に生成
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     */
    public void insert(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            st =  con.prepareStatement("INSERT INTO user_t(name,password,mail,address,newDate) VALUES(?,?,?,?,?)");
            st.setString(1, ud.getName());
            st.setString(2, ud.getPassword());//指定のタイムスタンプ値からSQL格納用のDATE型に変更
            st.setString(3, ud.getMail());
            st.setString(4, ud.getAddress());           
            st.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
            st.executeUpdate();
            System.out.println("insert completed");
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }
    }
        
    /**
     * ユーザーIDによる1件のデータの検索処理を行う。
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     * @return 検索結果
     */
    public UserDataDTO searchByID(int ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            
            String sql = "SELECT * FROM user_t WHERE userID = ?";
            
            st =  con.prepareStatement(sql);
            st.setInt(1, ud);
            
            ResultSet rs = st.executeQuery();
            rs.next();
            UserDataDTO resultUd = new UserDataDTO();
            resultUd.setUserID(rs.getInt(1));
            resultUd.setName(rs.getString(2));
            resultUd.setPassword(rs.getString(3));
            resultUd.setMail(rs.getString(4));
            resultUd.setAddress(rs.getString(5));
            resultUd.setTotal(rs.getInt(6));
            resultUd.setNewDate(rs.getTimestamp(7));
            resultUd.setDeleteFlg(rs.getInt(8));
            
            System.out.println("searchByID completed");

            return resultUd;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }

    }
    
    
    public UserDataDTO login(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs =null;
        try{
            con = DBManager.getConnection();
            
            String sql = "SELECT * FROM user_t WHERE name = ? and password = ?";
            
            st =  con.prepareStatement(sql);
            st.setString(1, ud.getName());
            st.setString(2,ud.getPassword());
            
            rs = st.executeQuery();
            UserDataDTO resultUd = new UserDataDTO();
            if(rs.next()){
                resultUd.setUserID(rs.getInt(1));
                resultUd.setName(rs.getString(2));
                resultUd.setPassword(rs.getString(3));
                resultUd.setMail(rs.getString(4));
                resultUd.setAddress(rs.getString(5));
                resultUd.setTotal(rs.getInt(6));
                resultUd.setNewDate(rs.getTimestamp(7));
                resultUd.setDeleteFlg(rs.getInt(8));
            }
            
            System.out.println("searchByID completed");

            return resultUd;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }

    }
    /**
     * 会員情報の更新処理
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     */
    public void update(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            st =  con.prepareStatement("UPDATE user_t SET name=?,password=?,mail=?,address=?,total=?,newDate=? WHERE userID=?");
            st.setString(1, ud.getName());
            st.setString(2, ud.getPassword());//指定のタイムスタンプ値からSQL格納用のDATE型に変更
            st.setString(3, ud.getMail());
            st.setString(4, ud.getAddress());   
            st.setInt(5,ud.getTotal());
            st.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
            st.setInt(7, ud.getUserID());
            st.executeUpdate();
            System.out.println("updata completed");
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }
    }
    
    public void buy(ArrayList<SearchDataBeans> ud,int userID,int type) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            st =  con.prepareStatement("INSERT INTO buy_t(userID,itemCode,type,buyDate) VALUES(?,?,?,?)");
            for(SearchDataBeans item: ud){
                         
            st.setInt(1, userID);
            st.setString(2, item.getCode());
            st.setInt(3, type);
            st.setTimestamp(4, new Timestamp(System.currentTimeMillis()));                     
            st.executeUpdate();
            }
            System.out.println("buy completed");
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }
    }
    
    
    
     /**
     * 会員情報の削除処理
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     */
    public void delete(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            st =  con.prepareStatement("DELETE FROM user_t WHERE userID = ?");
            st.setInt(1, ud.getUserID());
            st.executeUpdate();
            System.out.println("delete completed");
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        } 
    }
    
    public ArrayList<SearchDataBeans> history(int userID) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            
            String sql = "SELECT * FROM buy_t WHERE userID = ?";
            
            st =  con.prepareStatement(sql);
            st.setInt(1, userID);
            
            ResultSet rs = st.executeQuery();
            ArrayList<SearchDataBeans> result = new ArrayList<SearchDataBeans>();
            
            while(rs.next()){                
            SearchDataBeans resultUd = new SearchDataBeans();
            resultUd.setCode(rs.getString(3));
            result.add(resultUd);
            }
            System.out.println("searchByID completed");

            return result;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }
    }
    
}
