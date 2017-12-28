app.controller('FilmModalCtrl', ['$scope', '$modalInstance', 'param', 'resource', function ($scope, $modalInstance, param, resource) {
    $scope.fime = param;


    // 提交
    $scope.submit = function () {
        $modalInstance.close($scope.fime);
    };
    $scope.close = function () {
        $modalInstance.dismiss('cancel');
    };
}]);