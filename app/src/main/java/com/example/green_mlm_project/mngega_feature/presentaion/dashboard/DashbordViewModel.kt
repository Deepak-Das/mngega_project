package com.example.green_mlm_project.mngega_feature.presentaion.dashboard

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.green_mlm_project.mngega_feature.Domain.use_case.UseCase
import com.example.green_mlm_project.mngega_feature.presentaion.utli.UserPreference
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashbordViewModel @Inject constructor(
    private val useCase: UseCase,
    val userPreference: UserPreference,
    savedStateHandle: SavedStateHandle
) :ViewModel() {


    private val _sate = mutableStateOf(DashBoardState())
    val state:State<DashBoardState> = _sate


//    init {
//        Log.d("TAG", "collectxxx start: ${"Start"}")
//
//        savedStateHandle.get<String>("primary_id")?.let { id ->
//            Log.d("TAG", "collectxxx id: ${id}")
//            if(id!=null){
//                viewModelScope.launch {
//                useCase.GetDashboardDetail(id).collectLatest {
//                    Log.d("TAG", "collectxxx: ${it.toString()}")
//                    _sate.value=state.value.copy(
//                        response = it
//                    )
//                }
//                }
//            }
//
//        }
//    }

    init {
        Log.d("TAG", "init: ${savedStateHandle.get<String>("primaryId")}")

        savedStateHandle.get<String>("primaryId")?.let {
            setreponse(it)

        }
    }

    fun setreponse(id:String){
        Log.d("TAG", "collectxxx: primary  ${id.toString()}")
        if(id!=null){
            viewModelScope.launch {
                useCase.GetDashboardDetail(id).collectLatest {
                    Log.d("TAG", "collectxxx: ${it.toString()}")
                    _sate.value=state.value.copy(
                        response = it
                    )
                }
            }
        }
    }
    suspend fun logOut(){
        userPreference.saveLoginCode(-1)
    }
    suspend fun setPrimaryId(){
        userPreference.savePrimaryId(-1)
    }

}