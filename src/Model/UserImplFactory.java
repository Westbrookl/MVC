package Model;

public class UserImplFactory {
	public static IUserImpl getInstance() throws Exception{
		return new UserImplProxy();
	}
}
