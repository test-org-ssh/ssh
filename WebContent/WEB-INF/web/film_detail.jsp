<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<%
	String path = request.getContextPath();
%>
<title>OneTOone影视详情页</title>
    <link rel="stylesheet" href="<%=path %>/static/css/film_detail.css">
    <link rel="stylesheet" href="<%=path %>/static/assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=path %>/static/assets/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="<%=path %>/static/assets/starability-minified/starability-all.min.css">
    <link href="<%=path %>/static/css/communication.css" rel="stylesheet" style="text/css"/>
    <link href="<%=path %>/static/assets/font/download12/font_503801_6ri7xb94hdr3haor/iconfont.css" rel="stylesheet" style="text/css"/>
</head>

<body>
<div id="nav_box">
    <div class="nav_box">
        <div class="logo_box">
            <img src="<%=path %>/static/img\logo.png">
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

    <div class="film-de-ban">
        <img src="<%=path %>/static/img/film_de_ban.png">
    </div>
    <div class="film-de-contenter">
        <div class="film-de-title">
            奇门遁甲简介
        </div>
        <div class="film-de-word">
            <p>奇门遁甲号称帝王之学，为古代不传秘术之一，与太乙神数，大六壬统称为古三式。其本质是一门高等的天文物理学，揭示了太阳系八大行星和地球磁场的作用情况。奇门有天地人三盘。天盘在古为钦天监可用，主测天灾人祸，地盘为行军布阵，在于现代多用于环境调理，非将相之才不传。而人盘则为人世间的吉凶祸福。</p>
            <p>南斗僧，北斗将，南斗星云，北斗祸福。在古，认为北斗掌管世间万物的吉凶祸福。所以奇门遁甲采用北斗九皇（即大熊星座）。</p>
            <p>奇门遁甲中将一切事物的成败归纳为五大因素，即天时、地利、人和、神助，格局组合。它包含有天文学、历法学、战争学、谋略学、哲学等。是古人长期观察天体对地球自转公转的影响，运用阴阳的理论，将这种规律通过奇门遁甲来演示，模拟世间万物的吉凶祸福。</p>
            <p>民间流传的俗语有“学会奇门遁，来人不用问。”当下奇门遁甲应用于婚恋、工作、事业、环境（风水）、财运的预测、调理、化解和运筹等诸多方面。</p>
        </div>
        <div class="film-de-total-score">
            总评分：<span>4.5</span>
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
                    请给该影视评分
                </div>

            <button class="btn btn-save">提交</button>
        </div>
    </div>
    <div class="footer-content">
        @2017 Power by 成都信息工程大学
    </div>
</body>
    <script type="text/javascript" src="<%=path %>/static/assets/jquery/jquery-3.2.0.js"></script>
    <script type="text/javascript" src="<%=path %>/static/assets/bootstrap/js/bootstrap.min.js"></script>
    <!--<script type="text/javascript" src="assets/score/score.js"></script>-->
    <script src="<%=path %>/static/js/film_detail.js"></script>
</html>