'use strict';

angular.module('app').factory('_ms', ['$http', '$q', 'toaster', '$window', function ($http, $q, toaster, $window) {
    // 封装toaster方法
    var service = {};
    service.msg = function (t, text) {
        var type = {'s': 'success', 'i': 'info', 'wt': 'wait', 'w': 'warning', 'e': 'error'}[t];
        type = type ? type : 'success';
        text = text || '';
        toaster.pop(type, '信息提示', text);
    };

    return service;
}]);