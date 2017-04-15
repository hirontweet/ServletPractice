import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class DatabaseDeleteTest extends HttpServlet {
  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException{

    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();

    String get_code = request.getParameter("code");

    out.println("<html>");
    out.println("<head>");
    out.println("<title>データベーステスト</title>");
    out.println("</head>");
    out.println("<body>");

    Connection conn = null;
    String url = "jdbc:mysql://localhost/servletdb";
    String user = "svuser";
    String password = "password";

    try {
      Class.forName("com.mysql.jdbc.Driver").newInstance();
      conn = DriverManager.getConnection(url, user, password);

      Statement stmt = conn.createStatement();

    //   String sql = "delete from stocktable where code = 4755";
      String sql = String.format("delete from stocktable where code = %s", get_code);
      int num = stmt.executeUpdate(sql);

      sql = "select * from stocktable";
      ResultSet rs = stmt.executeQuery(sql);

      while(rs.next()){
        int code = rs.getInt("code");
        String company = rs.getString("company");
        out.println("<p>");
        out.println("コード:" + code + ", 会社名:" + company);
        out.println("</p>");
      }

      rs.close();
      stmt.close();
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
        }
      }catch (SQLException e){
        out.println("SQLException:" + e.getMessage());
      }
    }

    out.println("</body>");
    out.println("</html>");
  }
}