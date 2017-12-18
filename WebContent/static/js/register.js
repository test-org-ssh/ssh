var working = false;
$('.login').on('submit', function(e) {
    e.preventDefault();
    if (working) return;
    working = true;
    var $this = $(this),
        $state = $this.find('button > .state');
    $this.addClass('loading');
    
    // 这下面是原本就被注释掉的代码
//$state.html('Authenticating');
//setTimeout(function() {
//  $this.addClass('ok');
//  $state.html('Welcome back!');
//  setTimeout(function() {
//    $state.html('Log in');
//    $this.removeClass('ok loading');
//    working = false;
//  }, 4000);
//}, 3000);
});

/*这种形式的注释里面都是正常代码，取消可用*/