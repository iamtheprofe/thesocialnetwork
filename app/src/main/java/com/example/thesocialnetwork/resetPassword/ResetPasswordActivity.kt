package com.example.thesocialnetwork.resetPassword

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.thesocialnetwork.authentication.login.LoginActivity
import com.example.thesocialnetwork.databinding.ActivityResetPasswordBinding

class ResetPasswordActivity : AppCompatActivity() {

    private var binding: ActivityResetPasswordBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResetPasswordBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.submit?.setOnClickListener {
            handleSubmit()
        }
    }

    private fun handleSubmit() {

        val password1 = binding?.passwordInputLayout?.text.toString().trim().lowercase()
        val password2 = binding?.confirmPassword?.text.toString().trim().lowercase()
        val passwordSame = password1 == password2

        if (passwordSame) {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}




