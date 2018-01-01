app.controller('UserMgmtCtrl', ['$scope', 'resource', 'myPaginationService', '_ms','$modal',
    function ($scope, resource, myPaginationService, _ms, $modal) {
        $scope.user = {};
        $scope.users = [{username: 'abc', status: 1}, {username: 'zxc', status: 0}];

        //查询用户，并分页显示
        $scope.userPageObject = {
            currentPageList: $scope.users, //当前页面显示的数据列表
            currentPage: 1, //当前页，初始化为1
            totalPage: 1, //总页数
            pageSize: 10, //页面大小
            pages: [] //前台页面按钮显示内容
        };

        $scope.userSelect = {};
        $scope.getAllUser = function () {
            $scope.userSearch = {
                params: {
                    pageSize: $scope.userPageObject.pageSize,
                    currentPage: $scope.userPageObject.currentPage
                }
            };
            //TODO
            // $http.get("/api/user", $scope.userSearch).success(function (data, status, headers) {
            //     $scope.userPageObject.totalPage = headers('Page-Count');
            //     $scope.userPageObject.currentPageList = data;
            // }).error(function (err) {
            //     $scope.users = [];
            //     console.log(err);
            // });
        };
        $scope.getAllUser();

        $scope.init = function () {
            $scope.getAllUser();
            $scope.$watch('userPageObject.totalPage', function () {
                myPaginationService.showFirstPageContent($scope.userPageObject, 1);
            });
        };
        $scope.init();
        $scope.$watch('userPageObject.currentPage', function () {
            $scope.getAllUser();
        });

        //---------------------

        // 切换用户停用/启用状态
        $scope.switchStatus = function (item) {
            _ms.msg('s', 'done');
        };

        // 查看修改添加
        $scope.detail = function (item) {
            $scope.user = (item)?item:{};
            var modalInstance = $modal.open({
                templateUrl: 'tpl/modal/userModal.html',
                controller: 'UserModalCtrl',
                backdrop: 'static',
                size: 'lg',
                resolve: {
                    param: function () {
                        return $scope.user;
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
            $scope.user = item;
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
                }
            });
        }
    }])
;