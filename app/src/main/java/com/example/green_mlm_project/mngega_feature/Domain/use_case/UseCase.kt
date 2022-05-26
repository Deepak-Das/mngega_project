package com.example.green_mlm_project.mngega_feature.Domain.use_case

data class UseCase(
    val loginAccount:GetLoginStatus,
    val sponsorCheck:SponsorSatus,
    val registerAccount:GetRegisterStatus,
    val GetDashboardDetail:GetDashboardDetails
)
