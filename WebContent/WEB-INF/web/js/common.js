$(document).ready(function() {
    var sdelay = 0;

    function returnTop() {
        window.scrollBy(0, -2000);//Only for y vertical-axis
        if (document.body.scrollTop > 0) {
            sdelay = setTimeout('returnTop()', 2);
        }
    }
})