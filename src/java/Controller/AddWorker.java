
import Database.DatabaseConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
@@ -15,7 +16,6 @@
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
@@ -34,7 +34,7 @@ public class AddWorker extends HttpServlet {
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {

PrintWriter pw = response.getWriter();
try {
Date todaysDate = new Date();
DateFormat df2 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
@@ -53,11 +53,19 @@ protected void doPost(HttpServletRequest request, HttpServletResponse response)

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
                RequestDispatcher rd = request.getRequestDispatcher("AddWorker.jsp");
                rd.forward(request, response);
                pw.println("<script type=\"text/javascript\">");
                pw.println("alert('Incorrect Data..!');");
                pw.println("window.location.href = \"AddWorker.jsp\";");
                pw.println("</script>");
                //RequestDispatcher rd = request.getRequestDispatcher("AddWorker.jsp");
                //rd.forward(request, response);
}
} catch (SQLException | ClassNotFoundException ex) {
Logger.getLogger(AddPatient.class.getName()).log(Level.SEVERE, null, ex);
