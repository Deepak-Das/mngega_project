package com.example.green_mlm_project.mngega_feature.presentaion.login

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
class LoginViewModel @Inject constructor(
    private val userCase: UseCase
) : ViewModel() {

    private val _state = mutableStateOf(LoginState())
    val state: State<LoginState> = _state

    fun loginCall() = viewModelScope.launch {

        userCase

        userCase.loginAccount(username = state.value.username, password = state.value.password).also {
            _state.value = state.value.copy(
                response = it
            )
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
}