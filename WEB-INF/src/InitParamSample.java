import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class InitParamSample extends HttpServlet{
  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException{

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    String initTitle = getInitParameter("Title");
    String initMessage = getInitParameter("Message");

    out.println("<html>");
    out.println("<head>");
    out.print("<title>");
    out.print(initTitle);
    out.println("</title>");
    out.println("</head>");
    out.println("<body>");
    out.print("<h1>");
    out.print(initMessage);
    out.println("</h1>");
    out.println("</body>");
    out.println("</html>");

    out.close();
  }
}