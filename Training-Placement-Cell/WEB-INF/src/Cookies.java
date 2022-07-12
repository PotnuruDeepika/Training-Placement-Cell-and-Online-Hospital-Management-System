import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Cookies extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("Text/Html");
PrintWriter pw=response.getWriter();
Cookie c1=new Cookie("Deepika","myself");
Cookie c2=new Cookie("Charishma","myfrd");
Cookie c3=new Cookie("Kiran","mybuddy");
Cookie c4=new Cookie("Shannu","mychair");
response.addCookie(c1);
response.addCookie(c2);
response.addCookie(c3);
response.addCookie(c4);
Cookie[] c=request.getCookies();
String a=request.getParameter("fname");
String b=request.getParameter("password");
int flag=0;
pw.println("<html><body>");
if(c!=null && c.length!=0)
{
for(int i=0;i<c.length;i++)
{
if(a.equals(c[i].getName()))
if(b.equals(c[i].getValue()))	
	flag=1;
}
if(flag==1)
pw.println("<h1>welcome to "+a+" using cookies.</h1>");
else
pw.println("<h1>authencation is not completed.</h1>");
}
else
pw.println("<h1>authencation is not completed</h1>");
pw.println("</body></html>");
pw.close();
}
}

