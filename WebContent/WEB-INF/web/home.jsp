<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<%
	String path = request.getContextPath();
%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<head>
    <meta charset="UTF-8">
    <title>OneTOone首页</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/home.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/static/assets/bootstrap/css/bootstrap.min.css">
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
                        <img src="${pageContext.request.contextPath }/static/img/ban_2.jpg" alt="First slide">
                    </div>
                    <div class="item">
                        <img src="${pageContext.request.contextPath }/static/img/ban_1.jpg" alt="Second slide">
                    </div>
                    <div class="item">
                        <img src="${pageContext.request.contextPath }/static/img/ban_3.jpg" alt="Third slide">
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
                    <a href="${pageContext.request.contextPath }/getLoginAction" target="_blank"><button class="btn">Login</button></a>
                </div>
                <div class="register">
                    <a href="${pageContext.request.contextPath }/getRegisterAction" target="_blank"><button class="btn">Register</button></a>
                </div>
            </div>
        </div>
    </div>
    <div id="nav-content">
        <div class="anchor_layer" id="navHeight">
            <div class="nav_wrap" id="nav_wrap">
                <div class="wrap_layer">
                    <div class="wrap_tab"><a class="tab active" href="${pageContext.request.contextPath }/Index">Home</a></div>
                    <div class="wrap_tab"><a class="tab" href="${pageContext.request.contextPath }/FilmList" target="_blank">影视</a></div>
                    <div class="wrap_tab"><a class="tab" href="${pageContext.request.contextPath }/getCommunicationAction">论坛</a></div>
                    <div class="wrap_tab last_wrap_tab"><a class="tab" href="${pageContext.request.contextPath }/getMyselfAction">个人中心</a></div>
                </div>
            </div>
        </div>
    </div>
                        
                        
    <div id="main-content" >
        <img class="futures_bg" src="${pageContext.request.contextPath }/static/img/icon__slack.svg" width="1620" height="1620">
        <div class="main-wrap">
            <div class="film-content">
                <div class="film-title">
                    Film sharing
                </div>
                <div class="film-wrap">
                	<s:iterator value="#filmDaoList" status="bcs" begin="0" end="5">
               			<div class="film-box">
                			<div class="film-box-img">
                				<a href="${pageContext.request.contextPath }/gotoFilmDetail?filmindex=${bcs.index}" target="_blank"> <img src="${pageContext.request.contextPath }<s:property value="picPath"></s:property>"></a>
                			</div>
                			<div class="film-box-word">
                            	<a href="${pageContext.request.contextPath }/gotoFilmDetail?filmindex=${bcs.index}" target="_blank"><span class="film-box-word-name"><s:property value="name"></s:property></span></a>
                            	<span class="film-box-word-grade">评分：<s:property value="score"></s:property></span>
                        	</div>
                		</div>
                	</s:iterator>
                </div>
            </div>

            <div class="forum-content">
                <div class="forum-title">
                    Hot topic
                </div>
                <div class="forum-wrap">
                	<s:iterator value="#postTieList" status="bcs" begin="0" end="3">
                		
                		<div class="forum-box forum-left">
	                        <a href="${pageContext.request.contextPath }/NoteDetail?tieid=<s:property value="id"></s:property>&tieindex=${bcs.index}" target="_blank"><span class="forum-box-title"><s:property value="title"></s:property></span></a>
	                        <a href="${pageContext.request.contextPath }/NoteDetail?tieid=<s:property value="id"></s:property>&tieindex=${bcs.index}" target="_blank"><div class="forum-box-content"><s:property value="content"></s:property> </div></a>
	                        
	                        <div class="forum-funs icon-left">
	                            <span class="forum-icon"><img src="${pageContext.request.contextPath }/static/img/icon/jushoucang.png" style="width:20px;height:20px;"></span>
	                            <span class="forum-count">(<s:property value="agreeNum"></s:property>)</span>
	                        </div>
	                        <div class="forum-comment icon-left">
	                            <span class="forum-icon"><a href="${pageContext.request.contextPath }/NoteDetail?tieid=<s:property value="id"></s:property>&tieindex=${bcs.index}"><img src="${pageContext.request.contextPath }/static/img/icon/xxcenter.png" style="width:20px;height:20px;"></a></span>
	                            <span class="forum-count">(<s:property value="commentNum"></s:property>)</span>
	                        </div>
	                    </div>
                	</s:iterator>

                </div>
            </div>
        </div>
    </div>
    <div class="footer-content">
        @2017 Power by 成都信息工程大学
    </div>

</body>
    <script type="text/javascript" src="${pageContext.request.contextPath }/static/assets/jquery/jquery-3.2.0.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/static/assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath }/static/js/home.js"></script>
</html>