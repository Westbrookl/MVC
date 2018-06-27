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

public class showServlet extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
		String show_path="show.jsp";
		List<User> list = new ArrayList<>();
		try{
			list = UserImplFactory.getInstance().showAll();
		}catch(Exception e){
			e.printStackTrace();
		}
		req.setAttribute("list", list);
		req.getRequestDispatcher(show_path).forward(req, res);
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException{
		this.doGet(req, res);
	}
}
