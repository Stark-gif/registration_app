<%@page import="org.eclipse.jdt.internal.compiler.ast.IfStatement"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Register Here</h2>
<form action="newreg" method="post">
	<pre>
	Name <input type="text" name="name" />
	email <input type="text" name="email" />
	city <input type="text" name="city" />
	mobile <input type="text" name="mobile" />
	<input type="submit"  value="save" />
	</pre>
	
	
	
	
	</form>
<%
if(request.getAttribute("msg")!=null){
out.println(request.getAttribute("msg"));
}
%>


</body>
</html>