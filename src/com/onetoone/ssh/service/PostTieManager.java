package com.onetoone.ssh.service;

import java.util.List;

import com.onetoone.ssh.entity.PageBean;
import com.onetoone.ssh.entity.PostTie;

public interface PostTieManager {
	/**
	 * 获取所有帖子的信息
	 * @return
	 */
	public List<PostTie> getAllPostTie();
	
	/**
	 * 根据分页获取帖子
	 * @param currPage
	 * @param pageSize
	 * @return
	 */
	public PageBean<PostTie> getPostByPage(Integer currPage, Integer pageSize);
	
	/**
	 * 根据id获取帖子
	 * @param id
	 * @return
	 */
	public List<PostTie> getPostById(Integer id);

	
	/**
	 * 删除帖子
	 * @param id
	 * @return
	 */
	public Integer deletePost(Integer id);
	
	public void savePostTie(PostTie ptie);
	
	public List<PostTie> getLikePostTie(String title);
	
	public PostTie getPTById(int id);
	
	public void uppost(PostTie p);
}
