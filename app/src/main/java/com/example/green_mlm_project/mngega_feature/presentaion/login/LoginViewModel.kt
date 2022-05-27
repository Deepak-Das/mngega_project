package com.example.green_mlm_project.mngega_feature.presentaion.login

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.green_mlm_project.mngega_feature.Domain.use_case.UseCase
import com.example.green_mlm_project.mngega_feature.presentaion.utli.UserPreference
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val userCase: UseCase,
    private val userPreference: UserPreference
) : ViewModel() {

    private val _state= mutableStateOf(LoginState())
    val state: State<LoginState> = _state
    val readLoginCode=userPreference.readLoginCode
    val readPrimaryId=userPreference.readPrimaryID
//    val readData=userPreference.readPrimaryID




    fun loginCall() = viewModelScope.launch {
        userCase.loginAccount(username = state.value.username, password = state.value.password).also {
            _state.value = state.value.copy(
                response = it
            )
            userPreference.saveLoginCode(it?.error_code)
            userPreference.savePrimaryId(it?.primary_id?.toInt())

            if(it?.primary_id==null){
                userPreference.savePrimaryId(it?.primary_id?.toInt())
            }
        }

            if (state.value.response?.error_code ==2) {
                setError("Invalid username or password")
                setWarning(true)
            }else if (state.value.response?.error_code ==3) {
                setError("Please provide all data")
                setWarning(true)
            }


        Log.i("ViewModeloooooo", "call: ${state.value.response}")

    }


    fun setUsername(text: String) {
        _state.value = state.value.copy(
            username = text
        )

    }

    fun setPassword(text: String) {
        _state.value = state.value.copy(
            password = text
        )
    }

    fun setWarning(flag: Boolean) {
        _state.value = state.value.copy(
            warning = flag
        )
    }

    fun setConnection(flag: Boolean) {
        _state.value = state.value.copy(
            contection = flag
        )
    }

    fun setError(text:String) {
        _state.value = state.value.copy(
            errorText = text
        )
    }
    fun setlogicCode(code:Int) {
        _state.value = state.value.copy(
            loginCode = code
        )
    }
    fun setPrimaryID(code:Int) {
        _state.value = state.value.copy(
            primaryID = code
        )
    }

    fun setState() {
        _state.value = state.value.copy(
            response = null,
            username = "",
            password = "",
            warning = false,
            errorText = "",
        )
    }





}


