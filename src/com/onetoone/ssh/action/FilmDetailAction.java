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
	
	private int filmindex;// ��ҳչʾʱȡ�����е�Ӱ��  ����ȡ����Ҫչʾ��Ӱ�����б��е�index
	private int doGiving;//��ǰ�û�����������
	
	
	Map<String,Object> returndata=new HashMap<String,Object>();//���ظ�ҳ���json
	
	
	public String execute() {
		System.out.println("Ӱ���������󵽴�action");
		return "success";
	}
	//����
	public String giveScore() {
		ActionContext ac = ActionContext.getContext();
		ArrayList<FilmIntroduction> filmlist = (ArrayList<FilmIntroduction>) ac.getSession().get("filmlist");
		FilmIntroduction curfilm = filmlist.get(filmindex);
		//��ǰ�����õ��û�����myself
		User myself = (User) ac.getSession().get("myself");
		int res=0; //Ĭ�ϲ���ʧ��
		res = scoremanager.insertNewScore(curfilm,myself,doGiving);
		float updatescore = scoremanager.GetAvgScoreByFilmId(curfilm.getId());
		curfilm.setScore(updatescore);
		res = filmmanager.updateScore(curfilm); //����Ӱ�ӵ���ƽ������
		filmlist.set(filmindex, curfilm);
		ac.getSession().put("filmlist",filmlist);
		
		System.out.println(updatescore);
		returndata.put("status",res);   //����0��ʾ�����ɹ�
		returndata.put("updatescore", updatescore);
		returndata.put("success", true);
		return "success";
	}
	//ҳ���ʼ�� �ж��Ƿ��Ѿ�������
	public String isGaveScore() {
		ActionContext ac = ActionContext.getContext();
		ArrayList<FilmIntroduction> filmlist = (ArrayList<FilmIntroduction>) ac.getSession().get("filmlist");
		FilmIntroduction curfilm = filmlist.get(filmindex);
		//��ǰ�����û�����myself
		User myself = (User) ac.getSession().get("myself");
//		if(myself == null) { //��û����ǰ session����û��myself���� �Լ��̶�����һ��session����
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
