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
	
	
	/**
	 * ��ѯComment���ܼ�¼��
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
			//System.out.println("comment��������"+list.size());
			return list.size();
		}
		tx.commit();
		session.close();
		return 0;
	}
	
	
	/**
	 * ��ҳ��ѯ����
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
    	//System.out.println("comment��ҳ��ѯ���"+list);
    	//System.out.println(list.size());
    	tx.commit();
    	session.close();
		return list;
	}

	/**
	 * ����id��������
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
	 * ����IDɾ������
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
	 * ����id�����û�
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
