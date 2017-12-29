<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<%
	String path = request.getContextPath();
%>
<head>
    <meta charset="UTF-8">
    <title>OneTOone首页</title>
    <link rel="stylesheet" href="<%=path %>/static/css/home.css">
    <link rel="stylesheet" href="<%=path %>/static/assets/bootstrap/css/bootstrap.min.css">
</head>
<body>
    <div id="ban-content">
        <div class="banner-wrap">
            <div id="myCarousel" class="carousel slide">
                <!--&lt;!&ndash; 轮播（Carousel）指标 &ndash;&gt;-->
                <!--<ol class="carousel-indicators">-->
                    <!--<li data-target="#myCarousel" data-slide-to="0" class="active"></li>-->
                    <!--<li data-target="#myCarousel" data-slide-to="1"></li>-->
                    <!--<li data-target="#myCarousel" data-slide-to="2"></li>-->
                <!--</ol>-->
                <!-- 轮播（Carousel）项目 -->
                <div class="carousel-inner">
                    <div class="item active">
                        <img src="<%=path %>/static/img/ban_2.jpg" alt="First slide">
                    </div>
                    <div class="item">
                        <img src="<%=path %>/static/img/ban_1.jpg" alt="Second slide">
                    </div>
                    <div class="item">
                        <img src="<%=path %>/static/img/ban_3.jpg" alt="Third slide">
                    </div>
                </div>
                 <!--&lt;!&ndash;轮播（Carousel）导航&ndash;&gt;-->
                <!--<a class="carousel-control left" href="#myCarousel"-->
                   <!--data-slide="prev">&lsaquo;</a>-->
                <!--<a class="carousel-control right" href="#myCarousel"-->
                   <!--data-slide="next">&rsaquo;</a>-->
            </div>
        </div>
        <div class="home-haeder">
            <div class="home-title">
                OneTOone
            </div>
            <div class="home-tro">
                OneTOone share film and talk with other
            </div>
            <div class="home-btn">
                <div class="login">
                    <a href="<%=path %>/getLoginAction" target="_blank"><button class="btn">Login</button></a>
                </div>
                <div class="register">
                    <a href="<%=path %>/getRegisterAction" target="_blank"><button class="btn">Register</button></a>
                </div>
            </div>
        </div>
    </div>
    <div id="nav-content">
        <div class="anchor_layer" id="navHeight">
            <div class="nav_wrap" id="nav_wrap">
                <div class="wrap_layer">
                    <div class="wrap_tab"><a class="tab active" href="<%=path%>/Index">Home</a></div>
                    <div class="wrap_tab"><a class="tab" href="film_list.jsp">影视</a></div>
                    <div class="wrap_tab"><a class="tab" href="<%=path %>/getCommunicationAction">论坛</a></div>
                    <div class="wrap_tab last_wrap_tab"><a class="tab" href="<%=path %>/getMyselfAction">个人中心</a></div>
                </div>
            </div>
        </div>
    </div>
                        
                        
    <div id="main-content" >
        <img class="futures_bg" src="<%=path %>/static/img/icon__slack.svg" width="1620" height="1620">
        <div class="main-wrap">
            <div class="film-content">
                <div class="film-title">
                    Film sharing
                </div>
                <div class="film-wrap">
                	<s:iterator value="#filmDaoList" status="bcs">
                		<div class="film-box left">
                			<div class="film-box-img">
                				<a href="film_detail.jsp" target="_blank"> <img src="<%=path %><s:property value="pic_path"></s:property>"></a>
                			</div>
                			<div class="film-box-word">
                            	<a href="film_detailjsp" target="_blank"><span class="film-box-word-name"><s:property value="film_name"></s:property></span></a>
                            	<span class="film-box-word-grade">评分：<s:property value="score"></s:property></span>
                        	</div>
                		</div>
                	</s:iterator>
                    <!--<div class="film-box">
                        <div class="film-box-img">
                            <a href="film_detail.jsp" target="_blank"> <img src="<%=path %>/static/img/move.jpg"></a>
                        </div>
                        <div class="film-box-word">
                            <a href="film_detailjsp" target="_blank"><span class="film-box-word-name">奇门遁甲</span></a>
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
                    </div>  -->
                </div>
            </div>

            <div class="forum-content">
                <div class="forum-title">
                    Hot topic
                </div>
                <div class="forum-wrap">
                	<s:iterator value="#postTieList" status="bcs">
                		<div class="forum-box forum-left">
	                        <a href="noteDetail.jsp"><span class="forum-box-title"><s:property value="title"></s:property></span></a>
	                        <a href="noteDetail.jsp"><div class="forum-box-content"><s:property value="content"></s:property> </div></a>
	                        <div class="forum-funs icon-left">
	                            <span class="forum-icon"><img src="<%=path %>/static/img/icon/jushoucang.png" style="width:20px;height:20px;"></span>
	                            <span class="forum-count">(<s:property value="agree_num"></s:property>)</span>
	                        </div>
	                        <div class="forum-comment icon-left">
	                            <span class="forum-icon"><img src="<%=path %>/static/img/icon/xxcenter.png" style="width:20px;height:20px;"></span>
	                            <span class="forum-count">(<s:property value="comment_num"></s:property>)</span>
	                        </div>
	                    </div>
                	</s:iterator>
                    <!--<div class="forum-box">
                        <a href="noteDetail.jsp" target="_blank"><span class="forum-box-title">奇门遁甲</span></a>
                        <a href="noteDetail.jsp" target="_blank"><div class="forum-box-content">奇幻3D巨制《奇门遁甲》由徐克监制、编剧，袁和平执导，将于2017年12月15日贺岁档震撼公映。该片讲述的是一个妖孽横行，天象大乱的时代，外星妖物侵袭而来。此时江湖上精通“奇门遁甲”之术的神秘组织“雾隐门”挺身而出，其首领老大（伍佰 饰）、弟子诸葛青云（大鹏 饰）
                            、铁蜻蜓（倪妮 饰）和雾隐七子等众人各怀所长。另一方面，诸葛青云途中寻找新一代掌门小圆（周冬雨 饰）之时，新晋捕快刀宜长（李治廷 饰）为 </div></a>
                        <div class="forum-funs icon-left">
                            <span class="forum-icon"><img src="<%=path %>/static/img/icon/jushoucang.png" style="width:20px;height:20px;"></span>
                            <span class="forum-count">(110)</span>
                        </div>
                        <div class="forum-comment icon-left">
                            <span class="forum-icon"><img src="<%=path %>/static/img/icon/xxcenter.png" style="width:20px;height:20px;"></span>
                            <span class="forum-count">(9)</span>
                        </div>
                    </div>
                    <div class="forum-box forum-left">
                        <a href="#"><span class="forum-box-title">奇门遁甲</span></a>
                        <a href="#"><div class="forum-box-content">奇幻3D巨制《奇门遁甲》由徐克监制、编剧，袁和平执导，将于2017年12月15日贺岁档震撼公映。该片讲述的是一个妖孽横行，天象大乱的时代，外星妖物侵袭而来。此时江湖上精通“奇门遁甲”之术的神秘组织“雾隐门”挺身而出，其首领老大（伍佰 饰）、弟子诸葛青云（大鹏 饰）
                            、铁蜻蜓（倪妮 饰）和雾隐七子等众人各怀所长。另一方面，诸葛青云途中寻找新一代掌门小圆（周冬雨 饰）之时，新晋捕快刀宜长（李治廷 饰）为 </div></a>
                        <div class="forum-funs icon-left">
                            <span class="forum-icon"><img src="<%=path %>/static/img/icon/jushoucang.png" style="width:20px;height:20px;"></span>
                            <span class="forum-count">(110)</span>
                        </div>
                        <div class="forum-comment icon-left">
                            <span class="forum-icon"><img src="<%=path %>/static/img/icon/xxcenter.png" style="width:20px;height:20px;"></span>
                            <span class="forum-count">(9)</span>
                        </div>
                    </div>

                    <div class="forum-box">
                        <a href="#"><span class="forum-box-title">奇门遁甲</span></a>
                        <a href="#"><div class="forum-box-content">奇幻3D巨制《奇门遁甲》由徐克监制、编剧，袁和平执导，将于2017年12月15日贺岁档震撼公映。该片讲述的是一个妖孽横行，天象大乱的时代，外星妖物侵袭而来。此时江湖上精通“奇门遁甲”之术的神秘组织“雾隐门”挺身而出，其首领老大（伍佰 饰）、弟子诸葛青云（大鹏 饰）
                            、铁蜻蜓（倪妮 饰）和雾隐七子等众人各怀所长。另一方面，诸葛青云途中寻找新一代掌门小圆（周冬雨 饰）之时，新晋捕快刀宜长（李治廷 饰）为 </div></a>
                        <div class="forum-funs icon-left">
                            <span class="forum-icon"><img src="<%=path %>/static/img/icon/jushoucang.png" style="width:20px;height:20px;"></span>
                            <span class="forum-count">(110)</span>
                        </div>
                        <div class="forum-comment icon-left">
                            <span class="forum-icon"><img src="<%=path %>/static/img/icon/xxcenter.png" style="width:20px;height:20px;"></span>
                            <span class="forum-count">(9)</span>
                        </div>
                    </div>
                    <div class="forum-box forum-left">
                        <a href="#"><span class="forum-box-title">奇门遁甲</span></a>
                        <a href="#"><div class="forum-box-content">奇幻3D巨制《奇门遁甲》由徐克监制、编剧，袁和平执导，将于2017年12月15日贺岁档震撼公映。该片讲述的是一个妖孽横行，天象大乱的时代，外星妖物侵袭而来。此时江湖上精通“奇门遁甲”之术的神秘组织“雾隐门”挺身而出，其首领老大（伍佰 饰）、弟子诸葛青云（大鹏 饰）
                            、铁蜻蜓（倪妮 饰）和雾隐七子等众人各怀所长。另一方面，诸葛青云途中寻找新一代掌门小圆（周冬雨 饰）之时，新晋捕快刀宜长（李治廷 饰）为 </div></a>
                        <div class="forum-funs icon-left">
                            <span class="forum-icon"><img src="<%=path %>/static/img/icon/jushoucang.png" style="width:20px;height:20px;"></span>
                            <span class="forum-count">(110)</span>
                        </div>
                        <div class="forum-comment icon-left">
                            <span class="forum-icon"><img src="<%=path %>/static/img/icon/xxcenter.png" style="width:20px;height:20px;"></span>
                            <span class="forum-count">(9)</span>
                        </div>
                    </div>-->

                </div>
            </div>
        </div>
    </div>
    <div class="footer-content">
        @2017 Power by 成都信息工程大学
    </div>

</body>
    <script type="text/javascript" src="<%=path %>/static/assets/jquery/jquery-3.2.0.js"></script>
    <script type="text/javascript" src="<%=path %>/static/assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="<%=path %>/static/js/home.js"></script>
</html>