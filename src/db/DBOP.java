package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBOP {
	String driver = null;
	String url = null;
	String name = null;
	String password = null;
	Connection cn = null;
	
	public Connection getConnection(){
		try{
			Properties p = new Properties();
			p.load(this.getClass().getClassLoader().getResourceAsStream("DB.property"));
			driver = p.getProperty("driver");
			url = p.getProperty("url");
			password = p.getProperty("password");
			Class.forName(driver);
			cn = DriverManager.getConnection(url,name,password);
		
			}catch(Exception ex){
				ex.printStackTrace();
			}finally{
		
			}
			return cn;
		}
}
