import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Enumeration;

public class RequestMultiParameterSample extends HttpServlet {
  public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException{

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    request.setCharacterEncoding("UTF-8");

    StringBuffer sb = new StringBuffer();

    sb.append("<html>");
    sb.append("<head>");
    sb.append("<title>デバッグ</title>");
    sb.append("</head>");
    sb.append("<body>");

    sb.append("<p>");

    Enumeration names = request.getParameterNames();
    while (names.hasMoreElements()){
      String name = (String)names.nextElement();
      name = convertEncoding(name);
      String vals[] = request.getParameterValues(name);
      if (vals != null){
        for (int i = 0 ; i < vals.length ; i++){
          sb.append(name);
          sb.append(":");
          sb.append(vals[i]);
          sb.append("<br>");
        }
      }
    }

    sb.append("</p>");

    sb.append("</body>");
    sb.append("</html>");

    out.println(new String(sb));

    out.close();
  }

  private String convertEncoding(String str){
    try{
        byte[] str_bytes = str.getBytes("Shift-JIS");
        str = new String(str_bytes, "UTF-8");
    }catch(UnsupportedEncodingException e){
        return null;
    }

    return str;
  }
}