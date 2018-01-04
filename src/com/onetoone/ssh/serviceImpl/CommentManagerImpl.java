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
		
		System.out.println("获取评论之前");
		//System.out.println("form传的数据"+commentform.getcommentname());
		commentlist = commentDao.getAllCommentByTieId(id);
		System.out.println("获取评论之后 ");
		if (commentlist == null){
			commentlist = new ArrayList<Comment>();
		} 
		
		return commentlist;
	}
	
	
	/**
	 * 根据分页获取评论
	 */
	@Override
	public PageBean<Comment> getCommentByPage(Integer currPage, Integer pageSize) {
		PageBean<Comment> pageBean = new PageBean<Comment>();
		
		//封装PageBean里的数据
		pageBean.setCurrPage(currPage);
		pageBean.setPageSize(pageSize);
		int totalCount = commentDao.findCount();
		pageBean.setTotalCount(totalCount);
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		
		//封装每页线束的数据
		int begin = (currPage - 1) * pageSize;
		List<Comment> list = commentDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		
		return pageBean;
	}
	
	/**
	 * 根据id获取评论
	 */
	@Override
	public List<Comment> getCommentById(Integer id) {
		// TODO Auto-generated method stub
		List<Comment> list =commentDao.findById(id);
		
		return list;
	}
	
	/**
	 * 删除评论
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
