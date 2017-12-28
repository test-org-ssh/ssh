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
	//通过 帖子id获取帖子对象 整合后通过session中的map对象获取
	Map<Integer,PostTie> tieMap = new HashMap<Integer,PostTie>();	
	PostTie postTie = new PostTie();
	postTie.setUserId(1);
	postTie.setContent("林杨收到的神秘礼物原来是余周周亲自翻译的《与世界为敌》！不过这个拆礼物都能拆的一脸痴汉笑的的二傻子是谁？把我的小太阳还给我！");
	postTie.setId(1);
	postTie.setPicPath("");
	postTie.setTitle("林杨收到神秘礼物");
	postTie.setTopic("你好旧时光");
	postTie.setAgreeNum(0);
	postTie.setCommentNum(3);
	
	tieMap.put(postTie.getId(),postTie);
	

	


%>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title><%=postTie.getTitle() %>帖子详情</title>

        <link rel="stylesheet" href="<%=path %>/static/assets/trumbowyg/design/css/trumbowyg.css">
        <link rel="stylesheet" href="<%=path %>/static/css/noteDetail.css">
       <link href="<%=path %>/static/assets/font/download12/font_503801_6ri7xb94hdr3haor/iconfont.css" rel="stylesheet" style="text/css"/>

    </head>

    <body>
        


        <div id="main" role="main">
            <header>

                <h1><!--<p class="css408AFFC97A373E36" style="font-size:40px">OneTOone</p>-->
                	<img src="<%=path %>/static/img\logoSend.png">
                </h1>
            
                <br>
                <br>
            </header>
        <div class="user_box">
        	<div class="user_pho"><img src="<%=path %>/static/img\user3.jpg" width="100%" height="100%"></div>
        </div>
        <div class="main_content">
		<div class="style_zs">
			<div class="style_zss_border"></div>
			<div class="style_zss">
			 <sapn class="iconfont icon-zhankai12-copy" style="font-size:55px;color:#666;"></sapn>
			</div>
		</div>
		<div class="title_box">
			<h2><%=postTie.getTitle() %></h2>
		</div>
		<div class="content_box">
			
<!--
                    <p>

                        Lorem ipsum dolor sit amet, consectetur adipisicing elit. Possimus, aliquam, minima fugiat placeat provident optio nam reiciendis eius beatae quibusdam!

                    </p>

                    <p>

                        The text is derived from Cicero's De Finibus Bonorum et Malorum (On the Ends of Goods and Evils, or alternatively [About] The Purposes of Good and Evil ). The original passage began: Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit (Translation: &quot;Neither is there anyone who loves grief itself since it is grief and thus wants to obtain it&quot;).

                    </p>
                     <p>

                        The text is derived from Cicero's De Finibus Bonorum et Malorum (On the Ends of Goods and Evils, or alternatively [About] The Purposes of Good and Evil ). The original passage began: Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit (Translation: &quot;Neither is there anyone who loves grief itself since it is grief and thus wants to obtain it&quot;).

                    </p>
                     <p>

                        The text is derived from Cicero's De Finibus Bonorum et Malorum (On the Ends of Goods and Evils, or alternatively [About] The Purposes of Good and Evil ). The original passage began: Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit (Translation: &quot;Neither is there anyone who loves grief itself since it is grief and thus wants to obtain it&quot;).

                    </p>
                     <p>

                        The text is derived from Cicero's De Finibus Bonorum et Malorum (On the Ends of Goods and Evils, or alternatively [About] The Purposes of Good and Evil ). The original passage began: Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit (Translation: &quot;Neither is there anyone who loves grief itself since it is grief and thus wants to obtain it&quot;).

                    </p>  -->
                    <p><%=postTie.getContent()%></p>
		</div>
			<div class="note_info_box">
				
                        <div class="icon_box"><sapn class="iconfont  icon-biaoqian1" style="font-size:20px;"></sapn>#<%=postTie.getTopic() %>></div>
                        <div class="icon_box"><sapn class="iconfont  icon-xihuan1" style="font-size:20px;"></sapn>(<%=postTie.getAgreeNum() %>>)</div>
                        <div class="icon_box"><sapn class="iconfont icon-xiaoxi1" style="font-size:20px;"></sapn>(<%=postTie.getCommentNum() %>)</div>

                           
			</div>
		</div><!--styleborder-->
            <form action="#">
                
                <div id="simple-editor">

					输入评论
                </div>
                
            </form>
    		<button type="" class="cancle"><sapn class="iconfont  icon-quxiao2" style="font-size:42px;color: #666"><span></button> <button type="" class="confirm"><sapn class="iconfont  icon-queren" style="font-size:27px;color: #666;"><span></button>
        
       <!-- 评论板块 -->
       
       
        <div class="comment_box">
        	
        		<% for(Comment comment:commentlist){%>
        			<div class="comment_box_circle">
	        			<!-- 通过对象建立的外键 怎么获取相应字段的值 user对象？？？？？ -->
	            		<font style="color:#141414"><%=comment.getUser().getUsername()%>:</font>
	            		<font style="color:#666"><%=comment.getContent()%></font>
            		<% for(Reply reply:replylist){ 
            			//遍历和评论id相同的回复
            			if(reply.getComment().getId() == comment.getId()){
            		%>
            			
            			<font style="color:#666">&nbsp;&nbsp;&nbsp;<%=reply.getGiveuser().getUsername() %>&nbsp;回复:<%=reply.getGetuser().getUsername() %>&nbsp;<%=reply.getContent() %></font>
            		<%	} 
            		}%>
            		</div>
        		<%}%>
        	
        
        	 <!-- <div class="comment_box_circle">
        		<font style="color:#141414">user1:</font>
        		<font style="color:#666">comment The text is derived from Cicero's De Finibus Bonorum et Malorum (On the Ends of Goods and Evils, or alternatively [About] The Purposes of Good and Evil ). The original passage began: Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit (Translation: &quot;Neither is there anyone who loves grief itself since it is grief and thus wants to obtain it&quot;).</font>
        	</div>
        	<div class="comment_box_circle">
        		<font style="color:#141414">user2:</font>
        		<font style="color:#666">comment The text is derived from Cicero's De Finibus Bonorum et Malorum (On the Ends of Goods and Evils, or alternatively [About] The Purposes of Good and Evil ). The original passage began: Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit (Translation: &quot;Neither is there anyone who loves grief itself since it is grief and thus wants to obtain it&quot;).</font>
        	</div>
        	<div class="comment_box_circle">
        		<font style="color:#141414">user3:</font>
        		<font style="color:#666">comment The text is derived from Cicero's De Finibus Bonorum et Malorum (On the Ends of Goods and Evils, or alternatively [About] The Purposes of Good and Evil ). The original passage began: Neque </font>
        	</div>
        	<div class="comment_box_circle">
        		<font style="color:#141414">user4:</font>
        		<font style="color:#666">comment The text is derived from Cicero's De Finibus Bonorum et Malorum (On the Ends of Goods and Evils, or alternatively [About] The Purposes of Good and Evil ). The original passage began: Neque </font>
        	</div>
        	<div class="comment_box_circle">
        		<font style="color:#141414">user5:</font>
        		<font style="color:#666">comment The text is derived from Cicero's De Finibus Bonorum et Malorum (On the Ends of Goods and Evils </font>
        	</div>-->
        </div>

</div><!--main-->
 <div class="foot">
 	<br>

 	<br>
 	<br>
 	@ONT TO ONE
 </div>
        <script type="text/javascript" src="<%=path %>/static/assets/jquery/jquery-3.2.0.js"></script>

        <script src="<%=path %>/static/trumbowyg/trumbowyg.js"></script>

        <script src="<%=path %>/static/trumbowyg/langs/fr.js"></script>

        <script src="<%=path %>/static/trumbowyg/plugins/upload/trumbowyg.upload.js"></script>

        <script src="<%=path %>/static/trumbowyg/plugins/base64/trumbowyg.base64.js"></script>

        <script>

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

        </script>

    </body>

</html>