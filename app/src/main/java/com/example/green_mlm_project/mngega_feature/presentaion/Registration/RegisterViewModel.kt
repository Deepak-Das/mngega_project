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
class RegisterViewModel @Inject constructor(private val useCase: UseCase) : ViewModel() {


    private val _state = mutableStateOf(RegisterState())
    val state: State<RegisterState> = _state


    fun sponsorCheck() = viewModelScope.launch {
        if(state.value.connection){
            useCase.sponsorCheck(state.value.sponsorId).also {
                if (it.error_code == 22)
                    setSponsorText("invalid sponsor id")
                else if (it.error_code == 11)
                    setWaring(false)

                Log.i("sponser", "sponsorCheck: $it")
                _state.value = state.value.copy(
                    sponsor_response = it
                )
            }
        }
    }

    fun registerAccount() = viewModelScope.launch {
        if(state.value.connection){
            useCase.registerAccount(
                state.value.sponsorId,
                state.value.firstName,
                state.value.lastName,
                state.value.email,
                state.value.contact,
                state.value.password
            ).also {

                when (it.error_code) {
                    0 -> setRegisterText("Account created successfully")
                    1 -> setRegisterText("id restrictions for same data")
                    2 -> setRegisterText("invalid sponsorid")
                    3 -> setRegisterText("please provide all data")
                }

                setRegisterStatus(true)



                Log.i("sponser", "sponsorCheck: $it")
                _state.value = state.value.copy(
                    registor_response = it
                )
            }
        }
    }

    fun setWaring(flag: Boolean) {
        _state.value = state.value.copy(
            waring = flag
        )
    }

    fun setSponsorId(id: String) {
        _state.value = state.value.copy(
            sponsorId = id
        )
    }

    fun setSponsorText(text: String) {
        _state.value = state.value.copy(
            sponsorText = text
        )
    }

    fun setFirstName(text: String) {
        _state.value = state.value.copy(
            firstName = text
        )
    }

    fun setLastName(text: String) {
        _state.value = state.value.copy(
            lastName = text
        )
    }

    fun setEmail(text: String) {
        _state.value = state.value.copy(
            email = text
        )
    }

    fun setPassword(text: String) {
        _state.value = state.value.copy(
            password = text
        )
    }

    fun setSpouse(text: String) {
        _state.value = state.value.copy(
            spouse = text
        )
    }

    fun setContact(text: String) {
        _state.value = state.value.copy(
            contact = text
        )
    }

    fun setRegisterText(text: String) {
        _state.value = state.value.copy(
            registerText = text
        )
    }

    fun setRegisterStatus(flag: Boolean) {
        _state.value = state.value.copy(
            registerStatus = flag
        )
    }

    fun setConnection(flag: Boolean) {
        _state.value = state.value.copy(
            connection = flag
        )
    }
}
