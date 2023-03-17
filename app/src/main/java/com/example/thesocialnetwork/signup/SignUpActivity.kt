package com.example.thesocialnetwork.signup

import android.content.Intent
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.TextAppearanceSpan
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.thesocialnetwork.R
import com.example.thesocialnetwork.login.LoginActivity
import com.google.android.material.textfield.TextInputEditText

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        findViewById<TextView>(R.id.login).setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        val textView = findViewById<TextView>(R.id.agreement)
        val agreement = textView.text.toString()
        val builder = SpannableStringBuilder(agreement)
        val termsConditions = object : ClickableSpan() {
            override fun onClick(widget: View) {
            }
        }
        val privacyPolicy = object : ClickableSpan() {
            override fun onClick(widget: View) {
            }
        }
        val startIndex1 = agreement.indexOf(getString(R.string.feat_sign_up_terms_conditions))
        val endIndex1 = startIndex1 + (getString(R.string.feat_sign_up_terms_conditions)).length
        builder.setSpan(termsConditions, startIndex1, endIndex1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        val startIndex2 = agreement.indexOf(getString(R.string.feat_signup_privacy_policy))
        val endIndex2 = startIndex2 + (getString(R.string.feat_sign_up_privacy_policy)).length
        builder.setSpan(privacyPolicy, startIndex2, endIndex2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        val linkStyle = TextAppearanceSpan(this, R.style.TheSocialNetwork_TextStyle_Link)
        builder.setSpan(linkStyle, startIndex1, endIndex1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        builder.setSpan(linkStyle, startIndex2, endIndex2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        textView.setText(builder, TextView.BufferType.SPANNABLE)
        textView.movementMethod = LinkMovementMethod.getInstance()

        val continueButton = findViewById<Button>(R.id.continue_button)
        continueButton.setOnClickListener {
            handleContinue()
        }
    }

    private fun handleContinue() {

        val email = findViewById<TextInputEditText>(R.id.email)
        val fullName = findViewById<TextInputEditText>(R.id.fullName)
        val mobile = findViewById<TextInputEditText>(R.id.mobile)

        val isValidEmail = isValidEmail(email.text.toString())
        val isValidName = isValidName(fullName.text.toString())
        val isValidMobile = isValidMobile(mobile.text.toString())

        if (isValidEmail && isValidName && isValidMobile) {
            Toast.makeText(this, "Credential are correct", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Credentials are incorrect", Toast.LENGTH_SHORT).show()
        }
    }

    private fun isValidEmail(email: String): Boolean {
        val cleanEmail = email.trim().lowercase()
        return Patterns.EMAIL_ADDRESS.matcher(cleanEmail)
            .matches() && cleanEmail == "murillosamastream@gmail.com"
    }

    private fun isValidName(fullName: String): Boolean {
        val cleanName = fullName.trim()
        return cleanName == "Yordy Murillo"
    }

    private fun isValidMobile(mobile: String): Boolean {
        val cleanMobile = mobile.trim()
        return cleanMobile == "123125123"
    }
}