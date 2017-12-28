package com.onetoone.ssh.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.onetoone.ssh.entity.Reply;

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
    	
    	Query query = session.createQuery("from reply where reply_to_tieid=?");
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
	
}
