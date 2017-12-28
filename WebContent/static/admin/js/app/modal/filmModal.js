app.controller('RemoveModalCtrl', ['$scope', '$modalInstance',
    function ($scope, $modalInstance) {
        $scope.ok = function () {
            $modalInstance.close(true);
        };
        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };
    }]);