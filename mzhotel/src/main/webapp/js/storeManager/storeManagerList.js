var app = angular.module("storeManagerApp", []);
app.controller("storeManagerController", function ($scope, $http) {
    $scope.query = {};
    $scope.storehouseManagerList = {};
    $scope.init = function () {
        $http({
            method: "GET",
            url: "/storehouse/pimsTest/getResource",
            data: $scope.query
        }).then(function successCallback(result) {

        }, function errorCallback() {

        })
    }
    $scope.reset = function () {
        $scope.query = {};
    }
    $scope.add = function () {
        window.open("../storeManager/storeManagerEdit.jsp");
    }
    $scope.view = function (item) {
        if(item){

        }else{
            alert("请选择单据！");
        }
    }
    $scope.delete = function (item) {
        if(item){
            $http({
                method: "GET",
                url: "/mzhotel/pimsTest/getResource",
                data: $scope.query
            }).then(function successCallback(result) {

            }, function errorCallback() {

            })
        }else{
            alert("请选择单据！");
        }
    }
    $scope.export = function () {

    }
    $scope.innerStore = function () {

    }
    $scope.outStore = function () {

    }
    $scope.storeLog = function () {

    }
    $scope.init();
});

