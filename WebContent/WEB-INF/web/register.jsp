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
</head>

<body>
<div class="wrapper">
    <form name="frm" method="POST" action="<%=path %>/postRegisterAction" class="login">
        <p class="title">Register</p>
        <input name="userform.username" type="text" placeholder="Username" autofocus/>
        <i class="fa fa-user"></i>
        <input name="userform.password" type="password" placeholder="Password" value=""/>
        <i class="fa fa-key"></i>
        <input name="userform.confirm" type="password" placeholder="Repeat password" />
        <i class="fa fa-key"></i>
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
$('#register').onclick=function(){
	$('frm').submit();
};
</script>
</body>
</html>