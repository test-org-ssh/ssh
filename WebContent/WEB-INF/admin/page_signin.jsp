<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	String path = request.getContextPath();
%>
<head>
<meta charset="UTF-8">
<title>OneTOone登录</title>
<!--<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,700' rel='stylesheet' type='text/css'>-->
<link rel="stylesheet"
	href="<%=path%>/static/assets/font-awesome-4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="<%=path%>/static/assets/normalize/normalize.min.css">
<link href='<%=path%>/static/css/login.css' rel='stylesheet'
	type='text/css'>
<link href="<%=path %>/static/assets/font/download/font_503801_bot9w7zulk3s1yvi/iconfont.css" rel="stylesheet" style="text/css"/>
</head>

<body>
	<div class="wrapper">
		<form id="frm" name="frm" method="POST" action="<%=path%>/postLoginAdminAction"
			class="login">
			<p class="title">Login</p>
			<input name="userform.username" id="username" type="text"
				placeholder="Username" onBlur="checkName(this.value);" maxlength="14" autofocus />
			<i class="fa fa-user"></i> 
			<span class="username_tip" style="color:#666;font-size:14px;"></span>   
			<input name="userform.password" id="password" type="password"
				placeholder="Password" maxlength="16"/> 
			<i class="fa fa-key"></i> 
			<span class="password_tip" style="color:#666;font-size:14px;"></span>
        	<a href="#"></a>
			<button type="button" style="cursor: pointer;" onclick="beginLogin(this.value);">
				<i class="spinner"></i> <span class="state">Login</span>
			</button>
		</form>

		<div style="text-align: center; clear: both; margin-top: 80px">
			<!--<script src="/gg_bd_ad_720x90.js" type="text/javascript"></script>
<script src="/follow.js" type="text/javascript"></script>-->
		</div>

		</p>
	</div>
	<script src="<%=path%>/static/assets/jquery/jquery-3.2.0.js"></script>

	<%--     <script  src="<%=path %>/static/js/login.js"></script> --%>
	<script type="text/javascript">
		function checkName(userName) {
			if ($.trim(userName).length == 0) {
				$(".username_tip").html("<span class='iconfont icon-brush password_p' style='color:#666;font-size:18px;'></span>...请输入用户名");
				return;
			} else {
				$(".username_tip").html("");
			}
			return true;
		}
		function beginLogin(btn){
			alert("进来");
			var username=$('#username').val();
			var password = $('#password').val();
			var res1 = checkName(username);
			if (password.length == 0){
				$('.password_tip').html("<span class='iconfont icon-brush password_p' style='color:#666;font-size:18px;'></span>...密码错误，请重新输入");
				
			} else {
				$('.password_tip').html("");
			}
			var mytest = {
					'username' : $('#username').val(),
					'password' : $('#password').val(),
				};
			alert($('#username').val());
			$.ajax({
				url : 'checkPwd2',
				type : 'post',
				data : mytest,
				dataType : "json",
				success : function(data) {
					res = data.status;
					if (res == 0) {
						$('.password_tip').html("<span class='iconfont icon-brush password_p' style='color:#666;font-size:18px;'></span>...密码错误，请重新输入<br/>");
						return false;
					} else {
						$('#frm').submit();
						$('.password_tip').html("");
						return true;
					}
				}
			});
		};
	</script>
</body>
</html>