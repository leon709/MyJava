<%@ page contentType="text/html;charset=utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>    
  <title>my Spring MVC</title>
</head>

<body>
  Application Page!<br><br>
  <h3>User Can Visit</h3>
  <a href="<%=request.getContextPath() %>/j_spring_security_logout">Logout</a>
</body>
</html>
