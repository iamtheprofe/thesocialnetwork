package com.example.thesocialnetwork.authentication.signup

import android.util.Patterns
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.thesocialnetwork.authentication.shared.repository.RemoteAuthRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

data class RegisterState(
    val isLoading: Boolean = false,
    val error: Throwable? = null,
    val token: String? = null,
    val isSuccess : Boolean = false,
)

class SignUpViewModel(
    private val authRepository: RemoteAuthRepository = RemoteAuthRepository()
) : ViewModel() {

    private val internalState = MutableStateFlow(RegisterState())
    val state: StateFlow<RegisterState> = internalState

    fun signUp(email: String, password: String) {
        val isValidEmail = isValidEmail(email)
        val isValidatePassword = isValidatePassword(password)

        if (isValidEmail && isValidatePassword) {
            internalState.value = internalState.value.copy(
                isLoading = true
            )
            viewModelScope.launch(Dispatchers.IO) {
                val response = authRepository.singUp(email, password)
                if (response == null) {
                    internalState.value = internalState.value.copy(
                        error = Throwable("invalid credentials")
                    )
                } else {
                    internalState.value = internalState.value.copy(
                        isSuccess = true
                    )
                }
            }
        }

    }

    private fun isValidEmail(email: String): Boolean {
        val cleanEmail = email.trim().lowercase()
        return if (Patterns.EMAIL_ADDRESS.matcher(cleanEmail).matches()) {
            true
        } else {
            internalState.value = internalState.value.copy(
                error = Throwable("invalid email")
            )
            false
        }
    }

    private fun isValidatePassword(password: String): Boolean {
        val cleanPassword = password.trim()
        return if (cleanPassword.isNotEmpty()) {
            true
        } else {
            internalState.value = internalState.value.copy(
                error = Throwable("invalid password")
            )
            false
        }
    }
}