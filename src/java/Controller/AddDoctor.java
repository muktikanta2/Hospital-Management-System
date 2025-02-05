
import Database.DatabaseConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
@@ -34,10 +35,11 @@ public class AddDoctor extends HttpServlet {
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
try {
Date todaysDate = new Date();
DateFormat df2 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            

String sid = request.getParameter("id");
int id = Integer.parseInt(sid);
String fname = request.getParameter("fname");
@@ -48,7 +50,7 @@ protected void doPost(HttpServletRequest request, HttpServletResponse response)
String email = request.getParameter("email");
String age = request.getParameter("age");
String address = request.getParameter("address");
             String qualification = request.getParameter("qualification");
            String qualification = request.getParameter("qualification");

String DateAndTime = df2.format(todaysDate);

@@ -64,15 +66,23 @@ protected void doPost(HttpServletRequest request, HttpServletResponse response)
pst.setString(8, age);
pst.setString(9, address);
pst.setString(10, DateAndTime);
            pst.setString(11,qualification);
            pst.setString(11, qualification);

i = pst.executeUpdate();
if (i > 0) {
                RequestDispatcher rd = request.getRequestDispatcher("AdminHome.jsp");
                rd.forward(request, response);
                pw.println("<script type=\"text/javascript\">");
                pw.println("alert('Data Add Successfully..!');");
                pw.println("window.location.href = \"AdminHome.jsp\";");
                pw.println("</script>");
                //RequestDispatcher rd = request.getRequestDispatcher("AdminHome.jsp");
                //rd.forward(request, response);
} else {
                RequestDispatcher rd = request.getRequestDispatcher("addDoctor.jsp");
                rd.forward(request, response);
                pw.println("<script type=\"text/javascript\">");
                pw.println("alert('Failed !!!!,try Again Later!');");
                pw.println("window.location.href = \"addDoctor.jsp\";");
                pw.println("</script>");
                //RequestDispatcher rd = request.getRequestDispatcher("addDoctor.jsp");
                //rd.forward(request, response);
}
} catch (SQLException | ClassNotFoundException ex) {
Logger.getLogger(AddPatient.class.getName()).log(Level.SEVERE, null, ex);
