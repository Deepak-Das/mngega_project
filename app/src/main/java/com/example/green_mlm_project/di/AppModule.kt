package com.example.green_mlm_project.di

import com.example.green_mlm_project.mngega_feature.Domain.repository.RepositoryImp
import com.example.green_mlm_project.mngega_feature.Domain.use_case.*
import com.example.green_mlm_project.mngega_feature.data.data_soruce.ApiService
import com.example.green_mlm_project.mngega_feature.data.repository.Repository
import com.example.green_mlm_project.mngega_feature.presentaion.utli.UserPreference
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideApiService():ApiService{
        return ApiService()
    }

    @Singleton
    @Provides
    fun provideRepository(apiService: ApiService):Repository{
        return RepositoryImp(apiService);
    }

    @Singleton
    @Provides
    fun provideUseCase(repository: Repository):UseCase{
        return UseCase(
            loginAccount = GetLoginStatus(repository),
            sponsorCheck = SponsorSatus(repository),
            registerAccount = GetRegisterStatus(repository),
            GetDashboardDetail = GetDashboardDetails(repository)
        )


    }
//    @Provides
//    @Singleton
//    fun provideDataStoreClass(activityContext: ActivityContext):UserPreference{
//        return UserPreference(applicationContext)
//    }
}