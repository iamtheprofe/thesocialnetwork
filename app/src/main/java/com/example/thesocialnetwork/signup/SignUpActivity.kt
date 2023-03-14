package com.example.thesocialnetwork.signup


import android.content.Intent
import android.graphics.Paint
import android.net.Uri
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.TextAppearanceSpan
import android.util.Patterns
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
        fun toast() {
            Toast.makeText(this, "xxxx", Toast.LENGTH_LONG).show()
        }
        textViewLogin.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)

        })
        val textAnalice = resources.getString(R.string.feat_signup_privacy_policy)
        clickableLink(textAnalice)


    }

    fun clickableLink(longText: String) {
        try {
            val spanned = SpannableString(longText)
            val word1 = "Terms & Conditions"
            val word2 = "Privacy Policy"
            val customTextStyle2 = TextAppearanceSpan(this, R.style.TheSocialNetwork_TextStyle_Link)
            val customTextStyle = TextAppearanceSpan(this, R.style.TheSocialNetwork_TextStyle_Link)
            val spannableString = SpannableStringBuilder(longText)
            val start = spannableString.indexOf(word1)
            val end = spannableString.indexOf(word1) + word1.length
            val start2 = spannableString.indexOf(word2)
            val end2 = spannableString.indexOf(word2) + word2.length
            val clickableSpan: ClickableSpan = object : ClickableSpan() {
                override fun onClick(widget: View) {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://google.com"))
                    startActivity(intent)

                }
            }
            val clickableSpan2: ClickableSpan = object : ClickableSpan() {
                override fun onClick(widget: View) {
                    toast()

                }
            }

            spannableString.setSpan(clickableSpan, start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            spannableString.setSpan(
                clickableSpan2,
                start2,
                end2,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            val termsAndConditions = findViewById<TextView>(R.id.termsAndConditions)
            termsAndConditions.text = spannableString
            termsAndConditions.movementMethod = LinkMovementMethod.getInstance()
            termsAndConditions.paintFlags =
                termsAndConditions.paintFlags and Paint.UNDERLINE_TEXT_FLAG.inv()


        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }

    fun toast() {
        Toast.makeText(this, "me tocaste puto", Toast.LENGTH_LONG).show()
    }

    private fun spannableString() {
        val clickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
                // Acción a realizar cuando se hace clic en el enlace
                toast()
            }
        }
        val clickableSpan2 = object : ClickableSpan() {
            override fun onClick(widget: View) {
                toast()
            }
        }

    }
}


