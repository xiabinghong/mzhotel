define(function(require,exports){
    require("../app.inner")
    return angular.module("Role.REST",[
        "ngResource","ng-ui"
    ]).factory("RoleAPI",["ugResource",function (ugResource) {
        return ugResource("/role/:id",{id:"@id"},{
            query:{isArray:false,method:"GET"},
            update:{method:"PUT",params:{id:"@id"}},
            save:{method:"POST"},
            remove:{method:"DELETE"},
            getRoleList:{isArray:true,method:"GET",url:appname+"/role/getRoleList"}
        })
    }])
})
