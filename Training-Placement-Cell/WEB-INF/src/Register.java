import java.io.*;
import java.sql.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.*;

public class Registration extends HttpServlet {  
public void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {

response.setContentType("text/html");
PrintWriter out = response.getWriter();

String n=request.getParameter("name");
String j=request.getParameter("JN");
String e=request.getParameter("email");
String n=request.getParameter("telephone");
String p=request.getParameter("password");
try{
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection(
"jdbc:oracle:thin:@localhost:1521/xe","sriram26","Nanda@2002");

PreparedStatement ps=con.prepareStatement(
"insert into cherry values(?,?,?,?)");

ps.setString(1,f);
ps.setString(2,l);
ps.setString(3,e);
ps.setString(4,n);

int i=ps.executeUpdate();
if(i>0)
out.print("You are successfully registered...");


}catch (Exception e2) {System.out.println(e2);}

out.close();
}