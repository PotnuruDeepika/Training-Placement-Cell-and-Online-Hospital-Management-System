import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.*;
import javax.servlet.*;

public class RegistrationTable extends HttpServlet {
public void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
String n=request.getParameter("name");
String p=request.getParameter("password");
String e=request.getParameter("mail");
String jn=request.getParameter("JN");
String d=request.getParameter("Department");
String m=request.getParameter("Telephone");
String y=request.getParameter("year");
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","system","root");
Statement st=con.createStatement();
PreparedStatement ps=con.prepareStatement("insert into registrations values(?,?,?,?,?,?,?)");
int rs=st.executeUpdate("insert into register values('"+n+"','"+p+"','"+e+"','"+jn+"','"+d+"','"+m+"','"+y+"')"); 
response.setContentType("text/html");
PrintWriter pw=response.getWriter();   
java.lang.System.out.println("Register details saved");
pw.close();
}
}