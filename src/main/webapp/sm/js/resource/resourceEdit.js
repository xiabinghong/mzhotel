define(function (require, exports) {
    var moduleName = "resourceModule";
    var moduleApp = angular.module(moduleName,[]);
    moduleApp.controller("resourceEditController", ["$scope", "$http", function ($scope, $http) {
        $scope.query = {};
        $scope.resourceList = {};
        $scope.pageSetting = {
            disabled: true
        };
        var params = {
            id:null
        };
        $scope.resource = {};
        $scope.init = function () {
            if (params.id) {
                $http({
                    method: "GET",
                    url: "/mzhotel/resource/selectByPrimaryKey",
                    data: params.id
                }).then(function successCallback(result) {
                    $scope.resource = result;
                }, function errorCallback() {

                })
            } else {
                $scope.pageSetting.disabled = false;
            }
        }
        $scope.save = function () {
            if (params.id) {
                $http({
                    method: "POST",
                    url: "/mzhotel/resource/update",
                    data: $scope.resource
                }).then(function successCallback(result) {
                    params.id = result.data.id;
                    $scope.pageSetting.disabled = true;
                    $scope.resource = result.data;
                    alert("更新成功");
                }, function errorCallback() {
                    alert("更新失败");
                })
            } else {
                $http({
                    method: "POST",
                    url: "/mzhotel/resource/insert",
                    data: $scope.resource
                }).then(function successCallback(result) {
                    params.id = result.data.id;
                    $scope.pageSetting.disabled = true;
                    $scope.resource = result.data;
                    alert("新增成功");
                }, function errorCallback() {
                    alert("新增失败");
                })
            }
        }
        $scope.cancel = function () {
            $scope.pageSetting.disabled = true;
            $scope.init();
        }
        $scope.close = function () {
            window.close();
        }
        $scope.edit = function () {
            $scope.pageSetting.disabled = false;
        }
        $scope.init();
    }]);
    window.angular.bootstrap(document, [moduleName]);
});