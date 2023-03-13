package com.example.thesocialnetwork.signup


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ClickableSpan
import android.text.style.TextAppearanceSpan
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.thesocialnetwork.R
import com.example.thesocialnetwork.login.LoginActivity

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        spannableString()
        val textViewLogin = findViewById<TextView>(R.id.login)
        textViewLogin.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        })



    }
    fun linkSpannableString() {
        val clickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
                // Acción a realizar cuando se hace clic en el enlace
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"))
                startActivity(intent)
            }
        }

    }
    private fun spannableString() {
        val clickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
                // Acción a realizar cuando se hace clic en el enlace
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"))
                startActivity(intent)
            }
        }
        val clickableSpan2 = object : ClickableSpan() {
            override fun onClick(widget: View) {



            }
        }
        val word1 = "Terms & Conditions"
        val word2 = "Privacy Policy"
        val customTextStyle2 = TextAppearanceSpan(this, R.style.TheSocialNetwork_TextStyle_Link)
        val customTextStyle = TextAppearanceSpan(this, R.style.TheSocialNetwork_TextStyle_Link)
        val completeText = getString(R.string.feat_signup_privacy_policy)
        val spannableString = SpannableStringBuilder(completeText)
        val start = spannableString.indexOf(word1)
        val end = spannableString.indexOf(word1) + word1.length
        val start2 = spannableString.indexOf(word2)
        val end2 = spannableString.indexOf(word2) + word2.length
        spannableString.setSpan(customTextStyle, start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannableString.setSpan(customTextStyle2, start2, end2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannableString.setSpan(clickableSpan,start,end,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannableString.setSpan(clickableSpan2,start2,end2,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        val termsAndConditions = findViewById<TextView>(R.id.termsAndConditions)
        termsAndConditions.text = spannableString
    }
}


