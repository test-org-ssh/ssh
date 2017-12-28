package com.onetoone.ssh.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.onetoone.ssh.entity.Comment;
import com.onetoone.ssh.entity.User;
import com.onetoone.ssh.util.ApplicationContextUtil;

/**
 * 
 * @类功能说明： 关于评论表的操作 
 * @类修改者：  
 * @修改日期：  
 * @修改说明：  
 * @公司名称：adam  
 * @作者：tannanlin  
 * @创建时间：2017年12月28日 上午11:26:31  
 * @版本：V1.0
 */
public class CommentDao {

	ClassPathXmlApplicationContext ac=(ClassPathXmlApplicationContext) ApplicationContextUtil.getApplicationContext();
	SessionFactory factory = (SessionFactory) ac.getBean("sessionFactory");
	
	/**
	 * 
	 *方法功能说明：通过帖子id获得其下所有的评论  
	 * 创建：2017年12月28日 by Judy   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @parms参数： @param id
	 * @parms参数： @return      
	 * @return List<Comment>     
	 * @throws
	 */
	public List<Comment> getAllCommentByTieId(int id){
	
		Session session = factory.openSession();
    	Transaction tx = session.beginTransaction();
    	System.out.println("开始通过外键查数据");
    	Query query = session.createQuery("FROM Comment c LEFT OUTER JOIN FETCH c.postTie where c.postTie.id=?");
    	query.setParameter(0, id);
    	List<Comment> commentlist = query.list();
    	if (commentlist == null){
    		System.out.println("进来了list为null");
    		commentlist = new ArrayList<Comment>();
    	}
    	
    	tx.commit();
        session.close();
    	
    	return commentlist;
		
	
	}
}
