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
app.controller('PostMgmtCtrl', ['$scope', 'resource', 'myPaginationService', '_ms','$modal','toaster',
    function ($scope, resource, myPaginationService, _ms, $modal,toaster) {
        $scope.post = {};

        //查询帖子，并分页显示
        $scope.postPageObject = {
            currentPageList: [], //当前页面显示的数据列表
            currentPage: 1, //当前页，初始化为1
            totalPage: 0, //总页数
            pageSize: 5, //页面大小
            pages: [] //前台页面按钮显示内容
        };

       
        $scope.loadPage = function () {
            $scope.loadPageData = {
                currPage: $scope.postPageObject.currentPage,
                pageSize: $scope.postPageObject.pageSize
            };
            resource.get('./admin/get_post_by_page', $scope.loadPageData)
                .then(function (result) {
                    console.log(result);
                    $scope.postPageObject.currentPageList = result.data.list;
                    $scope.postPageObject.totalPage = result.data.totalPage;
                    $scope.postPageObject.pages = [];
                    if(result.data.totalPage == 1){
                    	$scope.postPageObject.pages.push($scope.postPageObject.currentPage);
                    }else{
	                    if($scope.postPageObject.currentPage == result.data.totalPage){
	                    	$scope.postPageObject.pages.push($scope.postPageObject.currentPage-1);
	                        $scope.postPageObject.pages.push($scope.postPageObject.currentPage);
	                    }else{
		                    $scope.postPageObject.pages.push($scope.postPageObject.currentPage);
		                    $scope.postPageObject.pages.push($scope.postPageObject.currentPage+1);
	                    }
                    }
                });
        };

        $scope.init = function () {
            $scope.loadPage();
            $scope.$watch('postPageObject.totalPage', function () {
                myPaginationService.showFirstPageContent($scope.postPageObject, 1);
            });
        };
        $scope.init();
        $scope.$watch('postPageObject.currentPage', function () {
            $scope.loadPage();
        });

        //---------------------


        // 查看
        $scope.detail = function (item) {
        	$scope.post = (item) ? item : {};
            var modalInstance = $modal.open({
                templateUrl: './static/admin/tpl/modal/postModal.html',
                controller: 'PostModalCtrl',
                backdrop: 'static',
                size: 'lg',
                resolve: {
                    param: function () {
                        return $scope.post;
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
            $scope.post = item;
            var modalInstance = $modal.open({
                templateUrl: './static/admin/tpl/modal/removeModal.html',
                controller: 'RemoveModalCtrl',
                backdrop: 'static',
                size: 's',
                resolve: {
                	param:function(){
                		return item;
                	}
                }
            });
            modalInstance.result.then(function (result) {
                if(result){
                    // TODO 向服务器发送删除请求
                	resource.get('./admin/delete_post',{id:$scope.post.id}).then(function (result) {
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
app.controller('PostModalCtrl', ['$scope', '$modalInstance', 'param', 'resource', function ($scope, $modalInstance, param, resource) {

    $scope.post = param;

    // 提交
    $scope.submit = function () {
        $modalInstance.close($scope.post);
    };
    $scope.close = function () {
        $modalInstance.dismiss('cancel');
    };
}]);
