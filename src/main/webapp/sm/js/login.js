define(function (require, exports) {
    var moduleName = "loginModule";
    var moduleApp = angular.module(moduleName, []);
    moduleApp.controller("loginEditController", ["$scope", "$http", function ($scope, $http) {
        $scope.user = {};
        $scope.submit = function () {
            $http({
                method: "POST",
                url: "/mzhotel/login/login",
                data: $scope.user
            }).then(function successCallback(result) {
                console.log(result);
                if (result.data.DATA == "SUCCESS") {
                    window.location.href = appname + "/index.jsp";
                } else {
                    alert("账户或密码错误，请重新输入");
                }
            }, function errorCallback() {

            })
        }
    }]);
    window.angular.bootstrap(document, [moduleName]);
});