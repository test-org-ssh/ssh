<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	String path = request.getContextPath();
%>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>发帖</title>

        <link rel="stylesheet" href="<%=path %>/static/assets/trumbowyg/design/css/trumbowyg.css">
       <link href="<%=path %>/static/assets/font/download12/font_503801_6ri7xb94hdr3haor/iconfont.css" rel="stylesheet" style="text/css"/>

        <style type="text/css">

            html, body {

                margin: 0;

                padding: 0;

                background-color: #F2F2F2;

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
                height:1000px;

            }
            .tmp{
                width: 100%;
                height:100px;
            }
            .confirm{
                outline:none;
                height:50px;
                width:60px;
                border:0px;
                background-color:#F7F7F7;
                cursor: pointer;
            }
            .cancle{
               outline:none;
                height:50px;
                width:60px;
                border:0px;
                background-color:#F7F7F7;
                cursor: pointer;
                margin-left: 80%;
                margin-right: 50px;

            }
            .title{
                width:26%;
                margin-left: 2%;
                background-color:#E8E8E8;
                outline:none;
                color:#666;
                font-size:14px;
                border-radius:15px;
                height:30px;
                border:solid thin #ccc;

            }
            .lib{
                width:26%;
                margin-left: 2%;
                background-color:#E8E8E8;
                outline:none;
                color:#666;
                font-size:14px;
                border-radius:15px;
                height:30px;
                border:solid thin #ccc;
            }

        </style>

    </head>

    <body>
        
        <div id="main" role="main">
            <header>

                <h1><!--<p class="css408AFFC97A373E36" style="font-size:40px">OneTOone</p>-->
                	<img src="<%=path %>/static/img/logoSend.png">
                </h1>
                
                <p>

                    EDITOR YOUR STORY TO THE WORLD.
                </p>
                <br>
                <br>
            </header>
            <form action="#">
                <input class="title" value="【标题】">
                <div id="simple-editor">

                    <h2>This editor is the default build of Trumbowyg.</h2>

                    <p>

                        Lorem ipsum dolor sit amet, consectetur adipisicing elit. Possimus, aliquam, minima fugiat placeat provident optio nam reiciendis eius beatae quibusdam!

                    </p>

                    <p>

                        The text is derived from Cicero's De Finibus Bonorum et Malorum (On the Ends of Goods and Evils, or alternatively [About] The Purposes of Good and Evil ). The original passage began: Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit (Translation: &quot;Neither is there anyone who loves grief itself since it is grief and thus wants to obtain it&quot;).

                    </p>

                </div>
                 <input class="lib" value="输入标签，用#号分隔">
                 <br>
                 <br>
                 <button type="" class="cancle"><sapn class="iconfont  icon-quxiao2" style="font-size:42px;color: #666"><span></button> <button type="" class="confirm"><sapn class="iconfont  icon-queren" style="font-size:27px;color: #666;"><span></button>
                  
            </form>
    
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