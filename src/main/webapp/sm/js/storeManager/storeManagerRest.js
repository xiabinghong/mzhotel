define(function(require,exports){
    require("../app.inner")
    return angular.module("StoreManager.REST",[
        "ngResource","ng-ui"
    ]).factory("StoreManagerAPI",["ugResource",function (ugResource) {
        return ugResource("/storehouse/:id",{id:"@id"},{
            query:{isArray:false,method:"GET"},
            update:{method:"PUT",params:{id:"@id"}},
            save:{method:"POST"},
            remove:{method:"DELETE"},
            getStorehouseList:{isArray:true,method:"GET",url:appname+"/storehouse/getStorehouseList"},
            innerOrOutStore : {method:"POST",url:appname+"/storehouse/innerOrOutStore"}
        })
    }])
})
