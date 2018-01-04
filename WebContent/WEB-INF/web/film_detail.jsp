<%@page import="com.onetoone.ssh.entity.FilmIntroduction"%>
<%@page import="com.onetoone.ssh.entity.Score"%>
<%@page import="com.onetoone.ssh.entity.User"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<%
	String path = request.getContextPath();
	int filmindex = (Integer)request.getAttribute("filmindex"); //在影视列表中的下标
    ArrayList<FilmIntroduction> filmlist = (ArrayList<FilmIntroduction>)session.getAttribute("filmlist");
	FilmIntroduction fi = filmlist.get(filmindex);//获得当前影视
	
	User myself = (User)session.getAttribute("myself");
	
	Score curScore = (Score)request.getAttribute("curScore"); //获取当前用户的评分对象
	int isLogin = 1;//默认已经登录
	if(myself == null ){
		isLogin = 0;//0表示未登录
	}
	int isGave = 1;  //默认已经评分
	if(curScore == null){  //还没评过分
		curScore = new Score();
		isGave = 0;//0表示未评分
	}
	
%>

<title>OneTOone影视详情页</title>
    <link rel="stylesheet" href="<%=path %>/static/css/film_detail.css">
    <link rel="stylesheet" href="<%=path %>/static/assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=path %>/static/assets/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="<%=path %>/static/assets/starability-minified/starability-all.min.css">
    <link href="<%=path %>/static/css/communication.css" rel="stylesheet" style="text/css"/>
    <link href="<%=path %>/static/assets/font/download12/font_503801_6ri7xb94hdr3haor/iconfont.css" rel="stylesheet" style="text/css"/>
    <link rel="stylesheet" href="<%=path %>/static/assets/layui/css/layui.css">
</head>

<body>
<!-- 添加评分对象时 -->
<input type="hidden" value="<%=filmindex %>" id="filmindex" name="filmindex"/> 
<div id="nav_box">
    <div class="nav_box">
        <div class="logo_box">
            <img src="<%=path %>/static/img/logo.png">
        </div>
        <div class="titile_box">
            <div class="title">
                <ul>
                    <li><span class="iconfont icon-shouye3" style="font-size:36px"></span></li>
                    <li><span class="iconfont icon-yingshi2" style="font-size:36px"></span></li>
                    <li><span class="iconfont icon-luntan" style="font-size:36px"></span></li>
                    <li><span class="iconfont icon-gerenzhongxin" style="font-size:36px"></span></li>
                </ul>
            </div>
            <div class="title2">
                <ul>
                    <a href="<%=path %>/Index" target="_blank"><li>&nbsp;首页</li></a>
                    <li><a href="<%=path %>/FilmList" target="_blank" style="color:#ccc;">&nbsp;影视</a></li>
                    <a href="communication.html"><li>论坛</li></a>
                    <li><a href="myself.html">个人中心</a></li>
                </ul>
            </div>

        </div>
       
    </div><!--classnav_box-->
   <div class="login_search_box"><a href="login.html"><span class="iconfont icon-denglu-copy" style="font-size:24px"></span>登录</div> </a><!--login-->
	</div><!--idnav_box-->
      <div class="nav_b"> </div>
<!--body-->

    <div class="film-de-ban">
        <img src="<%=path %>/static/img/film_de_ban.png"> <!--  -->
    </div>
    <div class="film-de-contenter">
        <div class="film-de-title">
          <%=filmlist.get(filmindex).getName() %>简介
        </div>
        <div class="film-de-word">
            <%=filmlist.get(filmindex).getDescription()  %>
        </div>
        <div class="film-de-total-score">
            总评分：<span id="score"><%=filmlist.get(filmindex).getScore() %></span>
        </div>
        <div class="film-de-score">
            <div class="film-de-score-wrap">

                    <div class="star-wrap" >
                        <form>
                            <fieldset class="starability-basic" style="float:left;">

                                <input type="radio" id="rate5-1" name="rating" value="5" />
                                <label for="rate5-1" title="Amazing">5 stars</label>

                                <input type="radio" id="rate4-1" name="rating" value="4" />
                                <label for="rate4-1" title="Very good">4 stars</label>

                                <input type="radio" id="rate3-1" name="rating" value="3" />
                                <label for="rate3-1" title="Average">3 stars</label>

                                <input type="radio" id="rate2-1" name="rating" value="2" />
                                <label for="rate2-1" title="Not good">2 stars</label>

                                <input type="radio" id="rate1-1" name="rating" value="1" />
                                <label for="rate1-1" title="Terrible">1 star</label>

                                <!--<input class="star-score" value="请给该影视评分">-->
                            </fieldset>
                        </form>
                    </div>
                </div>
                <div class="score-word">
                <%if(isLogin != 1){%>
                	请先登录
                <%}else{ %>
                		<% if(isGave == 0){ %>
                			请评分
                		<%}else{%>
                			已评分
						<% }
					}%>
                </div>
			
            <button id="btnCommit" class="btn btn-save" <% if(isGave == 0 && isLogin == 1){%>
            	onclick="giveScore();"
           <%}else{ %> style="cursor:not-allowed;background-color:#c5c5c5;" <%} %> >
          	  提交</button>
        </div>
    </div>
    <div class="footer-content">
        @2017 Power by 成都信息工程大学
    </div>
</body>

    <script type="text/javascript" src="<%=path %>/static/assets/jquery/jquery-3.2.0.js"></script>
    <script type="text/javascript" src="<%=path %>/static/assets/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="<%=path %>/static/assets/layui/layui.js"></script>
    <!--<script type="text/javascript" src="assets/score/score.js"></script>-->
    <script type="text/javascript" src="<%=path %>/static/js/film_detail.js"></script>
    <link rel="stylesheet" href="<%=path %>/static/assets/sweetalert/sweetalert.css" >
    <script type="text/javascript" src="<%=path %>/static/assets/sweetalert/sweetalert.min.js"></script>
	<script type="text/javascript">
	/**
	 * 处理影视详情页面的js请求
	 */

	    	/*
	    	 * 用户评分  然后就停在本页面 一颗星也没有表示0分
	    	 */
	    	function giveScore(){
	    		var rating = document.getElementsByName("rating");
	    		var doGiving = 0;  //评分默认为0
	    		var filmindex=$("#filmindex").val(); //评分的影视
	    		for(var i=0;i<rating.length;i++){
	    			if(rating[i].checked){ 
	    				doGiving=rating[i].value;  //得到分
	    				//alert(doGiving);
	    				break; 
	    			}
	    		}
	    		var mytest={
	    				"doGiving":doGiving,
	    				"filmindex":filmindex
	    		}
	    		
	    		$.ajax({
			        url:'giveScore',
			        type:'post',
			        data:mytest,
			        dataType:"json",
			        success:function(data){
			            result = data.status;
			            if (result == 1){
			            	swal({
								title:"评分成功",
								//text:"写点什么吧！",
								type:"info",
						        //confirmButtonText: "Ok",
						        confirmButtonColor: "#134723"
							})

			            	
			            	//alert(data.updatescore);
			            	$(".score-word").html("");
			            	$(".score-word").html("已评分");
			            	$("#score").html("");
			            	$("#score").html(data.updatescore);
			            	$("#btnCommit").removeAttr("onclick");
			            	$("#btnCommit").attr("style","cursor:not-allowed;background-color:#c5c5c5;");
			            }else{
			            	swal({
								title:"评分失败",
								//text:"写点什么吧！",
								type:"info",
						        //confirmButtonText: "Ok",
						        confirmButtonColor: "#134723"
							})
			            }
			        }
			    });
	    		
	    	}
	</script>
</html>