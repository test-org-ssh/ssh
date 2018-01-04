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
	Map<String,Object> returndata=new HashMap<String,Object>();//返回给页面的json
	
	
	public String execute(){
		System.out.println("影视列表请求到达action");
		return "success";
	}
	public String filmlist() {
		System.out.println("影视列表请求到达action");
		return"success";
	}
	public String getAllFilm() {
		ActionContext ac = ActionContext.getContext();
		//List<FilmIntroduction> filmlist =  filmmanager.getAllFilms();
		//ac.getSession().put("filmlist", filmlist);
		//request.setAttribute("filmlist", filmlist); //提供给标签使用
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
//				System.out.println("转换成json出错");
//			}
//            
//            
//         }
		//整合后 由前台首页加载时获得 filmlist
		ArrayList<FilmIntroduction> filmlist = (ArrayList<FilmIntroduction>)ac.getSession().get("filmlist");
        net.sf.json.JSONArray jsonArray = net.sf.json.JSONArray.fromObject(filmlist);
		System.out.println(jsonArray);
		returndata.put("filmlist", jsonArray); //将filmintroduction的list集合传进集合边
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
