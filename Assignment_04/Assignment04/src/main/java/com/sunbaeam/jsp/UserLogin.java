package com.sunbaeam.jsp;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.User;

public class UserLogin {
	
	private String email;
	private String passwd;
	int count;
	
	public UserLogin(String email, String passwd) {
		this.email = email;
		this.passwd = passwd;
	}

	public UserLogin() {
	
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void login()
	{
		
		try {
			UserDao user = new UserDaoImpl();
				User u=	user.findByEmail(email);
			if(u != null) {
				if(u.getPassword().equals(passwd) && u.getEmail().equals(email))
					count=1;
				else 
					count=0;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	

}
