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
@WebServlet(urlPatterns = "/Associationstabellen")
public class Associationstabellen extends HttpServlet {
    String middle;
    String middle2;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //PORT and DbName should be changed
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8889/GritAcademy", "ReadUser", "ReadUser");
            Statement stmt = con.createStatement(); //System.out.println("hello");st.id,st.Fname,ks.id,aso.id,aso.YHP From Students st  join Associationstabellen aso on st.id = Aso.studentID JOIN Kurser ks on ks.id = Aso.kursID  where id in (Select
            //TABLENAME should be changed http://localhost:9090/


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
                    "                border-radius: 50px; '><a href=\"http://localhost:9090/kurser\">\n" +
                    "                    <div>\n" +
                    "                        kurser\n" +
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
                    "            </tr>\n" +
                    "        </table>";
            out.print(hub);
            String top = "<html>" +
                    "<head><title>Hello Servlet</title></head>" +
                    "<body>" +
                    "<h2>Hello from Smallville! this is the Associationstabellen which shows our student records</h2>";
            out.println(top);

            ResultSet rs = stmt.executeQuery("Select Aso.id,st.Fname,ks.namn From Students st join Associationstabellen  Aso on st.id = Aso.studentID join kurser ks on ks.id = Aso.KursID ");
            while (rs.next()) {
                //print to console column 1 and 2
                middle = "<table>" +
                        "<th style='border: 1px solid black; background-color: #96D4D4;'>" + "id: "+rs.getInt(1) +
                        ", Student: " + rs.getString(2) + ", Kurs:" + rs.getString(3) + "<br>" + "</th></table>";
                out.println(middle);
                System.out.println("GET REQUEST");
            } /*ResultSet rs2 = stmt.executeQuery("Select * From kurser join Associationstabellen on kurser.id = Associationstabellen.KursID ");
            while (rs2.next()){
                middle2 =  "Kurs:" + rs2.getString("namn") + "<br>" + ;
               out.print( middle2);
            }*/
            String bottom = "</body>" +
                    "</html>";
            out.println(bottom);
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

