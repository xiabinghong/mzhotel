define(function (require, exports) {
    var moduleName = "userListModule";
    require("../app.directives");
    require("./userRest");
    var moduleApp = angular.module(moduleName, ["common", "User.REST"]);
    moduleApp.controller("userListController", ["$scope", "$http", "UserAPI", "$dialog", function ($scope, $http, UserAPI, $dialog) {
        $scope.query = {};
        $scope.userList = {};
        $scope.choiceItem = null;
        $scope.pageSetting = {
            pageSize: 10,
            pageNum: 1
        };
        $scope.getUserList = function () {
            $scope.userList = {};
            $scope.queryBtnLoading = true;
            $scope.choiceItem = null;
            UserAPI.query({
                userId: $scope.query.userId,
                password: $scope.query.password,
                username: $scope.query.username,
                pageNum: $scope.pageSetting.pageNum,
                pageSize: $scope.pageSetting.pageSize
            }, function (result) {
                $scope.userList = angular.copy(result.data);
                $scope.pageSetting = result.pageBean;
                $scope.pageSetting.loadData = $scope.getUserList;
            }).$promise.finally(function () {
                $scope.queryBtnLoading = false;
            });
        }
        $scope.init = function () {
            $scope.getUserList();
        };
        $scope.reset = function () {
            $scope.query = {};
        };
        $scope.add = function () {
            $dialog.modal({
                url: "../user/userEdit.jsp",
            });
        };
        $scope.view = function (item) {
            if (item && item.id) {
                $dialog.modal({
                    url: "../user/userEdit.jsp",
                    params: {
                        id: item.id
                    }
                });
            } else {
                alert("请选择单据！");
            }
        };
        $scope.choiceViewItem = function (item) {
            $scope.choiceItem = item;
        };
        $scope.delete = function (item) {
            if (item && item.id) {
                UserAPI.remove({
                    id: item.id
                }, function () {
                    alert("单据删除成功");
                })
            } else {
                alert("请选择单据");
            }
        };
        $scope.init();
        window.doCallback = function () {
            $scope.init();
        }
    }]);
    window.angular.bootstrap(document, [moduleName]);
});