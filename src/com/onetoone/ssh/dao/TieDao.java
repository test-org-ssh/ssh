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
	 *方法功能说明：  每增加一条评论  帖子表里对应帖子下的评论数加一
	 * 创建：2017年12月29日 by Judy   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @parms参数： @param postTie
	 * @parms参数： @return      
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
 *方法功能说明：  更新点赞的数目
 * 创建：2017年12月29日 by Judy   
 * 修改：日期 by 修改者  
 * 修改内容：  
 * @parms参数： @param postTie
 * @parms参数： @return      
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