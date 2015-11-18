package bo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.User;
import dao.UserDao;
import db.DBOP;

public class UserDaoImpl implements UserDao {
	Connection cn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	public User log(String name, String password) {
		User user = null;
		try{
			cn = new DBOP().getConnection();
			String sql = "select*from users where name=? and password=?";
			pst = cn.prepareStatement(sql);
			pst.setString(1,name);
			pst.setString(2, password);
			rs=pst.executeQuery();
			if(rs.next()){
				user =new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setSex(rs.getString("sex"));
				user.setAge(rs.getInt("age"));	
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				rs.close();
				pst.close();
				rs = null;
				pst = null;
				cn = null;
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return user;
	}

	public boolean register(User user) {
		boolean flag=false;
		try{
			cn = new DBOP().getConnection();
			String sql="insert into users(id,name,password,sex,age) values(?,?,?,?,?)";
			pst=cn.prepareStatement(sql);
			pst.setInt(1,user.getId());
			pst.setString(2,user.getName());
			pst.setString(3, user.getPassword());
			pst.setString(4, user.getSex());
			pst.setInt(5, user.getAge());
			if(pst.executeUpdate()>0)
			{
				flag = true;
			}
			}catch(Exception ex){
				ex.printStackTrace();
			}finally{
				try{
					pst.close();
					cn.close();
					rs = null;
					pst = null;
					cn = null;
				}catch(Exception ex){
					ex.printStackTrace();
				}
			}
			return flag;
	}

	public int getId() {
		int id = 0;
		try{
			cn = new DBOP().getConnection();
			String sql = "select max(id) from user";
			pst=cn.prepareStatement(sql);
			rs=pst.executeQuery();
			if(rs.next()){
				id = rs.getInt(1)+1;
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				rs.close();
				pst.close();
				cn.close();
				rs = null;
				pst = null;
				cn = null;
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return id;
	}

	public boolean search(String name) {
		boolean flag = false;
		try{
			cn = new DBOP().getConnection();
			String sql="select id from user where name=?";
			pst=cn.prepareStatement(sql);
			pst.setString(1, name);
			rs=pst.executeQuery();
			if(rs.next()){
				flag = false;
				}
			}catch(Exception ex){
				ex.printStackTrace();
			}finally{
				try{
					rs.close();
					pst.close();
					cn.close();
					rs = null;
					pst = null;
					cn = null;
				}catch(Exception ex){
					ex.printStackTrace();	
				}
			}
		return flag;
	}

	
	
}
