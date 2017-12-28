package com.onetoone.ssh.service;

import com.onetoone.ssh.entity.User;
import com.onetoone.ssh.form.UserForm;

public interface UserManager {
	/**
	 * ע���û������û���Ϣ
	 * @param user
	 */
	public void saveUser(User user);
	/**
	 * ����û��Ƿ��Ѿ�����
	 * @param username
	 * @return
	 */
	public int checkUsername(String username);
	
	public User checkPwd(UserForm userform);
}
