define(function (require, exports) {
    require("../app.inner")
    return angular.module("DocumentInfo.REST", [
        "ngResource", "ng-ui"
    ]).factory("DocumentInfoAPI", ["ugResource", function (ugResource) {
        return ugResource("/documentInfo/:id", {id: "@id"}, {
            query: {isArray: false, method: "GET"},
            update: {method: "PUT", params: {id: "@id"}},
            save: {method: "POST"},
            remove: {method: "DELETE"},
            upload: {method: "POST", url: appname + "/documentInfo/upload"}
        })
    }])
})
