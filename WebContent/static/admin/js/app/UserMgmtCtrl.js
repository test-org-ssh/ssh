app.controller('UserMgmtCtrl', ['$scope', 'resource', 'myPaginationService', '_ms', '$modal',
    function ($scope, resource, myPaginationService, _ms, $modal) {
        $scope.user = {};

        //查询用户，并分页显示
        $scope.userPageObject = {
            currentPageList: [], //当前页面显示的数据列表
            currentPage: 1, //当前页，初始化为1
            totalPage: 0, //总页数
            pageSize: 3, //页面大小
            pages: [] //前台页面按钮显示内容
        };

        $scope.loadPage = function () {
            $scope.loadPageData = {
                currPage: $scope.userPageObject.currentPage,
                pageSize: $scope.userPageObject.pageSize
            };
            resource.get('./admin/get_user_by_page', $scope.loadPageData)
                .then(function (result) {
                    console.log(result);
                    $scope.userPageObject.currentPageList = result.data.list;
                    $scope.userPageObject.totalPage = result.data.totalPage;
                    $scope.userPageObject.pages = [];
                    if(result.data.totalPage == 1){
                        $scope.userPageObject.pages.push($scope.userPageObject.currentPage);
                    }else{
                        if($scope.userPageObject.currentPage == result.data.totalPage){
                            $scope.userPageObject.pages.push($scope.userPageObject.currentPage-1);
                            $scope.userPageObject.pages.push($scope.userPageObject.currentPage);
                        }else{
                            $scope.userPageObject.pages.push($scope.userPageObject.currentPage);
                            $scope.userPageObject.pages.push($scope.userPageObject.currentPage+1);
                        }
                    }
                });
        };

        $scope.init = function () {
            $scope.loadPage();
            $scope.$watch('userPageObject.totalPage', function () {
                myPaginationService.showFirstPageContent($scope.userPageObject, 1);
            });
        };
        $scope.init();
        $scope.$watch('userPageObject.currentPage', function () {
            $scope.loadPage();
        });

        //---------------------


        // 切换用户停用/启用状态
        $scope.switchStatus = function (item) {
            var status = (item.status == 0) ? 1 : 0;
            resource.get('./admin/update_user_status', {id: item.id, status: status})
                .then(function (result) {
                    if (result.success) {
                        _ms.msg('s', '状态更新成功');
                        $scope.loadPage();
                    }
                });
        };

        // 查看修改添加
        $scope.detail = function (item) {
            $scope.user = (item) ? item : {};
            var modalInstance = $modal.open({
                templateUrl: './static/admin/tpl/modal/userModal.html',
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
                resource.get('./admin/sou_user', result)
                    .then(function (result) {
                        console.log(result);
                        if (result.success) {
                            _ms.msg('s', result.msg);
                            $scope.loadPage();
                        }
                    });
            });
        };

        // 删除
        $scope.remove = function (item) {
            $scope.user = item;
            var modalInstance = $modal.open({
                templateUrl: './static/admin/tpl/modal/removeModal.html',
                controller: 'RemoveModalCtrl',
                backdrop: 'static',
                size: 's',
                resolve: {
                    param: function () {
                        return item;
                    }
                }
            });
            modalInstance.result.then(function (result) {
                if (result) {
                    resource.get('./admin/delete_user', {id: $scope.user.id})
                        .then(function (result) {
                            if (result.success) {
                                _ms.msg('s', '删除成功');
                                $scope.loadPage();
                            }
                        });
                }
            });
        }
    }])
;

app.controller('UserPhotoUploadCtrl', ['$scope', 'FileUploader', '$http', 'toaster',
    function ($scope, FileUploader, $http, toaster) {
        var uploader = $scope.uploader = new FileUploader({
            url: './admin/upload_user_photo',
            removeAfterUpload: true,
            queueLimit: 1,
            headers: {'Content-Type': undefined}
        });

        $scope.startUpload = function (item) {
            var fd = new FormData();
            fd.append('file', item._file);

            $http({
                method: 'post',
                url: "./admin/upload_user_photo",
                data: fd,
                headers: {'Content-Type': undefined},
                transformRequest: angular.identity
            }).success(function (result) {
                $scope.user.photo = result.url;
                toaster.pop('error', result.msg);
            });
        }

    }])
;