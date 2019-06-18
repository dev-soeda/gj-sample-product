package kagoyume;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import java.util.ArrayList;

/**
 *
 * @author hayashi-s
 */
public class Search extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        
        try{            //アクセスルートチェック
        String search = request.getParameter("search");
        if(search.equals("")){
            throw new Exception("検索ワードを入力してください");
        }
        
        //APIのインスタンス作成
        YahooAPI api = new YahooAPI();
        
        //入力された検索ワードをセット
        api.setQuery(request.getParameter("search"));
        
        //webAPIに送るURL作成
        String url = api.queryURL();
        
        //URLを使い、JsonNodeのマップリストを作成
        JsonNode json = api.getJsonNode(api.getResult(url));
        
        int count = json.get("ResultSet").get("totalResultsReturned").intValue();
        if(count == 0){
            throw new Exception("検索結果がありませんでした");
        }
        //マップリストからデータを取り出してアレイリストに入れるやつ
        ArrayList<SearchDataBeans> itemlist = api.search(json);
        
        session.setAttribute("Search",itemlist);
        request.getRequestDispatcher("/search.jsp").forward(request, response);  
        
        }catch(Exception e){
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
