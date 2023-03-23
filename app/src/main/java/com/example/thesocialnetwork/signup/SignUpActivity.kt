package com.example.thesocialnetwork.signup

import android.content.Intent
import android.os.Bundle
import android.text.SpannableString
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.TextAppearanceSpan
import android.text.util.Linkify
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.example.thesocialnetwork.R
import com.example.thesocialnetwork.commons.isValidEmail
import com.example.thesocialnetwork.login.LoginActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout


class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        configListeners()
        configTermsAndPrivacySpan()
    }

    private fun configListeners() {
        findViewById<TextView>(R.id.login).setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        findViewById<AppCompatButton>(R.id.continueAppCompatButton).setOnClickListener {
            handleSignUp()
        }
    }

    private fun handleSignUp() {
        val emailEditText = findViewById<TextInputEditText>(R.id.email)
        val nameEditText = findViewById<TextInputEditText>(R.id.fullName)

        val isValidEmail = isValidEmail(emailEditText.text.toString())
        val hasFullName = !nameEditText.text.toString().isEmpty()

        findViewById<TextInputLayout>(R.id.emailInputLayout).error = null
        findViewById<TextInputLayout>(R.id.fullNameTextInputLayout).error = null

        if(!isValidEmail) {
            findViewById<TextInputLayout>(R.id.emailInputLayout).error = getString(R.string.feat_sign_up_email_error)
        }

        if(!hasFullName) {
            findViewById<TextInputLayout>(R.id.fullNameTextInputLayout).error = getString(R.string.feat_sign_up_full_name_error)
        }

        if(!isValidEmail || !hasFullName)
            return

        Toast.makeText(this, "Valid date proceed to sign up", Toast.LENGTH_SHORT).show()
    }

    private fun configTermsAndPrivacySpan() {
        val termsConditionsPrivacyTextView = findViewById<TextView>(R.id.termsConditionsPrivacy)

        val termsConditionsPrivacyText = getString(R.string.feat_sign_up_terms_privacy)
        val termsConditionsText = getString(R.string.feat_sign_up_terms_and_conditions)
        val privacyText = getString(R.string.feat_sign_up_privacy_policy)

        val termsLinkTextStyle =
            TextAppearanceSpan(this, R.style.TheSocialNetwork_TextStyle_Link)
        val privacyLinkTextStyle =
            TextAppearanceSpan(this, R.style.TheSocialNetwork_TextStyle_Link)

        val spannableString = SpannableString(termsConditionsPrivacyText)

        val startIndexTermsConditions: Int = termsConditionsPrivacyText.indexOf(termsConditionsText)
        val endIndexTermsConditions = startIndexTermsConditions + termsConditionsText.length
        spannableString.setSpan(
            termsLinkTextStyle,
            startIndexTermsConditions,
            endIndexTermsConditions,
            SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        val termsClickableSpan: ClickableSpan = buildClickableSpan(termsConditionsText)
        spannableString.setSpan(
            termsClickableSpan,
            startIndexTermsConditions,
            endIndexTermsConditions,
            SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        val startIndexPrivacy: Int = termsConditionsPrivacyText.indexOf(privacyText)
        val endIndexPrivacy = startIndexPrivacy + privacyText.length
        spannableString.setSpan(
            privacyLinkTextStyle,
            startIndexPrivacy,
            endIndexPrivacy,
            SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        val privacyClickableSpan: ClickableSpan = buildClickableSpan(privacyText)
        spannableString.setSpan(
            privacyClickableSpan,
            startIndexPrivacy,
            endIndexPrivacy,
            SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        termsConditionsPrivacyTextView.text = spannableString
        termsConditionsPrivacyTextView.movementMethod = LinkMovementMethod.getInstance()
    }

    private fun handleSpanClick(span: String) {
        Toast.makeText(this, "Clicked $span", Toast.LENGTH_SHORT).show()
    }
    private fun buildClickableSpan(span: String): ClickableSpan {
        val clickableSpan: ClickableSpan = object : ClickableSpan() {
            override fun onClick(view: View) {
                handleSpanClick(span)
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.isUnderlineText = false
            }
        }

        return clickableSpan
    }
}