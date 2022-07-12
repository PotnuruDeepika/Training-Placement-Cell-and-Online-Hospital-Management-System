import java.io.*;
import java.sql.*;

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
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
PreparedStatement ps=con.prepareStatement("insert into registrations values(?,?,?,?,?,?,?)");
ps.setString(1,n);
ps.setString(2,p);
ps.setString(3,e);
ps.setString(4,jn);
ps.setString(5,d);
ps.setString(6,m);
ps.setString(7,y);
int i=ps.executeUpdate();
if(i>0)
  out.print("You are successfully registered...");
}catch (Exception e2) {System.out.println(e2);}

out.close();
}
/*
@Override
protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
	super.service(arg0, arg1);
}

private String user1,pwd1,user2,pwd2,user3,pwd3,user4,pwd4,user5,pwd5;
public void init(ServletConfig sc)
{
  user1=sc.getInitParameter("user1");
  pwd1=sc.getInitParameter("password1");

  user2=sc.getInitParameter("user2");
  pwd2=sc.getInitParameter("password2");

         user3=sc.getInitParameter("user3");
  pwd3=sc.getInitParameter("password3");

         user4=sc.getInitParameter("user4");
  pwd4=sc.getInitParameter("password4");   
}
public void service(ServletRequest req,ServletResponse res)throws ServletException,IOException
{
   res.setContentType("text/html");
   PrintWriter out=res.getWriter();
   user5=req.getParameter("uname");
   pwd5=req.getParameter("pass");
   if((user5.equals(user1)&&pwd5.equals(pwd1))||(user5.equals(user2)&&pwd5.equals(pwd2))||(user5.equals(user3)&&pwd5.equals(pwd3))||(user5.equals(user4)&&pwd5.equals(pwd4)))
     out.println("<p> welcome to "+user5.toUpperCase());
   else
      out.println("You are not authorized user");
}
*/
}