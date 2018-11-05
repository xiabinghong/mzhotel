angular.module('ng-ui',[]).factory("ugResource",["$resource",function($resource){
    return function(url,params,methods){
        var resource = $resource(appname + url,params,methods);
        return resource;
    }
}])