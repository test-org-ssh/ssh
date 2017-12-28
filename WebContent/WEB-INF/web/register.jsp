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
    <link href="<%=path %>/static/assets/font/download/font_503801_bot9w7zulk3s1yvi/iconfont.css" rel="stylesheet" style="text/css"/>
	<script src="<%=path %>/static/assets/jquery/jquery-3.2.0.js"></script>
	<script type="text/javascript" src="<%=path %>/static/js/availdate-v1.0.2.js"></script>
</head>

<body>
<div class="wrapper">
    <form name="frm" id="frm" method="POST" action="<%=path %>/postRegisterAction" class="login">
        <p class="title">Register</p>
        <input name="userform.username" id="username" type="text" placeholder="Username" onBlur="checkName(this.value);" maxlength="14" autofocus/>
        <i class="fa fa-user"></i>
        <span class="iconfont icon-brush username_p" style="color:#666;font-size:18px;">...</span>
        <span class="username_tip" style="color:#666;font-size:14px;">最长14个英文或7个汉字</span>
        <input name="userform.password" id="password" type="password" placeholder="Password" onBlur="checkPwd(this.value);" value=""/>
        <i class="fa fa-key"></i>
        <span class="iconfont icon-brush password_p" style="color:#666;font-size:18px;">...</span>
        <span class="password_tip" style="color:#666;font-size:14px;">长度为8-16个字符</span>
        <input name="userform.confirm" id="confirm" type="password" placeholder="Repeat" onBlur="checkConfirm(this.value);" value=""/>
        <i class="fa fa-key"></i>
        <span class="confirm_tip" style="color:#666;font-size:14px;"></span>
        <button id="register" type="button" style="cursor: pointer;" onclick="beginReg(this.value);">
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
<!-- 这个JS给注释了，提交不成功——王海雪 -->
<%-- <script  src="<%=path %>/static/js/register.js"></script> --%>
<script type="text/javascript">
// 验证用户名
function checkName(userName) {
	var str = $.trim(userName);// 获取输入框用户名
	var len = 0;	// 输入用户名的长度
	var regzn = new RegExp("^[\u4e00-\u9fa5]*$");
	var regen = new RegExp("^[a-z]|[A-Z]$");
    if (str.length == 0) {
    	$(".username_p").html("...");
        $(".username_tip").html("用户名不能为空");
        return false;
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
            	$('#username').val("");
            	$('.username_tip').html("用户名已存在");	
            	return false;
            } else{
            	for(var i=0;i<str.length;i++){
                	var ck = str.charAt(i);
                	if (regzn.test(ck)){
                		len += 2;
                	} else if(regen.test(ck)){
                		len += 1;
                	} else {
                		$("#username").val("");
                		$(".username_p").html("...");
                		$(".username_tip").html("请输入中文或英文用户名");
                		return false;
                	}
                }
                if (len>14){
                	$("#username").val("");
                	$(".username_p").html("...");
                	$(".username_tip").html("不能超过14个字母或7个汉字");
                	return false;
                } else{
                	$(".username_p").html("");
                	$(".username_tip").html("用户名可用 √");
                	return true;
                }
            }
        }
    });
    /* else{
    	$(".username_tip").html("");
    } */
    return true;
}
function checkPwd(pwd) {
	pwd = $.trim(pwd);
    if (pwd.length == 0) {
    	$(".password_p").html("...");
        $(".password_tip").html("密码不能为空");
        return false;
    } else if(pwd.length<8 || pwd.length>16){
    	$(".password_p").html("...");
        $(".password_tip").html("请输入8-16位密码");
        return false;
    }else{
    	$(".password_p").html("");
    	$(".password_tip").html("密码合法 √");
    	return true;
    }
    return true;
}
function checkConfirm(pwd2) {
	pwd1 = $('#password').val();
    if ($.trim(pwd2).length == 0) {
        $(".confirm_tip").html("");
        return false;
    }
    if($.trim(pwd2) != pwd1){
    	 $("#confirm").val("");
    	 $(".confirm_tip").html("密码不一样");
    	 return false;
    }else{
    	$(".confirm_tip").html("");
    	return true;
    }
    return true;
}
function beginReg(btn){
	var username=$('#username').val();
	var password = $('#password').val();
	var confirm = $('#confirm').val();
	var res1 = checkName(username);
	var res2 = checkPwd(password);
	var res3 = checkConfirm(confirm);
	if (res1 && res2 && res3){
		$('#frm').submit();
	}
};
</script>
</body>
</html>