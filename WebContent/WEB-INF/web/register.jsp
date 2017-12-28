<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<%
	String path = request.getContextPath();
%>
<head>
    <meta charset="UTF-8">
    <title>OneTOone注册</title>
    <!--<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,700' rel='stylesheet' type='text/css'>-->
    <link rel="stylesheet" href="<%=path %>/static/assets/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="<%=path %>/static/assets/normalize/normalize.min.css">
    <link href='<%=path %>/static/css/register.css' rel='stylesheet' type='text/css'>
	<style type="text/css">
	.username_tip,.password_tip,.confirm_tip{
		float:left;
		color:white;
		opacity:0.5;
		background-color: red;
	}
	</style>
</head>

<body>
<div class="wrapper">
    <form name="frm" id="frm" method="POST" action="<%=path %>/postRegisterAction" class="login">
        <p class="title">Register</p>
        <input name="userform.username" id="username" type="text" placeholder="Username" onBlur="checkName(this.value);" maxlength="7" autofocus/>
        <i class="fa fa-user"></i>
        <span class="username_tip"></span>
        <input name="userform.password" id="password" type="password" placeholder="Password" onBlur="checkPwd(this.value);" value=""/>
        <i class="fa fa-key"></i>
        <span class="password_tip"></span>
        <input name="userform.confirm" id="confirm" type="password" placeholder="Repeat" onBlur="checkConfirm(this.value);" value=""/>
        <i class="fa fa-key"></i>
        <span class="confirm_tip"></span>
        <button id="register">
        <!--     <i class="spinner"></i> -->
            <span><!--  class="state" -->Register</span>
        </button>
    </form>

    <div style="text-align:center;clear:both;margin-top:80px">
        <!--<script src="/gg_bd_ad_720x90.js" type="text/javascript"></script>
        <script src="/follow.js" type="text/javascript"></script>-->
    </div>

    </p>
</div>
<script src="<%=path %>/static/assets/jquery/jquery-3.2.0.js"></script>
<!-- 这个JS给注释了，提交不成功——王海雪 -->
<%-- <script  src="<%=path %>/static/js/register.js"></script> --%>
<script type="text/javascript">
function checkName(userName) {
    if ($.trim(userName).length == 0) {
        $(".username_tip").html("请输入用户名");
        return;
    } else{
    	$(".username_tip").html("");
    }
    var mytest={
            'username':$('#username').val(),
        };
    $.ajax({
        url:'checkName',
        type:'post',
        data:mytest,
        dataType:"json",
        success:function(data){
            res = data.status;
            if (res != 0){
            	$('.username_tip').html("用户名已存在");	
            } else{
            	$('.username_tip').html("");
            }
        }
    });
}
function checkPwd(pwd) {
    if ($.trim(pwd).length == 0) {
        $(".password_tip").html("密码不能为空");
        return;
    } else{
    	$(".password_tip").html("");
    }
}
function checkConfirm(pwd2) {
	pwd1 = $('#password').val();
	alert("pwd1"+pwd1);
    if ($.trim(pwd2).length == 0) {
        $(".confirm_tip").html("两次密码不一样");
        return;
    }
    if($.trim(pwd2) != pwd1){
    	
    	 $(".confirm_tip").html("密码不一样");
    	 return;
    }else{
    	$(".confirm_tip").html("");
    }
}
$('#register').onclick=function(){
	username=$('#username').val();
	if ($.trim(userName).length == 0) {
        $(".username_tip").html("请输入用户名");
        return;
    }
	pwd = $('#password').val();
	if ($.trim(pwd).length == 0) {
        $(".password_tip").html("密码不能为空");
        return;
    }
	pwd1 = $('#password').val();
	alert("pwd1"+pwd1);
	if ($.trim(pwd2).length == 0) {
        $(".confirm_tip").html("两次密码不一样");
        return;
    }
	else if($.trim(pwd2) != pwd1){
    	
    	 $(".confirm_tip").html("密码不一样");
    	 return;
    }
	$('#frm').submit();
};
</script>
</body>
</html>