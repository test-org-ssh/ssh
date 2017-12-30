package com.onetoone.ssh.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.onetoone.ssh.entity.*;
import com.onetoone.ssh.util.ApplicationContextUtil;

public class FilmDao {
	ClassPathXmlApplicationContext ac=(ClassPathXmlApplicationContext) ApplicationContextUtil.getApplicationContext();
	SessionFactory factory = (SessionFactory) ac.getBean("sessionFactory");
	
	/**
	 * 查询影视信息
	 * @param 影视信息展示
	 * @return 影视信息字符串
	 */
	public List<FilmIntroduction> getAllFilmDao(){
		//获取session
		Session session = factory.openSession();
		
		//开启事务
    	//Transaction tx = session.beginTransaction();
    	
    	//后面当使用JPA的时候，EntityManager 类似于 Session
    	Query query = session.createQuery("from FilmIntroduction");
    	
    	//将所有的数据查询出来并放到List集合里
    	List<FilmIntroduction> list = query.getResultList();
    	
    	//将集合遍历循环
    	for(FilmIntroduction filmIntroduction:list){
    		//打印输出到控制台
             //System.out.println(filmIntroduction);
             System.out.println(filmIntroduction.getPicPath());
             //System.out.println(filmIntroduction.getName());
    	}

    	//事务提交
    	//tx.commit();
    	//关闭session
        session.close();
    	//返回list集合
    	return list;
	}
}
