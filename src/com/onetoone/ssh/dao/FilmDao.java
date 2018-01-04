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
     * ��ѯӰ����Ϣ
     * 
     * @param Ӱ����Ϣչʾ
     * @return Ӱ����Ϣ�ַ���
     */
    public List<FilmIntroduction> getAllFilmDao() {
	// ��ȡsession
	Session session = factory.openSession();

	// ��������
	// Transaction tx = session.beginTransaction();

	// ���浱ʹ��JPA��ʱ��EntityManager ������ Session
	Query query = session.createQuery("from FilmIntroduction f order by f.score desc");

	// �����е����ݲ�ѯ�������ŵ�List������
	List<FilmIntroduction> list = query.getResultList();

	// �����ϱ���ѭ��
	for (FilmIntroduction filmIntroduction : list) {
	    // ��ӡ���������̨
	    System.out.println(filmIntroduction);
	}

	// �����ύ
	// tx.commit();
	// �ر�session
	session.close();
	// ����list����
	return list;
    }

    /**
     * ��ѯfime_introduction���ܼ�¼��
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
     * ��ҳ��ѯӰ��
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
     * ����id����film
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
     * ����IDɾ��film
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
     * ���Ӱ��
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
     * ����id�޸�Ӱ��
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
	 *��������˵���� ��ȡ���е�Ӱ���б� 
	 * ������2017��12��31�� by Judy   
	 * �޸ģ����� by �޸���  
	 * �޸����ݣ�  
	 * @parms������ @return      
	 * @return List<FilmIntroduction>     
	 * @throws
	 */
	public List<FilmIntroduction> getAllFilms() {
		Session session = factory.openSession();
    	Transaction tx = session.beginTransaction();
    	System.out.println("��ʼͨ�����Ӳ�����");
    	Query query = session.createQuery("FROM FilmIntroduction f order by f.score desc");//
    	
    	List<FilmIntroduction> filmlist = query.list();
    	if (filmlist == null){
    		System.out.println("������listΪnull");
    		filmlist = new ArrayList<FilmIntroduction>();
    	}
    	tx.commit();
        session.close();
    	
    	return filmlist;
		
	}
	
	/**
	 * 
	 *��������˵����  ����Ӱ�ӵ�����
	 * ������2018��1��1�� by Judy   
	 * �޸ģ����� by �޸���  
	 * �޸����ݣ�  
	 * @parms������ @param curfilm
	 * @parms������ @return      
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
