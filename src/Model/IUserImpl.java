package Model;

import java.util.List;

public interface IUserImpl{
	public boolean findLogin(User user) throws Exception;
	public boolean insertUser(User user) throws Exception;
	public List<User> showAll() throws Exception;
}
