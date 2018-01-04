package com.onetoone.ssh.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.onetoone.ssh.dao.PostTieDao;
import com.onetoone.ssh.entity.PageBean;
import com.onetoone.ssh.entity.PostTie;
import com.onetoone.ssh.entity.User;
import com.onetoone.ssh.service.PostTieManager;

public class PostTieManagerImpl implements PostTieManager{
	private PostTieDao posttiedao;
	@Override
	public List<PostTie> getAllPostTie() {
		List<PostTie> list = null;

		list = posttiedao.getAllPostTie();
		if (list == null){
			list = new ArrayList<PostTie>();
		}
		return list;
	}

	@Override
	public void savePostTie(PostTie ptie) {
		// TODO Auto-generated method stub
		posttiedao.insertPostTie(ptie);
	}
	
	@Override
	public PostTie getPTById(int id) {
		PostTie p = posttiedao.getPTById(0);
		
		if (p == null){
			p = new PostTie();
		}
		
		return p;
	}
	
	@Override
	public void uppost(PostTie p) {
		posttiedao.uppost(p);
		
	}
	
	@Override
	public List<PostTie> getLikePostTie(String title) {
		List<PostTie> list = posttiedao.getLikePostTie(title);
		if (list == null){
			list = new ArrayList<>();
		}
		return list;
	}

	/**
	 * 根据分页获取帖子
	 */
	@Override
	public PageBean<PostTie> getPostByPage(Integer currPage, Integer pageSize) {
		PageBean<PostTie> pageBean = new PageBean<PostTie>();

		//封装PageBean里的数据
		pageBean.setCurrPage(currPage);
		pageBean.setPageSize(pageSize);
		int totalCount = posttiedao.findCount();
		pageBean.setTotalCount(totalCount);
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());

		//封装每页线束的数据
		int begin = (currPage - 1) * pageSize;
		List<PostTie> list = posttiedao.findByPage(begin,pageSize);
		pageBean.setList(list);

		return pageBean;
	}

	/**
	 * 根据id获取帖子
	 */
	@Override
	public List<PostTie> getPostById(Integer id) {
		// TODO Auto-generated method stub
		List<PostTie> list =posttiedao.findById(id);

		return list;
	}

	/**
	 * 删除帖子
	 */
	@Override
	public Integer deletePost(Integer id) {
		// TODO Auto-generated method stub
		return posttiedao.deletePostTieById(id);
	}

	// getter & setter method
	public PostTieDao getPosttiedao() {
		return posttiedao;
	}
	public void setPosttiedao(PostTieDao posttiedao) {
		this.posttiedao = posttiedao;
	}

}
