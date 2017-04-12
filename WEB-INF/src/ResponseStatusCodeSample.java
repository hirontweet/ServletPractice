import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ResponseStatusCodeSample extends HttpServlet {
  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException{

    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();

    String tmp;

    String code = "";
    tmp = request.getParameter("code");
    if (tmp == null || tmp.length() == 0){
      code = "200";
    }else{
      code = tmp;
    }


    /*
        ステータスコードの種類は以下のJavaDocを参照
        URL: http://mergedoc.osdn.jp/tomcat-servletapi-5-ja/

        HttpServletResponseクラスのフィールドに定義されている
     */

    if (code.equals("200")){
      response.setStatus(HttpServletResponse.SC_OK);

      StringBuffer sb = new StringBuffer();

      sb.append("<html>");
      sb.append("<head>");
      sb.append("<title>サンプル</title>");
      sb.append("</head>");
      sb.append("<body>");

      sb.append("<p>200:SC_OK</p>");

      sb.append("</body>");
      sb.append("</html>");

      out.println(new String(sb));
      out.close();
    }else{
      if (code.equals("404")){
        response.sendError(HttpServletResponse.SC_NOT_FOUND, "見つかりません");
      }else if (code.equals("500")){
        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
      }
    }
  }
}