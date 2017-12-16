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
})