var app = angular.module("storehouseEditApp", []);
app.controller("storehouseEditController", function ($scope, $http) {
    $scope.query = {};
    $scope.storehouseManagerList = {};
    $scope.pageSetting = {
        disabled : true
    };
    $scope.storehouse = {};
    var params = "";
    $scope.init = function () {
        if(params.id){
            $http({
                method: "GET",
                url: "/mzhotel/storehouse/selectByPrimaryKey",
                data: params.id
            }).then(function successCallback(result) {
                $scope.storehouse = result;
            }, function errorCallback() {

            })
        }else{
            $scope.pageSetting.disabled = true;
        }
    }
    $scope.save = function () {
        $http({
            method: "POST",
            url: "/mzhotel/storehouse/insert",
            data: $scope.storehouse
        }).then(function successCallback(result) {
            params.id = result.id;
            $scope.pageSetting.disabled = true;
            $scope.init();
            $scope.storehouse = result;
        }, function errorCallback() {

        })
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
});

