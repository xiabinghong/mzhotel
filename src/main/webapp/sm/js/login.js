define(function (require, exports) {
    var moduleName = "loginModule";
    var moduleApp = angular.module(moduleName, []);
    moduleApp.controller("loginEditController", ["$scope", "$http", function ($scope, $http) {
        $scope.user = {};
        $scope.loging = function () {
           /* $ajax({
                type: 'POST',
                url: url,
                data: data,
                success: success,
                dataType: dataType
            });*/
            $http({
                method: "POST",
                url: "/mzhotel/login/login",
                data: $scope.user
            }).then(function(response) {
                if(response.data.DATA == "SUCCESS"){
                    window.location.href = appname + "/index.jsp";
                } else {
                    alert("账户或密码错误，请重新输入");
                }
            });




            /*,function (result) {
                console.log(result);
                if (result.data.DATA == "SUCCESS") {
                    window.location.href = appname + "/index.jsp";
                } else {
                    alert("账户或密码错误，请重新输入");
                }
            })*/
        }
    }]);
    window.angular.bootstrap(document, [moduleName]);
});