'use strict';

/**
 * Config for the router
 */
angular.module('app')
    .run(
        ['$rootScope', '$state', '$stateParams',
            function ($rootScope, $state, $stateParams) {
                $rootScope.$state = $state;
                $rootScope.$stateParams = $stateParams;
            }
        ]
    )
    .config(
        ['$stateProvider', '$urlRouterProvider',
            function ($stateProvider, $urlRouterProvider) {

                $urlRouterProvider
                    .otherwise('/app/user');
                $stateProvider
                    .state('app', {
                        abstract: true,
                        url: '/app',
                        templateUrl: '../static/admin/tpl/app.html'
                    })
                    .state('app.user', {
                        url: '/user',
                        templateUrl: '../static/admin/tpl/page/user.html',
                        resolve: {
                            deps: ['$ocLazyLoad',
                                function ($ocLazyLoad) {
                                    return $ocLazyLoad.load(['toaster','../static/admin/js/app/UserMgmtCtrl.js']);
                                }]
                        }
                    })
                    .state('app.film', {
                        url: '/film',
                        templateUrl: '../static/admin/tpl/page/film.html',
                        resolve: {
                            deps: ['$ocLazyLoad',
                                function ($ocLazyLoad) {
                                    return $ocLazyLoad.load(['toaster','../static/admin/js/app/FilmMgmtCtrl.js']);
                                }]
                        }
                    })
                    .state('app.post', {
                        url: '/post',
                        templateUrl: '../static/admin/tpl/page/post.html',
                        resolve: {
                            deps: ['$ocLazyLoad',
                                function ($ocLazyLoad) {
                                    return $ocLazyLoad.load(['toaster','../static/admin/js/app/PostMgmtCtrl.js']);
                                }]
                        }
                    })
                    .state('app.comment', {
                        url: '/comment',
                        templateUrl: '../static/admin/tpl/page/comment.html',
                        resolve: {
                            deps: ['$ocLazyLoad',
                                function ($ocLazyLoad) {
                                    return $ocLazyLoad.load(['toaster','../static/admin/js/app/CommentMgmtCtrl.js']);
                                }]
                        }
                    })
            }
        ]
    );