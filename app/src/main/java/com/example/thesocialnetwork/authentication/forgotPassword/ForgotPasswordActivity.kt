package com.example.thesocialnetwork.authentication.forgotPassword

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.thesocialnetwork.R
import com.example.thesocialnetwork.databinding.ActivityForgotPasswordBinding
import com.example.thesocialnetwork.resetPassword.ResetPasswordActivity


class ForgotPasswordActivity : AppCompatActivity() {

    private var binding : ActivityForgotPasswordBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.submitButton?.setOnClickListener {
            handleSubmit()
        }
    }

    private fun handleSubmit() {

        val emailMobile = binding?.emailMobile?.text.toString().trim().lowercase()

        if (isValidEmailMobile(emailMobile)) {
            startActivity(Intent(this, ResetPasswordActivity::class.java))
        } else {
            Toast.makeText(this,
                getString(R.string.feat_forgot_password_invalid_email_mobile),
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun isValidEmailMobile(email: String): Boolean {
        val cleanEmail = email.trim().lowercase()
        val emailPattern = Patterns.EMAIL_ADDRESS
        val phonePattern = Patterns.PHONE
        return emailPattern.matcher(cleanEmail).matches() || phonePattern.matcher(cleanEmail)
            .matches()
    }
}
