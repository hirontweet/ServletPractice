import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ResponseContentType1Sample extends HttpServlet {
  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException{

    /*
        文字エンコーディングをContentTypeに設定していないため、デフォルトでISO-8859-1(Latin-1)でResponseが返される。
    */
    response.setContentType("text/html");
    /*
        他のコンテンツタイプ:
        html, htm: text/html
        txt: text/plain
        gif: image/gif
        png: image/png
        exe: application/octet-stream
    */
    PrintWriter out = response.getWriter();

    StringBuffer sb = new StringBuffer();

    sb.append("<html>");
    sb.append("<head>");
    sb.append("<title>サンプル</title>");
    sb.append("</head>");
    sb.append("<body>");

    sb.append("<p>Sample Page</p>");
    sb.append("<p>サンプルページ</p>");

    sb.append("</body>");
    sb.append("</html>");

    out.println(new String(sb));

    out.close();
  }
}