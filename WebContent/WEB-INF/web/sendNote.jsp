<%@page import="com.onetoone.ssh.entity.User"%>
<%@page import="com.onetoone.ssh.entity.PostTie"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.lang.Integer"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	String path = request.getContextPath();
	User user = null;

	user = (User) session.getAttribute("myself");

	if (user == null) {
		user = new User();
	}
%>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>发帖</title>

<link rel="stylesheet"
	href="<%=path%>/static/assets/trumbowyg/design/css/trumbowyg.css">
<link rel="stylesheet"
	href="<%=path%>/static/assets/sweetalert/sweetalert.css">
<script src="<%=path%>/static/assets/sweetalert/sweetalert.min.js"></script>
<link
	href="<%=path%>/static/assets/font/download12/font_503801_6ri7xb94hdr3haor/iconfont.css"
	rel="stylesheet" style="text/css" />
<style type="text/css">
html {
	margin: 0;
	padding: 0;
	background-color: #F2F2F2;
	background: url("<%=path%>/static/img/img_001.jpg");
	font-family: "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
}

header {
	text-align: center;
}

#main {
	/*max-width: 960px;*/
	width: 70%;
	margin-left: 15%;
	margin: 0 auto;
	height: 1000px;
}

.tmp {
	width: 100%;
	height: 100px;
}

.confirm_c {
	outline: none;
	height: 50px;
	width: 60px;
	border: 0px;
	background-color: #F7F7F7;
	cursor: pointer;
}

.cancle {
	outline: none;
	height: 50px;
	width: 60px;
	border: 0px;
	background-color: #F7F7F7;
	cursor: pointer;
	margin-left: 80%;
	margin-right: 50px;
}

.title {
	width: 26%;
	margin-left: 2%;
	background-color: #E8E8E8;
	outline: none;
	color: #666;
	font-size: 14px;
	border-radius: 15px;
	height: 30px;
	border: solid thin #ccc;
}

.lib {
	width: 26%;
	margin-left: 2%;
	background-color: #E8E8E8;
	outline: none;
	color: #666;
	font-size: 14px;
	border-radius: 15px;
	height: 30px;
	border: solid thin #ccc;
}
/*a  upload */
.a-upload {
	padding: 4px 10px;
	height: 20px;
	width: 890px;
	line-height: 20px;
	position: relative;
	cursor: pointer;
	color: #888;
	margin-top: -21px;
	margin-left: 15px;
	background: #ECF0F1;
	border: 1px solid #ddd;
	border-radius: 4px;
	overflow: hidden;
	display: inline-block;
	*display: inline;
	*zoom: 1
}

.a-upload  input {
	position: absolute;
	font-size: 100px;
	right: 0;
	top: 0;
	opacity: 0;
	filter: alpha(opacity = 0);
	cursor: pointer
}

.a-upload:hover {
	color: #444;
	background: #eee;
	border-color: #ccc;
	text-decoration: none
}

#title_logo {
	color: #FFF;
	font-size: 48px;
}
</style>

</head>

<body>
	<div id="main" role="main">
		<header>

		<p id="title_logo">OneTOone</p>

		<p style="color: #FFF;">EDITOR YOUR STORY TO THE WORLD.</p>
		<br>
		<br>
		</header>
		<form name="sfrm" id="sfrm" action="<%=path%>/postSendnoteAction"
			method="post" enctype="multipart/form-data">
			<input maxlength="40" class="title" name="postTie.title" id="p_title"
				style="padding-left: 8px;" onfocus="title_foc(this.value);"
				onblur="tile_blur(this.value);" value="【标题】"> 
				<input type="hidden" name="postTie.userId" id="p_userId"
				value="${myself.id }"> <input type="hidden"
				maxlength="10000" name="postTie.content" id="p_content" value="1">
			<div id="customized-buttonpane" id="editor" class="editor"></div>
			<br> <input maxlength="40" class="lib" style="padding-left: 8px;"
				name="postTie.topic" id="p_topic" value="输入标签，用#号分隔"
				onfocus="topic_foc(this.value);" onblur="topic_blur(this.value);">
			<br> <br>
			<button type="button" class="cancle"
				style="color: #666; font-size: 20px; border-radius: 10%;" onclick="cancle();">
				取消</button>
			<button type="button" class="confirm_c"
				style="color: #666; font-size: 20px; border-radius: 10%;"
				onclick="getT();">发表</button>

		</form>
	</div>

	<script src="<%=path%>/static/assets/jquery/jquery-3.2.0.js"></script>
	<script src="<%=path%>/static/assets/jquery/jquery.form.js"></script>

	<script src="<%=path%>/static/assets/trumbowyg/trumbowyg.js"></script>

	<script src="<%=path%>/static/assets/trumbowyg/langs/fr.js"></script>
	<script src="<%=path%>/static/assets/bootstrap/js/bootstrap.js"></script>
	<script
		src="<%=path%>/static/assets/trumbowyg/plugins/upload/trumbowyg.upload.js"></script>

	<script
		src="<%=path%>/static/assets/trumbowyg/plugins/base64/trumbowyg.base64.js"></script>

	<script>
	function cancle(){
		swal({
			title:"确定退出吗？",
			type:"warning",
			showCancelButton: true,
	        closeOnConfirm: false,
	        confirmButtonText: "确认",
	        confirmButtonColor: "#134723"
		},function(){
			window.location.href="<%=path %>/getCommunicationAction"; 
			return false;
		})
		
		return true;
	}
		/** Default editor configuration **/

		$('#simple-editor').trumbowyg();

		/********************************************************

		 * Customized button pane + buttons groups + dropdowns

		 * Use upload plugin

		 *******************************************************/

		/*

		 * Add your own groups of button

		 */

		$.trumbowyg.btnsGrps.test = [ 'bold', 'link' ];

		/* Add new words for customs btnsDef just below */

		$.extend(true, $.trumbowyg.langs, {

			fr : {

				align : 'Alignement',

				image : 'Image'

			}

		});
		$('#customized-buttonpane').trumbowyg(
				{

					lang : 'fr',

					closable : true,

					fixedBtnPane : true,

					btnsDef : {

						// Customizables dropdowns

						align : {

							dropdown : [ 'justifyLeft', 'justifyCenter',
									'justifyRight', 'justifyFull' ],

							ico : 'justifyLeft'

						},

						image : {

							dropdown : [ 'upload' ],

							ico : 'insertImage'

						}

					},

					btns : [ 'viewHTML',

					'|', 'formatting',

					'|', 'btnGrp-test',

					'|', 'align',

					'|', 'btnGrp-lists'

					]

				});

		/** Simple customization with current options **/

		$('#form-content').trumbowyg({

			lang : 'fr',

			closable : true,

			mobile : true,

			fixedBtnPane : true,

			fixedFullWidth : true,

			semantic : true,

			resetCss : true,

			autoAjustHeight : true,

			autogrow : true

		});

		$('.editor').on('dblclick', function(e) {

			$(this).trumbowyg({

				lang : 'fr',

				closable : true,

				fixedBtnPane : true

			});

		});

		function getT() {
			var conn = $('.editor').trumbowyg('html');
			conn = $.trim(conn);
			if (conn == "" || conn == null){
				swal({
					title:"帖子空空的",
					text:"写点什么吧！",
					type:"info",
			        confirmButtonText: "Ok",
			        confirmButtonColor: "#134723"
				})
			} else{
				$('#p_content').val(conn);
			 	$('#sfrm').submit();
			}

			return true;
		}
	</script>
	<script type="text/javascript">
		function title_foc(con) {
			if (con == "【标题】") {
				$('#p_title').val("");
			}
		}
		function tile_blur(con) {
			if (con == "" || con == null) {
				$('#p_title').val("【标题】");
			}
		}
		function topic_foc(con) {
			if (con == "输入标签，用#号分隔") {
				$('#p_topic').val("");
			}
		}
		function topic_blur(con) {
			if (con == "" || con == null) {
				$('#p_topic').val("输入标签，用#号分隔");
			}
		}
	</script>
</body>

</html>