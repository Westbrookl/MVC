package Model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	private final String DRIVER = "com.mysql.jdbc.Driver";
	private final String URL = "jdbc:mysql://localhost:3306/user_login?characterEncoding=utf8&useSSL=false";//////
	private final String USER = "root";
	private final String PSD = "123456";
	private Connection conn = null;
	public DatabaseConnection() throws Exception{
		try{
			Class.forName(DRIVER);
			this.conn = DriverManager.getConnection(URL, USER, PSD);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public Connection getConnection(){
		return this.conn;
	}
	public void close(){
		if(this.conn!=null){
			try{
				this.conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
}
