<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>论坛</title>
<link href="<%=path %>/static/css/communication.css" rel="stylesheet" style="text/css"/>
<link href="<%=path %>/static/assets/font/download12/font_503801_6ri7xb94hdr3haor/iconfont.css" rel="stylesheet" style="text/css"/>

</head>
<%
	String path = request.getContextPath();
%>
<body>

<div id ="BOX">
	
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
                        <a href="communication.html" style="color:#ccc;"><li>论坛</li></a>
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
    <div class="sidebar_box">
        	<div id="sendText_box">
                <a href="sendNote.html" target="_blank"><span class="iconfont icon-shuxie" style="font-size:52px"></span></a>
            </div>
            <div id="returntop_box"><a href="javascript:returnTop();"><span class="iconfont icon-fanhuidingbu" style="font-size:46px"></span></a></div>
        </div>
    <div id="main_box"><!--main--><div id="color_box">
    
    	
    <!--circle--> 
        <div class="white"></div>
        <div class="circle_box">
        	<div class="circle_left_box">
            	<div class="user_PHO">PHOTO</div>
            </div>
            <div class="circle_right_box">
            	 <div class="position_main_box_L">
                 	<div class="style_icon"><span class="iconfont icon-arrows-10-2" style="font-size:36px"></span></div>
                    <div class="style_border"></div>
                 </div>
                <div class="position_main_box">
                    <div class="white">
                    	<div class="white_style_border">
                        	<div class="white_icon"><span class="iconfont icon-shuqian" style="font-size:36px;color:#9393FF"></span></div>
                        </div>
                    </div>
                    <div class="content_title">【THIS IS CONTENT TITLE】</div>
                    <div class="content_box">【THIS IS CONTENT 】<p>I like to see movies so much. When I have time, I spend most of the spared time on watching classic movies. Though some people believe that it is a waste of time to spend time on this amusement, actually, they are wrong. Watching movies is a good way to broaden our vision. A good movie always shows something about culture or social problems, so as to catch more people’s attention and help them to think about the problem. We can perceive the world through excellent movies. When culture shock happens, we will considerate what we always believe is right needs to be changed. Our viewpoint about the world gets improved and helps us to be a better man. Reading books may be boring for some people, while watching movie is a fun way to gain knowledge. </div>
                    <div class="do_box">
                        <div class="next_box">
                             
                            <div class="next_icon"><i class="iconfont icon-zhankai1" style="font-size:35x;"></i></div>
                            <div class="next_txt">详情</div>
                           
                            
                        </div>
                        <div class="lib_box"><span class="iconfont icon-biaoqian1" style="font-size:20px;"></span>#安利君#</div>
                        <div class="icon_box"><i class="iconfont icon-xiaoxi1" style="font-size:20px;"></i>(9)</div>
                        <div class="icon_box"><i class="iconfont  icon-xihuan1" style="font-size:20px;"></i>(110)</div>
                        
                    </div>
                </div>
                <div class="position_main_box_R"></div>
            </div>
        </div>
        <!--circle-->
        <div class="circle_box">
        	<div class="circle_left_box">
            	<div class="user_PHO">PHOTO</div>
            </div>
            <div class="circle_right_box">
            	 <div class="position_main_box_L">
                 	<div class="style_icon"><span class="iconfont icon-arrows-10-2" style="font-size:36px"></span></div>
                    <div class="style_border"></div>
                 </div>
                <div class="position_main_box">
                    <div class="white">
                    	<div class="white_style_border">
                        	<div class="white_icon"><span class="iconfont icon-shuqian" style="font-size:36px;color:#9393FF"></span></div>
                        </div>
                    </div>
                    <div class="content_title">【THIS IS CONTENT TITLE】</div>
                    <div class="content_box">【THIS IS CONTENT 】<p>I like to see movies so much. When I have time, I spend most of the spared time on watching classic movies. Though some people believe that it is a waste of time to spend time on this amusement, actually, they are wrong. Watching movies is a good way to broaden our vision. A good movie always shows something about culture or social problems, so as to catch more people’s attention and help them to think about the problem. We can perceive the world through excellent movies. When culture shock happens, we will considerate what we always believe is right needs to be changed. Our viewpoint about the world gets improved and helps us to be a better man. Reading books may be boring for some people, while watching movie is a fun way to gain knowledge. </div>
                    <div class="do_box">
                        <div class="next_box">
                             
                            <div class="next_icon"><i class="iconfont icon-zhankai1" style="font-size:35x;"></i></div>
                            <div class="next_txt">详情</div>
                           
                            
                        </div>
                        <div class="lib_box"><span class="iconfont icon-biaoqian1" style="font-size:20px;"></span>#安利君#</div>
                        <div class="icon_box"><i class="iconfont icon-xiaoxi1" style="font-size:20px;"></i>(9)</div>
                        <div class="icon_box"><i class="iconfont  icon-xihuan1" style="font-size:20px;"></i>(110)</div>
                        
                    </div>
                </div>
                <div class="position_main_box_R"></div>
            </div>
        </div>
        <!--circle--> 
        <div class="white"></div>
        <!--circle-->
        <div class="circle_box">
        	<div class="circle_left_box">
            	<div class="user_PHO">PHOTO</div>
            </div>
            <div class="circle_right_box">
            	 <div class="position_main_box_L">
                 	<div class="style_icon"><span class="iconfont icon-arrows-10-2" style="font-size:36px"></span></div>
                    <div class="style_border"></div>
                 </div>
                <div class="position_main_box">
                    <div class="white">
                    	<div class="white_style_border">
                        	<div class="white_icon"><span class="iconfont icon-shuqian" style="font-size:36px;color:#9393FF"></span></div>
                        </div>
                    </div>
                    <div class="content_title">【THIS IS CONTENT TITLE】</div>
                    <div class="content_box">【THIS IS CONTENT 】<p>I like to see movies so much. When I have time, I spend most of the spared time on watching classic movies. Though some people believe that it is a waste of time to spend time on this amusement, actually, they are wrong. Watching movies is a good way to broaden our vision. A good movie always shows something about culture or social problems, so as to catch more people’s attention and help them to think about the problem. We can perceive the world through excellent movies. When culture shock happens, we will considerate what we always believe is right needs to be changed. Our viewpoint about the world gets improved and helps us to be a better man. Reading books may be boring for some people, while watching movie is a fun way to gain knowledge. </div>
                    <div class="do_box">
                        <div class="next_box">
                             
                            <div class="next_icon"><i class="iconfont icon-zhankai1" style="font-size:35x;"></i></div>
                            <div class="next_txt">详情</div>
                           
                            
                        </div>
                        <div class="lib_box"><span class="iconfont icon-biaoqian1" style="font-size:20px;"></span>#安利君#</div>
                        <div class="icon_box"><i class="iconfont icon-xiaoxi1" style="font-size:20px;"></i>(9)</div>
                        <div class="icon_box"><i class="iconfont  icon-xihuan1" style="font-size:20px;"></i>(110)</div>
                        
                    </div>
                </div>
                <div class="position_main_box_R"></div>
            </div>
        </div>
        <!--circle-->
        
     </div><!--main--></div><!--color-->
        <div class="foot_box"></div> <!--foot-->
</div><!--BOX-->

<script>
var sdelay=0;
function returnTop() {
 window.scrollBy(0,-2000);//Only for y vertical-axis
 if(document.body.scrollTop>0) { 
  sdelay= setTimeout('returnTop()',2);
 }
}
</script>
</body>
</html>
