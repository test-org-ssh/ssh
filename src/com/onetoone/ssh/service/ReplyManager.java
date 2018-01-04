package com.onetoone.ssh.service;

import java.util.List;

import com.onetoone.ssh.entity.Comment;
import com.onetoone.ssh.entity.PostTie;
import com.onetoone.ssh.entity.Reply;
import com.onetoone.ssh.entity.User;

public interface ReplyManager {
	/**
	 * 
	 *��������˵����  �����»ظ�
	 * ������2017��12��28�� by Judy   
	 * �޸ģ����� by �޸���  
	 * �޸����ݣ�  
	 * @parms������       
	 * @return void     
	 * @throws
	 */
	public void saveReply();
	/**
	 * 
	 *��������˵����  ���id�����µ����лظ�
	 * ������2017��12��28�� by Judy   
	 * �޸ģ����� by �޸���  
	 * �޸����ݣ�  
	 * @parms������ @param id      
	 * @return void     
	 * @throws
	 */
	public List<Reply> getALLReply(int id);
	/**
	 * 
	 *��������˵����  �����»ظ�
	 * ������2017��12��29�� by Judy   
	 * �޸ģ����� by �޸���  
	 * �޸����ݣ�  
	 * @parms������ @param replyFromUser
	 * @parms������ @param replyToUser
	 * @parms������ @param replyToTie
	 * @parms������ @param replyToCom
	 * @parms������ @param commentcontent
	 * @parms������ @return      
	 * @return int     
	 * @throws
	 */
	public int InsertNewReply(User replyFromUser, User replyToUser, PostTie replyToTie, Comment replyToCom, String replycontent);
}
