package com.onetoone.ssh.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
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
	
	
	/**
	 * 查询Comment的总记录数
	 * @return
	 */
	public int findCount() {
		// TODO Auto-generated method stub
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		List<Comment> list=null;
		
		session = factory.openSession();
		tx = session.beginTransaction();
		
		Query query = session.createQuery("from Comment");
		list = query.getResultList();
		if(list.size()>0){
			//System.out.println("comment的总条数"+list.size());
			return list.size();
		}
		tx.commit();
		session.close();
		return 0;
	}
	
	
	/**
	 * 分页查询评论
	 * @param begin
	 * @param pageSize
	 * @return
	 */
	public List<Comment> findByPage(int begin, Integer pageSize) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
    	Transaction tx = session.beginTransaction();
    	
    	Criteria criteria = session.createCriteria(Comment.class);
    	criteria.setFirstResult(begin);
    	criteria.setMaxResults(pageSize);
    	
    	List<Comment> list = criteria.list();
    	//System.out.println("comment分页查询结果"+list);
    	//System.out.println(list.size());
    	tx.commit();
    	session.close();
		return list;
	}

	/**
	 * 根据id查找评论
	 * @param id
	 * @return
	 */
	public Comment getCommentById(Integer id) {
	    Session session = factory.openSession();
	    Comment comment = new Comment();
		
		session = factory.openSession();
		comment = (Comment)session.get(Comment.class, id);

		session.close();
		return comment;
	}
	
	/**
	 * 根据ID删除评论
	 * @param id
	 * @return
	 */
	public int deleteCommentById(Integer id) {
	    Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		session = factory.openSession();
		tx = session.beginTransaction();
		Comment comment = this.getCommentById(id);
		session.delete(comment);
		tx.commit();
		session.close();
    	    
    	return 1;
	}
	
	/**
	 * 根据id查找用户
	 * @param id
	 * @return
	 */
	public List<Comment> findById(Integer id) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
    	Transaction tx = session.beginTransaction();
    	List<Comment> list=null;
		
		session = factory.openSession();
		tx = session.beginTransaction();
    	
		Query query = session.createQuery("from Comment where id=?");
		query.setParameter(0, id);
		list = query.getResultList();
		
		tx.commit();
		session.close();
		return list;
	}

}
