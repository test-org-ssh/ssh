package com.onetoone.ssh.service;

import java.util.List;

import com.onetoone.ssh.entity.Reply;

public interface ReplyManager {
	/**
	 * 
	 *方法功能说明：  保存新回复
	 * 创建：2017年12月28日 by Judy   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @parms参数：       
	 * @return void     
	 * @throws
	 */
	public void saveReply();
	/**
	 * 
	 *方法功能说明：  获得id帖子下的所有回复
	 * 创建：2017年12月28日 by Judy   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @parms参数： @param id      
	 * @return void     
	 * @throws
	 */
	public List<Reply> getALLReply(int id);
}
