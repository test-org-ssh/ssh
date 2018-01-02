angular.module('app').filter('cut', function() { 
    return function(value, wordwise, max, tail) {
    if (!value) return '';

    max = parseInt(max, 10);
    if (!max) return value;
    if (value.length <= max) return value;

    value = value.substr(0, max);
    if (wordwise) {
    var lastspace = value.lastIndexOf(' ');
    if (lastspace != -1) {
    value = value.substr(0, lastspace);
    }
    }

    return value + (tail || ' …');//'...'可以换成其它文字
    };
});
app.controller('CommentMgmtCtrl', ['$scope', 'resource', 'myPaginationService', '_ms','$modal','toaster',
    function ($scope, resource, myPaginationService, _ms, $modal,toaster) {
        $scope.comment = {};

        //查询评论，并分页显示
        $scope.commentPageObject = {
            currentPageList: [], //当前页面显示的数据列表
            currentPage: 1, //当前页，初始化为1
            totalPage: 0, //总页数
            pageSize: 5, //页面大小
            pages: [] //前台页面按钮显示内容
        };

       
        $scope.loadPage = function () {
            $scope.loadPageData = {
                currPage: $scope.commentPageObject.currentPage,
                pageSize: $scope.commentPageObject.pageSize
            };
            resource.get('get_comment_by_page', $scope.loadPageData)
                .then(function (result) {
                    console.log(result);
                    $scope.commentPageObject.currentPageList = result.data.list;
                    $scope.commentPageObject.totalPage = result.data.totalPage;
                    $scope.commentPageObject.pages = [];
                    if(result.data.totalPage == 1){
                    	$scope.commentPageObject.pages.push($scope.commentPageObject.currentPage);
                    }else{
	                    if($scope.commentPageObject.currentPage == result.data.totalPage){
	                    	$scope.commentPageObject.pages.push($scope.commentPageObject.currentPage-1);
	                        $scope.commentPageObject.pages.push($scope.commentPageObject.currentPage);
	                    }else{
		                    $scope.commentPageObject.pages.push($scope.commentPageObject.currentPage);
		                    $scope.commentPageObject.pages.push($scope.commentPageObject.currentPage+1);
	                    }
                    }
                });
        };

        $scope.init = function () {
            $scope.loadPage();
            $scope.$watch('commentPageObject.totalPage', function () {
                myPaginationService.showFirstPageContent($scope.commentPageObject, 1);
            });
        };
        $scope.init();
        $scope.$watch('commentPageObject.currentPage', function () {
            $scope.loadPage();
        });

        //---------------------

       
        // 查看
        $scope.detail = function (item) {
            $scope.comment = (item)?item:{};
            var modalInstance = $modal.open({
                templateUrl: '../static/admin/tpl/modal/commentModal.html',
                controller: 'CommentModalCtrl',
                backdrop: 'static',
                size: 'lg',
                resolve: {
                    param: function () {
                        return $scope.comment;
                    }
                }
            });
            modalInstance.result.then(function (result) {
                console.log(result);
                //TODO
                // resource.post('sou_user', result).then(function (response) {
                // });
            });
        };

        // 删除
        $scope.remove = function (item) {
        	$scope.comment = (item)?item:{};
            var modalInstance = $modal.open({
                templateUrl: 'tpl/modal/removeModal.html',
                controller: 'RemoveModalCtrl',
                backdrop: 'static',
                size: 's',
                resolve: {}
            });
            modalInstance.result.then(function (result) {
                if(result){
                    // TODO 向服务器发送删除请求
                	resource.get('delete_comment',{id:$scope.comment.id}).then(function (result) {
                        console.log(result);
                        if (result.success == true) {
                            toaster.pop('success', '提示', result.msg);
                            $scope.loadPage();
                        }else{
                        	toaster.pop('error', '提示', result.msg)
                        }
                    });
                }
            });
        }
    }])
;

//添加及编辑帖子信息弹窗
app.controller('CommentModalCtrl', ['$scope', '$modalInstance', 'param', 'resource', function ($scope, $modalInstance, param, resource) {

    $scope.comment = param;

    // 提交
    $scope.submit = function () {
        $modalInstance.close($scope.comment);
    };
    $scope.close = function () {
        $modalInstance.dismiss('cancel');
    };
}]);