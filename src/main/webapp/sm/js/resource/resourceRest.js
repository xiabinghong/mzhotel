define(function (require, exports) {
    require("../app.inner")
    return angular.module("Resource.REST", [
        "ngResource", "ng-ui"
    ]).factory("ResourceAPI", ["ugResource", function (ugResource) {
        return ugResource("/resource/:id", {id: "@id"}, {
            query: {isArray: false, method: "GET"},
            update: {method: "PUT", params: {id: "@id"}},
            save: {method: "POST"},
            remove: {method: "DELETE"}
        })
    }])
})