import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.Random;

public class DatabaseInsertTest extends HttpServlet {
  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException{

    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();

    /*
        サンプルコードに無い実装をする
        formで飛んできた値を追加する
     */

     String get_company = request.getParameter("company");
     if(get_company.equals("")){
         get_company = "Somecompany";
     }
     String get_code = request.getParameter("code");
     if(get_code.equals("")){
         Random rnd = new Random();
         get_code = String.valueOf(rnd.nextInt(1000) + 999);
     }

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

    //   String sql = "insert into stocktable (code, company) values (" + code + ", " + "'" + company + "')";
      String sql = String.format("insert into stocktable (code, company) values (%s, '%s')", get_code, get_company);
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