app.controller('UserModalCtrl', ['$scope', '$modalInstance', 'param', 'resource', function ($scope, $modalInstance, param, resource) {
    $scope.user = param;
    console.log($scope.user);

    // 提交
    $scope.submit = function () {
        $modalInstance.close($scope.user);
    };
    $scope.close = function () {
        $modalInstance.dismiss('cancel');
    };
}]);