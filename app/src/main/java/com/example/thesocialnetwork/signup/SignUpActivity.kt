package com.example.thesocialnetwork.signup

import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.TextAppearanceSpan
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.thesocialnetwork.R

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

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
    }
}