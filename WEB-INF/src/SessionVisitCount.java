import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SessionVisitCount extends HttpServlet {
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
      out.println("<p>初回訪問です</p>");
      session = request.getSession(true);
      session.setAttribute("visited", "1");
    }else{
      String visitedStr = (String)session.getAttribute("visited");
      int visited = Integer.parseInt(visitedStr);
      visited++;

      out.println("<p>訪問回数は");
      out.println(visited);
      out.println("回目です</p>");

      session.setAttribute("visited", Integer.toString(visited));
    }

    out.println("<a href=\"/servletpractice/session/sessionvisit\">再表示</a>");

    out.println("</body>");
    out.println("</html>");
  }
}