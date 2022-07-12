<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.* " %>
<%!String name,jn,email,dept,sub,cpga,rad;%>
<%
String name=request.getParameter("Name");
String jn=request.getParameter("JN");
String email=request.getParameter("EMail");
String dept=request.getParameter("Department");
String sub=request.getParameter("Subject");
String cpga=request.getParameter("cpga");
String rad=request.getParameter("radio");
try{
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
PreparedStatement ps=con.prepareStatement("insert into academic  values(?,?,?,?,?,?,?)");
ps.setString(1,name);
ps.setString(2,jn);
ps.setString(3,email);
ps.setString(4,dept);
ps.setString(5,sub);
ps.setString(6,cpga);
ps.setString(7,rad);
int i=ps.executeUpdate();
 out.print("You are details successfully Submitted...");
}
finally {
System.out.println( "finally : i execute always.");}
%>