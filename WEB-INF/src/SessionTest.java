import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SessionTest extends HttpServlet {
  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException{

    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();

    HttpSession session = request.getSession(false);

    out.println("<html>");
    out.println("<head>");
    out.println("<title>セッションテスト</title>");
    out.println("</head>");
    out.println("<body>");

    if (session == null){
      out.println("<p>セッションは存在しません。開始します</p>");
      session = request.getSession(true);
    }else{
      out.println("<p>セッション開始してます</p>");
    }

    out.println("<a href=\"/servletpractice/session/sessiontest\">再表示</a>");

    out.println("</body>");
    out.println("</html>");
  }
}