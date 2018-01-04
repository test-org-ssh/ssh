package com.onetoone.ssh.dao;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.onetoone.ssh.entity.Agree;
import com.onetoone.ssh.entity.FilmIntroduction;
import com.onetoone.ssh.entity.Score;
import com.onetoone.ssh.entity.User;
import com.onetoone.ssh.util.ApplicationContextUtil;
public class ScoreDao {
	ClassPathXmlApplicationContext ac=(ClassPathXmlApplicationContext) ApplicationContextUtil.getApplicationContext();
	SessionFactory factory = (SessionFactory) ac.getBean("sessionFactory");

	/**
	 * 
	 *��������˵����  ͨ���û�id��Ӱ��id��ø��û���ĳӰ�ӵ����ֶ��� 
	 * ������2018��1��1�� by Judy   
	 * �޸ģ����� by �޸���  
	 * �޸����ݣ�  
	 * @parms������ @param filmid
	 * @parms������ @param userid
	 * @parms������ @return      
	 * @return Score     
	 * @throws
	 */
	public Score getScoreByFilmAndUser(int filmid, int userid) {
		Session session = factory.openSession();
    	Transaction tx = session.beginTransaction();
    	System.out.println("��ʼͨ�����Ӳ�����");
    	Query query = session.createQuery("FROM Score s LEFT OUTER JOIN FETCH s.fi LEFT OUTER JOIN FETCH s.giver where s.fi.id=? and s.giver.id=?");//
    	query.setParameter(0, filmid);
    	query.setParameter(1, userid);
    	List<Score> scorelist = query.list();
    	if (scorelist == null){
    		System.out.println("������listΪnull");
    		scorelist = new ArrayList<Score>();
    	}
    	tx.commit();
        session.close();
    	
    	return scorelist.size()==0?null:scorelist.get(0);
	}
	/**
	 * 
	 *��������˵����  �����score��¼
	 * ������2018��1��1�� by Judy   
	 * �޸ģ����� by �޸���  
	 * �޸����ݣ�  
	 * @parms������ @param curfilm
	 * @parms������ @param giver
	 * @parms������ @param doGiving
	 * @parms������ @return      
	 * @return int     
	 * @throws
	 */
	public int insertNewScore(FilmIntroduction curfilm, User giver, int doGiving) {
		Session session = factory.openSession();
    	Transaction tx = session.beginTransaction();
		Score score = new Score();
		score.setFi(curfilm);
		score.setGiver(giver);
		score.setScore(doGiving);
		session.save(score);
		tx.commit();
        session.close();
		return 1;
	}
	/**
	 * 
	 *��������˵����  ��ȡӰ��id��ƽ������
	 * ������2018��1��1�� by Judy   
	 * �޸ģ����� by �޸���  
	 * �޸����ݣ�  
	 * @parms������ @param filmid
	 * @parms������ @return      
	 * @return float     
	 * @throws
	 */
	public float GetAvgScoreByFilmId(int filmid) {
		Session session = factory.openSession();
    	Transaction tx = session.beginTransaction();
    	Query query = session.createQuery("FROM Score s LEFT OUTER JOIN FETCH s.fi LEFT OUTER JOIN FETCH s.giver where s.fi.id=?");//
    	query.setParameter(0, filmid);
        List<Score> scorelist = query.list();
        float update = 0;
        int i = 0;
        for(Score s:scorelist) {
        	update=update+s.getScore();
        	i++;
        }
        if(i != 0) {
        	update=update/i;
        }
       // update = (float)(Math.round(update*100)/100); //������λС��
        BigDecimal   b  =   new BigDecimal(update);  
		float   f1   =  b.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue(); 
        tx.commit();
        session.close();
        
		return f1;
	}
}