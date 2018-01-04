<%@page import="com.onetoone.ssh.entity.Agree"%>
<%@page import="com.onetoone.ssh.entity.User"%>
<%@page import="com.onetoone.ssh.entity.Reply"%>
<%@page import="com.onetoone.ssh.entity.Comment"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.onetoone.ssh.entity.PostTie"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<%
	//网站上所有主动的都是myself对象
	String path = request.getContextPath();
	//获取帖子下所有评论的ArrayList对象
	ArrayList<Comment> commentlist = (ArrayList<Comment>)session.getAttribute("commentlist");
	if(commentlist == null){
		commentlist=new ArrayList<Comment>();
	}
	//获取帖子下所有评论的所有回复的ArrayList对象
	ArrayList<Reply> replylist = (ArrayList<Reply>)session.getAttribute("replylist");
	if(replylist == null){
		replylist=new ArrayList<Reply>();
	}
	//通过 帖子id获取帖子对象 整合后通过session中的map对象获取    ------------T
	//Map<Integer,PostTie> tieMap = new HashMap<Integer,PostTie>();	
	//PostTie postTie = new PostTie();
	//postTie.setUserId(1);
	//postTie.setContent("林杨收到的神秘礼物原来是余周周亲自翻译的《与世界为敌》！不过这个拆礼物都能拆的一脸痴汉笑的的二傻子是谁？把我的小太阳还给我！");
	//postTie.setId(1);
	//postTie.setPicPath("");
	//postTie.setTitle("林杨收到神秘礼物");
	//postTie.setTopic("你好旧时光");
	//postTie.setAgreeNum(1);
	//postTie.setCommentNum(20);
	
	//tieMap.put(postTie.getId(),postTie);
	int tieindex = (Integer)request.getAttribute("tieindex");
	
	PostTie postTie = (PostTie)session.getAttribute("postTie");
	//整合后从session里面取当前用户   --------T
	User myself = (User)session.getAttribute("myself");
	//User myself = new User();
	//myself.setId(1);
	//myself.setFnum(12);
	//myself.setJianjie("jjjjj");
	//myself.setPassword("123");
	//myself.setPhoto("456");
	//myself.setStatus(1);
	//myself.setUsername("Tom");
	
	//提供给action 调用插入新Comment对象时需要用到当前评论的用户myuser 和当前的帖子postTie
	//session.setAttribute("myself",myself);
	//session.setAttribute("postTie",postTie);

	//提供给action 调用插入新Reply对象时需要用到当前回复用户 得到回复的用户  和当前的帖子 当前评论的对象 
	//这些对象在这个jsp页面没办法的到 只有 包含comment的集合保存在session域中和i将comment的ndex传递过去
	//可以通过comment的getUser获得需要回复的对象  当前登录用户就是添加回复的对象 当前帖子就是需要操作的帖子
	//所以将帖子对象和comment集合存入session中 传comment位置commentindex过去
	///User replyFromUser = null;
	//User replyToUser = null;
	//PostTie replyToTie = null;
	//Comment replyToCom = null;
	
	//获取当前用户点赞对象
	Agree agree = (Agree)session.getAttribute("agreeobject");
	int isAgree = 0;//0 未赞 1已赞
	if(agree != null){ //当点过赞时能从数据库取出点赞对象
		isAgree = 1;
	}
	
	
	
	
%>

<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title><%=postTie.getTitle() %>帖子详情</title>

<link rel="stylesheet"
	href="<%=path %>/static/assets/trumbowyg/design/css/trumbowyg.css">
<link rel="stylesheet" href="<%=path %>/static/css/noteDetail.css">
<link
	href="<%=path %>/static/assets/font/download12/font_503801_6ri7xb94hdr3haor/iconfont.css"
	rel="stylesheet" style="text/css" />

</head>

<body>



	<div id="main" role="main">
		<header>

		<h1>
			<!--<p class="css408AFFC97A373E36" style="font-size:40px">OneTOone</p>-->
			<img src="<%=path %>/static/img\logoSend.png">
		</h1>

		<br>
		<br>
		</header>
		<div class="user_box">
			<div class="user_pho">
				<img src="<%=path %>/static/img/user3.jpg" width="100%"
					height="100%">
			</div>
		</div>
		<div class="main_content">
			<div class="style_zs">
				<div class="style_zss_border"></div>
				<div class="style_zss">
					<sapn class="iconfont icon-zhankai12-copy"
						style="font-size:55px;color:#666;"></sapn>
				</div>
			</div>
			<div class="title_box">
				<h2><%=postTie.getTitle() %></h2>
			</div>
			<div class="content_box">
				<p>
					&nbsp;&nbsp;<%=postTie.getContent()%></p>
			</div>
			<div class="note_info_box">

				<div class="icon_box">
					<sapn class="iconfont  icon-biaoqian1" style="font-size:20px;"></sapn>
					#<%=postTie.getTopic() %></div>
				<!--  <div class="icon_box"><sapn class="iconfont  icon-xihuan1" style="font-size:20px;"></sapn>(<%=postTie.getAgreeNum() %>)</div>-->
				<div class="icon_box" id="userID">
					<span class="iconfont  icon-xihuan1"
						style="font-size: 20px; cursor: pointer;" id="userID1"
						onclick="like(1);"></span>(<input type="hidden"
						value="<%=agree==null?0:agree.getId() %>" id="toAgreeid"><span
						id="likeNum1"><%=postTie.getAgreeNum() %></span>)
				</div>
				<div class="icon_box">
					<sapn class="iconfont icon-xiaoxi1" style="font-size:20px;"></sapn>
					(<span id="commentNum"><%=postTie.getCommentNum() %></span>)
				</div>


			</div>
		</div>
		<!--styleborder-->
		<form action="#" name="com_form">
			<div id="simple-editor">
				<input type="text" name="newComment" id="comment_content" value=""
					placeholder="请输入评论,不超过50字" maxlength="50"
					style="width: 800px; height: 25px; resize: none;" /> <input
					type="hidden" value="<%=myself==null?0:myself.getId() %>"
					name="from_userid" id="from_userid" /> <input type="hidden"
					value="<%=postTie.getId() %>" name="to_tieid" id="to_tieid" /> <input
					type="hidden" value="<%=myself.getUsername() %>" name="username"
					id="from_username" /> <input type="hidden" value=""
					name="replytouser" id="replytouser" /> <input type="hidden"
					value="" name="reindex" id="reindex" /> <input type="hidden"
					value="0" name="chooseMethod" id="chooseMethod">
			</div>
		</form>
		<button class="cancle" onclick="cancelComment();">
			<sapn class="iconfont  icon-quxiao2"
				style="font-size:40px;color: #666"> <span>
		</button>
		<button class="confirm" onclick="checkCommentIsNull();checkIsLogin();">
			<sapn class="iconfont  icon-queren"
				style="font-size:27px;color: #666;"> <span>
		</button>
		<!-- T -->
		<script type="text/javascript">
     		
        </script>

		<!-- T -->
		<!-- 评论板块 -->


		<div class="comment_box">

			<% int i=0;
        	   for(Comment comment:commentlist){
        			if(i !=0){                    %>
			<hr />
			<%}
        			%>

			<div class="comment_box_circle">

				<font style="color: #141414"><%=comment.getUser().getUsername()%>:</font>
				<font style="color: #666;"><%=comment.getContent()%>&nbsp;&nbsp;&nbsp;&nbsp;<% if(!comment.getUser().getUsername().equals(myself.getUsername())){%><span
					style="color: green; cursor: pointer;"
					onclick="callIndex('<%=i%>','<%=comment.getUser().getUsername()%>');">评论</span>
					<%} %></font>

				<% for(Reply reply:replylist){ 
            			//遍历和评论id相同的回复
            			if(reply.getComment().getId() == comment.getId()){
            		%>

				<font style="color: #666;"><br />&nbsp;&nbsp;&nbsp;&nbsp;<font
					color="black"><%=reply.getGiveuser().getUsername() %>&nbsp;<font
						color="blue">回复</font>:<%=reply.getGetuser().getUsername() %></font>&nbsp;<%=reply.getContent() %>&nbsp;&nbsp;&nbsp;&nbsp;<% if(!reply.getGiveuser().getUsername().equals(myself.getUsername())){%><span
					style="color: green; cursor: pointer;"
					onclick="callIndex('<%=i %>','<%=reply.getGiveuser().getUsername()%>');">回复</span>
					<%} %></font>
				<%} 
            		   }%>

			</div>
			<%  i++;}%>

		</div>

	</div>
	<!--main-->
	<div class="foot">
		<br> <br> <br> @ONT TO ONE
	</div>

	<script type="text/javascript"
		src="<%=path %>/static/assets/jquery/jquery-3.2.0.js"></script>

	<script src="<%=path %>/static/trumbowyg/trumbowyg.js"></script>

	<script src="<%=path %>/static/trumbowyg/langs/fr.js"></script>

	<script
		src="<%=path %>/static/trumbowyg/plugins/upload/trumbowyg.upload.js"></script>

	<script
		src="<%=path %>/static/trumbowyg/plugins/base64/trumbowyg.base64.js"></script>
	<script type="text/javascript"
		src="<%=path %>/static/assets/layui/layui.js"></script>
    <script type="text/javascript" src="<%=path %>/static/assets/layui/lay/modules/layer.js"></script>
	<link rel="stylesheet" href="<%=path %>/static/assets/sweetalert/sweetalert.css" >
    <script type="text/javascript" src="<%=path %>/static/assets/sweetalert/sweetalert.min.js"></script>
	<script>
        window.onload = function(){
        	//alert("进入js");
			//设置点赞图标的初始状态 
			 if(parseInt($("#toAgreeid").val()) != 0){
             	//alert("toAgreeid:"+$("#toAgreeid").val());
             	document.getElementById("userID1").style.color = "red";
             }
             
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

            $.trumbowyg.btnsGrps.test = ['bold', 'link'];



            /* Add new words for customs btnsDef just below */

            $.extend(true, $.trumbowyg.langs, {

                fr: {

                    align: 'Alignement',

                    image: 'Image'

                }

            });

            $('#customized-buttonpane').trumbowyg({

                lang: 'fr',

                closable: true,

                fixedBtnPane: true,

                btnsDef: {

                    // Customizables dropdowns

                    align: {

                        dropdown: ['justifyLeft', 'justifyCenter', 'justifyRight', 'justifyFull'],

                        ico: 'justifyLeft'

                    },

                    image: {

                        dropdown: ['insertImage', 'upload', 'base64'],

                        ico: 'insertImage'

                    }

                },

                btns: ['viewHTML',

                    '|', 'formatting',

                    '|', 'btnGrp-test',

                    '|', 'align',

                    '|', 'btnGrp-lists',

                    '|', 'image']

            });







            /** Simple customization with current options **/

            $('#form-content').trumbowyg({

                lang: 'fr',

                closable: true,

                mobile: true,

                fixedBtnPane: true,

                fixedFullWidth: true,

                semantic: true,

                resetCss: true,

                autoAjustHeight: true,

                autogrow: true

            });









            $('.editor').on('dblclick', function(e){

                $(this).trumbowyg({

                    lang: 'fr',

                    closable: true,

                    fixedBtnPane: true

                });

            });
            function like(num)
            { 
                var str1 = "likeNum" + num;
                var str2 = "userID" + num;
                var num=document.getElementById(str1).innerText; 
                var numm=parseInt(num);
               
                
                if(document.getElementById(str2).style.color == "red"){
                	document.getElementById(str2).style.color = "gray";
                	numm=numm-1;
                	document.getElementById(str1).innerText = numm;
                	AgreeEvent(0); //触发取消赞事件
                }else{
                	document.getElementById(str2).style.color = "red";
                	numm=numm+1;
                	document.getElementById(str1).innerText = numm;
                	AgreeEvent(1);//触发点赞事件
                }
               
            }
            
        </script>
   <script type="text/javascript">
   /**
    * 
    * 处理评论 回复 点赞的ajax
    */
   		/*
   		 * 点赞 取消赞
   		 */
           function AgreeEvent(isAgree){
           	var toAgreeid = parseInt($("#toAgreeid").val());
           	var mytest={
   		            'isAgree':isAgree,       // 0 表示取消赞 1表示点赞
   		            'toAgreeid':toAgreeid     // 当帖子未被赞过时为0 赞过就是赞表里的id
   			        };
   			$.ajax({
   			        url:'commitAgree',
   			        type:'post',
   			        data:mytest,
   			        dataType:"json",
   			        success:function(data){
   			            result = data.status;
   			            if (result == 0){
   			            	swal({
								title:"已取消",
								//text:"写点什么吧！",
								type:"info",
						        //confirmButtonText: "Ok",
						        confirmButtonColor: "#134723"
							})
   			            	updateAgreeNum(0)
   			            } else if (result == 2){
   			            	swal({
								title:"操作失败",
								//text:"写点什么吧！",
								type:"info",
						        //confirmButtonText: "Ok",
						        confirmButtonColor: "#134723"
							})
   			            }else{
   			            	swal({
								title:"已点赞",
								//text:"写点什么吧！",
								type:"info",
						        //confirmButtonText: "Ok",
						        confirmButtonColor: "#134723"
							})
   			            	$("#toAgreeid").val(result);
   			            	updateAgreeNum(1);
   			            }
   			        }
   			    });
           	
           	
           }
           /*
            * 更新帖子的点赞数
            */
           function updateAgreeNum(choose){
           	
           	var mytest={
   		            'updateAn':choose  // 0 表示点赞数目减一 1表示加一
   			        };
   			$.ajax({
   			        url:'updateAgreeNum',
   			        type:'post',
   			        data:mytest,
   			        dataType:"json",
   			        success:function(data){
   			            result = data.status;
   			            if (result == 0){
   			            	// alert("操作成功！");
   			            }else{
   			            	// alert("操作失败！");
   			            }
   			        }
   			    });
           	
           }
           /*
            * 提交新评论
            */
   		function commitNewComment(){
   			var content=$("#comment_content").val(); // 获取提交的评论
   			var username=$("#from_username").val();  // 获取填写评论的用户名
   			var num = parseInt($("#commentNum").html());
   			
   			var mytest={
   			            'commentcontent':content,
   			        };
   			$.ajax({
   			        url:'commitNewComment',
   			        type:'post',
   			        data:mytest,
   			        dataType:"json",
   			        success:function(data){
   			            result = data.status;
   			            if (result == 0){
   			            	swal({
								title:"评论成功",
								//text:"写点什么吧！",
								type:"info",
						        //confirmButtonText: "Ok",
						        confirmButtonColor: "#134723"
							})
   			            	var comment_box=$(".comment_box");
   			            	var hr=$("<hr/>");
   			            	hr.appendTo(comment_box);
   			            	var div = $("<div class='comment_box_circle'><font style='color:#141414'>"+username+":</font><font style='color:#666;'>"+content+"</font></div>");
   			            	div.appendTo(comment_box);
   			            	$("#comment_content").val("");
   			            	$("#commentNum").html(num+1);
   			            } else{
   			            	
   			            	swal({
								title:"评论失败",
								//text:"写点什么吧！",
								type:"info",
						        //confirmButtonText: "Ok",
						        confirmButtonColor: "#134723"
							})
   			            }
   			        }
   			    });
   			
   		}
   		/*
   		 * 提交回复
   		 */ 
   		function commitReply(){
   			var content=$("#comment_content").val(); // 新回复的内容
   			var replytouser=$("#replytouser").val(); // replytouser的name
   			var username=$("#from_username").val(); // replyfromuser的name
   			var i = parseInt(com_form.reindex.value);
   			// alert(username+"回复关于:第"+i+"条评论"+replytouser+"回复内容为："+content);
   			var mytest={
   			            'replycontent':content,
   			            'commentindex':i
   			        };
   			$.ajax({
   			        url:'commitReply',
   			        type:'post',
   			        data:mytest,
   			        dataType:"json",
   			        success:function(data){
   			            result = data.status;
   			            if (result == 0){
   			            	swal({
								title:"回复成功",
								//text:"写点什么吧！",
								type:"info",
						        //confirmButtonText: "Ok",
						        confirmButtonColor: "#134723"
							})
   			            
   			            	var div = $(".comment_box div:eq("+i+")");
   			            	var font=$("<font style='color:#666;'><br/>&nbsp;&nbsp;&nbsp;&nbsp;<font color='black'>"+username+"&nbsp;<font color='blue'>回复</font>:"+replytouser+"</font>&nbsp;"+content+"</font>");
   	            			font.appendTo(div);
   	            			$("#comment_content").val("");
   			            	
   			            } else{
   			            	swal({
								title:"评论失败",
								//text:"写点什么吧！",
								type:"info",
						        //confirmButtonText: "Ok",
						        confirmButtonColor: "#134723"
							})
   			            }
   			        }
   			    });
   			
   			
   		}
   		/*
   		 * 检查用户是否登录 没有登录则不可以评论和回复
   		 */
       	function checkIsLogin(){ 
       		if(com_form.from_userid.value == "0"){
       			
       			swal({
					title:"抱歉！你没有登录，不可以进行评论和回复",
					//text:"写点什么吧！",
					type:"info",
			        //confirmButtonText: "Ok",
			        confirmButtonColor: "#134723"
				})
       			com_form.newComment.value = "";
       			return ; 
       		}else{
       			// 在同一个输入框输入评论和回复 判断是触发的那个事件
       			if(com_form.chooseMethod.value == "1"){ // 触发回复
       				// alert("要进入回复了");
           			// alert(com_form.reindex.value);
           			commitReply();
           			// alert("commitReply调用成功");
           			com_form.chooseMethod.value == "0"; // 触发了回复后 设置为默认触发评论
       			}else if(com_form.chooseMethod.value == "0"){
       				commitNewComment(); // 触发评论
       			}
       			
       		}
       	
       		
       		
       	}
       	/*
       	 * 检查输入的评论是否为空
       	 */
    		  
       	function checkCommentIsNull(){
       		if(com_form.newComment.value.length == 0){
       			
       			swal({
					title:"请输入评论或回复",
					//text:"写点什么吧！",
					type:"info",
			        //confirmButtonText: "Ok",
			        confirmButtonColor: "#134723"
				})
       			com_form.newComment.focus();
       		}
       		
       	}
    		 /*
    		  * 取消评论
    		  */ 
    		 function cancelComment(){
    			com_form.newComment.value = "";
    		 }
    		 /*
    		  * 为回复所需的参数设置值 并存在隐藏域里面
    		  */
    		 function callIndex(index,replytouser){
    			 com_form.reindex.value=index; // index为该条回复在第几个评论下 即第几个div下
    			 com_form.replytouser.value=replytouser; // 设置replytouser的名字，共commitReply使用
    			 com_form.chooseMethod.value="1"; // 设置为触发回复事件
    			 // alert(index+"\t"+replytouser);
    			 com_form.newComment.focus();
    			 com_form.newComment.value="";
    		 }

           
   </script>

</body>

</html>