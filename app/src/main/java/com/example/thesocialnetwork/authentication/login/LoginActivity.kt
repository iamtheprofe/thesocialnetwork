package com.example.thesocialnetwork.authentication.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.thesocialnetwork.R
import com.example.thesocialnetwork.authentication.forgotPassword.ForgotPasswordActivity
import com.example.thesocialnetwork.authentication.signup.SignUpActivity
import com.example.thesocialnetwork.feed.FeedActivity
import com.example.thesocialnetwork.resetPassword.ResetPasswordActivity
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.seconds

class LoginActivity : AppCompatActivity() {

    private val viewModel: LoginViewModel by viewModels()

    private lateinit var loadingDialog: LoadingDialog
    private lateinit var errorDialog: LoadingDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val login = findViewById<Button>(R.id.login)
        login.setOnClickListener {
            handleLogin()
        }
        findViewById<TextView>(R.id.register).setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }
        findViewById<TextView>(R.id.forgotPassword).setOnClickListener {
            startActivity(Intent(this, ForgotPasswordActivity::class.java))
        }

        /*lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collectLatest { state ->
                    invalidate(state)
                }
            }
        }*/
        GlobalScope.launch {
            delay(3.seconds)
            loadingDialog.show()
        }



        Toast.makeText(this, "This is onCreate", Toast.LENGTH_SHORT).show()

    }

    private fun invalidate(state: LoginState) {
        loadingDialog = LoadingDialog(this, DialogType.LOADING)
        errorDialog = LoadingDialog(this, DialogType.ERROR)

        if (state.isLoading) {
            loadingDialog.show()
        } else {
            loadingDialog.dismiss()
        }

        if (state.error != null) {
            errorDialog.setErrorMessage(state.error.message ?: "Unknown error")
            errorDialog.show()
        } else {
            errorDialog.dismiss()
        }

        if (state.token != null) {
            startActivity(Intent(this, FeedActivity::class.java))
        }
    }

    private fun handleLogin() {
        val email = findViewById<TextInputEditText>(R.id.email)
        val password = findViewById<TextInputEditText>(R.id.password)

        viewModel.login(email.text.toString(), password.text.toString())
    }
}