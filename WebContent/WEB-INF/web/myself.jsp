<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人中心</title>
<%
	String path = request.getContextPath();
%>
<link href="<%=path %>/static/css/myself.css" rel="stylesheet" style="text/css"/>

<link href="<%=path %>/static/assets/font/download/font_503801_bot9w7zulk3s1yvi/iconfont.css" rel="stylesheet" style="text/css"/>
<script src="<%=path %>/static/js/jquery.min.js" type="text/javascript"></script>

</head>

<body>

<div id ="BOX">
	<div id="main_box">
    <div id="nav_box"> 
    	<div class="nav_box">
            <div class="logo_box">
            	<!--<p class="css408AFFC97A373E36" style="font-size:40px">OneTOone</p>-->
                <img src="img\logo.png">
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
                     	<li>&nbsp;首页</li>
                        <li>&nbsp;影视</li>
                        <li><a href="communication.html" style="color:#ccc;">论坛</a></li>
                     	<li>个人中心</li>
                     </ul>
                </div>
                
            </div>
            <div class="searchbox">
            	<div class="search_boxfor_Three">
                    <div class="three_right"><span class="iconfont icon-search" style="font-size:28px;"></span></div>
                    <div class="three_input"><input type="text" value="搜索" class="serach_input" /></div>   
                </div>
             	<div class="zc_search_box"><span class="iconfont icon-zhuce-" style="font-size:20px;"></span> 注册</div>
            </div>         
       </div><!--classnav_box-->
       <div class="login_search_box"><span class="iconfont icon-denglu-copy" style="font-size:24px"></span>登录</div> <!--login-->
    </div><!--idnav_box-->
    <div class="nav_b"> </div>
     <!--body-->
        <div class="backPIC_box"><!--backPIC_boxback_tmp-->
            <div class="back_tmp"></div>
            <div class="back_pic"><div class="back_pic_l"><div class="back_pic_l_p"><img src="img\user.jpg" width="100%" height="100%"></div></div></div>
            <div class="back_name"><div class="back_name_n">USER</div></div>
            <div class="back_sign"><div class="back_sign_s">I WANT TO A CAT,AND U?&nbsp;&nbsp;<sapn class="iconfont icon-shuxie2" style="font-size: 24px;"></sapn></div></div>
            
        </div><!--backPIC_box-->
        <div class="sidebar_float_box"><!--sidebar_float_box-->
            <div class="sidebar_boxL"><!--sidebar_boxL-->
                    <div class="change_side_box" onclick="change()">
                        <div class="side_select_tmp"></div>
                        <div class="side_select_box">
                            <p>
                            <sapn class="iconfont icon-xiugai1" style="font-size: 30px;"></sapn>&nbsp;EDIT
                        </div>

                    </div>
                    <div class="following_side_box" onclick="follow()">
                        <div class="side_select_tmp"></div>
                        <div class="side_select_box">
                            <p><sapn class="iconfont icon-guanzhu6" style="font-size: 26px;"></sapn>&nbsp;FOLLOW
                        </div>
                    </div>
                    <div class="note_side_box" onclick="note()">
                        <div class="side_select_tmp"></div>
                        <div class="side_select_box">
                           <p> <sapn class="iconfont icon-tiezi1" style="font-size: 22px;"></sapn>&nbsp;SENT
                        </div>
                    </div>
                    <div class="like_side_box" onclick="like()">
                        <div class="side_select_tmp"></div>
                        <div class="side_select_box">
                            <p><sapn class="iconfont icon-xihuan" style="font-size: 22px;color:#D96767;"></sapn>&nbsp;LIKED
                        </div>
                    </div>
                    <div class="fans_side_box" onclick="fans()">
                        <div class="side_select_tmp"></div>
                        <div class="side_select_box">
                            <p><sapn class="iconfont icon-fensi2" style="font-size: 34px;"></sapn>FANS
                        </div>
                    </div>
                    <div class="fans_side_box"><!--other-->
                        <div class="side_select_tmp"></div>
                        <div class="side_select_box">
                            <p><sapn class="iconfont icon-LOGO" style="font-size: 34px;"></sapn>OTHER
                        </div>
                    </div>
            </div> <!--sidebar_boxL-->
            <div class="div_box"><!--div_box-->
                    <div class="myNote_box" id="myNote_box"><!--my sentnote-->
                       <div class="myNote_box_header">
                            <sapn class="iconfont icon-zhankai12-copy" style="font-size:46px;color:#3565C4;"></sapn>
                        </div>
                        <div class="sent_circle_box"><!--sent_circle_box-->
                            <div class="sent_circle_style">
                                <sapn class="iconfont icon-accessory" style="font-size:30px;color:#3565C4;"></sapn>
                            </div>
                            <div class="sent_circle_title">【TITLE】</div>
                            <div class="sent_circle_content">【THIS IS CONTENT】I like to see movies so much. When I have time, I spend most of the spared time on watching actually, they are wrong. Watching movies is a good way to broaden our vision. A good movie always shows something about culture or social problems</div>
                            <div class="sent_circle_info">
                                <div class="icon_box"><sapn class="iconfont  icon-biaoqian1" style="font-size:20px;"></sapn>#安利君</div>
                                <div class="icon_box"><sapn class="iconfont  icon-xihuan1" style="font-size:20px;"></sapn>(11)</div>
                                <div class="icon_box"><sapn class="iconfont icon-xiaoxi1" style="font-size:20px;"></sapn>(23)</div>

                            </div>
                            <div class="sent_circle_time">2017/08/20&nbsp;&nbsp;</div>

                        </div><!--sent_circle_box-->
                       
                        <div class="sent_circle_box"><!--sent_circle_box-->
                            <div class="sent_circle_style">
                                <sapn class="iconfont icon-accessory" style="font-size:30px;color:#3565C4;"></sapn>
                            </div>
                            <div class="sent_circle_title">【TITLE】</div>
                            <div class="sent_circle_content">【THIS IS CONTENT】I like to see movies so much. When I have time, I spend most of the spared time on  movie always shows something about culture or social problems</div>
                            <div class="sent_circle_info">
                                <div class="icon_box"><sapn class="iconfont  icon-biaoqian1" style="font-size:20px;"></sapn>#安利君</div>
                                <div class="icon_box"><sapn class="iconfont  icon-xihuan1" style="font-size:20px;"></sapn>(11)</div>
                                <div class="icon_box"><sapn class="iconfont icon-xiaoxi1" style="font-size:20px;"></sapn>(23)</div>

                            </div>
                            <div class="sent_circle_time">2017/08/20&nbsp;&nbsp;</div>

                        </div><!--sent_circle_box-->
                        
                        <div class="sent_circle_box"><!--sent_circle_box-->
                            <div class="sent_circle_style">
                                <sapn class="iconfont icon-accessory" style="font-size:30px;color:#3565C4;"></sapn>
                            </div>
                            <div class="sent_circle_title">【TITLE】</div>
                            <div class="sent_circle_content">【THIS IS CONTENT】I like to see movies so much. When I have time, I spend most of the spared time on watching classic movies.  amusement, actually social problems</div>
                            <div class="sent_circle_info">
                                <div class="icon_box"><sapn class="iconfont  icon-biaoqian1" style="font-size:20px;"></sapn>#安利君</div>
                                <div class="icon_box"><sapn class="iconfont  icon-xihuan1" style="font-size:20px;"></sapn>(11)</div>
                                <div class="icon_box"><sapn class="iconfont icon-xiaoxi1" style="font-size:20px;"></sapn>(23)</div>

                            </div>
                            <div class="sent_circle_time">2017/08/20&nbsp;&nbsp;</div>

                        </div><!--sent_circle_box-->
                        
                    </div><!--my sentnote-->
                    <div class="likedNote_box" id="likedNote_box"><!--liked notes copy from mysentnote-->
                        <div class="myNote_box_header">
                            <sapn class="iconfont icon-zhankai12-copy" style="font-size:46px;color:#C93553;"></sapn>
                        </div>
                        <div class="sent_circle_box"><!--sent_circle_box-->
                            <div class="sent_circle_style">
                                <sapn class="iconfont icon-accessory" style="font-size:30px;color:#C93553;"></sapn>
                            </div>
                            <div class="sent_circle_title">【TITLE】</div>
                            <div class="sent_circle_content">【THIS IS CONTENT】I like to see movies so much. When I have time, I spend most of the spared time on watching actually, they are wrong. Watching movies is a good way to broaden our vision. A good movie always shows something about culture or social problems</div>
                            <div class="sent_circle_info">
                                <div class="icon_box"><sapn class="iconfont  icon-biaoqian1" style="font-size:20px;"></sapn>#安利君</div>
                                <div class="icon_box"><sapn class="iconfont  icon-xihuan1" style="font-size:20px;"></sapn>(11)</div>
                                <div class="icon_box"><sapn class="iconfont icon-xiaoxi1" style="font-size:20px;"></sapn>(23)</div>

                            </div>
                            <div class="sent_circle_time">2017/08/20&nbsp;&nbsp;</div>

                        </div><!--sent_circle_box-->
                       
                        <div class="sent_circle_box"><!--sent_circle_box-->
                            <div class="sent_circle_style">
                                <sapn class="iconfont icon-accessory" style="font-size:30px;color:#C93553;"></sapn>
                            </div>
                            <div class="sent_circle_title">【TITLE】</div>
                            <div class="sent_circle_content">【THIS IS CONTENT】I like to see movies so much. When I have time, I spend most of the spared time on  movie always shows something about culture or social problems</div>
                            <div class="sent_circle_info">
                                <div class="icon_box"><sapn class="iconfont  icon-biaoqian1" style="font-size:20px;"></sapn>#安利君</div>
                                <div class="icon_box"><sapn class="iconfont  icon-xihuan1" style="font-size:20px;"></sapn>(11)</div>
                                <div class="icon_box"><sapn class="iconfont icon-xiaoxi1" style="font-size:20px;"></sapn>(23)</div>

                            </div>
                            <div class="sent_circle_time">2017/08/20&nbsp;&nbsp;</div>

                        </div><!--sent_circle_box-->
                        
                        <div class="sent_circle_box"><!--sent_circle_box-->
                            <div class="sent_circle_style">
                                <sapn class="iconfont icon-accessory" style="font-size:30px;color:#C93553;"></sapn>
                            </div>
                            <div class="sent_circle_title">【TITLE】</div>
                            <div class="sent_circle_content">【THIS IS CONTENT】I like to see movies so much. When I have time, I spend most of the spared time on watching classic movies.  amusement, actually social problems</div>
                            <div class="sent_circle_info">
                                <div class="icon_box"><sapn class="iconfont  icon-biaoqian1" style="font-size:20px;"></sapn>#安利君</div>
                                <div class="icon_box"><sapn class="iconfont  icon-xihuan1" style="font-size:20px;"></sapn>(11)</div>
                                <div class="icon_box"><sapn class="iconfont icon-xiaoxi1" style="font-size:20px;"></sapn>(23)</div>

                            </div>
                            <div class="sent_circle_time">2017/08/20&nbsp;&nbsp;</div>

                        </div><!--sent_circle_box-->
                    </div><!--liked notes copy from mysentnote-->
                    <div class="change_box" id="change_box"><!--change_box-->
                        <div class="change_style">
                            <sapn class="iconfont icon-zhankai12-copy" style="font-size:46px;color:#C6C6C6;"></sapn>
                        </div>
                        <div class="change_pho_box">
                            <div class="user_pho">
                                <br><br><br><br><br><br>
                                <sapn class="iconfont icon-xiangji" style="font-size:29px;color:#333;margin-right:10px;"></sapn>
                            </div>
                            <div class="change_text">
                                <br><br><br><br>
                                PHOTO
                            </div>
                        </div>
                        <div class="change_name_box">
                            <input value="USER" type="text"><span style="margin-left:350px;">NAME</span>
                        </div>
                        <div class="change_sign_box">
                             <input value="SIGN FOR LIFE" type="text"><span style="margin-left:200px;">SIGN</span>
                        </div>
                        <div class="change_sex_box">
                            <input id="man" type="radio" checked="checked" name="1" style="width: 15px;height:15px;"/>男
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <input id="woman" type="radio" name="1" style="width: 15px;height:15px;"/>女
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <input id="no" type="radio" name="1" style="width: 15px;height:15px;"/>保密
                            <span style="margin-left: 300px;">SEX</span>
                        </div>
                        <div class="commit"><button type="">
                            <span class="iconfont icon-baocun1" style="font-size: 45px;color: #333"></span></button>
                        </div>

                    </div><!--change_box-->
                    <div class="followingPeo_box" id="following"><!--followingPeo_box-->
                        <div class="follow_header_style">
                             <sapn class="iconfont icon-zhankai12-copy" style="font-size:46px;color:#E8C516;"></sapn>
                        </div>
                        <div class="follow_circle"><!--follow_circle-->
                            <div class="follow_pho"><img src="img\user4.jpg" width="100%" height="100%"></div>
                            <div class="follow_info">
                                <br>&nbsp;&nbsp;
                                LAYI
                                <br><br>&nbsp;&nbsp;
                                 what U need  what U need  what U need 
                            </div>
                            <div class="follow_status">
                                <br>
                                <sapn class="iconfont icon-yiguanzhu2" style="font-size:30px;color:#666;margin-right:10px;"></sapn>
                               
                            </div>
                        </div><!--follow_circle-->
                         <div class="follow_circle"><!--follow_circle-->
                            <div class="follow_pho"><img src="img\user1.jpg" width="100%" height="100%"></div>
                            <div class="follow_info">
                                <br>&nbsp;&nbsp;
                                LAYI
                                <br><br>&nbsp;&nbsp;
                                 what U need  what U need  what U need 
                            </div>
                            <div class="follow_status">
                                <br>
                                <sapn class="iconfont icon-yiguanzhu2" style="font-size:30px;color:#666;margin-right:10px;"></sapn>
                              
                            </div>
                        </div><!--follow_circle-->
                         <div class="follow_circle"><!--follow_circle-->
                            <div class="follow_pho"><img src="img\user3.jpg" width="100%" height="100%"></div>
                            <div class="follow_info">
                                <br>&nbsp;&nbsp;
                                LAYI
                                <br><br>&nbsp;&nbsp;
                                 what U need  what U need  what U need 
                            </div>
                            <div class="follow_status">
                                <br>
                                <sapn class="iconfont icon-yiguanzhu2" style="font-size:30px;color:#666;margin-right:10px;"></sapn>
                               
                            </div>
                        </div><!--follow_circle-->
                         <div class="follow_circle"><!--follow_circle-->
                            <div class="follow_pho"><img src="img\user2.jpg" width="100%" height="100%"></div>
                            <div class="follow_info">
                                <br>&nbsp;&nbsp;
                                LAYI
                                <br><br>&nbsp;&nbsp;
                                 what U need  what U need  what U need 
                            </div>
                            <div class="follow_status">
                                <div class="follo_status_gz" id="follo_status_gz2" onclick="follogz(2);">
                                  <sapn class="iconfont icon-guanzhu10" style="font-size:30px;color:#666;"></sapn>
                                </div>
                                <div class="follo_status_ygz" id="follo_status_ygz2" onclick="folloygz(2);">
                                  <sapn class="iconfont icon-yiguanzhu2" style="font-size:30px;color:#666;"></sapn>
                                </div>
                            </div>
                        </div><!--follow_circle-->
                         <div class="follow_circle"><!--follow_circle-->
                            <div class="follow_pho"><img src="img\user2.jpg" width="100%" height="100%"></div>
                            <div class="follow_info">
                                <br>&nbsp;&nbsp;
                                LAYI
                                <br><br>&nbsp;&nbsp;
                                 what U need  what U need  what U need 
                            </div>
                            <div class="follow_status">
                                <div class="follo_status_gz" id="follo_status_gz1" onclick="follogz(1);">
                                  <sapn class="iconfont icon-guanzhu10" style="font-size:30px;color:#666;"></sapn>
                                </div>
                                <div class="follo_status_ygz" id="follo_status_ygz1" onclick="folloygz(1);">
                                  <sapn class="iconfont icon-yiguanzhu2" style="font-size:30px;color:#666;"></sapn>
                                </div>
                            </div>
                        </div><!--follow_circle-->
                    </div><!--followingPeo_box-->
                    <div class="fans_box" id="fans_box"><!--fansboxcopy from follow-->
                         <div class="fans_header_style">
                            <sapn class="iconfont icon-zhankai12-copy" style="font-size:46px;color:#FFB2B2;"></sapn>
                        </div>
                       <div class="fans_circle"><!--fans_circle-->
                            <div class="fans_pho"><img src="img\user4.jpg" width="100%" height="100%"></div>
                            <div class="fans_info">
                                <br>&nbsp;&nbsp;
                                LAYI
                                <br><br>&nbsp;&nbsp;
                                 what U need  what U need  what U need 
                            </div>
                           <div class="fans_status">
                                <div class="fans_status_gz" id="fans_status_gz5" onclick="fansgz(5);">
                                  <sapn class="iconfont icon-guanzhu10" style="font-size:30px;color:#666;"></sapn>
                                </div>
                                <div class="fans_status_ygz" id="fans_status_ygz5" onclick="fansygz(5);">
                                  <sapn class="iconfont icon-yiguanzhu2" style="font-size:30px;color:#666;"></sapn>
                                </div>
                            </div>
                        </div><!--fans_circle-->
                        <div class="fans_circle"><!--fans_circle-->
                            <div class="fans_pho"><img src="img\user4.jpg" width="100%" height="100%"></div>
                            <div class="fans_info">
                                <br>&nbsp;&nbsp;
                                LAYI
                                <br><br>&nbsp;&nbsp;
                                 what U need  what U need  what U need 
                            </div>
                           <div class="fans_status">
                                <div class="fans_status_gz" id="fans_status_gz4" onclick="fansgz(4);">
                                  <sapn class="iconfont icon-guanzhu10" style="font-size:30px;color:#666;"></sapn>
                                </div>
                                <div class="fans_status_ygz" id="fans_status_ygz4" onclick="fansygz(4);">
                                  <sapn class="iconfont icon-yiguanzhu2" style="font-size:30px;color:#666;"></sapn>
                                </div>
                            </div>
                        </div><!--fans_circle-->
                        <div class="fans_circle"><!--fans_circle-->
                            <div class="fans_pho"><img src="img\user4.jpg" width="100%" height="100%"></div>
                            <div class="fans_info">
                                <br>&nbsp;&nbsp;
                                LAYI
                                <br><br>&nbsp;&nbsp;
                                 what U need  what U need  what U need 
                            </div>
                           <div class="fans_status">
                                <div class="fans_status_gz" id="fans_status_gz3" onclick="fansgz(3);">
                                  <sapn class="iconfont icon-guanzhu10" style="font-size:30px;color:#666;"></sapn>
                                </div>
                                <div class="fans_status_ygz" id="fans_status_ygz3" onclick="fansygz(3);">
                                  <sapn class="iconfont icon-yiguanzhu2" style="font-size:30px;color:#666;"></sapn>
                                </div>
                            </div>
                        </div><!--fans_circle-->
                        <div class="fans_circle"><!--fans_circle-->
                            <div class="fans_pho"><img src="img\user4.jpg" width="100%" height="100%"></div>
                            <div class="fans_info">
                                <br>&nbsp;&nbsp;
                                LAYI
                                <br><br>&nbsp;&nbsp;
                                 what U need  what U need  what U need 
                            </div>
                           <div class="fans_status">
                                <div class="fans_status_gz" id="fans_status_gz2" onclick="fansgz(2);">
                                  <sapn class="iconfont icon-guanzhu10" style="font-size:30px;color:#666;"></sapn>
                                </div>
                                <div class="fans_status_ygz" id="fans_status_ygz2" onclick="fansygz(2);">
                                  <sapn class="iconfont icon-yiguanzhu2" style="font-size:30px;color:#666;"></sapn>
                                </div>
                            </div>
                        </div><!--fans_circle-->
                         <div class="fans_circle"><!--fans_circle-->
                            <div class="fans_pho"><img src="img\user4.jpg" width="100%" height="100%"></div>
                            <div class="fans_info">
                                <br>&nbsp;&nbsp;
                                LAYI
                                <br><br>&nbsp;&nbsp;
                                 what U need  what U need  what U need 
                            </div>
                           <div class="fans_status">
                                <div class="fans_status_gz" id="fans_status_gz1" onclick="fansgz(1);">
                                  <sapn class="iconfont icon-guanzhu10" style="font-size:30px;color:#666;"></sapn>
                                </div>
                                <div class="fans_status_ygz" id="fans_status_ygz1" onclick="fansygz(1);">
                                  <sapn class="iconfont icon-yiguanzhu2" style="font-size:30px;color:#666;"></sapn>
                                </div>
                            </div>
                        </div><!--fans_circle-->

                    </div><!--fansbox copyfrom follow-->
            </div><!--div_box-->
        </div><!--sidebar_float_box-->
        <div class="foot_box">
            
        </div>
     <!--body-->
  
   </div><!--mainbox--></div><!--box-->

<script  type="text/javascript" >
     function status_change(e){    
        if(!e){    
          var e = window.event;    
        }    
        //获取事件点击元素    
        var targ = e.target;    
        //获取元素名称    
      //  var tname = targ.attr("id"); 
      // alert("tname");    
        //var id = $(e.target).attr("id");
       // alert($(e.target).next().attr("id")); 
        $(e.target).css("display", "none"); 
        $(e.target).next().css("display", "block"); 

      }   
       
         function status_ygz(e){    
        if(!e){    
          var e = window.event;    
        }    
        //获取事件点击元素    
        var targ = e.target;    
         confirm("确定取消关注?");
         if(confirm("确定取消关注?")){
            $(e.target).css("display", "none"); 
        //alert($(e.target).prev().attr("id"))
        $(e.target).prev().css("display", "block"); 

       $(e.target).prev().append("<sapn>关注</sapn>"); 
       $(e.target).prev().firstChild().addClass("iconfont icon-guanzhu10");
       $(e.target).prev().firstChild().css({"color":"#666","font-size":"30px"});
         
         }


      }   
</script>
<script type="text/javascript">

function change(){
    document.getElementById('change_box').style.display='block'; 
    document.getElementById('myNote_box').style.display='none';
    document.getElementById('likedNote_box').style.display='none';
    document.getElementById('following').style.display='none';
    document.getElementById('fans_box').style.display='none';
}
function follow(){
    document.getElementById('following').style.display='block';
    document.getElementById('change_box').style.display='none';
     document.getElementById('myNote_box').style.display='none';
    document.getElementById('likedNote_box').style.display='none';
    document.getElementById('fans_box').style.display='none';
}
function like(){
    document.getElementById('following').style.display='none';
    document.getElementById('change_box').style.display='none';
     document.getElementById('myNote_box').style.display='none';
    document.getElementById('likedNote_box').style.display='block';
    document.getElementById('fans_box').style.display='none';
}

function note(){
    document.getElementById('following').style.display='none';
    document.getElementById('change_box').style.display='none';
     document.getElementById('myNote_box').style.display='block';
    document.getElementById('likedNote_box').style.display='none';
    document.getElementById('fans_box').style.display='none';
}
function fans(){
    document.getElementById('fans_box').style.display='block';
    document.getElementById('following').style.display='none';
    document.getElementById('change_box').style.display='none';
    document.getElementById('myNote_box').style.display='none';
    document.getElementById('likedNote_box').style.display='none';
}
 function fansgz(num)
            {
                var str1 = "fans_status_gz" + num;
                var str2 ="fans_status_ygz" +num;
                document.getElementById(str1).style.display = 'none';
                document.getElementById(str2).style.display = 'block';
            }

function fansygz(num)
            {
                var str1 = "fans_status_gz" + num;
                var str2 ="fans_status_ygz" +num;
                document.getElementById(str1).style.display = 'block';
                document.getElementById(str2).style.display = 'none';
            }

function follogz(num)
{
    var str1 = "follo_status_gz" + num;
    var str2 ="follo_status_ygz" +num;
    document.getElementById(str1).style.display = 'none';
    document.getElementById(str2).style.display = 'block';
}

function folloygz(num)
{
    var str1 = "follo_status_gz" + num;
    var str2 ="follo_status_ygz" +num;
    document.getElementById(str1).style.display = 'block';
    document.getElementById(str2).style.display = 'none';
}
</script>

</body>
</html>
