package com.onetoone.ssh.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.onetoone.ssh.dao.UserDao;
import com.onetoone.ssh.entity.User;
import com.onetoone.ssh.form.UserForm;
import com.onetoone.ssh.service.UserManager;
import com.onetoone.ssh.util.ApplicationContextUtil;
import com.onetoone.ssh.util.MD5Util;

public class UserManagerImpl implements UserManager{
	private UserDao userdao;
	
	public UserDao getUserdao() {
		return userdao;
	}
	public void setUserdao(UserDao userdao) {
		this.userdao = userdao;
	}
	
	@Override
	public int checkUsername(String username) {
		int res = userdao.getUserByName(username).size();
		return res;
	}
	@Override
	public void saveUser(User user) {
		userdao.insertUser(user);
	}
	@Override
	public User checkPwd(UserForm userform) {
		List<User> userlist;
		User user = new User();
		System.out.println("检查之前");
		System.out.println("form传的数据"+userform.getUsername());
		userlist = userdao.getUserByName(userform.getUsername());
		System.out.println("jianchazhihou ");
		if (userlist == null){
			userlist = new ArrayList<User>();
		} else {
			user = userlist.get(0);

			try {
				if(user.getPassword().equals(MD5Util.md5Encode(userform.getPassword()))){
				
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return user;
	}

	
}
