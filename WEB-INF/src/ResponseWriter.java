import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ResponseWriter extends HttpServlet {
  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException{

    response.setContentType("text/html; charset=UTF-8");

    /* 
        response.getWriter()は
        文字出力用の関数

        他に、
        HttpServletResponse.getOutputStream()は
        バイナリデータ用の関数
    */
    PrintWriter out = response.getWriter();

    out.println("<html>");
    out.println("<head>");
    out.println("<title>サンプル</title>");
    out.println("</head>");
    out.println("<body>");

    out.println("<p>Sample Page</p>");
    out.println("<p>サンプルページ</p>");

    out.println("</body>");
    out.println("</html>");

    out.close();
  }
}