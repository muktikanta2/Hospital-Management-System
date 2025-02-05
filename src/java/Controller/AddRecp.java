
import Database.DatabaseConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
@@ -34,7 +35,7 @@ public class AddRecp extends HttpServlet {
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {

        PrintWriter pw = response.getWriter();
try {
Date todaysDate = new Date();
DateFormat df2 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
@@ -53,11 +54,19 @@ protected void doPost(HttpServletRequest request, HttpServletResponse response)

i = pst.executeUpdate();
if (i > 0) {
                RequestDispatcher rd = request.getRequestDispatcher("AdminHome.jsp");
                rd.forward(request, response);
                pw.println("<script type=\"text/javascript\">");
                pw.println("alert('Add Successfully..!');");
                pw.println("window.location.href = \"AdminHome.jsp\";");
                pw.println("</script>");
                //RequestDispatcher rd = request.getRequestDispatcher("AdminHome.jsp");
                //rd.forward(request, response);
} else {
                RequestDispatcher rd = request.getRequestDispatcher("AddRecp.jsp");
                rd.forward(request, response);
                pw.println("<script type=\"text/javascript\">");
                pw.println("alert('Incorrect Data...!');");
                pw.println("window.location.href = \"AddRecp.jsp\";");
                pw.println("</script>");
                //RequestDispatcher rd = request.getRequestDispatcher("AddRecp.jsp");
                //rd.forward(request, response);
}
} catch (SQLException | ClassNotFoundException ex) {
Logger.getLogger(AddPatient.class.getName()).log(Level.SEVERE, null, ex);
