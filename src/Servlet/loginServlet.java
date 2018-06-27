package Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.User;
import Model.UserImplFactory;

public class loginServlet extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		boolean f = false;
		String success_path = "success.jsp";
		String fail_path = "login.jsp";
		String userid = req.getParameter("userid");
		String password = req.getParameter("password");
		List<String> info = new ArrayList<String>();
		if(userid == null || "".equals(userid)){
			info.add("用户名不能为空");
		}
		if(password == null || "".equals(password)){
			info.add("密码不能为空");
		}
		if(info.size()==0){
			User user = new User();
			user.setUserid(userid);
			user.setPassword(password);
			try{
				if(UserImplFactory.getInstance().findLogin(user)){
					info.add("登录成功，欢迎"+user.getName()+"光临");
					f = true;
				}else{
					info.add("登录失败，请重新登录。");
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			info.add(user.getUserid());
		}
		req.setAttribute("info", info);
	if(f){
		req.getRequestDispatcher(success_path).forward(req, res);
	}else{
		req.getRequestDispatcher(fail_path).forward(req,res);
	}
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		this.doGet(req, res);
	}
	
}
