import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ResponseSetHeaderSample extends HttpServlet {
  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException{

    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();

    response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);

    /*
        HTTPヘッダーのリスト
        URL: http://www.cresc.co.jp/tech/java/Servlet_Tutorial/Att_03.htm
     */
     /*
        応答ヘッダーとしてLocationを指定して、ページに飛ばす
      */
    response.setHeader("Location", "http://www.cs.gunma-u.ac.jp");

    StringBuffer sb = new StringBuffer();

    sb.append("<html>");
    sb.append("<head>");
    sb.append("<title>サンプル</title>");
    sb.append("</head>");
    sb.append("<body>");

    sb.append("<p>移動しました</p>");

    sb.append("</body>");
    sb.append("</html>");

    out.println(new String(sb));
    out.close();
  }
}