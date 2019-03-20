<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Login Information</h1>
	<form action="<c:url value='j_spring_security_check'/>" method="POST">
		<table>

			<tr>
				<td>Username:</td>
				<td><input type="text" name='j_username' /></td><!-- Maintain the j_username and j_password same -->
			</tr>

			<tr>
				<td>Password:</td>
				<td><input type="password" name='j_password' /></td>
			</tr>
			<tr>
				<td colspan="2">&nbsp;</td>
			</tr>

			<tr>
				<td colspan="2"><input name="submit" type="submit">&nbsp;
					<input name="reset" type="reset"></td>

			</tr>


		</table>

	</form>
</body>
</html>