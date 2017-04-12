import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class RequestParameterAltMultiLangSample extends HttpServlet {
  public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException{

    response.setContentType("text/html;charset=Shift_JIS");
    PrintWriter out = response.getWriter();

    request.setCharacterEncoding("Shift_JIS");

    String tmp;

    String name = "";
    tmp = request.getParameter("name");
    if (tmp == null || tmp.length() == 0){
      name = "未設定です";
    }else{
      name = tmp;
    }

    int old;
    tmp = request.getParameter("old");
    if (tmp == null || tmp.length() == 0){
      old = -1;
    }else{
      try{
        old = Integer.parseInt(tmp);
      }catch (NumberFormatException e){
        old = -1;
      }
    }

    String tmps[] = request.getParameterValues("food");
    String food = "";
    if (tmps != null){
      for (int i = 0 ; i < tmps.length ; i++){
        food += tmps[i];
        food += " ";
      }
    }else{
      food = "ありません";
    }

    StringBuffer sb = new StringBuffer();

    sb.append("<html>");
    sb.append("<head>");
    sb.append("<title>サンプル</title>");
    sb.append("</head>");
    sb.append("<body>");

    sb.append("<p>お名前は ");
    sb.append(name);
    sb.append(" です</p>");

    sb.append("<p>年齢は ");
    if (old == -1){
      sb.append("未設定です</p>");
    }else{
      sb.append(old);
      sb.append(" です</p>");
    }

    sb.append("<p>好きな果物は ");
    sb.append(food);
    sb.append("です</p>");

    sb.append("</body>");
    sb.append("</html>");

    out.println(new String(sb));

    out.close();
  }
}