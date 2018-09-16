var app = angular.module("indexApp", []);
app.controller("indexController", function ($scope, $http) {
    $('iframe').attr('src',"../mzhotel/shouye.jsp");
    $scope.transPage = function(value){
        if(value){
            $('iframe').removeAttr('src');
            $('iframe').attr('src',value);
        }
    };
});

