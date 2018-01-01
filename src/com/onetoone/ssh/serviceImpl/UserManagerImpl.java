package com.onetoone.ssh.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.onetoone.ssh.dao.UserDao;
import com.onetoone.ssh.entity.PageBean;
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
	
	public User getMySelf(String username){
		User user = null;
		user = userdao.getUserByName(username).get(0);
		if (user == null){
			user = new User();
		}
		return user;
	}
	
	public int checkPwd(UserForm userform) {
		int res=0;
		List<User> userlist;
		User user = new User();
		userlist = userdao.getUserByName(userform.getUsername());
		System.out.println("jianchazhihou ");
		if (userlist == null){
			System.out.println("整个list == null");
			userlist = new ArrayList<User>();
		} else {
			user = userlist.get(0);
			System.out.println("user的密码"+user.getPassword());
			System.out.println("userform密码"+userform.getPassword());
			try {
				if(user.getPassword().equals(MD5Util.md5Encode(userform.getPassword()))){
					System.out.println("密码是"+userform.getPassword());
					res = 1;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return res;
	}
	@Override
	public List<User> getAllUser() {
		List<User> list = null;
		list = userdao.getAllUser();
		
		if (list == null){
			list = new ArrayList<User>();
		}
		
		return list;
	}
	
	@Override
	//分页查询user的方法
	public PageBean<User> getUserInfoByPage(Integer currPage,Integer pageSize) {
		PageBean<User> pageBean = new PageBean<User>();
		
		//封装PageBean里的数据
		pageBean.setCurrPage(currPage);
		pageBean.setPageSize(pageSize);
		int totalCount = userdao.findCount();
		pageBean.setTotalCount(totalCount);
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		
		//封装每页线束的数据
		int begin = (currPage - 1) * pageSize;
		List<User> list = userdao.findByPage(begin,pageSize);
		pageBean.setList(list);
		
		return pageBean;
	}

	
}
