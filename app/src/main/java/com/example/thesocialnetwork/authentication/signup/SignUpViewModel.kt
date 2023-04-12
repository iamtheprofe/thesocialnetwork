package com.example.thesocialnetwork.authentication.signup

import android.util.Patterns
import androidx.annotation.StringRes
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.thesocialnetwork.R
import com.example.thesocialnetwork.authentication.shared.repository.RemoteAuthRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

data class RegisterState(
    val isSuccess: Boolean = false,
    @StringRes val error: Int? = null
)

class SignUpViewModel(
    private val authRepository: RemoteAuthRepository = RemoteAuthRepository()
) : ViewModel() {

    private val _state = MutableStateFlow(RegisterState())
    val state: StateFlow<RegisterState> = _state

    fun signUp(email: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val isValidEmail = async { isValidEmail(email) }
            val isValidatePassword = async { isValidatePassword(password) }

            if (awaitAll(isValidEmail, isValidatePassword).any { !it }) return@launch

            val response = authRepository.singUp(email, password)
            if (response == null) {
                _state.value = _state.value.copy(
                    error = R.string.feat_sign_up_error_token_is_null
                )
            } else {
                _state.value = _state.value.copy(
                    isSuccess = true
                )
            }
        }
    }

    private fun isValidEmail(email: String): Boolean {
        val cleanEmail = email.trim().lowercase()
        return if (Patterns.EMAIL_ADDRESS.matcher(cleanEmail).matches()) {
            true
        } else {
            _state.value = _state.value.copy(
                error = R.string.feat_sign_up_error_invalid_email
            )
            false
        }
    }

    private fun isValidatePassword(password: String): Boolean {
        val cleanPassword = password.trim()
        return if (cleanPassword.isNotEmpty()) {
            true
        } else {
            _state.value = _state.value.copy(
                error = R.string.feat_sign_up_error_invalid_password
            )
            false
        }
    }
}