package com.onetoone.ssh.service;

import java.util.List;

import com.onetoone.ssh.entity.Agree;
import com.onetoone.ssh.entity.PostTie;
import com.onetoone.ssh.entity.User;

public interface AgreeManager {
	public void saveAgree();
	/**
	 * ������еĵ�����Ϣ
	 * @return
	 */
	public List<Agree> getAllAgree(int userid);
	
	public int deleteAgreeById(int toAgreeid);
	
	public int insertNewAgreeByTieAndUser(PostTie postTie, User myself);
}
