angular.module('app').factory('myPaginationService', function () {

    var getPageData = function (pageObject, page) {
        pageObject.currentPage = page;
        if (pageObject.currentPage > 1 && pageObject.currentPage < pageObject.totalPage) {
            pageObject.pages = [
                pageObject.currentPage - 1,
                pageObject.currentPage,
                pageObject.currentPage + 1
            ];
        } else if (pageObject.currentPage == 1 && pageObject.totalPage == 1) {
            pageObject.pages = [
                1
            ];
        } else if (pageObject.currentPage == 1 && pageObject.totalPage == 2) {
            pageObject.pages = [
                1, 2
            ];
        } else if (pageObject.currentPage == 1 && pageObject.totalPage > 2) {
            pageObject.pages = [
                pageObject.currentPage,
                pageObject.currentPage + 1,
                pageObject.currentPage + 2
            ];
        } else if (pageObject.currentPage == pageObject.totalPage && pageObject.totalPage == 1) {
            pageObject.pages = [
                1
            ];
        } else if (pageObject.currentPage == pageObject.totalPage && pageObject.totalPage == 2) {
            pageObject.pages = [
                1, 2
            ];
        } else if (pageObject.currentPage == pageObject.totalPage && pageObject.totalPage > 2) {
            pageObject.pages = [
                pageObject.currentPage - 2,
                pageObject.currentPage - 1,
                pageObject.currentPage
            ];
        }
    };

    var service = {

        upPageClick: function (pageObject, page) {
            if (pageObject.currentPage == 1) {
                return;
            }
            ;
            pageObject.currentPage--;
            getPageData(pageObject, page);
        },

        downPageClick: function (pageObject, page) {
            if (pageObject.currentPage >= pageObject.totalPage) {
                return;
            }
            ;
            pageObject.currentPage++;
            getPageData(pageObject, page);
        },

        showFirstPageContent: function (pageObject, page) {
            pageObject.currentPage = 1;
            getPageData(pageObject, page);
        },

        showLastPageContent: function (pageObject, page) {
            pageObject.currentPage = pageObject.totalPage;
            getPageData(pageObject, page);
        },

        showCurrentPageContent: function (pageObject, page) {
            pageObject.currentPage = page;
            getPageData(pageObject, page);
        }
    };
    return service;
});


angular.module('app').directive('myPagination', function (myPaginationService) {
    return {
        restrict: 'A',
        replace: true,
        scope: {
            pageObject: '='
        },
        templateUrl: '../../static/admin/js/directives/myPagination.html',
        link: function (scope, element, attrs) {
            scope.upPageClick = function (page) {
                myPaginationService.upPageClick(scope.pageObject, page);
                //console.log(scope.pageObject.currentPage);
            };
            scope.downPageClick = function (page) {
                myPaginationService.downPageClick(scope.pageObject, page);
                //console.log(scope.pageObject.currentPage);
            };
            scope.showFirstPage = function (page) {
                myPaginationService.showFirstPageContent(scope.pageObject, page);
                //console.log(scope.pageObject.currentPage);
            };
            scope.showLastPage = function (page) {
                myPaginationService.showLastPageContent(scope.pageObject, page);
                //console.log(scope.pageObject.currentPage);
            };
            scope.showCurrentPage = function (page) {
                myPaginationService.showCurrentPageContent(scope.pageObject, page);
                //console.log(scope.pageObject.currentPage);
            };
        }
    };
});