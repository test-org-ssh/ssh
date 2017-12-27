package com.onetoone.ssh.action;

import com.opensymphony.xwork2.ActionSupport;

public class FilmListAction extends ActionSupport {

	public String execute() {
		System.out.println("影视列表请求到达action");
		return "success";
	}
}
