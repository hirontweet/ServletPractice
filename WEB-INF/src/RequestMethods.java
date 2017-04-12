import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class RequestMethods extends HttpServlet {
  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException{

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    StringBuffer sb = new StringBuffer();

    sb.append("<html>");
    sb.append("<head>");
    sb.append("<title>テスト</title>");
    sb.append("</head>");
    sb.append("<body>");

    sb.append("<p>");
    sb.append("getScheme:");
    sb.append(request.getScheme());
    sb.append("</p>");

    sb.append("<p>");
    sb.append("getProtocol:");
    sb.append(request.getProtocol());
    sb.append("</p>");

    sb.append("<p>");
    sb.append("getMethod:");
    sb.append(request.getMethod());
    sb.append("</p>");

    sb.append("</body>");
    sb.append("</html>");

    out.println(new String(sb));

    out.close();
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException{

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    StringBuffer sb = new StringBuffer();

    sb.append("<html>");
    sb.append("<head>");
    sb.append("<title>テスト</title>");
    sb.append("</head>");
    sb.append("<body>");

    sb.append("<p>");
    sb.append("getScheme:");
    sb.append(request.getScheme());
    sb.append("</p>");

    sb.append("<p>");
    sb.append("getProtocol:");
    sb.append(request.getProtocol());
    sb.append("</p>");

    sb.append("<p>");
    sb.append("getMethod:");
    sb.append(request.getMethod());
    sb.append("</p>");

    sb.append("</body>");
    sb.append("</html>");

    out.println(new String(sb));

    out.close();
  }
}