/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kagoyume;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author fukatsu-s
 */
public class BuyComplete extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        request.setCharacterEncoding("UTF-8");
        
        HttpSession session = request.getSession();
        ArrayList<SearchDataBeans> cart = (ArrayList<SearchDataBeans>)session.getAttribute("Cart");
        
        try{
            
            //送信された値段をトータルに足すことをする。

            if(session.getAttribute("userID") == null){
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
            

            String price = request.getParameter("price");
            int total = Integer.parseInt(price);
            String shipping = request.getParameter("shipping");
            int type = Integer.parseInt(shipping); 
            Integer userID = (Integer)session.getAttribute("userID");              
                    
            
            //ここは総合金額を足している箇所
            UserDataDTO searchResult = UserDataDAO .getInstance().searchByID(userID);
            searchResult.setTotal(total);
            UserDataDAO .getInstance().update(searchResult);
    
           
            
            //購入履歴のために商品DBにいれる文章書いてね
            
            UserDataDAO .getInstance().buy(cart,userID,type);                       
            cart.clear();
            
            request.setAttribute("Total", searchResult.getTotal());
            request.getRequestDispatcher("/buycomplete.jsp").forward(request, response);  
        
        }catch(Exception e){
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
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
