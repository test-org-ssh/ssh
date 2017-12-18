<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>影视列表</title>
    <link rel="stylesheet" href="<%=path %>/static/css/film_list.css">
    <link rel="stylesheet" href="<%=path %>/static/assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=path %>/static/assets/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="<%=path %>/static/assets/starability-minified/starability-all.min.css">
    <link rel="stylesheet" href="<%=path %>/static/assets/layui/css/layui.css">
    <link href="<%=path %>/static/css/communication.css" rel="stylesheet" style="text/css"/>
    <link href="<%=path %>/static/assets/font/download12/font_503801_6ri7xb94hdr3haor/iconfont.css" rel="stylesheet" style="text/css"/>
</head>
<%
	String path = request.getContextPath();
%>
<body>
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
                    <a href="home.html"><li>&nbsp;首页</li></a>
                    <a href="film_list.html" style="color:#ccc;"><li>&nbsp;影视</li></a>
                    <a href="communication.html"><li>论坛</li></a>
                    <li><a href="myself.html">个人中心</a></li>
                </ul>
            </div>

        </div>
        <div class="searchbox">
            <div class="search_boxfor_Three">
                <div class="three_right"><span class="iconfont icon-search" style="font-size:28px;"></span></div>
                <div class="three_input"><input type="text" value="搜索" class="serach_input" /></div>
            </div>
            <div class="zc_search_box"><a href="register.html"><span class="iconfont icon-zhuce-" style="font-size:20px;"></span> 注册</div></a>
        </div>
    </div><!--classnav_box-->
    <div class="login_search_box"><a href="login.html"><span class="iconfont icon-denglu-copy" style="font-size:24px"></span>登录</div> </a><!--login-->
</div><!--idnav_box-->
<div class="nav_b"> </div>
<!--body-->

    <div id="banner">
        <img src="<%=path %>/static/img/film_ban.jpg">
    </div>

    <div id="film-list-content">
        <div class="film-wrap">
            <div class="film-box">
                <div class="film-box-img">
                    <a href="film_detail.html" target="_blank"> <img src="<%=path %>/static/img/move.jpg"></a>
                </div>
                <div class="film-box-word">
                    <a href="film_detail.html" target="_blank"><span class="film-box-word-name">奇门遁甲</span></a>
                    <span class="film-box-word-grade">评分：5</span>
                </div>
            </div>
            <div class="film-box left">
                <div class="film-box-img">
                    <a href="#"> <img src="<%=path %>/static/img/move.jpg"></a>
                </div>
                <div class="film-box-word">
                    <a href="#"><span class="film-box-word-name">奇门遁甲</span></a>
                    <span class="film-box-word-grade">评分：5</span>
                </div>
            </div>
            <div class="film-box left">
                <div class="film-box-img">
                    <a href="#"> <img src="<%=path %>/static/img/move.jpg"></a>
                </div>
                <div class="film-box-word">
                    <a href="#"><span class="film-box-word-name">奇门遁甲</span></a>
                    <span class="film-box-word-grade">评分：5</span>
                </div>
            </div>
            <div class="film-box">
                <div class="film-box-img">
                    <a href="#"> <img src="<%=path %>/static/img/move.jpg"></a>
                </div>
                <div class="film-box-word">
                    <a href="#"><span class="film-box-word-name">奇门遁甲</span></a>
                    <span class="film-box-word-grade">评分：5</span>
                </div>
            </div>
            <div class="film-box left">
                <div class="film-box-img">
                    <a href="#"> <img src="<%=path %>/static/img/move.jpg"></a>
                </div>
                <div class="film-box-word">
                    <a href="#"><span class="film-box-word-name">奇门遁甲</span></a>
                    <span class="film-box-word-grade">评分：5</span>
                </div>
            </div>
            <div class="film-box left">
                <div class="film-box-img">
                    <a href="#"> <img src="<%=path %>/static/img/move.jpg"></a>
                </div>
                <div class="film-box-word">
                    <a href="#"><span class="film-box-word-name">奇门遁甲</span></a>
                    <span class="film-box-word-grade">评分：5</span>
                </div>
            </div>
        </div>

        <div id="film-page">

        </div>
    </div>


    <div class="footer-content">
        @2016 Power by 成都信息工程大学
    </div>
</body>
    <script type="text/javascript" src="<%=path %>/static/assets/jquery/jquery-3.2.0.js"></script>
    <script type="text/javascript" src="<%=path %>/static/assets/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="<%=path %>/static/assets/layui/layui.js"></script>
    <!--<script type="text/javascript" src="assets/score/score.js"></script>-->
    <script src="<%=path %>/static/js/film_list.js"></script>
</html>