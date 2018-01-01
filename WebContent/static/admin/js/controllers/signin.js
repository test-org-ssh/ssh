'use strict';

/* Controllers */
// signin controller
app.controller('SigninFormController', ['$scope', '$http', '$state', function ($scope, $http, $state) {
    $scope.user = {};
    $scope.authError = null;
    $scope.login = function () {
        $scope.authError = null;
        // Try to login
        //   TODO
        $http.post('api/login', {username: $scope.user.username, password: $scope.user.password})
            .then(function (response) {
                if (response.result == 'error') {
                    $scope.authError = '账号或密码有误';
                    $scope.user = {};
                } else {
                    $state.go('app.user');
                }
            });
    };
}])
;