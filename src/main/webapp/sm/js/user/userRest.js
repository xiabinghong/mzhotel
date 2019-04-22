define(function (require, exports) {
    require("../app.inner");
    return angular.module("User.REST", [
        "ngResource", "ng-ui"
    ]).factory("UserAPI", ["ugResource", function (ugResource) {
        return ugResource("/userInfo/:id", {id: "@id"}, {
            query: {isArray: false, method: "GET"},
            update: {method: "PUT", params: {id: "@id"}},
            save: {method: "POST"},
            remove: {method: "DELETE"},
            userRoleRelation: {method: "GET", url: appname + "/userInfo/getUserRoleRelation"},
            addUserRole:{method: "POST", url: appname + "/userInfo/addUserRole"},
            removeUserRole:{method: "DELETE", url: appname + "/userInfo/removeUserRole"}
        })
    }])
});