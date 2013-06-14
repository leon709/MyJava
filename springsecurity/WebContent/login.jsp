<%@ page contentType="text/html;charset=utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>    
  <title>my Spring MVC</title>
</head>

<body onload='document.loginForm.j_username.focus();'>
<center>
	<h2>User Login</h2>
	<hr>
	<form name="loginForm" action="j_spring_security_check" method="post">
	<table border="0">
		<tr>
			<td>UserName:</td>
			<td><input type="text" name="j_username"/></td>
		</tr>
		<tr>
			<td>PassWord:</td>
			<td><input type="password" name="j_password"/></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td><input type="submit" value="Login" />&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="reset" value="Reset" /></td>
		</tr>
	</table>
	</form>
</center>
</body>
</html>
