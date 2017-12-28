package com.onetoone.ssh.service;

import java.util.List;

import com.onetoone.ssh.entity.PostTie;

public interface PostTieManager {
	/**
	 * 获取所有帖子的信息
	 * @return
	 */
	public List<PostTie> getAllPostTie();
}
