import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Enumeration;

public class SessionRegisterObject extends HttpServlet {
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
      out.println("<p>セッションオブジェクトを登録します</p>");
      session = request.getSession(true);

      session.setAttribute("age", "24");
      session.setAttribute("name", "山田");
    }

    /* 現在登録されているセッションオブジェクトを表示 */
    out.println("<p>");
    out.println("登録されているセッションオブジェクトを表示します<br>");
    Enumeration enum_session = session.getAttributeNames(); 
    while(enum_session.hasMoreElements()) {
      String key = (String)enum_session.nextElement();
      String val = (String)session.getAttribute(key);

      out.println(key + " = " + val + "<br>");
    }
    out.println("</p>");

    out.println("<a href=\"/servletpractice/session/deleteobject\">ageオブジェクトの削除</a>");

    out.println("</body>");
    out.println("</html>");
  }
}