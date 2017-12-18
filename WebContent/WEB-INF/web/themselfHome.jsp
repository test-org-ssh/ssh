<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>USER</title>
	<link rel="stylesheet" href="">
	<link href="<%=path %>/static/css/themselfHome.css" rel="stylesheet" style="text/css"/>
	<link href="<%=path %>/static/css/communication.css" rel="stylesheet" style="text/css"/>
	<link href="<%=path %>/static/assets/font/download12/font_503801_6ri7xb94hdr3haor/iconfont.css" rel="stylesheet" style="text/css"/>

</head>
<%
	String path = request.getContextPath();
%>
<body>
	<div id ="BOX">
	<div id="main_box">
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
                         <a href="film_list.html"><li>&nbsp;影视</li></a>
                         <a href="communication.html"><li>论坛</li></a>
                         <li><a href="myself.html" style="color:#ccc;">个人中心</a></li>
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
<!--backPIC_boxback_tmp-->
    <div class="backPIC_box">
            <div class="back_tmp"></div>
            <div class="back_pic"><div class="back_pic_l"><div class="back_pic_l_p"><img src="<%=path %>/static/img\user.jpg" width="100%" height="100%"></div></div></div>
            <div class="back_name"><div class="back_name_n">USER</div></div>
            <div class="back_sign"><div class="back_sign_s">I WANT TO A CAT,AND U?</div></div>
            <div class="back_follow"><div class="back_follow_f">
                <span class="iconfont icon-yiguanzhu2" style="font-size:28px;color:#333;margin-left:40px;"></span>
                <span class="iconfont icon-shouye1" style="font-size:28px;color:#333;margin-left:50px;"></span>
            </div></div>
            
     </div>
<!--backPIC_box-->
<!--sendnote-->
        <div class="show_sendNote_box">
            <div class="myNote_box" id="myNote_box"><!--my sentnote-->
                       <div class="myNote_box_header">
                            <sapn class="iconfont icon-zhankai12-copy" style="font-size:46px;color:#3565C4;"><pn>
                        </div>
                        <div class="sent_circle_box"><!--sent_circle_box-->
                            <div class="sent_circle_style">
                                <sapn class="iconfont icon-accessory" style="font-size:30px;color:#3565C4;"><pn>
                            </div>
                            <div class="sent_circle_title">【TITLE】</div>
                            <div class="sent_circle_content">【THIS IS CONTENT】I like to see movies so much. When I have time, I spend most of the spared time on watching actually, they are wrong. Watching movies is a good way to broaden our vision. A good movie always shows something about culture or social problems</div>
                            <div class="sent_circle_info">
                                <div class="sent_circle_info_icon"><sapn class="iconfont  icon-biaoqian1" style="font-size:17px;"><span>#安利空</div>
                                <div class="sent_circle_info_icon"><sapn class="iconfont  icon-xihuan1" style="font-size:17px;"><span>(11)</div>
                                <div class="sent_circle_info_icon"><sapn class="iconfont icon-xiaoxi1" style="font-size:17px;margin-left: -20px;"><span>(23)</div>

                            </div>
                            <div class="sent_circle_time">2017/08/20&nbsp;&nbsp;</div>

                        </div><!--sent_circle_box-->
                       
                        <div class="sent_circle_box"><!--sent_circle_box-->
                            <div class="sent_circle_style">
                                <sapn class="iconfont icon-accessory" style="font-size:30px;color:#3565C4;"><pn>
                            </div>
                            <div class="sent_circle_title">【TITLE】</div>
                            <div class="sent_circle_content">【THIS IS CONTENT】I like to see movies so much. When I have time, I spend most of the spared time on  movie always shows something about culture or social problems</div>
                           <div class="sent_circle_info">
                                <div class="sent_circle_info_icon"><sapn class="iconfont  icon-biaoqian1" style="font-size:17px;"><span>#安利空</div>
                                <div class="sent_circle_info_icon"><sapn class="iconfont  icon-xihuan1" style="font-size:17px;"><span>(11)</div>
                                <div class="sent_circle_info_icon"><sapn class="iconfont icon-xiaoxi1" style="font-size:17px;margin-left: -20px;"><span>(23)</div>

                            </div>
                            <div class="sent_circle_time">2017/08/20&nbsp;&nbsp;</div>

                        </div><!--sent_circle_box-->
                        
                        <div class="sent_circle_box"><!--sent_circle_box-->
                            <div class="sent_circle_style">
                                <sapn class="iconfont icon-accessory" style="font-size:30px;color:#3565C4;"><span>
                            </div>
                            <div class="sent_circle_title">【TITLE】</div>
                            <div class="sent_circle_content">【THIS IS CONTENT】I like to see movies so much. When I have time, I spend most of the spared time on watching classic movies.  amusement, actually social problems</div>
                            <div class="sent_circle_info">
                                <div class="sent_circle_info_icon"><sapn class="iconfont  icon-biaoqian1" style="font-size:17px;"><span>#安利空</div>
                                <div class="sent_circle_info_icon"><sapn class="iconfont  icon-xihuan1" style="font-size:17px;"><span>(11)</div>
                                <div class="sent_circle_info_icon"><sapn class="iconfont icon-xiaoxi1" style="font-size:17px;margin-left: -20px;"><span>(23)</div>

                            </div>
                            <div class="sent_circle_time">2017/08/20&nbsp;&nbsp;</div>

                        </div><!--sent_circle_box-->
                        
                    </div><!--my sentnote-->
                    <div class="next_page">
                        <sapn class="iconfont  icon-xiayiye1" style="font-size:37px;color: #666"><span>
                    </div>
        </div>
 <!--sendnote-->
    <div class="foot_box"></div>
</div><!--mainbox--></div><!--box-->

</body>
</html>