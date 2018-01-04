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
	
	
	/**
	 * 
	 *��������˵����  ͨ������id���û�id����û��ĵ��ޱ�
	 * ������2017��12��29�� by Judy   
	 * �޸ģ����� by �޸���  
	 * �޸����ݣ�  
	 * @parms������ @param tieid
	 * @parms������ @param id
	 * @parms������ @return      
	 * @return Agree     
	 * @throws
	 */
	public Agree getAgreeByTieIdAndUserId(int tieid, int userid);
	/**
	 * 
	 *��������˵����  �����µ��޶���
	 * ������2017��12��29�� by Judy   
	 * �޸ģ����� by �޸���  
	 * �޸����ݣ�  
	 * @parms������ @param postTie
	 * @parms������ @param myself      
	 * @return void     
	 * @throws
	 */
	public int insertNewAgreeByTieAndUser(PostTie postTie, User myself);

	/**
	 * 
	 *��������˵����  ɾ���Ѵ��ڵĵ��޼�¼
	 * ������2017��12��29�� by Judy   
	 * �޸ģ����� by �޸���  
	 * �޸����ݣ�  
	 * @parms������ @param postTie
	 * @parms������ @param myself      
	 * @return void     
	 * @throws
	 */
	public int deleteAgreeById(int toAgreeid);
}
