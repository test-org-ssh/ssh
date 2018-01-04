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
	 *方法功能说明：  通过用户id和影视id获得该用户对某影视的评分对象 
	 * 创建：2018年1月1日 by Judy   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @parms参数： @param filmid
	 * @parms参数： @param userid
	 * @parms参数： @return      
	 * @return Score     
	 * @throws
	 */
	public Score getScoreByFilmAndUser(int filmid, int userid) {
		Session session = factory.openSession();
    	Transaction tx = session.beginTransaction();
    	System.out.println("开始通过链接查数据");
    	Query query = session.createQuery("FROM Score s LEFT OUTER JOIN FETCH s.fi LEFT OUTER JOIN FETCH s.giver where s.fi.id=? and s.giver.id=?");//
    	query.setParameter(0, filmid);
    	query.setParameter(1, userid);
    	List<Score> scorelist = query.list();
    	if (scorelist == null){
    		System.out.println("进来了list为null");
    		scorelist = new ArrayList<Score>();
    	}
    	tx.commit();
        session.close();
    	
    	return scorelist.size()==0?null:scorelist.get(0);
	}
	/**
	 * 
	 *方法功能说明：  添加新score记录
	 * 创建：2018年1月1日 by Judy   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @parms参数： @param curfilm
	 * @parms参数： @param giver
	 * @parms参数： @param doGiving
	 * @parms参数： @return      
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
	 *方法功能说明：  获取影视id的平均评分
	 * 创建：2018年1月1日 by Judy   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @parms参数： @param filmid
	 * @parms参数： @return      
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
       // update = (float)(Math.round(update*100)/100); //保留两位小数
        BigDecimal   b  =   new BigDecimal(update);  
		float   f1   =  b.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue(); 
        tx.commit();
        session.close();
        
		return f1;
	}
}