package com.onetoone.ssh.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.onetoone.ssh.entity.PostTie;
import com.onetoone.ssh.entity.User;
import com.onetoone.ssh.util.ApplicationContextUtil;

/**
 * 帖子类
 * @author wanghaixue
 *
 */
public class PostTieDao {
	ClassPathXmlApplicationContext ac=(ClassPathXmlApplicationContext) ApplicationContextUtil.getApplicationContext();
	SessionFactory factory = (SessionFactory) ac.getBean("sessionFactory");
	Session session = null;
	Transaction tx = null;

	/**
	 * 获取所有的帖子
	 * @return
	 */
	public List<PostTie> getAllPostTie(){
		List<PostTie> list=null;
		session = factory.openSession();
		tx = session.beginTransaction();

		Query query = session.createQuery("from PostTie");
		list = query.list();
		if (list == null){
			list = new ArrayList<PostTie>();
		}

		//tx.commit();
		session.close();

		return list;
	}



	/**
	 * 查询posttie的总记录数
	 * @return
	 */
	public int findCount() {
		// TODO Auto-generated method stub

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		List<PostTie> list=null;

		session = factory.openSession();
		tx = session.beginTransaction();

		Query query = session.createQuery("from PostTie");
		list = query.getResultList();
		if(list.size()>0){
			return list.size();
		}
		tx.commit();
		session.close();
		return 0;
	}


	/**
	 * 分页查询帖子
	 * @param begin
	 * @param pageSize
	 * @return
	 */
	public List<PostTie> findByPage(int begin, Integer pageSize) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		Criteria criteria = session.createCriteria(PostTie.class);
		criteria.setFirstResult(begin);
		criteria.setMaxResults(pageSize);

		List<PostTie> list = criteria.list();
		//System.out.println(list.size());
		tx.commit();
		session.close();
		return list;
	}

	/**
	 * 根据id查找帖子
	 * @param id
	 * @return
	 */
	public PostTie getPostTieById(Integer id) {
		Session session = factory.openSession();
		PostTie postTie = new PostTie();

		session = factory.openSession();
		postTie = (PostTie)session.get(PostTie.class, id);

		session.close();
		return postTie;
	}

	/**
	 * 根据ID删除帖子
	 * @param id
	 * @return
	 */
	public Integer deletePostTieById(Integer id) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		session = factory.openSession();
		tx = session.beginTransaction();
		PostTie postTie = this.getPostTieById(id);
		session.delete(postTie);
		tx.commit();
		session.close();

		return 1;
	}

	/**
	 * 根据id查找用户
	 * @param id
	 * @return
	 */
	public List<PostTie> findById(Integer id) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		List<PostTie> list=null;

		session = factory.openSession();
		tx = session.beginTransaction();

		Query query = session.createQuery("from PostTie where id=?");
		query.setParameter(0, id);
		list = query.getResultList();

		tx.commit();
		session.close();
		return list;
	}

	public int insertPostTie(PostTie ptie){
		int res = 0;

		session = factory.openSession();
		tx = session.beginTransaction();

		session.save(ptie);
		tx.commit();
		session.close();

		return res;
	}

	public PostTie getPTById(int id){

		System.out.println("id::::"+id);
		PostTie pt = null;
		session = factory.openSession();
		tx = session.beginTransaction();
		pt = session.get(PostTie.class, id);
		if (pt == null){
			pt = new PostTie();
		}
		session.close();
		return pt;
	}

	public List<PostTie> getLikePostTie(String title){
		System.out.println(title);
		List<PostTie> list=null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			Query query = session.createQuery("from PostTie where title like ?");
			query.setParameter(0, "%"+title+"%");
			list = query.list();
			if (list == null){
				list = new ArrayList<PostTie>();
			}
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
		return list;
	}

	public void uppost(PostTie p){
		session = factory.openSession();
		tx = session.beginTransaction();
		session.saveOrUpdate(p);

		tx.commit();
		session.close();
	}
}
