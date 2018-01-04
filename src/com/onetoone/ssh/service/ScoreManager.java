package com.onetoone.ssh.service;

import com.onetoone.ssh.entity.FilmIntroduction;
import com.onetoone.ssh.entity.Score;
import com.onetoone.ssh.entity.User;

public interface ScoreManager {
	public void saveScore();
	/**
	 * 
	 *��������˵���� ͨ���û�id��Ӱ��id��ø��û���ĳӰ�ӵ����ֶ��� 
	 * ������2018��1��1�� by Judy   
	 * �޸ģ����� by �޸���  
	 * �޸����ݣ�  
	 * @parms������ @param id
	 * @parms������ @param id2
	 * @parms������ @return      
	 * @return Score     
	 * @throws
	 */
	public Score getScoreByFilmAndUser(int filmid, int user);
	/**
	 * 
	 *��������˵���� �����µ�score���� 
	 * ������2018��1��1�� by Judy   
	 * �޸ģ����� by �޸���  
	 * �޸����ݣ�  
	 * @parms������ @param curfilm
	 * @parms������ @param giver
	 * @parms������ @param doGiving
	 * @parms������ @return      
	 * @return int     
	 * @throws
	 */
	public int insertNewScore(FilmIntroduction curfilm, User giver, int doGiving);
	/**
	 * 
	 *��������˵���� ��õ�ǰӰ�ӵ�ƽ���� 
	 * ������2018��1��1�� by Judy   
	 * �޸ģ����� by �޸���  
	 * �޸����ݣ�  
	 * @parms������ @param id
	 * @parms������ @return      
	 * @return float     
	 * @throws
	 */
	public float GetAvgScoreByFilmId(int id);
}
