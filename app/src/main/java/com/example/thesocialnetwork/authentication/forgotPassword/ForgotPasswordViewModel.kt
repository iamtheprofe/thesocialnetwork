package com.example.thesocialnetwork.authentication.forgotPassword

import android.util.Patterns
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.thesocialnetwork.authentication.shared.repository.AuthRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

data class ForgotPasswordState (
    val isSuccess: Boolean = false,
    val error: Throwable? = null
)

class ForgotPasswordViewModel (
    private val authRepository : AuthRepository = AuthRepository()
) : ViewModel (){
    private val _state = MutableStateFlow(ForgotPasswordState())
    val state : StateFlow<ForgotPasswordState> = _state
    private fun isValidEmailMobile (email:String):Boolean{
        val cleanEmail = email.trim().lowercase()
        return Patterns.EMAIL_ADDRESS.matcher(cleanEmail).matches() && email.isNotEmpty()
    }
    fun forgotPassword(emailMobile:String){
        val isValidEmailMobile = isValidEmailMobile(emailMobile)
        if(isValidEmailMobile){
            viewModelScope.launch(Dispatchers.IO){
        val token = authRepository.forgotPassword(emailMobile.trim().lowercase())
        if(token==null){
            println("Error token is null")
        }else{
            println("Token:$token")
        }
            }
        }else{
            _state.value = _state.value.copy(
                error = RuntimeException("Invalid Credencials")
            )
        }
    }
}
