package base;
/**
 *
 * @author hayashi-s
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBManager {
    public static Connection getConnection(){
        Connection con = null;
        try{
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kagoyume_db?serverTimezone=JST","root","");
        	  Class.forName("org.postgresql.Driver");
        	  con = DriverManager.getConnection("jdbc:postgres://vpziupvssvzqsp:6e35c9eb8da9b28bf1aaefc077a3abab280c6d1080fad27ae4a74f09766b6f18@ec2-54-243-47-196.compute-1.amazonaws.com:5432/dd1e4gm97d2md4", "vpziupvssvzqsp", "6e35c9eb8da9b28bf1aaefc077a3abab280c6d1080fad27ae4a74f09766b6f18");
            System.out.println("DBConnected!!");
            return con;
        }catch(ClassNotFoundException e){
            throw new IllegalMonitorStateException();
        } catch (SQLException e) {
            throw new IllegalMonitorStateException();
        }
    }
}
