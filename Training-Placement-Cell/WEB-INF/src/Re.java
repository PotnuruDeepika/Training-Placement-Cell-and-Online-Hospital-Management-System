import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.*;
import javax.servlet.*;

public class Registration extends HttpServlet {
public void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {

response.setContentType("text/html");
PrintWriter out = response.getWriter();

String n=request.getParameter("name");
String p=request.getParameter("password");
String e=request.getParameter("mail");
String jn=request.getParameter("JN");
String d=request.getParameter("Department");
String m=request.getParameter("Telephone");
String y=request.getParameter("year");
try{
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","system","root");
Statement st=con.createStatement();
PreparedStatement ps=con.prepareStatement("insert into registrations values(?,?,?,?,?,?,?)");
int rs=st.executeUpdate("insert into register values('"+name+"','"+password+"','"+mail+"','"+JN+"','"+Dept+"','"+Year+"','"+Mobile+"')"); 
response.setContentType("text/html");
   PrintWriter pw=response.getWriter();   
out.println("<h1>login details saved</h1>");
pw.close();
}
}