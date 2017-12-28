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
 * @�๦��˵���� �������۱�Ĳ��� 
 * @���޸��ߣ�  
 * @�޸����ڣ�  
 * @�޸�˵����  
 * @��˾���ƣ�adam  
 * @���ߣ�tannanlin  
 * @����ʱ�䣺2017��12��28�� ����11:26:31  
 * @�汾��V1.0
 */
public class CommentDao {

	ClassPathXmlApplicationContext ac=(ClassPathXmlApplicationContext) ApplicationContextUtil.getApplicationContext();
	SessionFactory factory = (SessionFactory) ac.getBean("sessionFactory");
	
	/**
	 * 
	 *��������˵����ͨ������id����������е�����  
	 * ������2017��12��28�� by Judy   
	 * �޸ģ����� by �޸���  
	 * �޸����ݣ�  
	 * @parms������ @param id
	 * @parms������ @return      
	 * @return List<Comment>     
	 * @throws
	 */
	public List<Comment> getAllCommentByTieId(int id){
	
		Session session = factory.openSession();
    	Transaction tx = session.beginTransaction();
    	System.out.println("��ʼͨ�����������");
    	Query query = session.createQuery("FROM Comment c LEFT OUTER JOIN FETCH c.postTie where c.postTie.id=?");
    	query.setParameter(0, id);
    	List<Comment> commentlist = query.list();
    	if (commentlist == null){
    		System.out.println("������listΪnull");
    		commentlist = new ArrayList<Comment>();
    	}
    	
    	tx.commit();
        session.close();
    	
    	return commentlist;
		
	
	}
}
