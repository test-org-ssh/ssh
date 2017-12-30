$(document).ready(function(){

    //轮播图
    $('.carousel').carousel({
        interval: 5000
    })
    $('.carousel').carousel('cycle')

    //内容信息导航吸顶
    var navHeight= $("#navHeight").offset().top;
    var navFix=$("#nav_wrap");
    $(window).scroll(function(){
        if($(this).scrollTop()>navHeight){
            navFix.addClass("navFix");
        }
        else{
            navFix.removeClass("navFix");
        }
    })
    
    $(".forum-box").find(".forum-box-content").each(function(){
    	var maxwidth = 190;
    	if($(this).text().length>maxwidth){
    		$(this).text($(this).text().substring(0,maxwidth));
			$(this).html($(this).html()+'…');
    	}
    })
    
    $(".forum-box").find(".forum-box-title").each(function(){
    	var maxwidth = 20;
    	if($(this).text().length>maxwidth){
    		$(this).text($(this).text().substring(0,maxwidth));
			$(this).html($(this).html()+'…');
    	}
    })
})