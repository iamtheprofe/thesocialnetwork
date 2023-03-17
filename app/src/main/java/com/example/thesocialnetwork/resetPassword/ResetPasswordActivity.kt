package com.example.thesocialnetwork.resetPassword

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.thesocialnetwork.R
import com.google.android.material.textfield.TextInputEditText

class ResetPasswordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)

        val resetPassword = findViewById<Button>(R.id.buttonResetPassword)
        resetPassword.setOnClickListener {
            handleResetPassword()
        }

        val backButton = findViewById<ImageButton>(R.id.back)
        backButton.setOnClickListener { finish() }

        Toast.makeText(this, "This is onCreate", Toast.LENGTH_SHORT).show()

    }

    private fun handleResetPassword() {
        val password = findViewById<TextInputEditText>(R.id.newPassword)
        val newPassword = findViewById<TextInputEditText>(R.id.confirmNewPassword)

        val passwordText = password.text.toString()
        val newPasswordText = newPassword.text.toString()

        val isValidPassword = isValidPassword(password.text.toString())
        val isValidNewPassword = isValidPassword(newPassword.text.toString())

        if ((isValidPassword && isValidNewPassword) && passwordText == newPasswordText) {
            Toast.makeText(this, "Reset password complete", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Password not match", Toast.LENGTH_SHORT).show()
        }

    }

    private fun isValidPassword(password: String): Boolean {
        return password.trim().isNotEmpty()

    }
}


