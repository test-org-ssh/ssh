package com.onetoone.ssh.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.onetoone.ssh.dao.CommentDao;
import com.onetoone.ssh.entity.Comment;

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

}
