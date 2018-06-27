<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import = "java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录成功</title>
</head>
<body>
	<% 
		List<String> info = (List<String>)request.getAttribute("info");
		Iterator it = info.iterator();
		it.next();
		String id = (String)it.next();
	%>
	
	<h4>${info[0]}</h4>
	<%
		if(id.equals("1")){
			
	%>
	<h4><a href="showServlet">显示所有的员工的信息</a></h4>
	<%
		}
	%>
	<h5><a href="login.jsp">注销</a></h5>
</body>
</html>