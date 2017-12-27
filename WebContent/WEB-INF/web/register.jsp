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
        <input name="userform.username" id="username" type="text" placeholder="Username" onBlur="checkName(this.value);" autofocus/>
        <i class="fa fa-user"></i>
        <span class="username_tip"></span>
        <input name="userform.password" id="password" type="password" placeholder="Password" value=""/>
        <i class="fa fa-key"></i>
        <span class="password_tip"></span>
        <input name="userform.confirm" id="confirm" type="password" placeholder="Repeat password" />
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
            //有时候感觉接受的数据总是显示各种乱七八糟的错误，你可以先alert看下，传回的是什么东西
            alert(data);
            //随便的显示一下传回的数据喽
            var backdata=JSON.parse(data); //传回的是json字符串，要先把它转换成js中的类对象，对于json字符串和json对象自己去百度
            $('#username_tip').html(backdata.backusername);
        }
    });
}

$('#register').onclick=function(){
	$('frm').submit();
};
</script>
</body>
</html>