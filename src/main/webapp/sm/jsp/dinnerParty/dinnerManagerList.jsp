<%--
  Created by IntelliJ IDEA.
  User: In The Future
  Date: 2018/6/5
  Time: 18:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="description" content="12">
    <meta name="author" content="12">
    <meta name="keyword" content="12">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>XXXXXX</title>
    <!-- start: Css -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <!-- plugins -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/plugins/font-awesome.min.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/plugins/simple-line-icons.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/plugins/animate.min.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/plugins/fullcalendar.min.css"/>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
    <!-- end: Css -->
</head>
<body>
<div ng-app="storeManagerApp" ng-controller="storeManagerController">
    <div class="col-md-12 padding-0 form-element">
        <div class="col-md-12">
            <div class="panel form-element-padding">
                <div style="padding-bottom:20px;">
                    <div class="form-group">
                        <label class="col-sm-1 control-label text-right">宴会类别</label>
                        <div class="col-sm-2">
                            <select class="form-control" ng-model="query.dinnerPartyType">
                                <option>option one</option>
                                <option>option two</option>
                                <option>option three</option>
                                <option>option four</option>
                            </select>
                        </div>
                        <label class="col-sm-1 control-label text-right" name=dinnerPartyUser ng-model="query.dinnerPartyUser">用户</label>
                        <label class="col-sm-1 control-label text-right" name=tel ng-model="query.tel">联系方式</label>
                        <label class="col-sm-1 control-label text-right" name=consumptionItem ng-model="query.consumptionItem">消费项目</label>
                        <div class="col-sm-2">
                            <input type="text" class="form-control">
                        </div>
                        <div class="col-sm-2">
                            <input class="btn btn-info" type="button" ng-click="init();" value="搜索">
                            <input class="btn btn-danger" type="button" ng-click="reset();" value="重置">
                        </div>
                    </div>
                </div>
            </div>
            <div class="panel">
                <div align="right" style="padding-top: 10px;">

                        <input class="btn btn-info" type="button" ng-click="add();" value="新增">

                        <input class="btn btn-info" type="button" ng-click="view(choiceItem);" value="查看">

                        <input class="btn btn-info" type="button" ng-click="delete(choiceItem)" value="删除">

                    <btn-download download-params="query" download-href="/mzhotel/storehouse/export" btn-text="导出"></btn-download>
                    <%--<input class="btn btn-info" type="button" ng-click="export()" value="导出">--%>

                </div>
                <div class="panel-body">
                    <div class="responsive-table">
                        <div id="datatables-example_wrapper" class="dataTables_wrapper form-inline dt-bootstrap no-footer">
                            <div>
                                <div class="col-sm-12">
                                    <table cellspacing="0" style="width: 100%;">
                                        <tr align="center">
                                            <td>序号</td>
                                            <td>宴会类别</td>
                                            <td>用户</td>
                                            <td>联系方式</td>
                                            <td>消费项目</td>
                                            <td>备注</td>
                                            <td>创建人</td>
                                            <td>创建时间</td>
                                            <td>修改人</td>
                                            <td>修改时间</td>
                                        </tr>
                                        <tr align="center" ng-show="DinnerPartyManagerList"
                                            ng-repeat="list in DinnerPartyManagerList"
                                            ng-class="{'current-tr':choiceItem.id == list.id}"
                                            ng-click="choiceViewItem(list)"
                                            data-ng-dbclick="choiceViewItem(list)">
                                            <td ng-bind="$index+1"></td>
                                            <td ng-bind="list.dinnerPartyType"></td>
                                            <td ng-bind="list.dinnerPartyUser"></td>
                                            <td ng-bind="list.tel"></td>
                                            <td ng-bind="list.consumptionItem"></td>
                                            <td ng-bind="list.remark"></td>
                                            <td ng-bind="list.createdBy"></td>
                                            <td ng-bind="list.createdDate"></td>
                                            <td ng-bind="list.updatedBy"></td>
                                            <td ng-bind="list.updatedDate"></td>
                                        </tr>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
<script src="${pageContext.request.contextPath}/js/html5shiv.min.js"></script>
<script src="${pageContext.request.contextPath}/js/respond.min.js"></script>
<![endif]-->
<!-- start: Javascript -->
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.ui.min.js"></script>
<script src="${pageContext.request.contextPath}/js/tools/bootstrap.js"></script>
<!-- plugins -->
<script src="${pageContext.request.contextPath}/js/plugins/jquery.nicescroll.js"></script>
<!-- custom -->
<script src="${pageContext.request.contextPath}/js/main.js"></script>
<script src="${pageContext.request.contextPath}/js/tools/angular.min.js"></script>
<script src="${pageContext.request.contextPath}/js/tools/angular-resource.min.js"></script>
<script src="${pageContext.request.contextPath}/js/tools/angular-animate.min.js"></script>
<script src="${pageContext.request.contextPath}/js/tools/ui-bootstrap-tpls.min.js"></script>
<script src="${pageContext.request.contextPath}/js/storeManager/storeManagerList.js"></script>
</body>
</html>
