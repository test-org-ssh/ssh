package com.onetoone.ssh.service;

import java.util.List;

import com.onetoone.ssh.entity.Comment;
import com.onetoone.ssh.entity.PageBean;
import com.onetoone.ssh.entity.User;

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
	
	/**
	 * ���ݷ�ҳ��ȡ����
	 * @param currPage
	 * @param pageSize
	 * @return
	 */
	public PageBean<Comment> getCommentByPage(Integer currPage, Integer pageSize);
	
	/**
	 * ����id��ȡ����
	 * @param id
	 * @return
	 */
	public List<Comment> getCommentById(Integer id);
	
	/**
	 * ɾ������
	 * @param id
	 * @return
	 */
	public Integer deleteComment(Integer id);
}
