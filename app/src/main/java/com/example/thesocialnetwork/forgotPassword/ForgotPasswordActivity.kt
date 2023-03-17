package com.example.thesocialnetwork.forgotPassword

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.thesocialnetwork.R
import com.example.thesocialnetwork.resetPassword.ResetPasswordActivity
import com.google.android.material.textfield.TextInputEditText

class ForgotPasswordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        val login = findViewById<Button>(R.id.submit_Button)
        login.setOnClickListener {
            handleSubmit()
        }
    }

    private fun handleSubmit() {
        val emailMobile = findViewById<TextInputEditText>(R.id.emailMobile)
        val isValidEmailMobile = emailMobile.text.toString().trim().lowercase()

        if (isValidEmailMobile(isValidEmailMobile)) {
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
