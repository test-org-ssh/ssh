$(document).ready(function() {
    layui.use(['laypage', 'layer'], function() {
        var laypage = layui.laypage
            , layer = layui.layer;
        laypage.render({
            elem: 'film-page'
            , count: 100
            , layout: ['count', 'prev', 'page', 'next', 'limit', 'skip']
            , jump: function (obj) {
                // console.log(obj)
            }
        });
    })
})