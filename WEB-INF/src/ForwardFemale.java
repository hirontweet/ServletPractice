import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ForwardFemale extends HttpServlet {
  public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException{

    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();
    request.setCharacterEncoding("UTF-8");

    out.println("<html>");
    out.println("<head>");
    out.println("<title>ディスパッチ</title>");
    out.println("</head>");
    out.println("<body>");

    String[] toshi = request.getParameterValues("age");
    String[] nensyu = request.getParameterValues("salery");

    out.println("<p>");
    out.println("女性用ホームページです");
    out.println("</p>");

    out.println("<p>");
    out.println("年齢：" + toshi[0] + ", 年収" + nensyu[0]);
    out.println("</p>");

    out.println("</body>");
    out.println("</html>");
  }
}