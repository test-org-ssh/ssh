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
	public List<FilmIntroduction> getAllFilmDao(){
		//��ȡsession
		Session session = factory.openSession();
		 System.out.println(1);
		//��������
    	Transaction tx = session.beginTransaction();
    	 System.out.println(2);
    	//���浱ʹ��JPA��ʱ��EntityManager ������ Session
    	Query query = session.createQuery("from FilmIntroduction");
    	 System.out.println(3);
    	//�����е����ݲ�ѯ�������ŵ�List������
    	List<FilmIntroduction> list = query.getResultList();
    	 System.out.println(4);
    	//�����ϱ���ѭ��
    	for(FilmIntroduction filmDao:list){
    		//��ӡ���������̨
    		 System.out.println(5);
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
