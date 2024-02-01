package Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
@WebServlet(urlPatterns = "/kurser")
public class kurser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //PORT and DbName should be changed
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8889/GritAcademy", "ReadUser", "ReadUser");
            Statement stmt = con.createStatement(); //System.out.println("hello");
            //TABLENAME should be changed
            ResultSet rs = stmt.executeQuery("select * from kurser");
            PrintWriter out = resp.getWriter();
            String hub = " <table style='box-sizing: border-box; text-decoration: none;\n" +
                    "               font-size: 188%;\n" +
                    "               font-weight:lighter;\n" +
                    "               color:gold;\n" +
                    "\n" +
                    "               display: inline-block;\n" +
                    "               border: 3px solid black;\n" +
                    "               border-radius: 12px; justify-content: center;\n" +
                    "            display: flex;\n" +
                    "            gap: 30px;'>\n" +
                    "            <tr>\n" +
                    "                <th style='border: 1px solid black; background-color: #96D4D4;  padding: 50px;\n" +
                    "                width: auto;\n" +
                    "                margin-left: 5%;\n" +
                    "                margin-right: auto;\n" +
                    "                border: 50px;\n" +
                    "                border-radius: 50px; '><a href=\"http://localhost:9090/home\">\n" +
                    "                    <div >\n" +
                    "                        Students\n" +
                    "                    </div>\n" +
                    "                </a></th>\n" +
                    "                <th style='border: 1px solid black; background-color: #96D4D4;  padding: 50px;\n" +
                    "                width: auto;\n" +
                    "                margin-left: 5%;\n" +
                    "                margin-right: auto;\n" +
                    "                border: 50px;\n" +
                    "                border-radius: 50px; '><a href=\"http://localhost:9090/\">\n" +
                    "                    <div>\n" +
                    "                        Homepage\n" +
                    "                    </div>\n" +
                    "                </a></th>\n" +
                    "                <th style='border: 1px solid black; background-color: #96D4D4;  padding: 50px;\n" +
                    "                width: auto;\n" +
                    "                margin-left: 5%;\n" +
                    "                margin-right: auto;\n" +
                    "                border: 50px;\n" +
                    "                border-radius: 50px; '><a href=\"http://localhost:9090/Associationstabellen\">\n" +
                    "                    <div>\n" +
                    "                        Associationstabellen\n" +
                    "                    </div>\n" +
                    "                </a></th>\n" +
                    "            </tr>\n" +
                    "        </table>";
            out.print(hub);
            String top = "<html>" +
                    "<head><title>Hello Servlet</title></head>" +
                    "<body>" +
                    "<h2>Hello this is Kurser where you can see all the courses availible to our students</h2>";
            out.println(top);
            while (rs.next()) {
                //print to console column 1 and 2
                String middle = "<table>" +
                        "<th style='border: 1px solid black; background-color: #96D4D4;'>" + rs.getInt(1) +
                        " " + rs.getString(2) + " " + rs.getString(3) + "<br>" + "</th></table>";
                out.println(middle);
                System.out.println("GET REQUEST");
            }
            String bottom = "</body>" +
                    "</html>";
            out.println(bottom);
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
