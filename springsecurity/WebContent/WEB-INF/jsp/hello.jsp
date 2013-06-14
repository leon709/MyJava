<%@ page contentType="text/html;charset=utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>    
  <title>my Spring MVC</title>
</head>
 <%
	String str = (String)request.getAttribute("helloWorld");
 %>

<body>
  <h2><%=str %></h2>
</body>
</html>
