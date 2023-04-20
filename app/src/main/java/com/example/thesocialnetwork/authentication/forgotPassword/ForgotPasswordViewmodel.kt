package com.example.thesocialnetwork.authentication.forgotPassword

import android.util.Patterns
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.thesocialnetwork.authentication.shared.AuthenticationModule
import com.example.thesocialnetwork.authentication.shared.repository.domain.AuthRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

data class ForgotPasswordState(
    val token : String? =null,
    val isLoading: Boolean = false,
    val error: Throwable? = null,
)

class ForgotPasswordViewModel(
    private val authRepository: AuthRepository = AuthenticationModule.provideRepository()
) : ViewModel() {

    private val internalState = MutableStateFlow(ForgotPasswordState())
    val state: MutableStateFlow<ForgotPasswordState> = internalState

    private fun isValidEmailMobile(emailMobile: String): Boolean {
        val cleanEmailMobile = emailMobile.trim().lowercase()
        val emailPattern = Patterns.EMAIL_ADDRESS
        val phonePattern = Patterns.PHONE
        return when {
            emailPattern.matcher(cleanEmailMobile).matches() -> {
                true
            }
            phonePattern.matcher(cleanEmailMobile).matches() -> {
                true
            }
            else -> {
                internalState.value = internalState.value.copy(
                    error = RuntimeException("error")
                )
                false
            }
        }
    }

    fun forgotPassword(emailMobile: String) {
        val isValidEmailMobile = isValidEmailMobile(emailMobile)
        if (isValidEmailMobile) {
            internalState.value = internalState.value.copy(
                isLoading = true
            )
            viewModelScope.launch(Dispatchers.IO) {
                internalState.value = internalState.value.copy(
                    isLoading = false
                )
                val response = if (Patterns.EMAIL_ADDRESS.matcher(emailMobile).matches()) {
                    authRepository.forgotPassword(emailMobile, "")
                } else {
                    authRepository.forgotPassword("", emailMobile)
                }
                if (response == null) {
                    internalState.value = internalState.value.copy(
                        error = RuntimeException("Invalid email or password ")
                    )
                } else {
                    internalState.value = internalState.value.copy(
                        token = response
                    )
                }
            }
        } else {
           internalState.value = internalState.value.copy(
               error = RuntimeException ("Invalid Credentials")
           )
        }
    }
}