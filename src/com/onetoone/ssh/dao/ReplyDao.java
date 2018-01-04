package com.onetoone.ssh.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.onetoone.ssh.entity.Comment;
import com.onetoone.ssh.entity.PostTie;
import com.onetoone.ssh.entity.Reply;
import com.onetoone.ssh.entity.User;
import com.onetoone.ssh.util.ApplicationContextUtil;

/**
 * 
 * @�๦��˵�������ڻظ���Ĳ���  
 * @���޸��ߣ�  
 * @�޸����ڣ�  
 * @�޸�˵����  
 * @��˾���ƣ�adam  
 * @���ߣ�tannanlin  
 * @����ʱ�䣺2017��12��28�� ����11:37:49  
 * @�汾��V1.0
 */
public class ReplyDao {

	ClassPathXmlApplicationContext ac=(ClassPathXmlApplicationContext) ApplicationContextUtil.getApplicationContext();
	SessionFactory factory = (SessionFactory) ac.getBean("sessionFactory");

	/**
	 * 
	 *��������˵����ͨ������id����������еĻظ�
	 * ������2017��12��28�� by Judy   
	 * �޸ģ����� by �޸���  
	 * �޸����ݣ�  
	 * @parms������ @param id
	 * @parms������ @return      
	 * @return List<reply>     
	 * @throws
	 */
	public List<Reply> getAllreplyByTieId(int id){
	
		Session session = factory.openSession();
    	Transaction tx = session.beginTransaction();
    	String hql="FROM Reply r LEFT OUTER JOIN FETCH r.postTie  LEFT OUTER JOIN FETCH r.comment where r.postTie.id=?";
    	Query query = session.createQuery(hql);
    	query.setParameter(0, id);
    	List<Reply> replylist = query.list();
    	if (replylist == null){
    		System.out.println("������listΪnull");
    		replylist = new ArrayList<Reply>();
    	}
    	tx.commit();
        session.close();
    	
    	return replylist;
		
	
	}
/**
 * 
 *��������˵����  �����µĻظ�����
 * ������2017��12��29�� by Judy   
 * �޸ģ����� by �޸���  
 * �޸����ݣ�  
 * @parms������ @param replyFromUser
 * @parms������ @param replyToUser
 * @parms������ @param replyToTie
 * @parms������ @param replyToCom
 * @parms������ @param commentcontent
 * @parms������ @return      
 * @return int     
 * @throws
 */
	public int insertNewReply(User replyFromUser, User replyToUser, PostTie replyToTie, Comment replyToCom,	String replycontent) {
		
		Session session = factory.openSession();
    	Transaction tx = session.beginTransaction();
    	System.out.println("��ʼ�����»ظ�����");
    	Reply r = new Reply();
    	r.setComment(replyToCom);
    	r.setGetuser(replyToUser);
    	r.setGiveuser(replyFromUser);
    	r.setPostTie(replyToTie);
    	r.setContent(replycontent);
        session.save(r);
        tx.commit();
        session.close();
        System.out.println("�����»ظ�����ɹ�");
		return 0;
	}

}
