var app = angular.module("myApp", []);
app.controller("pimsTestController", function ($scope, $http) {
    $scope.pimsTestList = {};
    $scope.queryUserInfo = {};
    $scope.userInfo = {};
    var init = function () {
        $http({
            method: "GET",
            url: "/mzhotel/pimsTest/getResource?queryDate=123456"
        }).then(function successCallback(result) {
            $scope.pimsTestList = result.data;
            console.log($scope.pimsTestList);
        }, function errorCallback() {

        })
    };
    $scope.login = function () {
        $http({
            method: "POST",
            url: "/mzhotel/login/login",
            data: $scope.queryUserInfo
        }).then(function successCallback(result) {
            //$scope.pimsTestList = result.data;
            //console.log($scope.pimsTestList);
        }, function errorCallback() {

        })
    };
    $scope.addUser = function(){
        $http({
            method: "POST",
            url: "/mzhotel/userInfo/insert",
            data: $scope.userInfo
        }).then(function successCallback(result) {
            //$scope.pimsTestList = result.data;
            //console.log($scope.pimsTestList);
        }, function errorCallback() {

        })
    };
    init();
});

