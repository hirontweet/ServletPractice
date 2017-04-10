import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CheckMethod extends HttpServlet {
  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException{

    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    out.println(createHTML("GET"));

    out.close();
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException{

    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    out.println(createHTML("POST"));

    out.close();
  }

  protected String createHTML(String methodType){
    StringBuffer sb = new StringBuffer();

    sb.append("<html>");
    sb.append("<head>");
    sb.append("<title>サンプル</title>");
    sb.append("</head>");
    sb.append("<body>");

    sb.append("<p>");
    sb.append(methodType);
    sb.append("メソッドで呼び出されました</p>");

    sb.append("<p><a href=\"/servletPractice/checkmethod\">リンク</a></p>");

    sb.append("<form action=\"/servletPractice/checkmethod\" method=\"get\">");
    sb.append("<input type=\"submit\" value=\"GETで送信\">");
    sb.append("</form>");

    sb.append("<form action=\"/servletPractice/checkmethod\" method=\"post\">");
    sb.append("<input type=\"submit\" value=\"POSTで送信\">");
    sb.append("</form>");

    sb.append("</body>");
    sb.append("</html>");

    return (new String(sb));
  }
}