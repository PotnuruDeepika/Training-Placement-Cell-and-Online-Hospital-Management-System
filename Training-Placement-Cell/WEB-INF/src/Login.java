import java.io.*;
import java.sql.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.*;

public class Login extends HttpServlet {
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
   user5=req.getParameter("fname");
   pwd5=req.getParameter("password");
   if((user5.equals(user1)&&pwd5.equals(pwd1))||(user5.equals(user2)&&pwd5.equals(pwd2))||(user5.equals(user3)&&pwd5.equals(pwd3))||(user5.equals(user4)&&pwd5.equals(pwd4)))
     out.println("<p> welcome to "+user5.toUpperCase());
   else
      out.println("You are not authorized user");
}

}