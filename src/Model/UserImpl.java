package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserImpl implements IUserImpl {
	private Connection conn = null;
	private PreparedStatement pst =null;
	private ResultSet rs = null;
	public UserImpl(Connection conn){
		this.conn = conn;
	}
	
	public boolean findLogin(User user) throws Exception{
		boolean flag = false;
		try{
			String sql = "select * from user where userid=? and password=?";
		    pst = this.conn.prepareStatement(sql);
			pst.setString(1, user.getUserid());
			pst.setString(2, user.getPassword());
		    rs = pst.executeQuery();
			if(rs.next()){///////////////////////////////////////////////////
				flag = true;
				String name = rs.getString(2);
				user.setName(name);
				}
			}catch (Exception e){
				e.printStackTrace();
			}finally{
				try{
					if(pst!=null){
						rs.close();
						pst.close();
					}
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		return flag;
	}
	public List<User> showAll() throws Exception{
		List<User> list = new ArrayList<>();
		try{
			String sql = "select * from user";
			pst = this.conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				User user = new User();
				user.setUserid(rs.getString(1));
				user.setName(rs.getString(2));
				user.setPassword(rs.getString(3));
				list.add(user);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(pst!=null){
					rs.close();
					pst.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return list;
	}
	public boolean insertUser(User user) throws Exception{
		boolean flag = true;
		try{
			String sql = "insert into user values(?,?,?)";
			pst = this.conn.prepareStatement(sql);
			pst.setString(1, user.getUserid());
			pst.setString(2,user.getName());
			pst.setString(3, user.getPassword());
			int i = pst.executeUpdate();
			if(i!=0){
				flag= true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(pst!=null){
					pst.close();
				}
			}catch(Exception e){
					e.printStackTrace();
				}
			}
		
		return flag;
	}
}
