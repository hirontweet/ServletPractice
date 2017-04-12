/**
    リクエストパラメータの取得(getParameter)
    URL: https://www.javadrive.jp/servlet/request/index2.html
 */

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class RequestParameterSample extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException{

        /*
            HttpServletRequestのインスタンスrequestで受け取るときのURLは以下のようになる
            http://localhost:8080/servletpractice/ReqParamSamp?name=%E6%97%A5%E6%9C%AC%E8%AA%9E&old=21&food=grape&button1=%E9%80%81%E4%BF%A1
            (http://localhost:8080/servletpractice/ReqParamSamp?name=日本語&old=21&food=grape&button1=送信)
        */

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");

        int old;
        String tmp = request.getParameter("old");
        if (tmp == null || tmp.length() == 0){
            old = -1;
        }else{
            try{
                old = Integer.parseInt(tmp);
            }catch (NumberFormatException e){
                old = -1;
            }
        }

        String food[] = request.getParameterValues("food");

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
        if (food != null){
            for (int i = 0 ; i < food.length ; i++){
                sb.append(food[i]);
                sb.append(" ");
            }

            sb.append(" です</p>");
        }else{
            sb.append("選択されていません</p>");
        }

        sb.append("</body>");
        sb.append("</html>");

        out.println(new String(sb));

        out.close();
    }
}