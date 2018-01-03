package com.onetoone.ssh.action;

import java.util.List;

import com.onetoone.ssh.service.UserManager;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.ActionContext;
import com.onetoone.ssh.dao.*;
import com.onetoone.ssh.entity.*;
import com.onetoone.ssh.service.*;
import com.onetoone.ssh.serviceImpl.*;
import java.util.HashMap;
import java.util.Map;
import org.apache.struts2.ServletActionContext;
import org.omg.CORBA.PRIVATE_MEMBER;

public class AdminFilmAction extends ActionSupport {
    // 返回到前台的对象
    Map<String, Object> returndata = new HashMap<String, Object>();

    public Map<String, Object> getReturndata() {
	return returndata;
    }

    public void setReturndata(Map<String, Object> returndata) {
	this.returndata = returndata;
    }

    // 注入service
    private FilmManager filmmanager;

    public FilmManager getFilmmanager() {
	return filmmanager;
    }

    public void setFilmmanager(FilmManager filmmanager) {
	this.filmmanager = filmmanager;
    }

    // 分页查询变量
    private Integer currPage;
    private Integer pageSize;
    // 影视信息的字段
    private Integer id;
    private String name;
    private String path;
    private String desc;

    public Integer getCurrPage() {
	return currPage;
    }

    public void setCurrPage(Integer currPage) {
	this.currPage = currPage;
    }

    public Integer getPageSize() {
	return pageSize;
    }

    public void setPageSize(Integer pageSize) {
	this.pageSize = pageSize;
    }

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getPath() {
	return path;
    }

    public void setPath(String path) {
	this.path = path;
    }

    public String getDesc() {
	return desc;
    }

    public void setDesc(String desc) {
	this.desc = desc;
    }

    //分页查询
    public String getFilmByPage() {
	String msg = "";
	Boolean flag = true;

	PageBean<FilmIntroduction> pageBean = filmmanager.getFilmByPage(currPage, pageSize);

	if (pageBean.getTotalCount() == 0) {
	    msg = "查询影视信息失败！";
	    flag = false;
	}
	if (flag == true) {
	    returndata.put("data", pageBean);
	    returndata.put("status", 0);
	    returndata.put("success", true);
	} else {
	    returndata.put("msg", msg);
	    returndata.put("success", false);
	}
	return SUCCESS;
    }

    // 添加、修改
    public String souFilm() {
	String msg = "";
	Boolean flag = true;
	String temp1 = "";

	int count = 0;

	if (id == null) {
	    count = filmmanager.addFilm(name, path, desc);
	    temp1 = "添加";
	} else {
	    count = filmmanager.updateFilmById(id, name, path, desc);
	    temp1 = "修改";
	}

	if (count == 1) {
	    msg = temp1 + "成功！";
	    flag = true;
	} else {
	    msg = temp1 + "失败！";
	    flag = false;
	}

	if (flag == true) {
	    returndata.put("msg", msg);
	    returndata.put("success", true);
	} else {
	    returndata.put("msg", msg);
	    returndata.put("success", false);
	}
	return SUCCESS;
    }

    // 删除
    public String deleteFilm() {
	Integer result = filmmanager.deleteFilm(id);
	if (result == 1) {
	    returndata.put("msg", "删除失败");
	    returndata.put("status", result);
	    returndata.put("success", false);
	} else {
	    returndata.put("msg", "删除成功");
	    returndata.put("status", result);
	    returndata.put("success", true);
	}
	System.out.println(returndata);
	return SUCCESS;
    }

}
