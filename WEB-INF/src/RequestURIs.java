import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class RequestURIs extends HttpServlet {
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
    sb.append("getRequestURL:");
    // StringBuffer.append()にStringBufferを受け取るメソッドも用意されているため、小さな書き換えを行った。
    sb.append(request.getRequestURL());
    sb.append("</p>");

    sb.append("<p>");
    sb.append("getRequestURL(new String format):");
    // Original
    sb.append(new String(request.getRequestURL()));
    sb.append("</p>");

    sb.append("<p>");
    sb.append("getRequestURI:");
    sb.append(request.getRequestURI());
    sb.append("</p>");

    sb.append("<p>");
    sb.append("getServletPath:");
    sb.append(request.getServletPath());
    sb.append("</p>");

    sb.append("</body>");
    sb.append("</html>");

    out.println(new String(sb));

    out.close();
  }
}