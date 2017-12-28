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
 * @类功能说明：关于回复表的操作  
 * @类修改者：  
 * @修改日期：  
 * @修改说明：  
 * @公司名称：adam  
 * @作者：tannanlin  
 * @创建时间：2017年12月28日 上午11:37:49  
 * @版本：V1.0
 */
public class ReplyDao {

	ClassPathXmlApplicationContext ac=(ClassPathXmlApplicationContext) ApplicationContextUtil.getApplicationContext();
	SessionFactory factory = (SessionFactory) ac.getBean("sessionFactory");
	
	/**
	 * 
	 *方法功能说明：通过帖子id获得其下所有的回复
	 * 创建：2017年12月28日 by Judy   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @parms参数： @param id
	 * @parms参数： @return      
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
    		System.out.println("进来了list为null");
    		replylist = new ArrayList<Reply>();
    	}
    	
    	tx.commit();
        session.close();
    	
    	return replylist;
		
	
	}
	
}
