package com.onetoone.ssh.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.onetoone.ssh.entity.Agree;
import com.onetoone.ssh.entity.PostTie;
import com.onetoone.ssh.entity.User;
import com.onetoone.ssh.util.ApplicationContextUtil;

public class AgreeDao {
	ClassPathXmlApplicationContext ac=(ClassPathXmlApplicationContext) ApplicationContextUtil.getApplicationContext();
	SessionFactory factory = (SessionFactory) ac.getBean("sessionFactory");

	public List<Agree> getAllAgree(int userid){
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println("开始通过链接查数据");
		Query query = session.createQuery("FROM Agree a LEFT OUTER JOIN FETCH a.postTie LEFT OUTER JOIN FETCH a.user where a.user.id=?");//
		query.setParameter(0, userid);
		List<Agree> agreelist = query.list();
		if (agreelist == null){
			System.out.println("进来了list为null");
			agreelist = new ArrayList<Agree>();
		}
		if (agreelist.size() == 0){
			System.out.println("00000000000");
		}

		tx.commit();
		session.close();

		return agreelist;
	}

	

	/**
	 * 
	 *方法功能说明： 通过帖子id和用户id获取当前用户的点赞对象 
	 * 创建：2017年12月29日 by Judy   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @parms参数： @param tieid
	 * @parms参数： @param userid
	 * @parms参数： @return      
	 * @return Agree     
	 * @throws
	 */
	public Agree getAgreeByTieIdAndUserId(int tieid, int userid) {
		Session session = factory.openSession();
    	Transaction tx = session.beginTransaction();
    	System.out.println("开始通过链接查数据");
    	Query query = session.createQuery("FROM Agree a LEFT OUTER JOIN FETCH a.postTie LEFT OUTER JOIN FETCH a.user where a.postTie.id=? and a.user.id=?");//
    	query.setParameter(0, tieid);
    	query.setParameter(1, userid);
    	List<Agree> agreelist = query.list();
    	if (agreelist == null){
    		System.out.println("进来了list为null");
    		agreelist = new ArrayList<Agree>();
    	}
    	tx.commit();
        session.close();
    	
    	return agreelist.size()==0?null:agreelist.get(0);
	}

	/**
	 * 
	 *方法功能说明：  插入新赞
	 * 创建：2017年12月29日 by Judy   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @parms参数： @param postTie
	 * @parms参数： @param myself
	 * @parms参数： @return      
	 * @return int     
	 * @throws
	 */
	public int insertNewAgreeByTieAndUser(PostTie postTie, User myself) {
		Session session = factory.openSession();
    	Transaction tx = session.beginTransaction();
    	Agree agree = new Agree();
    	agree.setPostTie(postTie);
    	agree.setUser(myself);
        session.save(agree);
        tx.commit();
        session.close(); 
		return agree.getId();
		
	}

	/**
	 * 
	 *方法功能说明：  根据id删除赞记录
	 * 创建：2017年12月29日 by Judy   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @parms参数： @param postTie
	 * @parms参数： @param myself
	 * @parms参数： @return      
	 * @return int     
	 * @throws
	 */
	
	public int deleteAgreeById(int toAgreeid) {
		Session session = factory.openSession();
    	Transaction tx = session.beginTransaction();
    	String hql="delete Agree as a where a.id=?";
    	Query query=session.createQuery(hql);
    	query.setParameter(0,toAgreeid);
    	query.executeUpdate();
    	
        tx.commit();
        session.close();
		return 0;
	}

}
