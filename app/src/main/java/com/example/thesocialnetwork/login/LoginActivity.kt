package com.example.thesocialnetwork.login

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
import com.example.thesocialnetwork.forgotPassword.ForgotPasswordActivity
import com.example.thesocialnetwork.signup.SignUpActivity
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {

    private val viewModel: LoginViewModel by viewModels()

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

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collectLatest { state ->
                    if (state.isSuccess) {
                        // TODO: Handle success state
                    }
                    state.error?.let {
                        Toast.makeText(
                            this@LoginActivity,
                            getString(R.string.feat_sign_up_incorrect_credentials),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
        Toast.makeText(this, "This is onCreate", Toast.LENGTH_SHORT).show()

    }

    private fun handleLogin() {
        val email = findViewById<TextInputEditText>(R.id.email)
        val password = findViewById<TextInputEditText>(R.id.password)

        viewModel.login(email.text.toString(), password.text.toString())
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "This is onResume", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this, "This is onPause", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "This is onDestroy", Toast.LENGTH_SHORT).show()
    }
}