import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DispatchForward extends HttpServlet {
  public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException{

    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();
    request.setCharacterEncoding("UTF-8");

    String[] seibetsu = request.getParameterValues("sex");
    if (seibetsu[0].equals("男性")){
      String disp = "/dispatch/forwardmale";
      RequestDispatcher dispatch = request.getRequestDispatcher(disp);
      dispatch.forward(request, response);
    }else{
      String disp = "/dispatch/forwardfemale";
      RequestDispatcher dispatch = request.getRequestDispatcher(disp);
      dispatch.forward(request, response);
    }
  }
}