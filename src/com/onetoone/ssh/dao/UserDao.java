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
 * �û����� Dao ��
 * @author wanghaixue
 *
 */
public class UserDao{
	ClassPathXmlApplicationContext ac=(ClassPathXmlApplicationContext) ApplicationContextUtil.getApplicationContext();
	SessionFactory factory = (SessionFactory) ac.getBean("sessionFactory");
	
	/**
	 * ����һ�����û�
	 * @param ��Ҫ���������û�����
	 * @return ����Ƿ� �ɹ�
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
	 * �����û����������û���¼
	 * @param username
	 * @return ��ѯ�õ��ļ�¼����
	 */
	public List<User> getUserByName(String username){
		Session session = factory.openSession();
    	Transaction tx = session.beginTransaction();
    	
    	Query query = session.createQuery("from User where username=?");
    	query.setParameter(0, username);
    	List<User> userlist = query.list();
    	if (userlist == null){
    		System.out.println("������listΪnull");
    		userlist = new ArrayList<User>();
    	}
    	
    	tx.commit();
        session.close();
    	
    	return userlist;
	}
	
	/**
	 * ��ȡ�����û�
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
	 * ��ѯuser���ܼ�¼��
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
	 * ��ҳ��ѯ�û�
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
	 * ����id�����û�
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
	 * ����IDɾ���û�
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
	 * ����id�����û�
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
	 * ����û�
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
	 * �޸��û�
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
	 * �޸��û�״̬
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
