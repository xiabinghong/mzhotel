define(function(require,exports){
    require("../app.inner")
    return angular.module("PersonalManager.REST",[
        "ngResource","ng-ui"
    ]).factory("PersonalManagerAPI",["ugResource",function (ugResource) {
        return ugResource("/personalReservation/:id",{id:"@id"},{
            query:{isArray:false,method:"GET"},
            update:{method:"PUT",params:{id:"@id"}},
            save:{method:"POST"},
            remove:{method:"DELETE"},
            getPersonalReservationList:{isArray:true,method:"GET",url:appname+"/personalReservation/getPersonalReservationList"}
        })
    }])
})
