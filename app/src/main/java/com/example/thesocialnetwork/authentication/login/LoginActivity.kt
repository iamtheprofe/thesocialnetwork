package com.example.thesocialnetwork.authentication.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.thesocialnetwork.R
import com.example.thesocialnetwork.authentication.forgotPassword.ForgotPasswordActivity
import com.example.thesocialnetwork.authentication.signup.SignUpActivity
import com.example.thesocialnetwork.databinding.ActivityLoginBinding
import com.example.thesocialnetwork.databinding.ItemPostBinding
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {

    private val viewModel: LoginViewModel by viewModels()
    private var binding: ActivityLoginBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.login?.setOnClickListener {
            handleLogin()
        }
        binding?.register?.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }
        binding?.forgotPassword?.setOnClickListener {
            startActivity(Intent(this, ForgotPasswordActivity::class.java))
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collectLatest { state ->
                    invalidate(state)
                }
            }
        }
    }

    private fun invalidate(state: LoginState) {
        if (state.isLoading) {
            // TODO: Launch loading dialog
            Toast.makeText(
                this,
                R.string.feat_login_loading,
                Toast.LENGTH_SHORT
            ).show()
        } else {
            // TODO: If loading dialog is shown, cancel it
        }
        if (state.error != null) {
            // TODO: Launch error alert
            Toast.makeText(
                this,
                getString(R.string.feat_login_error, state.error.toString()),
                Toast.LENGTH_SHORT
            ).show()
        }
        if (state.token != null) {
            // TODO: Launch FeedActivity
            finish()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    private fun handleLogin() {
        val email = binding?.email?.text.toString()
        val password = binding?.password?.text.toString()
        viewModel.login(email, password)
    }
}

