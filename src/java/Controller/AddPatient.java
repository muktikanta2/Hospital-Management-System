
import Database.DatabaseConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
@@ -34,7 +35,7 @@ public class AddPatient extends HttpServlet {
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {

        PrintWriter pw = response.getWriter();
try {
Date todaysDate = new Date();
DateFormat df2 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
@@ -64,11 +65,19 @@ protected void doPost(HttpServletRequest request, HttpServletResponse response)

i = pst.executeUpdate();
if (i > 0) {
                RequestDispatcher rd = request.getRequestDispatcher("UserHome.jsp");
                rd.forward(request, response);
                pw.println("<script type=\"text/javascript\">");
                pw.println("alert('Login Successfully..!');");
                pw.println("window.location.href = \"UserHome.jsp\";");
                pw.println("</script>");
                //RequestDispatcher rd = request.getRequestDispatcher("UserHome.jsp");
                //rd.forward(request, response);
} else {
                RequestDispatcher rd = request.getRequestDispatcher("addpatient.jsp");
                rd.forward(request, response);
                pw.println("<script type=\"text/javascript\">");
                pw.println("alert('Incorrect Data..!');");
                pw.println("window.location.href = \"addpatient.jsp\";");
                pw.println("</script>");
                //RequestDispatcher rd = request.getRequestDispatcher("addpatient.jsp");
                //rd.forward(request, response);
}
} catch (SQLException ex) {
Logger.getLogger(AddPatient.class.getName()).log(Level.SEVERE, null, ex);
@@ -78,4 +87,4 @@ protected void doPost(HttpServletRequest request, HttpServletResponse response)

}

}
}
