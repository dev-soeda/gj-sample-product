package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import kagoyume.SearchDataBeans;
import java.util.ArrayList;
import com.fasterxml.jackson.databind.JsonNode;
import kagoyume.KagoyumeHelper;
import kagoyume.UserDataDTO;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;

public final class buyconfirm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

KagoyumeHelper kh = KagoyumeHelper.getInstance();
HttpSession hs = request.getSession();
Integer userID = 0;
if(!(hs.getAttribute("userID") == null || hs.getAttribute("userID").equals(""))){userID = (Integer)hs.getAttribute("userID");}

ArrayList<SearchDataBeans> cart = (ArrayList<SearchDataBeans>)session.getAttribute("Cart");
long price = 0;

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>買い物かご</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      out.print(kh.loginLink(userID));
      out.write("\n");
      out.write("        <br>\n");
      out.write("        買い物かご<br>\n");
      out.write("        \n");
      out.write("        ");
 if(cart !=null){
      out.write("\n");
      out.write("        <table border=1>\n");
      out.write("            <tr>\n");
      out.write("                <th>画像</th>\n");
      out.write("                <th>商品</th>\n");
      out.write("                <th>値段</th>\n");
      out.write("            </tr>\n");
      out.write("            \n");
      out.write("            <tr>\n");
      out.write("                ");
 for(SearchDataBeans item: cart){
      out.write("\n");
      out.write("\t        <td><img src=\"");
      out.print( item.getImage());
      out.write("\"></td>\n");
      out.write("                <td width=\"300\">");
      out.print( item.getName());
      out.write("</td>\n");
      out.write("                <td>");
      out.print( item.getPrice());
      out.write("円</td>\n");
      out.write("                </tr>");
 price += Integer.parseInt(item.getPrice());}
      out.write("            \n");
      out.write("        </table>");
}
      out.write("\n");
      out.write("        <br>\n");
      out.write("        <h2>合計金額：");
      out.print(price);
      out.write("円</h2><br>\n");
      out.write("        <form action=\"BuyConfirm\" method=\"post\">\n");
      out.write("            <input type=\"radio\" name=\"shipping\" value=\"1\">\n");
      out.write("            <input type=\"submit\" name=\"cart\" value=\"購入する\">\n");
      out.write("        </form>\n");
      out.write("        ");
      out.print(kh.home());
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
