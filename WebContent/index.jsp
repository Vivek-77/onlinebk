<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<img src="sc.png">
<h2>onlinebanking.com</h2>
<hr>
<form name="frm" method="post" action="Check">

<table>
<tr>
<td>UserID
<td><input type="text" name="uid">
</tr>

<tr>
<td>Password :
<td><input type="password" name="psw">
<%
Calendar cal=Calendar.getInstance();
String dt=String.valueOf(cal.getTime());
%>
<input type="hidden" name="logdt" value="<%=dt%>">
</tr>

<tr>
<td><input type="submit" value="Submit">
<td>
</tr>

</table>
</form>
<br>
<a href="TakeChoice.html">Test Cookies</a>
<br><br>
<a href="NewUser.html">New User? Registertion Now...</a> | 
<a href="About">About us</a> | 
<a href="AccountsList">List of account holders</a>
</body>
</html>
