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
	Query query = session.createQuery("from FilmIntroduction");

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
}
