<%@page import="java.sql.*" %>
<html>
<head>
<title>
Authorization
</title>
</head>
<body bgcolor="aliceblue">
<%!String name,pwd;%>
<%
name=request.getParameter("fname");
pwd=request.getParameter("password");
try
{
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");

PreparedStatement ps=con.prepareStatement("select * from registrations where name=? and password=?");  
                  ps.setString(1, name);  
                  ps.setString(2, pwd);  
                  ResultSet rs=ps.executeQuery();  
if(rs.next())
{
out.println("Authorized person");
}
else
{
out.println("UnAuthorized person");
}
con.close();
}
catch(Exception e){out.println(""+e);}
%>
</body>
</html>