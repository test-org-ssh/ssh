package com.onetoone.ssh.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import com.onetoone.ssh.entity.FilmIntroduction;
import com.onetoone.ssh.service.FilmManager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;




public class FilmListAction extends ActionSupport  {
	private FilmManager filmmanager;
	private int getFilmFlag;
	Map<String,Object> returndata=new HashMap<String,Object>();//���ظ�ҳ���json
	
	
	public String execute(){
		System.out.println("Ӱ���б����󵽴�action");
		return "success";
	}
	public String filmlist() {
		System.out.println("Ӱ���б����󵽴�action");
		return"success";
	}
	public String getAllFilm() {
		ActionContext ac = ActionContext.getContext();
		//List<FilmIntroduction> filmlist =  filmmanager.getAllFilms();
		//ac.getSession().put("filmlist", filmlist);
		//request.setAttribute("filmlist", filmlist); //�ṩ����ǩʹ��
	//	Object o;
		// JsonArray arr = JsonArray.fromObject(filmlist);
	
//		 JSONArray json = new JSONArray();
//         for(FilmIntroduction fl : filmlist){
//             JSONObject jo = new JSONObject();
//             
//             try {
//            	 jo.put("id", fl.getId());
//                 jo.put("name", fl.getName());
//                 jo.put("picPath", fl.getPicPath());
//                 jo.put("score", fl.getScore());
//				 jo.put("description", fl.getDescription());
//				 json.put(jo);
//			} catch (JSONException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				System.out.println("ת����json����");
//			}
//            
//            
//         }
		//���Ϻ� ��ǰ̨��ҳ����ʱ��� filmlist
		ArrayList<FilmIntroduction> filmlist = (ArrayList<FilmIntroduction>)ac.getSession().get("filmlist");
        net.sf.json.JSONArray jsonArray = net.sf.json.JSONArray.fromObject(filmlist);
		System.out.println(jsonArray);
		returndata.put("filmlist", jsonArray); //��filmintroduction��list���ϴ������ϱ�
		returndata.put("success", true);
		returndata.put("status",getFilmFlag);
		return "success";
	}
	
	public FilmManager getFilmmanager() {
		return filmmanager;
	}
	public void setFilmmanager(FilmManager filmmanager) {
		this.filmmanager = filmmanager;
	}
	public Map<String, Object> getReturndata() {
		return returndata;
	}
	public void setReturndata(Map<String, Object> returndata) {
		this.returndata = returndata;
	}
	public int getGetFilmFlag() {
		return getFilmFlag;
	}
	public void setGetFilmFlag(int getFilmFlag) {
		this.getFilmFlag = getFilmFlag;
	}
	
	
}
