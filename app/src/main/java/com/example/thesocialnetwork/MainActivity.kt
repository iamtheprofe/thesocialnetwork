package com.example.thesocialnetwork

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.thesocialnetwork.feed.FeedActivity
import com.example.thesocialnetwork.authentication.forgotPassword.ForgotPasswordActivity
import com.example.thesocialnetwork.authentication.login.LoginActivity
import com.example.thesocialnetwork.resetPassword.ResetPasswordActivity
import com.example.thesocialnetwork.authentication.signup.SignUpActivity
import com.example.thesocialnetwork.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding : ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.login?.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        binding?.signUp?.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }

        binding?.forgotPassword?.setOnClickListener {
            startActivity(Intent(this, ForgotPasswordActivity::class.java))
        }

        binding?.resetPassword?.setOnClickListener {
            startActivity(Intent(this, ResetPasswordActivity::class.java))
        }

        binding?.feed?.setOnClickListener {
            startActivity(Intent(this, FeedActivity::class.java))
        }
    }
}