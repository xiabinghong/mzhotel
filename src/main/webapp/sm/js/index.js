var app = angular.module("indexApp", []);
app.controller("indexController", function ($scope, $http) {
    $('iframe').attr('src', "/mzhotel/sm/jsp/user/userList.jsp");
    $scope.transPage = function (value) {
        if (value) {
            $('iframe').removeAttr('src');
            $('iframe').attr('src', value);
        }
    };
});