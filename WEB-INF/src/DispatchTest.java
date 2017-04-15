import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DispatchTest extends HttpServlet {
  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException{

    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<html>");
    out.println("<head>");
    out.println("<title>ディスパッチ</title>");
    out.println("</head>");
    out.println("<body>");

    out.println("<p>この下の部分がインクルードで処理されています</p>");

    String disp = "/dispatch/include";
    RequestDispatcher dispatch = request.getRequestDispatcher(disp);

    dispatch.include(request, response);

    out.println("<p>この上の部分がインクルードで処理されています</p>");

    out.println("</body>");
    out.println("</html>");
  }
}