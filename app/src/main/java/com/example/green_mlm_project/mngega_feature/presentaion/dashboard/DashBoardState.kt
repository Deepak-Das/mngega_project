package com.example.green_mlm_project.mngega_feature.presentaion.dashboard

import com.example.green_mlm_project.mngega_feature.Domain.model.DashboardResponse

data class DashBoardState(
    var response: DashboardResponse=DashboardResponse("","","","","","","","","","",0),
    var contection:Boolean=false,
    var primaryKey: String?=null
)
