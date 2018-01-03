app.controller('FilmMgmtCtrl', ['$scope', 'resource', 'myPaginationService', '_ms', '$modal',
    function ($scope, resource, myPaginationService, _ms, $modal) {
        $scope.film = {};

        //查询用户，并分页显示
        $scope.filmPageObject = {
            currentPageList: [], //当前页面显示的数据列表
            currentPage: 1, //当前页，初始化为1
            totalPage: 0, //总页数
            pageSize: 3, //页面大小
            pages: [] //前台页面按钮显示内容
        };

        $scope.loadPage = function () {
            $scope.loadPageData = {
                currPage: $scope.filmPageObject.currentPage,
                pageSize: $scope.filmPageObject.pageSize
            };
            resource.get('get_film_by_page', $scope.loadPageData)
                .then(function (result) {
                    console.log(result);
                    $scope.filmPageObject.currentPageList = result.data.list;
                    $scope.filmPageObject.totalPage = result.data.totalPage;
                    $scope.filmPageObject.pages = [];
                    if(result.data.totalPage == 1){
                        $scope.filmPageObject.pages.push($scope.filmPageObject.currentPage);
                    }else{
                        if($scope.filmPageObject.currentPage == result.data.totalPage){
                            $scope.filmPageObject.pages.push($scope.filmPageObject.currentPage-1);
                            $scope.filmPageObject.pages.push($scope.filmPageObject.currentPage);
                        }else{
                            $scope.filmPageObject.pages.push($scope.filmPageObject.currentPage);
                            $scope.filmPageObject.pages.push($scope.filmPageObject.currentPage+1);
                        }
                    }
                });
        };

        $scope.init = function () {
            $scope.loadPage();
            $scope.$watch('filmPageObject.totalPage', function () {
                myPaginationService.showFirstPageContent($scope.filmPageObject, 1);
            });
        };
        $scope.init();
        $scope.$watch('filmPageObject.currentPage', function () {
            $scope.loadPage();
        });

        //---------------------

        // 查看修改添加
        $scope.detail = function (item) {
            $scope.film = (item) ? item : {};
            var modalInstance = $modal.open({
                templateUrl: '../static/admin/tpl/modal/filmModal.html',
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
                resource.get('sou_film', result)
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
            $scope.film = item;
            var modalInstance = $modal.open({
                templateUrl: '../static/admin/tpl/modal/removeModal.html',
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
                    resource.get('delete_film', {id: $scope.film.id})
                        .then(function (result) {
                            if (result.success) {
                                _ms.msg('s', '删除成功');
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
            url: 'upload_film_photo',
            removeAfterUpload: true,
            queueLimit: 1,
            headers: {'Content-Type': undefined}
        });

        $scope.startUpload = function (item) {
            var fd = new FormData();
            fd.append('file', item._file);

            $http({
                method: 'post',
                url: "upload_film_photo",
                data: fd,
                headers: {'Content-Type': undefined},
                transformRequest: angular.identity
            }).success(function (result) {
                $scope.film.photo = result.url;
                toaster.pop('error', result.msg);
            });
        }

    }])
;