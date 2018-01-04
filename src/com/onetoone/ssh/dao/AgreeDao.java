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
		System.out.println("��ʼͨ�����Ӳ�����");
		Query query = session.createQuery("FROM Agree a LEFT OUTER JOIN FETCH a.postTie LEFT OUTER JOIN FETCH a.user where a.user.id=?");//
		query.setParameter(0, userid);
		List<Agree> agreelist = query.list();
		if (agreelist == null){
			System.out.println("������listΪnull");
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
	 *��������˵���� ͨ������id���û�id��ȡ��ǰ�û��ĵ��޶��� 
	 * ������2017��12��29�� by Judy   
	 * �޸ģ����� by �޸���  
	 * �޸����ݣ�  
	 * @parms������ @param tieid
	 * @parms������ @param userid
	 * @parms������ @return      
	 * @return Agree     
	 * @throws
	 */
	public Agree getAgreeByTieIdAndUserId(int tieid, int userid) {
		Session session = factory.openSession();
    	Transaction tx = session.beginTransaction();
    	System.out.println("��ʼͨ�����Ӳ�����");
    	Query query = session.createQuery("FROM Agree a LEFT OUTER JOIN FETCH a.postTie LEFT OUTER JOIN FETCH a.user where a.postTie.id=? and a.user.id=?");//
    	query.setParameter(0, tieid);
    	query.setParameter(1, userid);
    	List<Agree> agreelist = query.list();
    	if (agreelist == null){
    		System.out.println("������listΪnull");
    		agreelist = new ArrayList<Agree>();
    	}
    	tx.commit();
        session.close();
    	
    	return agreelist.size()==0?null:agreelist.get(0);
	}

	/**
	 * 
	 *��������˵����  ��������
	 * ������2017��12��29�� by Judy   
	 * �޸ģ����� by �޸���  
	 * �޸����ݣ�  
	 * @parms������ @param postTie
	 * @parms������ @param myself
	 * @parms������ @return      
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
	 *��������˵����  ����idɾ���޼�¼
	 * ������2017��12��29�� by Judy   
	 * �޸ģ����� by �޸���  
	 * �޸����ݣ�  
	 * @parms������ @param postTie
	 * @parms������ @param myself
	 * @parms������ @return      
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
