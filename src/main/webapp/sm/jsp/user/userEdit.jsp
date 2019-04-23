<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/header_inner.jsp"%>
<div ng-controller="userEditController" style="align-content: left;">
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
                                    <label class="col-sm-1 control-label text-right">账号</label>
                                    <div class="col-sm-3">
                                        <input type="text" class="form-control" ng-disabled="pageSetting.disabled" ng-model="user.userId">
                                    </div>
                                    <label class="col-sm-1 control-label text-right">用户名称</label>
                                    <div class="col-sm-3">
                                        <input type="text" class="form-control" ng-disabled="pageSetting.disabled" ng-model="user.username">
                                    </div>
                                    <label class="col-sm-1 control-label text-right">用户密码</label>
                                    <div class="col-sm-3">
                                        <input type="text" class="form-control" ng-disabled="pageSetting.disabled" ng-model="user.password">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-1 control-label text-right">联系方式</label>
                                    <div class="col-sm-3">
                                        <input type="text" class="form-control" ng-disabled="pageSetting.disabled" ng-model="user.tel">
                                    </div>
                                    <label class="col-sm-1 control-label text-right">地址</label>
                                    <div class="col-sm-3">
                                        <input type="text" class="form-control" ng-disabled="pageSetting.disabled" ng-model="user.address">
                                    </div>
                                    <label class="col-sm-1 control-label text-right">状态</label>
                                    <div class="col-sm-3">
                                        <input type="text" class="form-control" ng-disabled="pageSetting.disabled" ng-model="user.state">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-1 control-label text-right">备注</label>
                                    <div class="col-sm-3">
                                        <input type="text" class="form-control" ng-disabled="pageSetting.disabled" ng-model="user.remark">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-12 text-center" style="margin:20px;">
                        <shiro:hasPermission name="USER_OPERATE:BUTTON:EDIT">
                            <input ng-show="pageSetting.disabled" ng-click="edit();" class="btn btn-success" type="button" value="修改">
                        </shiro:hasPermission>
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
    seajs.use('../../../sm/js/user/userEdit');
</script>
