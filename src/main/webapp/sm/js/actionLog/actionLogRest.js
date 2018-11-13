define(function (require, exports) {
    require("../app.inner")
    return angular.module("ActionLog.REST", [
        "ngResource", "ng-ui"
    ]).factory("ActionLogAPI", ["ugResource", function (ugResource) {
        return ugResource("/actionLog/:id", {id: "@id"}, {
            query: {isArray: false, method: "GET"},
            update: {method: "PUT", params: {id: "@id"}},
            save: {method: "POST"},
            remove: {method: "DELETE"},
            queryActionLogList: {isArray: true, method: "GET", url: appname + "/actionLog/queryActionLogList"}
        })
    }])
})
