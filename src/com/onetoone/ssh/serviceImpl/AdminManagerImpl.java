package com.onetoone.ssh.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.onetoone.ssh.dao.AdminDao;
import com.onetoone.ssh.entity.Admin;
import com.onetoone.ssh.entity.User;
import com.onetoone.ssh.form.AdminForm;
import com.onetoone.ssh.form.UserForm;
import com.onetoone.ssh.service.AdminManager;
import com.onetoone.ssh.util.MD5Util;

public class AdminManagerImpl implements AdminManager{
	private AdminDao adminDao;

	public int checkPwd(AdminForm admin) {
		int res=0;
		List<Admin> adminlist;
		Admin user = new Admin();
		System.out.println("进来11111admin");
		adminlist = adminDao.getAdminByName(admin.getUsername());
		System.out.println("jianchazhihou--admin ");
		if (adminlist == null){
			System.out.println("整个list == null");
			adminlist = new ArrayList<Admin>();
		} else {
			user = adminlist.get(0);
			try {
				if(user.getPassword().equals(MD5Util.md5Encode(admin.getPassword()))){
					System.out.println("密码是"+admin.getPassword());
					res = 1;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return res;
	}
	
	public AdminDao getAdminDao() {
		return adminDao;
	}

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	@Override
	public void saveUser(Admin user) {
		// TODO Auto-generated method stub
		
	}
	public Admin getMySelf(String username) {
		Admin user = null;
		user = adminDao.getAllAdmin().get(0);

		System.out.println("adaa"+user.getUsername());
		if (user == null){
			user = new Admin();
		}
		return user;
	}

	@Override
	public List<Admin> getUserById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
}
