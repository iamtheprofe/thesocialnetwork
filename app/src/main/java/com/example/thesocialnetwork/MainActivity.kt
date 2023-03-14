package com.example.thesocialnetwork

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.thesocialnetwork.forgotPassword.ForgotPasswordActivity
import com.example.thesocialnetwork.login.LoginActivity
import com.example.thesocialnetwork.resetPassword.ResetPasswordActivity
import com.example.thesocialnetwork.signup.SignUpActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.login).setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        findViewById<Button>(R.id.signUp).setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }

        findViewById<Button>(R.id.forgotPassword).setOnClickListener {
            startActivity(Intent(this, ForgotPasswordActivity::class.java))
        }

        findViewById<Button>(R.id.resetPassword).setOnClickListener {
            startActivity(Intent(this, ResetPasswordActivity::class.java))
        }
    }
}