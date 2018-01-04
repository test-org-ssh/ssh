package com.onetoone.ssh.service;

import com.onetoone.ssh.entity.PostTie;

public interface TieManager {
	/**
	 * 
	 *��������˵����  ��������
	 * ������2017��12��29�� by Judy   
	 * �޸ģ����� by �޸���  
	 * �޸����ݣ�  
	 * @parms������       
	 * @return void     
	 * @throws
	 */
	public void saveTie();

	/**
	 * 
	 *��������˵����  ���������µ���������
	 * ������2017��12��29�� by Judy   
	 * �޸ģ����� by �޸���  
	 * �޸����ݣ�  
	 * @parms������ @param postTie      
	 * @return int     
	 * @throws
	 */
	public int updateCommentNumToTie(PostTie postTie);
	/**
	 * 
	 *��������˵����  ���µ��޵���Ŀ
	 * ������2017��12��29�� by Judy   
	 * �޸ģ����� by �޸���  
	 * �޸����ݣ�  
	 * @parms������ @param postTie
	 * @parms������ @return      
	 * @return int     
	 * @throws
	 */
		public int updateAgreeNumToTie(PostTie postTie);
}
