<%@page import="com.onetoone.ssh.entity.Agree"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.onetoone.ssh.entity.User"%>
<%@page import="com.onetoone.ssh.entity.PostTie"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.lang.Integer"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>论坛</title>
<%
	String path = request.getContextPath();

	User user = null;

	List<PostTie> posttiemap = (List<PostTie>) session.getAttribute("posttiemap");
	List<User> usermap = (List<User>) session.getAttribute("usermap");
	List<Agree> agreelist = (List<Agree>)session.getAttribute("agreelist");

	user = (User) session.getAttribute("myself");

	if (posttiemap == null) {
		posttiemap = new ArrayList<PostTie>();
	}
	if (usermap == null) {
		usermap = new ArrayList<User>();
	}
	if (agreelist == null){
		agreelist = new ArrayList<Agree>();
	}
	if (user == null) {
		user = new User();
	}
	int sss = usermap.size();
%>
<link href="<%=path%>/static/css/communication.css" rel="stylesheet"
	style="text/css" />
<link
	href="<%=path%>/static/assets/font/download12/font_503801_6ri7xb94hdr3haor/iconfont.css"
	rel="stylesheet" style="text/css" />

</head>

<body>

	<div id="BOX">

		<div id="nav_box">
			<div class="nav_box">
				<div class="logo_box">
					<a href="<%=path%>/Index"><img
						src="<%=path%>/static/img/logo.png"></a>
				</div>
				<div class="titile_box">
					<div class="title">
						<ul>
							<li><span class="iconfont icon-shouye3"
								style="font-size: 36px"></span></li>
							<li><span class="iconfont icon-yingshi2"
								style="font-size: 36px"></span></li>
							<li><span class="iconfont icon-luntan"
								style="font-size: 36px"></span></li>
							<li><span class="iconfont icon-gerenzhongxin"
								style="font-size: 36px"></span></li>
						</ul>
					</div>
					<div class="title2">
						<ul>
							<li>&nbsp;首页</li>
							<a href="film_list.html"><li>&nbsp;影视</li></a>
							<a href="communication.html" style="color: #ccc;"><li>论坛</li></a>
							<li><a href="myself.html">个人中心</a></li>
						</ul>
					</div>

				</div>
				<div class="searchbox">
					<form action="<%=path%>/LikePostTieAction" method="post" name="likefrm" id="likefrm">
						<div class="search_boxfor_Three">
							<div class="three_right">
								<span class="iconfont icon-search"
									style="font-size: 28px; cursor: pointer;" onclick="getlikept();"></span>
							</div>
							<div class="three_input">
								<input type="text" name="liketitle" id="search_input"
									class="serach_input" style="padding-left: 8px;"
									placeholder="搜索" />
							</div>
						</div>
					</form>
					<div class="zc_search_box">
						<a href="register.html"><span class="iconfont icon-zhuce-"
							style="font-size: 20px;"></span> 注册 
					</div>
					</a>
				</div>
			</div>
			<!--classnav_box-->
			<div class="login_search_box">
				<a href="login.html"><span class="iconfont icon-denglu-copy"
					style="font-size: 24px"></span>登录 
			</div>
			</a>
			<!--login-->
		</div>
		<!--底部发帖div-->
		<div class="nav_b"></div>
		<div class="sidebar_box">
			<div id="sendText_box">
				<a href="<%=path%>/getSendnoteAction" target="_blank"><span
					class="iconfont icon-shuxie" style="font-size: 52px"></span></a>
			</div>
			<div id="returntop_box">
				<a href="javascript:returnTop();"><span
					class="iconfont icon-fanhuidingbu" style="font-size: 46px"></span></a>
			</div>
		</div>
		<div id="main_box">
			<!--main-->
			<div id="color_box">


				<!--circle-->
				<%
					for (int i = posttiemap.size() - 1; i >= 0; i--) {
						int ff = 0;
				%>
				<div class="white"></div>
				<div class="circle_box">
					<div class="circle_left_box">
						<div class="user_PHO">
							<%
								for (int j = 0; j < usermap.size(); j++) {
										if (usermap.get(j).getId() == posttiemap.get(i).getUserId()) {
							%>
							<img style="width: 100px; height: 100px;" alt="用户头像"
								src="<%=path%><%=usermap.get(j).getPhoto()%>" /> jiadhiahdiahsi
							<%
								}
									}
							%>
						</div>
					</div>
					<div class="circle_right_box">
						<div class="position_main_box_L">
							<div class="style_icon">
								<span class="iconfont icon-arrows-10-2" style="font-size: 36px"></span>
							</div>
							<div class="style_border"></div>
						</div>
						<div class="position_main_box">
							<div class="white">
								<div class="white_style_border">
									<div class="white_icon">
										<span class="iconfont icon-shuqian"
											style="font-size: 36px; color: #9393FF"></span>
									</div>
								</div>
							</div>
							<div class="content_title">
								【<%=posttiemap.get(i).getTitle()%>】
							</div>
							<div class="content_box"><%=posttiemap.get(i).getContent()%></div>
							<div class="do_box">
								<div class="next_box">
									<div class="next_icon">
										<i class="iconfont icon-zhankai1" style="font-size: 35x;"></i>
									</div>
									<div class="next_txt"><a href="<%=path %>/NoteDetail?tieid=<%=posttiemap.get(i).getId()%>&tieindex=<%=i%>" target="">详情</a></div>
								</div>
								<div class="lib_box">
									<span class="iconfont icon-biaoqian1" style="font-size: 20px;"></span>#安利君#
								</div>
								<%
								for (int k=0; k<agreelist.size(); k++){
									%>
									<input type="hidden" id="kk" name="kk" value="<%=agreelist.get(k).getId()%>">
									<%if ((agreelist.get(k).getPostTie().getId() == posttiemap.get(i).getId()) && (agreelist.get(k).getUser().getId() == user.getId()) && (ff == 0)){
										ff = 1;
										%>
										<div class="icon_box" id="userID">
											<span class="iconfont  icon-xihuan1"
										style="font-size: 20px; cursor: pointer; color:red" id="userID<%=posttiemap.get(i).getId()%>"
										onclick="like(<%=posttiemap.get(i).getId()%>);"></span> (<span id="likeNum<%=posttiemap.get(i).getId()%>"><%=posttiemap.get(i).getAgreeNum()%></span>)
										</div>
										<%
									} %>
									
								
									<%
								}%>
								<%if (ff == 0){
										ff = 1;
										%>
										<div class="icon_box" id="userID">
											<span class="iconfont  icon-xihuan1"
										style="font-size: 20px; cursor: pointer;"id="userID<%=posttiemap.get(i).getId()%>"
										onclick="like(<%=posttiemap.get(i).getId()%>);"></span> (<span id="likeNum<%=posttiemap.get(i).getId()%>"><%=posttiemap.get(i).getAgreeNum()%></span>)
										</div>
										<%
									} %>
								<div class="icon_box">
								<a href="<%=path %>/NoteDetail?tieid=<%=posttiemap.get(i).getId()%>&tieindex=<%=i%>" target="_blank">
									<i class="iconfont icon-xiaoxi1"
										style="font-size: 20px; cursor: pointer;"></i></a>(<%=posttiemap.get(i).getCommentNum()%>)
								</div>
							</div>

						</div>
						<div class="position_main_box_R"></div>
					</div>
				</div>

				<%
					}
				%>
				<%-- <c:out value="${m.title }"></c:out>
				
					
					<div class="circle_right_box">
						<div class="position_main_box_L">
							<div class="style_icon">
								<span class="iconfont icon-arrows-10-2" style="font-size: 36px"></span>
							</div>
							<div class="style_border"></div>
						</div>
						<div class="position_main_box">
							<div class="white">
								<div class="white_style_border">
									<div class="white_icon">
										<span class="iconfont icon-shuqian"
											style="font-size: 36px; color: #9393FF"></span>
									</div>
								</div>
							</div>
								<div class="content_title">【${m.title }】</div>
								<div class="content_box">${m.content }</div>
								<div class="do_box">
								<div class="next_box">
									<div class="next_icon">
										<i class="iconfont icon-zhankai1" style="font-size: 35x;"></i>
									</div>
									<div class="next_txt">详情</div>
								</div>
								<div class="lib_box">
									<span class="iconfont icon-biaoqian1" style="font-size: 20px;"></span>#安利君#
								</div>
								<div class="icon_box">
									<i class="iconfont icon-xiaoxi1" style="font-size: 20px; cursor: pointer;"></i>(${m.commentNum })
								</div>
								<div class="icon_box" id="userID">
									<span class="iconfont  icon-xihuan1" style="font-size: 20px; cursor: pointer;"
										id="userID1" onclick="like(1);"></span> (<span id="likeNum1">${m.agreeNum }</span>)
								</div>

							</div>
							
						</div>
						<div class="position_main_box_R"></div>
					</div>
			
				</c:forEach> --%>
			</div>
			<!--main-->
		</div>
		<!--color-->
		<div class="foot_box"></div>
		<!--foot-->
	</div>
	<!--BOX-->
	<script src="<%=path%>/static/assets/jquery/jquery-3.2.0.js"></script>
	<script>
		var sdelay = 0;
		function returnTop() {
			window.scrollBy(0, -2000);//Only for y vertical-axis
			if (document.body.scrollTop > 0) {
				sdelay = setTimeout('returnTop()', 2);
			}
		}
		function like(num) {
		/* 	alert(num); */
			var op = 0; 
			var kk = $('#kk').val();
			var ptmapid = num;
			// 操作，取消赞还是点赞
		/* 	alert(num);
			alert(kk); */
			//num为帖子id
			var str1 = "likeNum" + num;
			var str2 = "userID" + num;
			if (document.getElementById(str2).style.color == "red"){
				document.getElementById(str2).style.color = "#000";
				var num = document.getElementById(str1).innerText;
				var numm = parseInt(num) - 1;
				op = 1;
				document.getElementById(str1).innerText = numm;
			} else {
				document.getElementById(str2).style.color = "red";
				var num = document.getElementById(str1).innerText;
				var numm = parseInt(num) + 1;
				op = 0;
				document.getElementById(str1).innerText = numm;
			}
			 var mytest={
			            'op':op,
			            'kk':kk,
			            'ptmapid':ptmapid,
			        };
			$.ajax({
		        url:'checkAgreeAction',
		        type:'post',
		        data:mytest,
		        dataType:"json",
		        success:function(data){
		           alert("成功!");
		        }
		    });
		}
		function sear_foc(con) {
			if (con == "搜索") {
				$('#search_input').val("");
			}

			return;
		}
		function sear_blur(con) {
			if (con == "" || con == null) {
				$('#search_input').val("搜索");
			}
		}
		function getlikept(){
			$('#likefrm').submit();
		}
	</script>
</body>
</html>
