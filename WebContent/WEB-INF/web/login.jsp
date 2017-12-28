<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<%
	String path = request.getContextPath();
%>
<head>
  <meta charset="UTF-8">
  <title>OneTOone登录</title>
  <!--<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,700' rel='stylesheet' type='text/css'>-->
<link rel="stylesheet" href="<%=path %>/static/assets/font-awesome-4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="<%=path %>/static/assets/normalize/normalize.min.css">
<link href='<%=path %>/static/css/login.css' rel='stylesheet' type='text/css'>
</head>

<body>
  <div class="wrapper">
  <form name="frm" method="POST" action="<%=path %>/postLoginAction"  class="login">
    <p class="title">Log in</p>
    <input name="userform.username" id="username" type="text" placeholder="Username" onBlur="checkName(this.value);" autofocus/>
    <i class="fa fa-user"></i>
	<span class="username_tip"></span>   
    <input  name="userform.password" id="password" type="password" placeholder="Password" />
    <i class="fa fa-key"></i>
    <span class="password_tip"></span>
    <a href="#">Forgot your password?</a>
    <button>
      <i class="spinner"></i>
      <span class="state">Log in</span>
    </button>
  </form>

 <div style="text-align:center;clear:both;margin-top:80px">
<!--<script src="/gg_bd_ad_720x90.js" type="text/javascript"></script>
<script src="/follow.js" type="text/javascript"></script>-->
</div>

  </p>
</div>
  <script src="<%=path %>/static/assets/jquery/jquery-3.2.0.js"></script>

<%--     <script  src="<%=path %>/static/js/login.js"></script> --%>
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
            if (res == 0){
            	$('.username_tip').html("该用户不存在");	
            } else{
            	$('.username_tip').html("");
            }
        }
    });
}
/* function slogin(userName) {
    var mytest={
            'username':$('#username').val(),
            'password':$('#password').val(),
        };
    $.ajax({
        url:'checkPwd',
        type:'post',
        data:mytest,
        dataType:"json",
        success:function(data){
            res = data.status;
            if (res == 0){
            	$('.username_tip').html("密码错误");	
            } else{
            	$('frm').submit();
            }
        }
    });
} */
</script>
</body>
</html>