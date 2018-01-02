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
	
	/**
	 * 根据id查找用户
	 * @param id
	 * @return
	 */
	public List<User> getUserById(Integer id);
	
	/**
	 * 添加用户
	 * @return
	 */
	public int addUser(String username, String photo, String jianjie);
	
	/**
	 * 修改用户
	 * @param username
	 * @param photo
	 * @param jianjie
	 * @return
	 */
	public int updateUserById(Integer id,String username, String photo, String jianjie);
	
	/**
	 * 修改用户状态
	 * @param id
	 * @param status
	 * @return
	 */
	public int updateUserStatus(Integer id, Integer status);
	
	
	public int deleteUser(Integer id);
}
