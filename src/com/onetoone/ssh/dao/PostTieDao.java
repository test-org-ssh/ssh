package com.onetoone.ssh.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.onetoone.ssh.entity.PostTie;
import com.onetoone.ssh.util.ApplicationContextUtil;

/**
 * 帖子类
 * @author wanghaixue
 *
 */
public class PostTieDao {
	ClassPathXmlApplicationContext ac=(ClassPathXmlApplicationContext) ApplicationContextUtil.getApplicationContext();
	SessionFactory factory = (SessionFactory) ac.getBean("sessionFactory");
	Session session = null;
	Transaction tx = null;
	
	/**
	 * 获取所有的帖子
	 * @return
	 */
	public List<PostTie> getAllPostTie(){
		List<PostTie> list=null;
		session = factory.openSession();
		tx = session.beginTransaction();
		
		Query query = session.createQuery("from PostTie");
		list = query.list();
		if (list == null){
			list = new ArrayList<PostTie>();
		}
		
		//tx.commit();
        session.close();
        
		return list;
	}

}
