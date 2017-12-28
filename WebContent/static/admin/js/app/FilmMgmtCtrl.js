app.controller('FilmMgmtCtrl', ['$scope', 'resource', 'myPaginationService', '_ms','$modal',
    function ($scope, resource, myPaginationService, _ms, $modal) {
        $scope.film = {};
        $scope.films = [{name: 'abc', description: 'xxxxx'}, {name: 'asd', description: '123'}];

        //查询用户，并分页显示
        $scope.userPageObject = {
            currentPageList: $scope.films, //当前页面显示的数据列表
            currentPage: 1, //当前页，初始化为1
            totalPage: 0, //总页数
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

        // 查看修改添加
        $scope.detail = function (item) {
            $scope.film = (item)?item:{};
            var modalInstance = $modal.open({
                templateUrl: 'tpl/modal/filmModal.html',
                controller: 'FilmModalCtrl',
                backdrop: 'static',
                size: 'lg',
                resolve: {
                    param: function () {
                        return $scope.film;
                    }
                }
            });
            modalInstance.result.then(function (result) {
                //TODO
                // resource.post('sou_user', result).then(function (response) {
                // });
            });
        };

        // 删除
        $scope.remove = function (item) {
            $scope.film = item;
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