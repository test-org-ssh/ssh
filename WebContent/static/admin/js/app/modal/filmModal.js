app.controller('FilmModalCtrl', ['$scope', '$modalInstance', 'param', 'resource', function ($scope, $modalInstance, param, resource) {
    $scope.film = param;

    // 提交
    $scope.submit = function () {
        $modalInstance.close($scope.film);
    };
    $scope.close = function () {
        $modalInstance.dismiss('cancel');
    };
}]);