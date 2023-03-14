package com.example.thesocialnetwork.signup

import android.os.Bundle
import android.text.SpannableString
import android.text.method.LinkMovementMethod
import android.text.style.TextAppearanceSpan
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.thesocialnetwork.R


class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        configTermsAndPrivacySpan()
    }

    private fun configTermsAndPrivacySpan() {
        val termsConditionsPrivacyTextView = findViewById<TextView>(R.id.termsConditionsPrivacy)
        val termsConditionsPrivacyText = getString(R.string.feat_sign_up_terms_privacy)
        val termsConditionsText = getString(R.string.feat_sign_up_terms_and_conditions)
        val privacyText = getString(R.string.feat_sign_up_privacy_policy)
        val termsLinkTextStyle = TextAppearanceSpan(this, R.style.TheSocialNetwork_TextStyle_Link_Caption)
        val privacyLinkTextStyle = TextAppearanceSpan(this, R.style.TheSocialNetwork_TextStyle_Link_Caption)

        val spannableString = SpannableString(termsConditionsPrivacyText)

        val startIndexTermsConditions: Int = termsConditionsPrivacyText.indexOf(termsConditionsText)
        val endIndexTermsConditions = startIndexTermsConditions + termsConditionsText.length
        spannableString.setSpan(
            termsLinkTextStyle,
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



        termsConditionsPrivacyTextView.text = spannableString
        termsConditionsPrivacyTextView.movementMethod = LinkMovementMethod.getInstance()
    }
}