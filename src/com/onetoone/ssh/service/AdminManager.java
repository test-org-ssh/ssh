package com.onetoone.ssh.service;

import java.util.List;

import com.onetoone.ssh.entity.Admin;
import com.onetoone.ssh.entity.PageBean;
import com.onetoone.ssh.entity.User;
import com.onetoone.ssh.form.AdminForm;
import com.onetoone.ssh.form.UserForm;

public interface AdminManager {
	/**
	 * ע���û������û���Ϣ
	 * @param user
	 */
	public void saveUser(Admin user);
	
	public int checkPwd(AdminForm userform);
	
	public Admin getMySelf(String username);
	
	public List<Admin> getUserById(Integer id);
}
