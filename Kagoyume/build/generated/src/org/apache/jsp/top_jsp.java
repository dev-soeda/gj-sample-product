package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import kagoyume.KagoyumeHelper;
import kagoyume.UserDataDTO;

public final class top_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\n');
      out.write('\n');

KagoyumeHelper kh = KagoyumeHelper.getInstance();
HttpSession hs = request.getSession();
Integer userID = 0;
if(!(hs.getAttribute("userID") == null || hs.getAttribute("userID").equals(""))){userID = (Integer)hs.getAttribute("userID");}

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"ja\">\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("    <title>kagoyumeトップ</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<center>\n");
      out.write("    <h1>kagoyume</h1><br>\n");
      out.write("    <form action=\"Search\" method=\"GET\">\n");
      out.write("        <p>検索したい商品を入力してください<br>       \n");
      out.write("        <input type=\"text\" name=\"search\" size=40 >\n");
      out.write("        <input type=\"submit\" value=\"検索\">    \n");
      out.write("    </p>\n");
      out.write("    </form>\n");
      out.write("    ");
      out.print(kh.loginLink(userID));
      out.write("\n");
      out.write("\n");
      out.write("    \n");
      out.write("    <br>\n");
      out.write("    <br>    \n");
      out.write("        <h4>ショッピングサイトを使っている時、こんな経験ありませんか？</h4>\n");
      out.write("\n");
      out.write("            「あれいいな」<br>\n");
      out.write("            「これいいな」<br>\n");
      out.write("            「あっ、関連商品のこれもいい」<br>\n");
      out.write("            「20%オフセールだって！？買わなきゃ！」<br><br>\n");
      out.write("\n");
      out.write("            そしていざ『買い物かご』を開いたとき、その合計金額に愕然とします。<br>\n");
      out.write("            「こんなに買ってたのか……しょうがない。いくつか減らそう……」<br><br>\n");
      out.write("\n");
      out.write("            仕方がありません。無駄遣いは厳禁です。<br>\n");
      out.write("            でも、一度買うと決めたものを諦めるなんて、ストレスじゃあありませんか？<br>\n");
      out.write("            できればお金の事なんか考えずに好きなだけ買い物がしたい……。<br><br>\n");
      out.write("\n");
      out.write("            このサービスは、そんなフラストレーションを解消するために生まれた、<br><br>\n");
      out.write("\n");
      out.write("            『金銭取引が絶対に発生しない』<br>\n");
      out.write("            『いくらでも、どんなものでも購入できる(気分になれる)』<br>\n");
      out.write("            『ECサイト』<br><br>\n");
      out.write("\n");
      out.write("            です。<br>\n");
      out.write("        \n");
      out.write("        </\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");
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
