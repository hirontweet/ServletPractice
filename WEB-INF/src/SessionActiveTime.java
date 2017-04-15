import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Date;

public class SessionActiveTime extends HttpServlet {
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
      out.println("<p>セッションを開始します</p>");
      session = request.getSession(true);
    }

    int intervalTime = session.getMaxInactiveInterval();

    out.println("<p>");
    out.println("デフォルトの有効期限は" + intervalTime + "秒です<br>");
    out.println("</p>");

    out.println("<a href=\"/servletpractice/session/activetime\">再表示</a>");

    out.println("</body>");
    out.println("</html>");
  }
}