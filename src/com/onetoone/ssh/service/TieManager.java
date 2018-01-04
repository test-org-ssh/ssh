package com.onetoone.ssh.service;

import com.onetoone.ssh.entity.PostTie;

public interface TieManager {
	/**
	 * 
	 *方法功能说明：  保存帖子
	 * 创建：2017年12月29日 by Judy   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @parms参数：       
	 * @return void     
	 * @throws
	 */
	public void saveTie();

	/**
	 * 
	 *方法功能说明：  更新帖子下的评论条数
	 * 创建：2017年12月29日 by Judy   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @parms参数： @param postTie      
	 * @return int     
	 * @throws
	 */
	public int updateCommentNumToTie(PostTie postTie);
	/**
	 * 
	 *方法功能说明：  更新点赞的数目
	 * 创建：2017年12月29日 by Judy   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @parms参数： @param postTie
	 * @parms参数： @return      
	 * @return int     
	 * @throws
	 */
		public int updateAgreeNumToTie(PostTie postTie);
}
