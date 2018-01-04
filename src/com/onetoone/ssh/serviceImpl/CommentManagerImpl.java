package com.onetoone.ssh.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.onetoone.ssh.dao.CommentDao;
import com.onetoone.ssh.entity.Comment;
import com.onetoone.ssh.entity.PageBean;
import com.onetoone.ssh.entity.PostTie;
import com.onetoone.ssh.entity.User;
import com.onetoone.ssh.service.CommentManager;
import com.onetoone.ssh.util.MD5Util;

public class CommentManagerImpl implements CommentManager {

	private CommentDao commentDao;
	public CommentDao getCommentDao() {
		return commentDao;
	}
	public void setCommentDao(CommentDao commentDao) {
		this.commentDao = commentDao;
	}
	@Override
	public void saveComment() {
		// TODO Auto-generated method stub

	}
	@Override
	public List<Comment> getAllComment(int id) {
		List<Comment> commentlist;
		
		System.out.println("��ȡ����֮ǰ");
		//System.out.println("form��������"+commentform.getcommentname());
		commentlist = commentDao.getAllCommentByTieId(id);
		System.out.println("��ȡ����֮�� ");
		if (commentlist == null){
			commentlist = new ArrayList<Comment>();
		} 
		
		return commentlist;
	}
	
	
	/**
	 * ���ݷ�ҳ��ȡ����
	 */
	@Override
	public PageBean<Comment> getCommentByPage(Integer currPage, Integer pageSize) {
		PageBean<Comment> pageBean = new PageBean<Comment>();
		
		//��װPageBean�������
		pageBean.setCurrPage(currPage);
		pageBean.setPageSize(pageSize);
		int totalCount = commentDao.findCount();
		pageBean.setTotalCount(totalCount);
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		
		//��װÿҳ����������
		int begin = (currPage - 1) * pageSize;
		List<Comment> list = commentDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		
		return pageBean;
	}
	
	/**
	 * ����id��ȡ����
	 */
	@Override
	public List<Comment> getCommentById(Integer id) {
		// TODO Auto-generated method stub
		List<Comment> list =commentDao.findById(id);
		
		return list;
	}
	
	/**
	 * ɾ������
	 */
	@Override
	public Integer deleteComment(Integer id) {
		// TODO Auto-generated method stub
		return commentDao.deleteCommentById(id);
	}

	@Override
	public int InsertNewComment(User user, PostTie postTie, String commentcontent) {
		return commentDao.InsertNewComment(user,postTie,commentcontent);
		
	}
}
