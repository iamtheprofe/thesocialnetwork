package com.example.thesocialnetwork.signup

import android.content.Intent
import android.os.Bundle
import android.text.SpannableString
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.TextAppearanceSpan
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.thesocialnetwork.R
import com.example.thesocialnetwork.login.LoginActivity


class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        findViewById<TextView>(R.id.login).setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        configTermsAndPrivacySpan()
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

        val termsClickableSpan: ClickableSpan = object : ClickableSpan() {
            override fun onClick(view: View) {
                println("termsClickableSpan")
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.isUnderlineText = false
            }
        }
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
        val privacyClickableSpan: ClickableSpan = object : ClickableSpan() {
            override fun onClick(view: View) {
                println("privacyClickableSpan")
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.isUnderlineText = false
            }
        }
        spannableString.setSpan(
            privacyClickableSpan,
            startIndexPrivacy,
            endIndexPrivacy,
            SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        termsConditionsPrivacyTextView.text = spannableString
        termsConditionsPrivacyTextView.movementMethod = LinkMovementMethod.getInstance()
    }
}