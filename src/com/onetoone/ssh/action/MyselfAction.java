package com.onetoone.ssh.action;

import com.opensymphony.xwork2.ActionSupport;

public class MyselfAction extends ActionSupport{
	
		public String getexecute(){
			System.out.println("��ת��������ҳ");
			return "getsuccess";
		}
		public String postexecute(){
			System.out.println("888");
			return "postsuccess";//

	}
	
}
