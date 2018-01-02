package com.onetoone.ssh.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.query.Query;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.onetoone.ssh.entity.PostTie;
import com.onetoone.ssh.entity.User;
import com.onetoone.ssh.util.ApplicationContextUtil;

/**
 * 用户操作 Dao 类
 * @author wanghaixue
 *
 */
public class UserDao{
	ClassPathXmlApplicationContext ac=(ClassPathXmlApplicationContext) ApplicationContextUtil.getApplicationContext();
	SessionFactory factory = (SessionFactory) ac.getBean("sessionFactory");
	
	/**
	 * 插入一个新用户
	 * @param 将要创建的新用户对象
	 * @return 添加是否 成功
	 */
	public int insertUser(User user){
		Session session = factory.openSession();
    	Transaction tx = session.beginTransaction();
        user.setUsername(user.getUsername());
        user.setPassword(user.getPassword());
        user.setFnum(user.getFnum());
        user.setJianjie(user.getJianjie());
        user.setPhoto(user.getPhoto());
        user.setStatus(user.getStatus());
        
        System.out.println(user.getUsername());
        session.save(user);
        tx.commit();
        session.close();
		return 0;
	}
	
	/**
	 * 根据用户名来查找用户记录
	 * @param username
	 * @return 查询得到的记录条数
	 */
	public List<User> getUserByName(String username){
		Session session = factory.openSession();
    	Transaction tx = session.beginTransaction();
    	
    	Query query = session.createQuery("from User where username=?");
    	query.setParameter(0, username);
    	List<User> userlist = query.list();
    	if (userlist == null){
    		System.out.println("进来了list为null");
    		userlist = new ArrayList<User>();
    	}
    	
    	tx.commit();
        session.close();
    	
    	return userlist;
	}
	
	/**
	 * 获取所有用户
	 * @return
	 */
	public List<User> getAllUser(){
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		List<User> list=null;
		
		session = factory.openSession();
		tx = session.beginTransaction();
		
		Query query = session.createQuery("from User");
		list = query.list();
		if (list == null){
			list = new ArrayList<User>();
		}
		
		tx.commit();
		session.close();
        
		return list;
	}

	
	/**
	 * 查询user的总记录数
	 * @return
	 */
	public int findCount() {
		// TODO Auto-generated method stub
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		List<User> list=null;
		
		session = factory.openSession();
		tx = session.beginTransaction();
		
		Query query = session.createQuery("from User");
		list = query.getResultList();
		if(list.size()>0){
			return list.size();
		}
		tx.commit();
		session.close();
		return 0;
	}
	
	
	/**
	 * 分页查询用户
	 * @param begin
	 * @param pageSize
	 * @return
	 */
	public List<User> findByPage(int begin, Integer pageSize) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
    	Transaction tx = session.beginTransaction();
    	
    	Criteria criteria = session.createCriteria(User.class);
    	criteria.setFirstResult(begin);
    	criteria.setMaxResults(pageSize);
    	
    	List<User> list = criteria.list();
    	System.out.println(list.size());
    	tx.commit();
    	session.close();
		return list;
	}

	/**
	 * 根据id查找用户
	 * @param id
	 * @return
	 */
	public User getUserById(Integer id) {
	    	Session session = factory.openSession();
	    	User user = new User();
		
		session = factory.openSession();
		user = (User)session.get(User.class, id);

		session.close();
		return user;
	}
	
	/**
	 * 根据ID删除用户
	 * @param id
	 * @return
	 */
	public int deleteUserById(Integer id) {
	    	Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		session = factory.openSession();
		tx = session.beginTransaction();
		User user = this.getUserById(id);
		session.delete(user);
		tx.commit();
		session.close();
    	    
    	    	return 0;
	}
	
	/**
	 * 根据id查找用户
	 * @param id
	 * @return
	 */
	public List<User> findById(Integer id) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
    	Transaction tx = session.beginTransaction();
    	List<User> list=null;
		
		session = factory.openSession();
		tx = session.beginTransaction();
    	
		Query query = session.createQuery("from User where id=?");
		query.setParameter(0, id);
		list = query.getResultList();
		
		tx.commit();
		session.close();
		return list;
	}

	/**
	 * 添加用户
	 * @param username
	 * @param photo
	 * @param jianjie
	 * @return
	 */
	public int addUser(String username, String photo, String jianjie) {
		// TODO Auto-generated method stub
		String password = "123";
		int fnum = 0;
		int status = 1;
		User user = new User();
		
		Session session = factory.openSession();
    	Transaction tx = session.beginTransaction();
    	
        user.setUsername(username);
        user.setPassword(password);
        user.setPhoto(photo);
        user.setJianjie(jianjie);
        user.setFnum(fnum);
        user.setStatus(status);
        
        session.save(user); 
        tx.commit();
        session.close();
		return 1;
	}

	/**
	 * 修改用户
	 * @param id
	 * @param username
	 * @param photo
	 * @param jianjie
	 * @return
	 */
	public int updateUser(Integer id, String username, String photo, String jianjie) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
    	Transaction tx = session.beginTransaction();
        
        User user = (User)session.get(User.class,id);
        user.setUsername(username);
        user.setPhoto(photo);
        user.setJianjie(jianjie);
        
        session.update(user);
        tx.commit();
        session.close();
		return 1;
	}

	/**
	 * 修改用户状态
	 * @param id
	 * @param status
	 * @return
	 */
	public int updateStatus(Integer id, Integer status) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
    	Transaction tx = session.beginTransaction();
        
        User user = (User)session.get(User.class,id);
        user.setStatus(status);
        
        session.update(user);
        tx.commit();
        session.close();
		return 1;
	}



	
}
