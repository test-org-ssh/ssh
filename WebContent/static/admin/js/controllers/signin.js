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
        $http.post('api/login', {email: $scope.user.email, password: $scope.user.password})
            .then(function (response) {
                if (response.data.user.name != $scope.user.name && response.data.user.password != $scope.password) {
                    $scope.authError = '账号或密码有误';
                } else {
                    $state.go('app.user');
                }
            }, function (x) {
                $scope.authError = '错误';
            });
    };
}])
;