package bean;

public class User {
	private int id;
	private String name;
	private String password;
	private String sex;
	private int age;
	
	public User(){
		
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public void setSex(String sex){
		this.sex = sex;
	}

	public void setAge(int age){
		this.age = age;
	}
	
	public int getId(){
		return this.id;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getPassword(){
		return this.password;
	}
	
	public String getSex(){
		return this.sex;
	}

	public int getAge(){
		return this.age;
	} 
}
