package com.onetoone.ssh.service;

import com.onetoone.ssh.entity.FilmIntroduction;
import com.onetoone.ssh.entity.Score;
import com.onetoone.ssh.entity.User;

public interface ScoreManager {
	public void saveScore();
	/**
	 * 
	 *方法功能说明： 通过用户id和影视id获得该用户对某影视的评分对象 
	 * 创建：2018年1月1日 by Judy   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @parms参数： @param id
	 * @parms参数： @param id2
	 * @parms参数： @return      
	 * @return Score     
	 * @throws
	 */
	public Score getScoreByFilmAndUser(int filmid, int user);
	/**
	 * 
	 *方法功能说明： 插入新的score对象 
	 * 创建：2018年1月1日 by Judy   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @parms参数： @param curfilm
	 * @parms参数： @param giver
	 * @parms参数： @param doGiving
	 * @parms参数： @return      
	 * @return int     
	 * @throws
	 */
	public int insertNewScore(FilmIntroduction curfilm, User giver, int doGiving);
	/**
	 * 
	 *方法功能说明： 获得当前影视的平均分 
	 * 创建：2018年1月1日 by Judy   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @parms参数： @param id
	 * @parms参数： @return      
	 * @return float     
	 * @throws
	 */
	public float GetAvgScoreByFilmId(int id);
}
