define(function(require,exports){
    require("../app.inner")
    return angular.module("DinnerManager.REST",[
        "ngResource","ng-ui"
    ]).factory("DinnerManagerAPI",["ugResource",function (ugResource) {
        return ugResource("/dinnerParty/:id",{id:"@id"},{
            query:{isArray:false,method:"GET"},
            update:{method:"PUT",params:{id:"@id"}},
            save:{method:"POST"},
            remove:{method:"DELETE"},
            getDinnerPartyList:{isArray:true,method:"GET",url:appname+"/dinnerParty/getDinnerPartyList"}
        })
    }])
})
