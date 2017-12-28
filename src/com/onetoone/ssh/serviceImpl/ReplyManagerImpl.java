package com.onetoone.ssh.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.onetoone.ssh.dao.ReplyDao;

import com.onetoone.ssh.entity.Reply;
import com.onetoone.ssh.service.ReplyManager;

public class ReplyManagerImpl implements ReplyManager {

	private ReplyDao replyDao;
	@Override
	public void saveReply() {
		// TODO Auto-generated method stub

	}
	public ReplyDao getReplyDao() {
		return replyDao;
	}
	public void setReplyDao(ReplyDao replyDao) {
		this.replyDao = replyDao;
	}
	@Override
	public List<Reply> getALLReply(int id) {
		List<Reply> replylist;
		
		System.out.println("获取回复之前");
		//System.out.println("form传的数据"+replyform.getreplyname());
		replylist = replyDao.getAllreplyByTieId(id);
		System.out.println("获取回复之后 ");
		if (replylist == null){
			replylist = new ArrayList<Reply>();
		} 
		
		return replylist;
	}
	

}
