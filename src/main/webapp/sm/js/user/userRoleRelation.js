define(function (require, exports) {
    var moduleName = "userRoleRelationModule";
    require("../app.directives");
    require("./userRest");
    var moduleApp = angular.module(moduleName, ["common", "User.REST"]);
    moduleApp.controller("userRoleRelationController", ["$scope", "$UrlUtils", "UserAPI", function ($scope, $UrlUtils, UserAPI) {
        $scope.query = {};
        $scope.file = null;
        $scope.pageSetting = {
            disabled: true,
            loading: false
        };
        var params = $UrlUtils.getParameters();
        $scope.userRoleRelation = null;
        $scope.userHasRoleRelation = null;
        $scope.userNotHasRoleRelation = null;
        $scope.hasRoleItem = null;
        $scope.notHasRoleItem = null;
        $scope.user = {};
        $scope.init = function () {
            UserAPI.userRoleRelation({
                userId:params.userId,
                queryType: "ALL"
            }, function (result) {
                $scope.userRoleRelation = result;
                $scope.userHasRoleRelation = $scope.userRoleRelation.userHasRoleList;
                $scope.userNotHasRoleRelation = $scope.userRoleRelation.userNotHasRoleList;
            });
        };

        $scope.findUserHasRole = function () {
            UserAPI.userRoleRelation({
                userId:params.userId,
                roleName: $scope.query.HasRoleName,
                queryType: "USER_HAS_ROLE"
            }, function (result) {
                $scope.userHasRoleRelation = result.userHasRoleList;
            });
        };

        $scope.findUserNotHasRole = function () {
            UserAPI.userRoleRelation({
                userId:params.userId,
                roleName: $scope.query.notHasRoleName,
                queryType: "USER_NOT_HAS_ROLE"
            }, function (result) {
                $scope.userNotHasRoleRelation = result.userNotHasRoleList;
            });
        };

        $scope.choiceHasRoleItem = function (item) {
            $scope.hasRoleItem = item;
        };

        $scope.choiceNotHasRoleItem = function (item) {
            $scope.notHasRoleItem = item;
        };

        $scope.subRolesInfo = function (type) {
            if (type == 1) {
                if (!$scope.notHasRoleItem) {
                    alert("请选择角色");
                    return;
                }
                UserAPI.addUserRole({
                    userId:params.userId,
                    roleCode: $scope.notHasRoleItem.roleCode
                }, $scope.user, function (result) {
                    $scope.init();
                    alert("操作成功");
                }).$promise.finally(function () {
                    $scope.pageSetting.loading = false;
                });
            } else if (type == 2) {
                if (!$scope.hasRoleItem) {
                    alert("请选择角色");
                    return;
                }
                UserAPI.removeUserRole({
                    userId:params.userId,
                    roleCode: $scope.hasRoleItem.roleCode
                }, function (result) {
                    $scope.init();
                    alert("操作成功");
                }).$promise.finally(function () {
                    $scope.pageSetting.loading = false;
                });
            }
        };
        $scope.close = function () {
            window.close();
        };
        $scope.init();
    }]);
    window.angular.bootstrap(document, [moduleName]);
});