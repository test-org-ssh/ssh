package com.onetoone.ssh.service;

import java.util.List;

import com.onetoone.ssh.entity.PageBean;
import com.onetoone.ssh.entity.PostTie;
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
	
	public int checkPwd(UserForm userform);
	
	public User getMySelf(String username);
	/**
	 * 获取所有用户
	 * @return
	 */
	public List<User> getAllUser();
	
	/**
	 * 根据分页获取用户
	 * @param currPage
	 * @param pageSize
	 * @return
	 */
	public PageBean<User> getUserByPage(Integer currPage,Integer pageSize);
}
