package Model;

public class User {
	private String userid;
	private String name;
	private String password;
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return this.name;
	}
	public void setUserid(String id){
		this.userid = id;
	}
	public String getUserid(){
		return this.userid;
	}
	public void setPassword(String psd){
		this.password = psd;
	}
	public String getPassword(){
		return this.password;
	}
}
