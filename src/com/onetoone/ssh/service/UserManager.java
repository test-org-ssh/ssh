package com.onetoone.ssh.service;

import java.util.List;

import com.onetoone.ssh.entity.PageBean;
import com.onetoone.ssh.entity.PostTie;
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
	
	public int checkPwd(UserForm userform);
	
	public User getMySelf(String username);
	/**
	 * ��ȡ�����û�
	 * @return
	 */
	public List<User> getAllUser();
	
	/**
	 * ���ݷ�ҳ��ȡ�û�
	 * @param currPage
	 * @param pageSize
	 * @return
	 */
	public PageBean<User> getUserByPage(Integer currPage,Integer pageSize);
}
