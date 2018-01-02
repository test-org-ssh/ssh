app.controller('RemoveModalCtrl', ['$scope', '$modalInstance', 'param', 'resource', function ($scope, $modalInstance, param, resource) {
    $scope.item = param;


    // 提交
    $scope.submit = function () {
        $modalInstance.close($scope.item);
    };
    $scope.close = function () {
        $modalInstance.dismiss('cancel');
    };
}]);