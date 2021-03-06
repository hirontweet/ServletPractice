import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class DatabaseConnectionTest extends HttpServlet {
  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException{

    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<html>");
    out.println("<head>");
    out.println("<title>データベーステスト</title>");
    out.println("</head>");
    out.println("<body>");

    out.println("<p>");

    Connection conn = null;
    String url = "jdbc:mysql://localhost/servletdb";
    String user = "svuser";
    String password = "password";

    try {
      Class.forName("com.mysql.jdbc.Driver").newInstance();
      out.println("ドライバのロードに成功しました<br>");

      conn = DriverManager.getConnection(url, user, password);
      out.println("データベース接続に成功しました<br>");
    }catch (ClassNotFoundException e){
      out.println("ClassNotFoundException:" + e.getMessage());
    }catch (SQLException e){
      out.println("SQLException:" + e.getMessage());
    }catch (Exception e){
      out.println("Exception:" + e.getMessage());
    }finally{
      try{
        if (conn != null){
          conn.close();
          out.println("データベース切断に成功しました");
        }else{
          out.println("コネクションがありません");
        }
      }catch (SQLException e){
        out.println("SQLException:" + e.getMessage());
      }
    }

    out.println("</p>");

    out.println("</body>");
    out.println("</html>");
  }
}