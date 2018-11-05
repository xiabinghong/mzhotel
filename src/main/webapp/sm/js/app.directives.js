define(function (require, exports) {
    angular.module(
        "common", []
    ).factory("$UrlUtils", ["$location", function ($location) {
        return {
            getParameters: function () {
                var info = location.search;
                /*去除？*/
                info = info.length > 0 ? info.substring(1) : "";
                /*以&分割字符串*/
                var result1 = info.split("&");
                /*存储key和value的数组*/
                var key, value;
                var data = [];
                for (var i = 0; i < result1.length; i++) {
                    /*以=分割字符串*/
                    var result2 = result1[i].split("=");
                    key = result2[0];
                    value = result2[1];
                    if (key && key != '') {
                        data[key] = value;
                    }
                }
                return data;

                /* var params = {};
                 var obj = $location.search();
                 for (var key in obj) {
                     params[key] = obj[key];
                 }
                 return params;*/
            },
            getParamsUrlString: function () {
                var params = "";
                var obj = $location.search();
                for (var key in obj) {
                    params += key + "=" + encodeURIComponent(obj[key]);
                    params += "&";
                }
                params = params.substring(0, params.length - 1);
                return "?" + params;
            }
        }
    }]).factory("$dialog", [function () {
        return {
            modal: function (option) {
                var defaultConfig = {
                    url: "/"
                };
                angular.extend(defaultConfig, option);
                var paramstr = "";
                if (option.params) {
                    paramstr = "?";
                    for (var prop in option.params) {
                        if (angular.isDefined(option.params[prop])) {
                            paramstr = paramstr + prop + "=" + encodeURIComponent(option.params[prop]) + "&";
                        }
                    }
                }
                window.open(defaultConfig.url + paramstr, '_blank', 'status,scrollbars=yes,resizable,left=10,top=0,width=1000,height=600');
            }
        }
    }]).factory("pubSubService", ["$rootScope", function ($rootScope) {
        var _DATA_UPDATED_ = '_DATA_UPDATED_';
        var publish = function (msg, data) {
            msg = msg || _DATA_UPDATED_;
            $rootScope.$emit(msg, data);
        };
        var subscribe = function (msg, func, scope) {
            if (!angular.isFunction(func)) {
                console.log("pubSubService.subscribe need a callback function");
                return;
            }
            msg = msg || _DATA_UPDATED_;
            var unbind = $rootScope.$on(msg, func);
            if (scope) {
                scope.$on('$destroy', unbind)
            }
        };

        return {
            publish: publish,
            subscribe: subscribe
        };
    }]).directive("ugPagination", function () {
        return {
            restrict: 'E',
            replace: true,
            transclude: true,
            scope: {
                pageInfo: "=",
                loadParameter: "=",
                loadEvent: "&"
            },
            templateUrl: appname + "/sm/js/core/pageination-tpl.html",
            controller: ['$scope', '$attrs', '$timeout', function ($scope, $attrs, $timeout) {
                $scope.maxSize = "10";
                $scope.pageInfo = angular.extend({}, {
                    showSkip: true,
                    showTotal: true,
                    total: 0,
                    showPageNum: true,
                    pageSize: 10,
                    pageNum: 1,
                    styleCss: 1
                }, $scope.pageInfo);
                $scope.$watch('pageInfo', function (newVal, oldVal) {
                    if (newVal && newVal !== oldVal) {
                        $scope.load();
                    }
                }, true);
                $scope.load = function () {
                    $scope.curPage = $scope.pageInfo.pageNum;
                    $scope.pageSize = $scope.pageInfo.pageSize;
                    $scope.total = $scope.pageInfo.total ? $scope.pageInfo.total : 0;
                    if ($scope.pageInfo.pages) {
                        $scope.pages = $scope.pageInfo.pages;
                    } else {
                        $scope.pages = 1;
                    }
                    $scope.pageList = [];
                    for (var i = 1; i <= $scope.pages; i++) {
                        var page = {
                            isDisabled: false,
                            num: i,
                            isOmit: false,
                            text: "",
                            isShow: true
                        };
                        if (page.num == $scope.curPage) {
                            page.isDisabled = true;
                        }
                        if ($scope.pages < 6) {
                            $scope.pageList.push(page);
                        } else {
                            if (i == 1) {
                                $scope.pageList.push($scope.page);
                                continue;
                            }
                            if (i == $scope.pages) {
                                $scope.pageList.push(page);
                                continue;
                            }
                            if ($scope.curPage >= 1 && $scope.curPage <= $scope.pages) {
                                if (($scope.curPage - 1) == i || ($scope.curPage + 1) == i || $scope.curPage) {
                                    if (($scope.curPage - 1) == i && i != $scope.curPage) {
                                        var page2 = angular.copy(page);
                                        page2.isOmit = true;
                                        page2.text = "...";
                                        page2.num = "...";
                                        if (i != 2) {
                                        }
                                        $scope.pageList.push(page);
                                    } else if (($scope.curPage + 1) == i && i != $scope.curPage) {
                                        $scope.pageList.push(page);
                                        var page2 = angular.copy(page);
                                        page2.isOmit = true;
                                        page2.text = "...";
                                        page2.num = "...";
                                        if (i != ($scope.pages - 1)) {
                                        }
                                    }
                                    if (i == $scope.curPage) {
                                        $scope.pageList.push(page);
                                    }
                                }
                            }
                        }
                    }
                };
                $scope.$watch("maxSize", function (newVal, oldVal) {
                    if (newVal != oldVal) {
                        var oldMax = parseInt(oldVal);
                        var newMax = parseInt(newVal);
                        if (oldMax < newMax) {
                            $scope.pageInfo.pageNum = 1;
                            $scope.pageInfo.pageSize = newMax;
                        } else {
                            $scope.pageInfo.pageSize = newMax;
                        }
                        if ($attrs.loadEvent) {
                            $scope.loadEvent();
                        } else {
                            $scope.pageInfo.loadData();
                        }
                    }
                });
                $scope.skipPage = function (num) {
                    num = parseInt(num);
                    if (num <= $scope.pages && num >= 1) {
                        $scope.pageInfo.pageNum = num;
                    } else if (num > $scope.pages) {
                        $scope.pageInfo.pageNum = angular.copy($scope.pages);
                        $scope.inPageNo = angular.copy($scope.pages);
                    } else if (num < 1) {
                        $scope.pageInfo.pageNum = 1;
                        $scope.inPageNo = 1;
                    }
                    if ($attrs.loadEvent) {
                        $scope.loadEvent();
                    } else {
                        $scope.pageInfo.loadData();
                    }
                };
                var t;
                $scope.$watch("loadParameter", function (newVal, oldVal) {
                    if (newVal != oldVal) {
                        if (t) {
                            $timeout.cancel(t);
                            t = $timeout(function () {
                                $scope.pageInfo.pageNum = 1;
                                if ($attrs.loadEvent) {
                                    $scope.loadEvent();
                                } else {
                                    $scope.pageInfo.loadData();
                                }
                                $timeout.cancel(t);
                            }, 1000)
                        } else {
                            t = $timeout(function () {
                                $scope.pageInfo.pageNum = 1;
                                if ($attrs.loadEvent) {
                                    $scope.loadEvent();
                                } else {
                                    $scope.pageInfo.loadData();
                                }
                                $timeout.cancel(t);
                            }, 1000)
                        }
                    }
                }, true);
                $scope.load();
            }]
        };
    }).directive("btnDownload", ["$timeout", "$q", "$dialog", function ($timeout, $q, $dialog) {
        return {
            restrict: 'E',
            replace: 'true',
            template: '<button type="button" class="btn btn-info" ng-click="handleClick()"><i class="fa fa-arrow-down">&nbsp;&nbsp;</i>{{text}}</button>',
            scope: {
                btnText: "@",
                downloadUrl: "=",
                downloadHref: "@",
                downloadParams: "="
            },
            link: function (scope, element, attr) {
                if (attr.btnText) {
                    scope.text = attr.btnText;
                } else {
                    scope.text = '下载模板';
                }
                scope.handleClick = function () {
                    if (!attr.downloadUrl && !attr.downloadHref) {
                        $dialog.alert("btn-down directive only choice one attribute: download-url or download-href.");
                    }
                    var defer = $q.defer();
                    var anchor = angular.element("<iframe/>");
                    anchor.attr({
                        style: "display:none",
                        src: function () {
                            var params = "";
                            if (attr.downloadParams) {
                                for (var p in scope.downloadParams) {
                                    if (scope.downloadParams[p] != '' && scope.downloadParams[p] != null) {
                                        if (params == "") {
                                            params += "?" + p + "=" + encodeURIComponent(scope.downloadParams[p]);
                                        } else {
                                            params += "&" + p + "=" + encodeURIComponent(scope.downloadParams[p]);
                                        }
                                    }
                                }
                            }
                            if (attr.downloadUrl && attr.downloadHref) {
                                return scope.downloadUrl + params;
                            } else if (attr.downloadHref && attr.downloadHref) {
                                return scope.downloadHref + params;
                            }
                        },
                        onLoad: function () {
                            $timeout(function () {
                                anchor.remove();
                            }, 50000);
                        }
                    });
                    angular.element("body").append(anchor);
                    return defer.promise;
                }
            }
        }
    }]).directive("uiaSelect", ["$compile", "$http", function ($compile, $http) {
        return {
            restrict: "A",
            scope: {
                dictCode: "=",
                dictParentCode: "=",
                dictSource: "@?",
                ngModel: "=",
                permissionFilter: "@?",
                include: "=?"
            },
            require: ["?ngModel", "select"],
            templateUrl: '<option value>请选择</option>\n' +
            '<option ng-repeat="item in dictInfoList" ng-selected = "item.selected" value = "{{item.dictCode}}">{{item.dictName}}</option>',
            link: function (scope, elem, attrs, ctrls) {
                scope.isChange = false;
                if (angular.isUndefined(attrs.dictCode)) {
                    throw new Error("directive dict must be define 'dict-code.'");
                } else {
                    scope.dictCode = scope.dictCode || attrs.dictCode;
                }
                if (angular.isDefined(attrs.dictParentCode)) {
                    scope.$watch("dictParentCode", function (newVal, oldVal) {
                        if (newVal != oldVal) {
                            if (!newVal) {
                                scope.dictInfoList = [];
                                scope.ngModel = null;
                            } else {
                                getDictInfoList();
                            }
                        }
                    })
                }
                scope.$watch("ngModel", function (newVal, oldVal) {
                    if (newVal === null) {
                        scope.ngModel = null;
                    }
                    if (newVal != oldVal) {
                        angular.forEach(scope.dictInfoList, function (value, index) {
                            var code = scope.ngModel;
                            if (scope.dictCode = code) {
                                scope.dictInfoList[index].selected = true;
                            }
                        });
                    }
                });
                var getDictInfoList = function () {
                    scope.dictInfoList = [];
                    var params = {};
                    if (scope.dictParentCode) {
                        params.parentCode = scope.dictParentCode;
                    }
                    if (scope.dictCode) {
                        params.dictCode = scope.dictCode;
                    }
                    if (scope.dictSource) {
                        params.dictSource = scope.dictSource
                    }
                    $http.get("", {
                        params: params
                    }).then(function () {
                        //data.datat = handleResult(data.data);
                        scope.dictInfoList = data.data;
                        var change = true;
                        angular.forEach(scope.dictInfoList, function (value, index) {
                            var code = scope.ngModel;
                            if (value.dictCode = code) {
                                scope.dictInfoList[index].selected = true;
                                change = false;
                            }
                        });
                        if (change) {
                            scope.ngModel = null;
                        }
                    });
                };
                if (!angular.isDefined(attrs.dictParentCode) || (angular.isDefined(attrs.dictParentCode) && scope.dictParentCode)) {
                    getDictInfoList();
                };
            }
        }
    }])
})