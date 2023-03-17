package com.example.thesocialnetwork.forgotPassword

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.thesocialnetwork.R
import android.widget.ImageView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.airbnb.lottie.LottieAnimationView
import com.example.thesocialnetwork.resetPassword.ResetPasswordActivity
import com.google.android.material.textfield.TextInputLayout

class ForgotPasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)


        val animationView = findViewById<LottieAnimationView>(R.id.animation_view)
        animationView.setAnimation("loading_in.json")


        val image = findViewById<ImageView>(R.id.imageForgot)
        val text = findViewById<ConstraintLayout>(R.id.forgotPassword)

        val textInputRecovery = findViewById<TextInputLayout>(R.id.textInputRecovery)

        val submit = findViewById<Button>(R.id.submit)
        submit.setOnClickListener {
            val recoveryText = textInputRecovery.editText?.text.toString().trim()
            if (recoveryText.isNotEmpty()) {

                animationView.visibility = View.VISIBLE
                image.visibility = View.INVISIBLE
                text.visibility = View.INVISIBLE
                animationView.playAnimation()

                Handler().postDelayed({
                    val intent = Intent(this, ResetPasswordActivity::class.java)
                    startActivity(intent)
                }, 3000)
            } else {
                Toast.makeText(this, "Please enter your email address", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onStop() {
        super.onStop()
        val image = findViewById<ImageView>(R.id.imageForgot)
        val text = findViewById<ConstraintLayout>(R.id.forgotPassword)
        val animationView = findViewById<LottieAnimationView>(R.id.animation_view)
        animationView.pauseAnimation()
        animationView.visibility = View.GONE
        image.visibility = View.VISIBLE
        text.visibility = View.VISIBLE
    }

}
