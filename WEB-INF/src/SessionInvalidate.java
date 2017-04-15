import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Enumeration;

public class SessionInvalidate extends HttpServlet {
  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException{

    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();

    HttpSession session = request.getSession(false);

    out.println("<html>");
    out.println("<head>");
    out.println("<title>セッションテスト</title>");
    out.println("</head>");
    out.println("<body>");

    if (session != null){
      out.println("<p>セッションは開始されています</p>");

      /*
        セッションを破棄しても、クライアント側のCookieは存在したまま。
        おそらく、サーバ側で管理しているセッションのIDが破棄されるため
        そのため、セッションが破棄された後に再度セッションを作成するとIDが変わってクライアントに保存されているのを確認した。
       */
      out.println("<p>セッションを破棄し確認します。</p>");
      session.invalidate();

      session = request.getSession(false);

      if (session == null){
        out.println("<p>セッションは破棄されました</p>");
      }else{
        out.println("<p>セッションが残っています</p>");
      }
    }else{
      out.println("<p>セッションがありません</p>");
    }

    out.println("</body>");
    out.println("</html>");
  }
}