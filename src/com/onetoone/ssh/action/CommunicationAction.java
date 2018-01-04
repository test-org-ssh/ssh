package com.onetoone.ssh.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.apache.struts2.ServletActionContext;

import com.onetoone.ssh.entity.Agree;
import com.onetoone.ssh.entity.PostTie;
import com.onetoone.ssh.entity.User;
import com.onetoone.ssh.service.AgreeManager;
import com.onetoone.ssh.service.PostTieManager;
import com.onetoone.ssh.service.UserManager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CommunicationAction extends ActionSupport{
	Map<String,Object> returndata=new HashMap<String,Object>();
	private String kk;
	private Map<Integer,PostTie> posttiemap = new HashMap<Integer,PostTie>();
	private Map<Integer,User> usermap = new HashMap<Integer,User>();
	private List<PostTie> posttielist = null;
	private List<User> userlist = null;
	private PostTieManager manager;
	private UserManager usermanager;
	private PostTie posttie;
	private AgreeManager agreemanager;
	private List<Agree> agreelist;
	private String ptmapid;
	private String op;
	private String liketitle;	// 模糊查询时传来的字符串

	public String getexecute() throws Exception {
		ActionContext ac = ActionContext.getContext();
		User myself = (User)ac.getSession().get("myself");
		
		posttielist = manager.getAllPostTie();
		userlist = usermanager.getAllUser();
		agreelist = agreemanager.getAllAgree(myself.getId());
		
		for (int i=0; i<agreelist.size(); i++){
			System.out.println("Id:"+agreelist.get(i).getId());
			System.out.println("点赞的人："+agreelist.get(i).getUser().getUsername());
			System.out.println("被点赞的帖子"+agreelist.get(i).getPostTie().getTitle());
		}
		
		System.out.println("daxiao"+posttielist.size());
		ac.getSession().put("posttiemap",posttielist);
		ac.getSession().put("usermap", userlist);
		ac.getSession().put("agreelist", agreelist);
		
		return SUCCESS;
	}

	public String getlikept(){
		System.out.println(liketitle+"liketitle");
		liketitle = (String)ServletActionContext.getRequest().getParameter("liketitle");
		List<PostTie> list = manager.getLikePostTie(liketitle);
		if (list == null){
			list = new ArrayList<PostTie>();
		}
		System.out.println(list.size()+"list的size");
		ActionContext ac = ActionContext.getContext();
		ac.getSession().put("posttiemap",list);
		return SUCCESS;
	}
	
	public String checkagree(){
		ActionContext ac = ActionContext.getContext();
		User myself = (User)ac.getSession().get("myself");
		int userid = myself.getId();
		int postid = Integer.parseInt(ptmapid);
		int k=0; 
		System.out.println("kk"+kk);
		System.out.println("op"+op);
		System.out.println("postid"+postid);
		if (kk != null){
			k = Integer.parseInt(kk);
		}
		// op ： 取消点赞是1 点赞是0
		
		int o = 0;
		if (op != null){
			o = Integer.parseInt(op);
		}
		
		if (o == 1){
			PostTie pp = new PostTie();
			posttielist = manager.getAllPostTie();
			for (int j = 0; j<posttielist.size(); j++){
				if (posttielist.get(j).getId() == postid){
					pp = posttielist.get(j);
					pp.setAgreeNum(pp.getAgreeNum()-1);
					posttielist.set(j, pp);
					System.out.println("ppnum"+pp.getAgreeNum());
				}
			}
			manager.uppost(pp);
			agreemanager.deleteAgreeById(k);
			returndata.put("status",1);  
		} else {
			PostTie pp = new PostTie();
			posttielist = manager.getAllPostTie();
			for (int j = 0; j<posttielist.size(); j++){
				if (posttielist.get(j).getId() == postid){
					pp = posttielist.get(j);
					pp.setAgreeNum(pp.getAgreeNum()+1);
					System.out.println("ppnum"+pp.getAgreeNum());
					posttielist.set(j, pp);
				}
			}
			manager.uppost(pp);
			agreemanager.insertNewAgreeByTieAndUser(pp, myself);
			returndata.put("status",1); 
		}
		ac = ActionContext.getContext();
		ac.getSession().put("posttiemap", posttielist);
		ac.getSession().put("postTieList", posttielist);
	
		returndata.put("status",0); 
		returndata.put("success", true);
		return SUCCESS;
	}
	
	// getter & setter method
	public PostTieManager getManager() {
		return manager;
	}
	public void setManager(PostTieManager manager) {
		this.manager = manager;
	}
	public Map<Integer, PostTie> getPosttiemap() {
		return posttiemap;
	}
	public void setPosttiemap(Map<Integer, PostTie> posttiemap) {
		this.posttiemap = posttiemap;
	}
	public List<PostTie> getPosttielist() {
		return posttielist;
	}
	public void setPosttielist(List<PostTie> posttielist) {
		this.posttielist = posttielist;
	}
	public UserManager getUsermanager() {
		return usermanager;
	}
	public void setUsermanager(UserManager usermanager) {
		this.usermanager = usermanager;
	}
	public List<User> getUserlist() {
		return userlist;
	}
	public void setUserlist(List<User> userlist) {
		this.userlist = userlist;
	}
	public AgreeManager getAgreemanager() {
		return agreemanager;
	}
	public void setAgreemanager(AgreeManager agreemanager) {
		this.agreemanager = agreemanager;
	}
	public PostTie getPosttie() {
		return posttie;
	}
	public void setPosttie(PostTie posttie) {
		this.posttie = posttie;
	}
	public List<Agree> getAgreelist() {
		return agreelist;
	}
	public void setAgreelist(List<Agree> agreelist) {
		this.agreelist = agreelist;
	}
	public String getKk() {
		return kk;
	}
	public void setKk(String kk) {
		this.kk = kk;
	}
	public Map<String, Object> getReturndata() {
		return returndata;
	}
	public void setReturndata(Map<String, Object> returndata) {
		this.returndata = returndata;
	}
	public Map<Integer, User> getUsermap() {
		return usermap;
	}
	public void setUsermap(Map<Integer, User> usermap) {
		this.usermap = usermap;
	}
	public String getPtmapid() {
		return ptmapid;
	}
	public void setPtmapid(String ptmapid) {
		this.ptmapid = ptmapid;
	}
	public String getOp() {
		return op;
	}
	public void setOp(String op) {
		this.op = op;
	}
	public String getLiketitle() {
		return liketitle;
	}
	public void setLiketitle(String liketitle) {
		this.liketitle = liketitle;
	}
}
