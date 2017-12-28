package com.onetoone.ssh.service;

import com.onetoone.ssh.entity.User;
import com.onetoone.ssh.form.UserForm;

public interface UserManager {
	/**
	 * 注册用户保存用户信息
	 * @param user
	 */
	public void saveUser(User user);
	/**
	 * 检查用户是否已经存在
	 * @param username
	 * @return
	 */
	public int checkUsername(String username);
	
	public User checkPwd(UserForm userform);
}
