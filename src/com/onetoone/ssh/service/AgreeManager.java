package com.onetoone.ssh.service;

import java.util.List;

import com.onetoone.ssh.entity.Agree;
import com.onetoone.ssh.entity.PostTie;
import com.onetoone.ssh.entity.User;

public interface AgreeManager {
	public void saveAgree();
	/**
	 * 获得所有的点赞信息
	 * @return
	 */
	public List<Agree> getAllAgree(int userid);
	
	
	/**
	 * 
	 *方法功能说明：  通过帖子id和用户id获得用户的点赞表
	 * 创建：2017年12月29日 by Judy   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @parms参数： @param tieid
	 * @parms参数： @param id
	 * @parms参数： @return      
	 * @return Agree     
	 * @throws
	 */
	public Agree getAgreeByTieIdAndUserId(int tieid, int userid);
	/**
	 * 
	 *方法功能说明：  插入新点赞对象
	 * 创建：2017年12月29日 by Judy   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @parms参数： @param postTie
	 * @parms参数： @param myself      
	 * @return void     
	 * @throws
	 */
	public int insertNewAgreeByTieAndUser(PostTie postTie, User myself);

	/**
	 * 
	 *方法功能说明：  删除已存在的点赞记录
	 * 创建：2017年12月29日 by Judy   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @parms参数： @param postTie
	 * @parms参数： @param myself      
	 * @return void     
	 * @throws
	 */
	public int deleteAgreeById(int toAgreeid);
}
