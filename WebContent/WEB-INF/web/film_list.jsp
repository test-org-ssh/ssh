<%@page import="com.onetoone.ssh.entity.FilmIntroduction"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<% 
    String  path = request.getContextPath();
    ArrayList<FilmIntroduction> filmlist = (ArrayList<FilmIntroduction>)session.getAttribute("filmlist");
	
%>

<title>影视列表</title>
    <link rel="stylesheet" href="<%=path %>/static/css/film_list.css">
    <link rel="stylesheet" href="<%=path %>/static/assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=path %>/static/assets/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="<%=path %>/static/assets/starability-minified/starability-all.min.css">
    <link rel="stylesheet" href="<%=path %>/static/assets/layui/css/layui.css">
    <link href="<%=path %>/static/css/communication.css" rel="stylesheet" style="text/css"/>
    <link href="<%=path %>/static/assets/font/download12/font_503801_6ri7xb94hdr3haor/iconfont.css" rel="stylesheet" style="text/css"/>
</head>

<body>
<input type="hidden" value="<%=path %>" name="path" id="path"/> 

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
                    <a href="#" style="color:#ccc;"><li>&nbsp;影视</li></a>
                    <a href="communication.html"><li>论坛</li></a>
                    <li><a href="myself.html">个人中心</a></li>
                </ul>
            </div>

        </div>
       
    </div><!--classnav_box-->
    <div class="login_search_box"><a href="login.html"><span class="iconfont icon-denglu-copy" style="font-size:24px"></span>登录</div> </a><!--login-->
    </div> <!--idnav_box-->
	 <div class="nav_b"> </div>
<!--body-->

    <div id="banner">
        <img src="<%=path %>/static/img/film_ban.jpg">
    </div>

    <div id="film-list-content">
        <div class="film-wrap">
        </div>

        <div id="film-page">

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
    <script type="text/javascript" src="<%=path %>/static/js/film_list.js"></script>
    <script type="text/javascript" src="<%=path %>/static/assets/layui/lay/modules/layer.js"></script>
   <link rel="stylesheet" href="<%=path %>/static/assets/sweetalert/sweetalert.css" >
    <script type="text/javascript" src="<%=path %>/static/assets/sweetalert/sweetalert.min.js"></script>
	
	<script type="text/javascript">
	/**
	 * 处理影视列表的请求
	 */
		window.onload = function(){
	    	getAllFilm();
	    }
	   
	    var filmlist; //保存全部影视数据
	    var index=0;//分页的首码
	    var filmlistLen=0; //数据总条数
	    var path=$("#path").val();
	  
	    /*
	     * 根据index 显示6条数据
	     */
	    function showFilmList(){
	    	var path=$("#path").val();
	    	//alert("展示film数据");
	    	//alert("index:"+index+"length:"+filmlist.length);
	    	filmlistLen=filmlist.length;
	    	var filmwrap = $(".film-wrap");
			filmwrap.html("");
	    	for(var i=index;i<index+6;i++){
	    		if(i == filmlist.length){//当是最后一个时
	    			break;
	    		}
	    		//alert(filmlist[i].picPath);
	    		//alert("i:"+i);
	    		var isLeft="film-box"; //判断是不是最右边的框
	    		if(i % 3 == 2 ){
	    			isLeft="film_box left";
	    		}

	    		var div1=$("<div class='"+isLeft+"'></div>");
	    		div1.appendTo(filmwrap);
	    		var div2=$("<div class='film-box-img'><a href='gotoFilmDetail?filmindex="+i+"'><img src='"+path+filmlist[i].picPath+"'></a></div>");
	    		div2.appendTo(div1);
	    		var div3=$("<div class='film-box-word'><a href='gotoFilmDetail?filmindex="+i+"'><span class='film-box-word-name'>"+filmlist[i].name+"</span></a> <span class='film-box-word-grade'>评分："+filmlist[i].score+"</span></div>");
	            div3.appendTo(div2);
	            //alert(filmwrap.html());
	    	}
	    	
	    }
	    /*
	     * 取得所有的影视 -- 影视列表
	     */
	    function getAllFilm(){
	       var mytest={
		            'getFilmFlag':1
			        };
			$.ajax({
			        url:'getAllFilm',
			        type:'post',
			        data:mytest,
			        dataType:"json",
			        success:function(data){
			            result = data.status;
			            filmlist = data.filmlist;
			            if (result == 1){
			            	//alert("取到film数据！");
			            	//index = 0;
			            	filmlistLen=filmlist.length;
			            	showFilmList();
			            	layuiFilm();
			            }else{
			            	swal({
								title:"操作失败",
								//text:"写点什么吧！",
								type:"info",
						        //confirmButtonText: "Ok",
						        confirmButtonColor: "#134723"
							})	
			            }
			        }
			    });
	    }
	    /*
	     * 分页
	     */
	    function layuiFilm(){
	    	layui.use('laypage', function(){
	      	  var laypage = layui.laypage;
	      	  //alert("执行layui");
	      	  //执行一个laypage实例
	      	 	laypage.render({
	      	    elem: 'film-page' //注意，这里的  是 ID，不用加 # 号
	      	    ,count: filmlistLen //数据总数，从服务端得到
	      	    ,limit:6 //每页显示条数
	      	    ,first: true   //显示首页
	      	    ,last: true     //显示尾页
	      	    ,jump: function(obj, first){
	      	    	index = parseInt((obj.curr-1)*6);
	      	    	showFilmList();
	      	        if(!first){
	      	          layer.msg('第 '+ obj.curr +' 页');
	      	        }
	      	      }
	      	  });
	      	});
	    }
	    
	    
	</script>
</html>