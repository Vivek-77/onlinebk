<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
Cookie cook[]=request.getCookies();
if(cook!=null)
{
	for(int i=0;i<cook.length;i++)
	{
		out.println("Name : "+cook[i].getName());
		out.println("Name : "+cook[i].getValue()+"<br>");
	}
}

%>
</body>
</html>