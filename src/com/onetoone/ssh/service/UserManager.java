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
	
	/**
	 * ����id�����û�
	 * @param id
	 * @return
	 */
	public List<User> getUserById(Integer id);
	
	/**
	 * ����û�
	 * @return
	 */
	public int addUser(String username, String photo, String jianjie);
	
	/**
	 * �޸��û�
	 * @param username
	 * @param photo
	 * @param jianjie
	 * @return
	 */
	public int updateUserById(Integer id,String username, String photo, String jianjie);
	
	/**
	 * �޸��û�״̬
	 * @param id
	 * @param status
	 * @return
	 */
	public int updateUserStatus(Integer id, Integer status);
	
	
	public int deleteUser(Integer id);
}
