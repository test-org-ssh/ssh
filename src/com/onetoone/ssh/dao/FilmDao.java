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
	 * ��ѯӰ����Ϣ
	 * @param Ӱ����Ϣչʾ
	 * @return Ӱ����Ϣ�ַ���
	 */
	public List<FilmDao> getAllFilmDao(){
		//��ȡsession
		Session session = factory.openSession();
		//��������
    	Transaction tx = session.beginTransaction();
    	
    	//���浱ʹ��JPA��ʱ��EntityManager ������ Session
    	Query query = session.createQuery("from FilmDao");
    	
    	//�����е����ݲ�ѯ�������ŵ�List������
    	List<FilmDao> list = query.getResultList();
    	
    	//�����ϱ���ѭ��
    	for(FilmDao filmDao:list){
    		//��ӡ���������̨
             System.out.println(filmDao);
    	}

    	//�����ύ
    	tx.commit();
    	//�ر�session
        session.close();
    	//����list����
    	return list;
	}
}
