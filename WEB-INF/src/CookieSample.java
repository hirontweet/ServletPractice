import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CookieSample extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        Cookie clientCookie[] = request.getCookies();

        int visitCount = 1;

        out.println("<html>");
        out.println("<head>");
        out.print("<title>");
        out.print("Cookie Sample");
        out.println("</title>");
        out.println("</head>");
        out.println("<body>");
        out.print("<h1>");
        out.print("Cookie!");
        out.println("</h1>");
        out.println("<p>クッキーを保存しました</p>");
        out.println("<p>ページ更新から5秒後にCounterクッキーは消えます</p>");

        /*
        Cookieに値をセットする方法も存在する

        クッキーの値を取得する関数
        Cookie.getValue();
        クッキーに値を書き込む関数
        Cookie.setValue();

        最後にかならずresponseにaddCookieをして返す

         */
        if(clientCookie != null){
            for(int i = 0; i < clientCookie.length; i++){
                if(clientCookie[i].getName().equals("visited")){
                    visitCount = Integer.parseInt(clientCookie[i].getValue());
                    out.println("<p>Cookie Found! Visited Times: " + visitCount + "</p>");
                    visitCount++;
                    Cookie cookie = new Cookie("visited", String.valueOf(visitCount));
                    response.addCookie(cookie);
                }

                if(clientCookie[i].getName().equals("counter")){
                    Cookie cookie_counter = clientCookie[i];
                    int counter = Integer.parseInt(cookie_counter.getValue());

                    out.println("<p>Cookie Found! Counter is " + counter + "</p>");

                    counter++;
                    cookie_counter.setValue(String.valueOf(counter));

                    /*
                        有効期限を5秒にする

                        引数は秒単位
                        -1にするとデフォルト同様にブラウザを閉じるまで
                        0にすると破棄
                    */
                    cookie_counter.setMaxAge(5);

                    response.addCookie(cookie_counter);
                }else{
                    Cookie altCookie = new Cookie("counter", "1");

                    /*
                        有効期限を5秒にする

                        引数は秒単位
                        -1にするとデフォルト同様にブラウザを閉じるまで
                        0にすると破棄
                    */
                    altCookie.setMaxAge(5);

                    response.addCookie(altCookie);
                }
                
            }
        }else{
            Cookie cookie = new Cookie("visited", "1");
            response.addCookie(cookie);
            out.println("<p>First Visit</p>");

            Cookie altCookie = new Cookie("counter", "1");

            /*
                有効期限を5秒にする

                引数は秒単位
                -1にするとデフォルト同様にブラウザを閉じるまで
                0にすると破棄
             */
            altCookie.setMaxAge(5);

            response.addCookie(altCookie);
            out.println("<p>Cookie Saved(coutner)</p>");
            
        }

        out.println("</body>");
        out.println("</html>");
    }
}