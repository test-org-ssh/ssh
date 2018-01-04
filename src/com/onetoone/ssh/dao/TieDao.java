package com.onetoone.ssh.dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.onetoone.ssh.entity.PostTie;
import com.onetoone.ssh.util.ApplicationContextUtil;

public class TieDao {
	ClassPathXmlApplicationContext ac=(ClassPathXmlApplicationContext) ApplicationContextUtil.getApplicationContext();
	SessionFactory factory = (SessionFactory) ac.getBean("sessionFactory");
	
	
	/**
	 * 
	 *��������˵����  ÿ����һ������  ���ӱ����Ӧ�����µ���������һ
	 * ������2017��12��29�� by Judy   
	 * �޸ģ����� by �޸���  
	 * �޸����ݣ�  
	 * @parms������ @param postTie
	 * @parms������ @return      
	 * @return int     
	 * @throws
	 */
	public int updateCommentNumToTie(PostTie postTie) {
		
		Session session = factory.openSession();
    	Transaction tx = session.beginTransaction();
    	postTie.setCommentNum(postTie.getCommentNum()+1);
        session.saveOrUpdate(postTie);
        tx.commit();
        session.close();
		
		return 0;
	}

/**
 * 
 *��������˵����  ���µ��޵���Ŀ
 * ������2017��12��29�� by Judy   
 * �޸ģ����� by �޸���  
 * �޸����ݣ�  
 * @parms������ @param postTie
 * @parms������ @return      
 * @return int     
 * @throws
 */
	public int updateAgreeNumToTie(PostTie postTie) {
		Session session = factory.openSession();
    	Transaction tx = session.beginTransaction();
    	
        session.saveOrUpdate(postTie);
        tx.commit();
        session.close();
		
		return 0;
		
	}

}