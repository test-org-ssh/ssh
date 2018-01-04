package com.onetoone.ssh.action;

import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.onetoone.ssh.entity.FilmIntroduction;
import com.onetoone.ssh.entity.Score;
import com.onetoone.ssh.entity.User;
import com.onetoone.ssh.service.FilmManager;
import com.onetoone.ssh.service.ScoreManager;
import com.opensymphony.xwork2.ActionContext;
import javax.servlet.http.HttpServletRequest;


public class FilmDetailAction extends ActionSupport implements ServletRequestAware {
	private FilmManager filmmanager;
	private ScoreManager scoremanager;
	private HttpServletRequest request;
	
	private int filmindex;// 首页展示时取出所有的影视  这里取到需要展示的影视在列表中的index
	private int doGiving;//当前用户给出的评分
	
	
	Map<String,Object> returndata=new HashMap<String,Object>();//返回给页面的json
	
	
	public String execute() {
		System.out.println("影视详情请求到达action");
		return "success";
	}
	//评分
	public String giveScore() {
		ActionContext ac = ActionContext.getContext();
		ArrayList<FilmIntroduction> filmlist = (ArrayList<FilmIntroduction>) ac.getSession().get("filmlist");
		FilmIntroduction curfilm = filmlist.get(filmindex);
		//当前操作得当用户就是myself
		User myself = (User) ac.getSession().get("myself");
		int res=0; //默认操作失败
		res = scoremanager.insertNewScore(curfilm,myself,doGiving);
		float updatescore = scoremanager.GetAvgScoreByFilmId(curfilm.getId());
		curfilm.setScore(updatescore);
		res = filmmanager.updateScore(curfilm); //插入影视的新平均评分
		filmlist.set(filmindex, curfilm);
		ac.getSession().put("filmlist",filmlist);
		
		System.out.println(updatescore);
		returndata.put("status",res);   //返回0表示操作成功
		returndata.put("updatescore", updatescore);
		returndata.put("success", true);
		return "success";
	}
	//页面初始化 判断是否已经评过分
	public String isGaveScore() {
		ActionContext ac = ActionContext.getContext();
		ArrayList<FilmIntroduction> filmlist = (ArrayList<FilmIntroduction>) ac.getSession().get("filmlist");
		FilmIntroduction curfilm = filmlist.get(filmindex);
		//当前操作用户就是myself
		User myself = (User) ac.getSession().get("myself");
//		if(myself == null) { //还没整合前 session域中没有myself对象 自己固定建立一个session对象
//			myself = new User();
//			myself.setId(1);
//			myself.setFnum(12);
//			myself.setJianjie("jjjjj");
//			myself.setPassword("123");
//			myself.setPhoto("456");
//			myself.setStatus(1);
//			myself.setUsername("Tom");
//			ac.getSession().put("myself",myself);
//		}
		Score curScore = scoremanager.getScoreByFilmAndUser(curfilm.getId(),myself.getId());
		request.setAttribute("curScore", curScore);
		
		return "success";
	}
	
	public FilmManager getFilmmanager() {
		return filmmanager;
	}
	public void setFilmmanager(FilmManager filmmanager) {
		this.filmmanager = filmmanager;
	}
	public ScoreManager getScoremanager() {
		return scoremanager;
	}
	public void setScoremanager(ScoreManager scoremanager) {
		this.scoremanager = scoremanager;
	}
	public Map<String, Object> getReturndata() {
		return returndata;
	}
	public void setReturndata(Map<String, Object> returndata) {
		this.returndata = returndata;
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}
	public int getFilmindex() {
		return filmindex;
	}
	public void setFilmindex(int filmindex) {
		this.filmindex = filmindex;
	}
	public HttpServletRequest getRequest() {
		return request;
	}
	public int getDoGiving() {
		return doGiving;
	}
	public void setDoGiving(int doGiving) {
		this.doGiving = doGiving;
	}
}
