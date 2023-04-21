package com.example.thesocialnetwork.resetPassword

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.thesocialnetwork.R
import com.example.thesocialnetwork.databinding.ActivityResetPasswordBinding

class ResetPasswordActivity : AppCompatActivity() {
    private var binding: ActivityResetPasswordBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResetPasswordBinding.inflate(layoutInflater)
        setContentView(binding?.root)
    }
}
