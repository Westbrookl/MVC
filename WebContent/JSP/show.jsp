
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import = "java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>员工信息</title>
</head>
<body>
<% 
	request.setCharacterEncoding("utf-8");
	List list = (List)request.getAttribute("list");
	if(list!=null){
%>
	<table border="1" width="80%">
		<tr>
			<td>员工ID</td>
			<td>员工名称</td>
			<td>员工密码</td>
		</tr>
		<%
			Iterator it = list.iterator();
			while(it.hasNext()){
				pageContext.setAttribute("user", it.next());
		%>
		<tr>
		<td>${user.userid}</td>
		<td>${user.name}</td>
		<td>${user.password}</td>
		</tr>
		<%
			}
		%>
	</table>
	
<% 

	}else{
%>
<h3>目前还没有员工</h3>
<%
	}

%>
</body>
</html>