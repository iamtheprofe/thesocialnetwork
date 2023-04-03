package com.example.thesocialnetwork.signup

import android.util.Patterns
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

data class SignUpState(
    val isSuccess: Boolean = false,
    val error: Throwable? = null
)

class SignUpViewModel(
    private val signUpRepository: SignUpRepository = SignUpRepository()
) : ViewModel() {
    private val _state = MutableStateFlow(SignUpState())
    val state: StateFlow<SignUpState> = _state

    private fun isValidEmail(email: String): Boolean {
        val cleanEmail = email.trim().lowercase()
        return Patterns.EMAIL_ADDRESS.matcher(cleanEmail)
            .matches() && email.isNotEmpty()
    }

    private fun isValidName(fullName: String): Boolean {
        val cleanName = fullName.trim()
        return cleanName.isNotEmpty()
    }

    private fun isValidMobile(mobile: String): Boolean {
        val cleanMobile = mobile.trim()
        return cleanMobile.isNotEmpty()
    }

    fun signUp(email: String, fullName: String, mobile: String) {
        val isValidEmail = isValidEmail(email)
        val isValidName = isValidName(fullName)
        val isValidMobile = isValidMobile(mobile)

        if (isValidEmail && isValidName ) {
            viewModelScope.launch(Dispatchers.IO) {
                val token = signUpRepository.signUp(
                    email.trim().lowercase(),
                    fullName.trim(),
                    mobile.trim()
                )
                if (token == null) {
                    println("Error, the token is null")
                } else {
                    println("Token: $token")
                } }
        } else {
            _state.value = _state.value.copy(
                error = RuntimeException("Invalid credentials")
            )
        }
        println("HI COROUTINES")
    }
}