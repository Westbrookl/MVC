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

public class logServlet extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException{
	    String success_path = "success.jsp";
	    String fail_path = "login.jsp";
	    req.setCharacterEncoding("utf-8");
	    boolean flag= false;
	    User user = new User();
	    String userid = req.getParameter("userid");
	    String psd = req.getParameter("password");
	    String name = req.getParameter("name");
	    user.setUserid(userid);
	    user.setName(name);
	    user.setPassword(psd);
	    List<String> info = new ArrayList<String>();
	    try{
	    	if(UserImplFactory.getInstance().insertUser(user)){
	    		info.add("◊¢≤·≥…π¶£¨ª∂”≠"+user.getName()+"π‚¡Ÿ");
	    		flag = true;
	    	}else{
	    		info.add("◊¢≤· ß∞‹£¨«Î÷ÿ–¬ ‰»Î£°");
	    	}
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	    info.add(user.getUserid());
	    req.setAttribute("info", info);
	    if(flag){
	    	req.getRequestDispatcher(success_path).forward(req, res);
	    }else{
	    	req.getRequestDispatcher(fail_path).forward(req,res);
	    }
		
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException{
		this.doGet(req,res);
	}
}
