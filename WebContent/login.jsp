<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>登录页面</title>
</head>
<body>
	<% request.setCharacterEncoding("utf-8"); %>
	<%
		List<String> info = (List<String>)request.getAttribute("info");
		Iterator<String> it = info.iterator();
		while(it.hasNext()){
	%>

		<h4><%= it.next() %></h2>
	<%
		}
	%>
	<form action="JSP/loginServlet" method="post">
		<table>
			<tr>
				<td>用户名Id</td>
				<td><input type="text" name="userid"></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td><input type="submit" value="登录"></td>
				<td><input type="reset" value="重置"> </td>
			</tr>
		</table>
	</form>
</body>
</html>