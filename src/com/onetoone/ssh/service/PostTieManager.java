package com.onetoone.ssh.service;

import java.util.List;

import com.onetoone.ssh.entity.PageBean;
import com.onetoone.ssh.entity.PostTie;

public interface PostTieManager {
	/**
	 * ��ȡ�������ӵ���Ϣ
	 * @return
	 */
	public List<PostTie> getAllPostTie();
	
	/**
	 * ���ݷ�ҳ��ȡ����
	 * @param currPage
	 * @param pageSize
	 * @return
	 */
	public PageBean<PostTie> getPostByPage(Integer currPage, Integer pageSize);
	
	/**
	 * ����id��ȡ����
	 * @param id
	 * @return
	 */
	public List<PostTie> getPostById(Integer id);

	
	/**
	 * ɾ������
	 * @param id
	 * @return
	 */
	public Integer deletePost(Integer id);
	
	public void savePostTie(PostTie ptie);
	
	public List<PostTie> getLikePostTie(String title);
	
	public PostTie getPTById(int id);
	
	public void uppost(PostTie p);
}
