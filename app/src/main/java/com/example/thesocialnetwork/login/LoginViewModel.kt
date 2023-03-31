package com.example.thesocialnetwork.login

import android.util.Patterns
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

data class LoginState(
    val isSuccess: Boolean = false,
    val error: Throwable? = null
)

class LoginViewModel(
    private val loginRepository: LoginRepository = LoginRepository()
) : ViewModel() {

    private val _state = MutableStateFlow(LoginState())
    val state: StateFlow<LoginState> = _state

    private fun isValidEmail(email: String): Boolean {
        val cleanEmail = email.trim().lowercase()
        return Patterns.EMAIL_ADDRESS.matcher(cleanEmail).matches() && email.isNotEmpty()
    }

    private fun isValidPassword(password: String): Boolean {
        val cleanPassword = password.trim()
        return cleanPassword.isNotEmpty()
    }

    fun login(email: String, password: String) {
        val isValidEmail = isValidEmail(email)
        val isValidPassword = isValidPassword(password)

        if (isValidEmail && isValidPassword) {
            viewModelScope.launch(Dispatchers.IO) {
                val token = loginRepository.login(email.trim().lowercase(), password.trim())
                if (token == null) {
                    println("Error the token is null")
                } else {
                    println("Token: $token")
                }
            }
        } else {
            _state.value = _state.value.copy(
                error = RuntimeException("Invalid credentials")
            )
        }
        println("HI COROUTINES")
    }
}
