<%@ page contentType="text/html;charset=utf-8" %>
<html>
<head><title>Spring MVC</title></head>
<body>
	<form name="form1" action="/SpringWeb/myMultiMethodAction.do" method="post">
		Message:<input type="text" name="msg" value=""/><br>
		<input type="submit" name="method" value="insert"/>
		<input type="submit" name="method" value="update"/>
		<input type="submit" name="method" value="delete"/>
	</form>
</body>
</html>