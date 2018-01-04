package com.onetoone.ssh.service;

import java.util.List;

import com.onetoone.ssh.entity.Comment;
import com.onetoone.ssh.entity.PageBean;
import com.onetoone.ssh.entity.PostTie;
import com.onetoone.ssh.entity.User;

public interface CommentManager {
	/**
	 * 
	 *方法功能说明： 保存新评论 
	 * 创建：2017年12月28日 by Judy   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @parms参数：       
	 * @return void     
	 * @throws
	 */
	public void saveComment();
	
	/**
	 * 
	 *方法功能说明：获取id帖子下的所有评论  
	 * 创建：2017年12月28日 by Judy   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @parms参数： @param id      
	 * @return void     
	 * @throws
	 */
	public List<Comment> getAllComment(int id);
	/**
	 * 
	 *方法功能说明：  插入新评论
	 * 创建：2017年12月29日 by Judy   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @parms参数： @param userid
	 * @parms参数： @param tieid
	 * @parms参数： @param commentcontent
	 * @parms参数： @return      
	 * @return int     
	 * @throws
	 */
	public int InsertNewComment(User user, PostTie postTie, String commentcontent);
	
	/**
	 * 根据分页获取评论
	 * @param currPage
	 * @param pageSize
	 * @return
	 */
	public PageBean<Comment> getCommentByPage(Integer currPage, Integer pageSize);
	
	/**
	 * 根据id获取评论
	 * @param id
	 * @return
	 */
	public List<Comment> getCommentById(Integer id);
	
	/**
	 * 删除评论
	 * @param id
	 * @return
	 */
	public Integer deleteComment(Integer id);
}
