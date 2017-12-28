package com.onetoone.ssh.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.onetoone.ssh.dao.PostTieDao;
import com.onetoone.ssh.entity.PostTie;
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
	
	// getter & setter method
	public PostTieDao getPosttiedao() {
		return posttiedao;
	}
	public void setPosttiedao(PostTieDao posttiedao) {
		this.posttiedao = posttiedao;
	}
	
}
