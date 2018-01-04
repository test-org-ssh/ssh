package com.onetoone.ssh.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.onetoone.ssh.entity.*;
import com.onetoone.ssh.util.ApplicationContextUtil;

public class FilmDao {
    ClassPathXmlApplicationContext ac = (ClassPathXmlApplicationContext) ApplicationContextUtil.getApplicationContext();
    SessionFactory factory = (SessionFactory) ac.getBean("sessionFactory");

    /**
     * 查询影视信息
     * 
     * @param 影视信息展示
     * @return 影视信息字符串
     */
    public List<FilmIntroduction> getAllFilmDao() {
	// 获取session
	Session session = factory.openSession();

	// 开启事务
	// Transaction tx = session.beginTransaction();

	// 后面当使用JPA的时候，EntityManager 类似于 Session
	Query query = session.createQuery("from FilmIntroduction f order by f.score desc");

	// 将所有的数据查询出来并放到List集合里
	List<FilmIntroduction> list = query.getResultList();

	// 将集合遍历循环
	for (FilmIntroduction filmIntroduction : list) {
	    // 打印输出到控制台
	    System.out.println(filmIntroduction);
	}

	// 事务提交
	// tx.commit();
	// 关闭session
	session.close();
	// 返回list集合
	return list;
    }

    /**
     * 查询fime_introduction的总记录数
     * 
     * @return
     */
    public int findCount() {
	Session session = factory.openSession();
	Transaction tx = session.beginTransaction();
	List<FilmIntroduction> list = null;

	session = factory.openSession();
	tx = session.beginTransaction();

	Query query = session.createQuery("from FilmIntroduction");
	list = query.getResultList();
	if (list.size() > 0) {
	    return list.size();
	}
	tx.commit();
	session.close();
	return 0;
    }

    /**
     * 分页查询影视
     * 
     * @param begin
     * @param pageSize
     * @return
     */
    public List<FilmIntroduction> findByPage(int begin, Integer pageSize) {
	Session session = factory.openSession();
	Transaction tx = session.beginTransaction();

	Criteria criteria = session.createCriteria(FilmIntroduction.class);
	criteria.setFirstResult(begin);
	criteria.setMaxResults(pageSize);

	List<FilmIntroduction> list = criteria.list();
	System.out.println(list.size());
	tx.commit();
	session.close();
	return list;
    }

    /**
     * 根据id查找film
     * 
     * @param id
     * @return
     */
    public FilmIntroduction getFilmById(Integer id) {
	Session session = factory.openSession();
	FilmIntroduction film = new FilmIntroduction();

	session = factory.openSession();
	film = (FilmIntroduction) session.get(FilmIntroduction.class, id);

	session.close();
	return film;
    }

    /**
     * 根据ID删除film
     * 
     * @param id
     * @return
     */
    public int deleteFilmById(Integer id) {
	Session session = factory.openSession();
	Transaction tx = session.beginTransaction();

	session = factory.openSession();
	tx = session.beginTransaction();
	FilmIntroduction film = this.getFilmById(id);
	session.delete(film);
	tx.commit();
	session.close();

	return 0;
    }

    /**
     * 添加影视
     * 
     * @param name
     * @param path
     * @param desc
     * @return
     */
    public int addFilm(String name, String path, String desc) {
	FilmIntroduction film = new FilmIntroduction();

	System.out.println("film_name="+name);
	Session session = factory.openSession();
	Transaction tx = session.beginTransaction();

	film.setName(name);
	film.setDescription(desc);
	film.setPicPath(path);

	session.save(film);
	tx.commit();
	session.close();
	return 1;
    }

    /**
     * 根据id修改影视
     * 
     * @param id
     * @param name
     * @param path
     * @param desc
     * @return
     */
    public int updateFilmById(Integer id, String name, String path, String desc) {
	Session session = factory.openSession();
	Transaction tx = session.beginTransaction();
	FilmIntroduction film = this.getFilmById(id);

	film.setDescription(desc);
	film.setName(name);
	film.setPicPath(path);

	session.update(film);
	tx.commit();
	session.close();
	return 1;
    }
    
    /**
	 * 
	 *方法功能说明： 获取所有的影视列表 
	 * 创建：2017年12月31日 by Judy   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @parms参数： @return      
	 * @return List<FilmIntroduction>     
	 * @throws
	 */
	public List<FilmIntroduction> getAllFilms() {
		Session session = factory.openSession();
    	Transaction tx = session.beginTransaction();
    	System.out.println("开始通过链接查数据");
    	Query query = session.createQuery("FROM FilmIntroduction f order by f.score desc");//
    	
    	List<FilmIntroduction> filmlist = query.list();
    	if (filmlist == null){
    		System.out.println("进来了list为null");
    		filmlist = new ArrayList<FilmIntroduction>();
    	}
    	tx.commit();
        session.close();
    	
    	return filmlist;
		
	}
	
	/**
	 * 
	 *方法功能说明：  更新影视的评分
	 * 创建：2018年1月1日 by Judy   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @parms参数： @param curfilm
	 * @parms参数： @return      
	 * @return int     
	 * @throws
	 */
	public int updateScore(FilmIntroduction curfilm) {
		Session session = factory.openSession();
    	Transaction tx = session.beginTransaction();
		session.saveOrUpdate(curfilm);
		tx.commit();
		session.close();
		return 1;
	}


}
