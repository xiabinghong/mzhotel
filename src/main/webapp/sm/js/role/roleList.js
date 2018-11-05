define(function (require, exports) {
    var moduleName = "roleModule";
    require("../app.directives");
    require("./roleRest");
    var moduleApp = angular.module(moduleName, ["common", "role.REST"]);
    moduleApp.controller("roleListController", ["$scope", "$http", "$dialog", "roleAPI", function ($scope, $http, $dialog, roleAPI) {
        $scope.query = {};
        $scope.roleList = {};
        $scope.choiceItem = null;
        $scope.pageSetting = {
            pageSize: 10,
            pageNum: 1
        };
        $scope.getRoleList = function(){
            $scope.roleList = {};
            $scope.queryBtnLoading = true;
            $scope.choiceItem = null;
            roleAPI.query({
                roleName: $scope.query.roleName,
                roleType: $scope.query.roleType,
                pageNum: $scope.pageSetting.pageNum,
                pageSize: $scope.pageSetting.pageSize
            }, function (result) {
                $scope.roleList = angular.copy(result.data);
                $scope.pageSetting = result.pageBean;
                $scope.pageSetting.loadData = $scope.getRoleList;
            }).$promise.finally(function(){
                $scope.queryBtnLoading = false;
            });
        }
        $scope.init = function () {
            $scope.getRoleList();
        };
        $scope.reset = function () {
            $scope.query = {};
        };
        $scope.add = function () {
            $dialog.modal({
                url: "../role/roleEdit.jsp",
            });
        };
        $scope.view = function (item) {
            if (item && item.id) {
                $dialog.modal({
                    url: "../role/roleEdit.jsp",
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
                roleAPI.remove({
                    id: item.id
                }, function () {
                    alert("单据删除成功");
                    $scope.init();
                });
            } else {
                alert("请选择单据");
            }
        };
        $scope.innerStore = function () {

        };
        $scope.outStore = function () {

        };
        $scope.storeLog = function () {

        };
        $scope.init();
        window.doCallback = function () {
            $scope.init();
        }
    }]);
    window.angular.bootstrap(document, [moduleName]);
});


