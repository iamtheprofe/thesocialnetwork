package com.example.thesocialnetwork.authentication.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.thesocialnetwork.R
import com.example.thesocialnetwork.authentication.forgotPassword.ForgotPasswordActivity
import com.example.thesocialnetwork.authentication.signup.SignUpActivity
import com.example.thesocialnetwork.databinding.ActivityLoginBinding
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

        binding?.email?.doAfterTextChanged {
            binding?.login?.isEnabled = isValidForm()
        }

        binding?.password?.doAfterTextChanged {
            binding?.login?.isEnabled = isValidForm()
        }
    }

    override fun onResume() {
        super.onResume()
        binding?.login?.isEnabled = isValidForm()
    }

    private fun isValidForm(): Boolean {
        return binding?.email?.text.toString().isNotEmpty() &&
                binding?.password?.text.toString().isNotEmpty()
    }

    private fun invalidate(state: LoginState) {
        if (state.isLoading) {
            Toast.makeText(
                this,
                R.string.feat_login_loading,
                Toast.LENGTH_SHORT
            ).show()
        } else {
            // TODO: If loading dialog is shown, cancel it
        }
        if (state.error != null) {
            Toast.makeText(
                this,
                getString(R.string.feat_login_error, state.error.toString()),
                Toast.LENGTH_SHORT
            ).show()
        }
        if (state.token != null) {
            finish()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    private fun handleLogin() {
        val email = findViewById<TextInputEditText>(R.id.email)
        val password = findViewById<TextInputEditText>(R.id.password)

        viewModel.login(email.text.toString(), password.text.toString())
    }
}