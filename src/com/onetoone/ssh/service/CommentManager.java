package com.onetoone.ssh.service;

import java.util.List;

import com.onetoone.ssh.entity.Comment;

public interface CommentManager {
	/**
	 * 
	 *��������˵���� ���������� 
	 * ������2017��12��28�� by Judy   
	 * �޸ģ����� by �޸���  
	 * �޸����ݣ�  
	 * @parms������       
	 * @return void     
	 * @throws
	 */
	public void saveComment();
	/**
	 * 
	 *��������˵������ȡid�����µ���������  
	 * ������2017��12��28�� by Judy   
	 * �޸ģ����� by �޸���  
	 * �޸����ݣ�  
	 * @parms������ @param id      
	 * @return void     
	 * @throws
	 */
	public List<Comment> getAllComment(int id);
}
