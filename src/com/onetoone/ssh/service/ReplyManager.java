package com.onetoone.ssh.service;

import java.util.List;

import com.onetoone.ssh.entity.Reply;

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
}
