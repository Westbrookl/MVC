package Model;

import java.util.ArrayList;
import java.util.List;

public class UserImplProxy implements IUserImpl{
	private DatabaseConnection dbc = null;
	private UserImpl uil = null ;
	public UserImplProxy() throws Exception{
		try{
			this.dbc = new DatabaseConnection();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		this.uil = new UserImpl(this.dbc.getConnection());
	}
	public boolean findLogin(User user){
		boolean flag = false;
		try{
			flag = this.uil.findLogin(user);
//			System.out.println("1111"+flag);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.dbc.close();
		}
//		System.out.println(flag);
		return flag;
	}
	public boolean insertUser(User user){
		boolean flag = false;
		try{
			flag =this.uil.insertUser(user);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.dbc.close();
		}
		return flag;
	}
	public List<User> showAll(){
		List<User> list = new ArrayList<>();
		try{
			list = this.uil.showAll();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.dbc.close();
		}
		return list;
	}
}
