import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Date;

public class SessionSetActiveTime extends HttpServlet {
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
      out.println("<p>セッションがありません</p>");
    }else{
      session.setMaxInactiveInterval(20);

      int intervalTime = session.getMaxInactiveInterval();

      out.println("<p>");
      out.println("現在のセッションの有効期限は" + intervalTime + "秒です<br>");
      out.println("</p>");
    }

    out.println("</body>");
    out.println("</html>");
  }
}