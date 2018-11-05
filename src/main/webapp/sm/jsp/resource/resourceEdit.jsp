<%--
  Created by IntelliJ IDEA.
  User: In The Future
  Date: 2018/6/5
  Time: 18:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/header_inner.jsp"%>
<div ng-controller="resourceEditController" style="align-content: left;">
    <div class="form-element">
        <div class="col-md-12 padding-0">
            <form>
                <div class="col-md-12">
                    <div class="panel form-element-padding">
                        <div class="panel-heading">
                            <h4>资源新增</h4>
                        </div>
                        <div class="panel-body" style="padding-bottom:10px;">
                            <div class="col-md-12">
                                <div class="form-group">
                                    <label class="col-sm-1 control-label text-right">资源名称</label>
                                    <div class="col-sm-3">
                                        <input type="text" class="form-control" ng-disabled="pageSetting.disabled" ng-model="resource.resourceName">
                                    </div>
                                    <label class="col-sm-1 control-label text-right">资源编号</label>
                                    <div class="col-sm-3">
                                        <input type="text" class="form-control" ng-disabled="pageSetting.disabled" ng-model="resource.resourceCode">
                                    </div>
                                    <label class="col-sm-1 control-label text-right">资源类型</label>
                                    <div class="col-sm-3">
                                        <input type="text" class="form-control" ng-disabled="pageSetting.disabled" ng-model="resource.resourceType">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-1 control-label text-right">页面地址</label>
                                    <div class="col-sm-3">
                                        <input type="text" class="form-control" ng-disabled="pageSetting.disabled" ng-model="resource.url">
                                    </div>
                                    <label class="col-sm-1 control-label text-right">父级资源</label>
                                    <div class="col-sm-3">
                                        <input type="text" class="form-control" ng-disabled="pageSetting.disabled" ng-model="resource.resource_parent">
                                    </div>
                                    <label class="col-sm-1 control-label text-right">操作类型</label>
                                    <div class="col-sm-3">
                                        <input type="text" class="form-control" ng-disabled="pageSetting.disabled" ng-model="resource.action">
                                    </div>
                            </div>

                                <div class="form-group">
                                    <label class="col-sm-1 control-label text-right">状态</label>
                                    <div class="col-sm-3">
                                        <input type="text" class="form-control" ng-disabled="pageSetting.disabled" ng-model="resource.state">
                                    </div>
                                    <label class="col-sm-1 control-label text-right">排序</label>
                                    <div class="col-sm-3">
                                        <input type="text" class="form-control" ng-disabled="pageSetting.disabled" ng-model="resource.order">
                                    </div>
                                    <label class="col-sm-1 control-label text-right">备注</label>
                                    <div class="col-sm-3">
                                        <input type="text" class="form-control" ng-disabled="pageSetting.disabled" ng-model="resource.remark">
                                    </div>
                                </div>
                        </div>
                    </div>
                    <div class="col-md-12 text-center" style="margin:20px;">
                        <input ng-show="pageSetting.disabled" ng-click="edit();" class="btn btn-success" type="button" value="修改">
                        <input ng-show="!pageSetting.disabled" ng-click="save();" class="btn btn-success" type="button" value="保存">
                        <input ng-show="!pageSetting.disabled" ng-click="cancel();" class="btn btn-danger" type="button" value="取消">
                        <input ng-click="close();" class="btn btn-warning" type="button" value="关闭">
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<%@include file="../common/common.jsp"%>
<script type = "text/javascript">
    seajs.use('../../js/resource/resourceEdit');
</script>
