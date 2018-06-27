<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<script language="JavaScript">
		function validate(f){
		
			psd = f.password.value;
			psd1 = f.confirmPassword.value;
			if(psd == psd1){
				return true;
			}else{
				f.password.focus();
				alert("两次输入的密码不一致");
				return false;
			}
		}


	</script>
<title>注册界面</title>
</head>
<body>
	<form action="logServlet" method="post" onSubmit=" return validate(this)">
	<table>
		<tr>
			<td>用户ID</td>
			<td><input type="text" name="userid"></td>
		</tr>
		<tr>
			<td>姓名</td>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<td>密码</td>
			<td><input type="password" name="password"></td>
		</tr>
		<tr>
			<td>确认密码</td>
			<td><input type="password" name="confirmPassword"></td>
		</tr>
		<tr>
			<td><input type="submit" value="注册"></td>
			<td><input type="reset" value="重置"></td>
		</tr>
	</table>
	</form>

</body>
</html>