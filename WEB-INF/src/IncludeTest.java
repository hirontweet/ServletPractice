import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class IncludeTest extends HttpServlet {
  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException{

    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<p style=\"background:#ff0000\">");
    out.println("インクルードファイル内で処理されています");
    out.println("</p>");
  }
}