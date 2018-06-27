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
			info.add("�û�������Ϊ��");
		}
		if(password == null || "".equals(password)){
			info.add("���벻��Ϊ��");
		}
		if(info.size()==0){
			User user = new User();
			user.setUserid(userid);
			user.setPassword(password);
			try{
				if(UserImplFactory.getInstance().findLogin(user)){
					info.add("��¼�ɹ�����ӭ"+user.getName()+"����");
					f = true;
				}else{
					info.add("��¼ʧ�ܣ������µ�¼��");
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
