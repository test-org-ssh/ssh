package com.onetoone.ssh.action;

import com.opensymphony.xwork2.ActionSupport;

public class NoteDetailAction extends ActionSupport {

	public String execute() {
		System.out.println("帖子详情请求到达action");
		return "success";
	}
}
