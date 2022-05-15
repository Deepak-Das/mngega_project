package com.example.green_mlm_project.mngega_feature.presentaion.Registration

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.green_mlm_project.mngega_feature.Domain.use_case.UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val useCase: UseCase) :ViewModel() {

    private val _state= mutableStateOf(RegisterState())
    val state:State<RegisterState> = _state

    fun sponsorCheck()=viewModelScope.launch {
        useCase.sponsorCheck(state.value.referal).also {
            if(it.error_code==22)
                setSponsorText("invalid sponsor id")
            else if(it.error_code==11)
                setWaring(false)

            Log.i("sponser", "sponsorCheck: $it")
            _state.value=state.value.copy(
                response = it
            )
        }
    }

    fun setWaring(flag:Boolean){
        _state.value=state.value.copy(
            waring = flag
        )
    }
    fun setSponsorId(id:String){
        _state.value=state.value.copy(
            referal = id
        )
    }
    fun setSponsorText(text:String){
        _state.value=state.value.copy(
            sponsorText = text
        )
    }

}