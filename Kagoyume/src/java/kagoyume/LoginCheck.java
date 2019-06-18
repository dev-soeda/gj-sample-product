/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kagoyume;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author fukatsu-s
 */
public class LoginCheck extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            response.setContentType("text/html;charset=UTF-8");
            HttpSession session = request.getSession();
        
        try{
            request.setCharacterEncoding("UTF-8");//リクエストパラメータの文字コードをUTF-8に変更
            
            //login.jspから来てるのかの判定
            if(request.getParameter("login") != null){
                //未入力かの判定。
                if(request.getParameter("name").equals("") || request.getParameter("password").equals("")){
                    throw new Exception("入力情報が足りていません");
                }
                
                UserDataBeans udb = new UserDataBeans();
                udb.setName(request.getParameter("name"));
                udb.setPassword(request.getParameter("password"));
                
                //DTOオブジェクトにマッピング。DB専用のパラメータに変換
                UserDataDTO searchData = new UserDataDTO();
                udb.UD2DTOMapping(searchData);
                
                //入力値をデータベースでサーチし、DTOに入れる。
                UserDataDTO loginResult = UserDataDAO .getInstance().login(searchData);
            
                String name = request.getParameter("name");
                String password = request.getParameter("password");
                
                if(loginResult.getName().equals(name) && loginResult.getPassword().equals(password) && loginResult.getDeleteFlg() == 0){
                    session.setAttribute("userID",loginResult.getUserID());
                    String url = request.getParameter("login");
                    int index = request.getParameter("login").lastIndexOf("/");
                    url = url.substring(index);
                    request.getRequestDispatcher(url).forward(request, response);
                } else {
                    throw new Exception("ログイン情報が間違っています。");
                }                            
                
            } else {
    
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            
            }
            
        }catch(Exception e){
            //何らかの理由で失敗したらエラーページにエラー文を渡して表示。想定は不正なアクセスとDBエラー
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }        
    
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
