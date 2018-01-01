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
                    // system
                    .state('access', {
                        url: '/access',
                        template: '<div ui-view class="fade-in-right-big smooth"></div>'
                    })
                    .state('access.signin', {
                        url: '/signin',
                        templateUrl: '../static/admin/tpl/page_signin.html',
                        resolve: {
                            deps: ['uiLoad',
                                function( uiLoad ){
                                    return uiLoad.load( ['../static/admin/js/controllers/signin.js'] );
                                }]
                        }
                    })
                    .state('access.signup', {
                        url: '/signup',
                        templateUrl: '../static/admin/tpl/page_signup.html',
                        resolve: {
                            deps: ['uiLoad',
                                function( uiLoad ){
                                    return uiLoad.load( ['../static/admin/js/controllers/signup.js'] );
                                }]
                        }
                    })
                    .state('access.forgotpwd', {
                        url: '/forgotpwd',
                        templateUrl: '../static/admin/tpl/page_forgotpwd.html'
                    })
                    .state('access.404', {
                        url: '/404',
                        templateUrl: '../static/admin/tpl/page_404.html'
                    })
            }
        ]
    );