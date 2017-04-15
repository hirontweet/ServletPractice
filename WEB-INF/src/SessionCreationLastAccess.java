import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Date;

public class SessionCreationLastAccess extends HttpServlet {
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

      long createTime = session.getCreationTime();
      Date createDate = new Date(createTime);

      out.println("<p>");
      out.println("セッション開始時間:" + createDate + "<br>");
      out.println("</p>");
    }else{
      out.println("<p>セッションは開始されています</p>");

      long createTime = session.getCreationTime();
      Date createDate = new Date(createTime);

      long accessTime = session.getLastAccessedTime();
      Date accessDate = new Date(accessTime);

      out.println("<p>");
      out.println("セッション開始時間:" + createDate + "<br>");
      out.println("最終アクセス時間  :" + accessDate);
      out.println("</p>");
    }

    out.println("<a href=\"/servletpractice/session/sessioncheck\">再表示</a>");

    out.println("</body>");
    out.println("</html>");
  }
}