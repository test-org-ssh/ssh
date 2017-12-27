package com.onetoone.ssh.action;

import com.opensymphony.xwork2.ActionSupport;

public class FilmDetailAction extends ActionSupport {

	public String execute() {
		System.out.println("影视详情请求到达action");
		return "success";
	}
}
