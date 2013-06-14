<%@ page contentType="text/html;charset=utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>    
  <title>my Spring MVC</title>
</head>
 <%
	String msg = (String)request.getAttribute("msg");
 %>

<body>
  <h2><%=msg %></h2>
</body>
</html>
