import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Enumeration;

public class RequestHeaderSample extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException{

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        StringBuffer sb = new StringBuffer();

        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title>テスト</title>");
        sb.append("</head>");
        sb.append("<body>");

        sb.append("<p>");

        Enumeration headernames = request.getHeaderNames();
        while(headernames.hasMoreElements()){
            String name = (String)headernames.nextElement();
            
            Enumeration headervalues = request.getHeaders(name);
            while(headervalues.hasMoreElements()){
                String value = (String)headervalues.nextElement();
                sb.append(name + ":");
                sb.append(value);
                sb.append("<br>");
            }
        }

        sb.append("</p>");

        sb.append("</body>");
        sb.append("</html>");

        out.println(new String(sb));

        out.close();

    }

}