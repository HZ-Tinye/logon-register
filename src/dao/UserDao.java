package dao;

import bean.User;

public interface UserDao {
	public User log(String name,String password);
	public boolean register(User user);
	public int getId();
	public boolean search(String name);	
}
