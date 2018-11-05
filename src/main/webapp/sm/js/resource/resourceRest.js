define(function(require,exports){
    require("../app.inner")
    return angular.module("Resource.REST",[
        "ngResource","ng-ui"
    ]).factory("ResourceAPI",["ugResource",function (ugResource) {
        return ugResource("/userInfo/:id",{id:"@id"},{
            query:{isArray:false,method:"GET"},
            update:{method:"PUT",params:{id:"@id"}},
            save:{method:"POST"},
            remove:{method:"DELETE"},
            getResourceList:{isArray:true,method:"GET",url:appname+"/resource/getResourceList"}
        })
    }])
})