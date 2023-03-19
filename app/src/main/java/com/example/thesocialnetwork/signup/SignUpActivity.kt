package com.example.thesocialnetwork.signup

import android.content.Intent
import android.graphics.Paint
import android.net.Uri
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.TextAppearanceSpan
import android.util.Patterns
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.example.thesocialnetwork.R
import com.example.thesocialnetwork.login.LoginActivity
import com.google.android.material.textfield.TextInputEditText
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)


//-------------------------------------------------------------------------------------------------------------
        val login = findViewById<TextView>(R.id.login)
        val completeText = resources.getString(R.string.feat_signup_privacy_policy)
        clickableLink(completeText)
        login.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        //-----------------------------------------------------------------------------------------------------------------------------
        val continueButton = findViewById<AppCompatButton>(R.id.continue1)
        continueButton.setOnClickListener {
            val textEmail = findViewById<TextInputEditText>(R.id.email)
            val textPassword = findViewById<TextInputEditText>(R.id.password)
            val textConfirmPassword = findViewById<TextInputEditText>(R.id.confirmPassword)
            val fields = checkFields(
                textEmail.text.toString(),
                textPassword.text.toString(),
                textConfirmPassword.text.toString()
            )
            if (fields[0] && fields[1]) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://example.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                Toast.makeText(this, "Good job you are register", Toast.LENGTH_LONG).show()

            } else Toast.makeText(this, "incorrect data", Toast.LENGTH_LONG).show()
        }
    }

    //--------------------------------------------------------------------------------------------------------------------------------------------------------
    private fun checkFields(
        email: String,
        password: String,
        confirmPassword: String
    ): ArrayList<Boolean> {
        val arrayList = ArrayList<Boolean>()
        val cleanEmail = email.trim().lowercase()
        val cleanPassword = password.trim().lowercase()
        val cleanConfirmPassword = confirmPassword.trim().lowercase()
        val checkEmail =
            Patterns.EMAIL_ADDRESS.matcher(cleanEmail).matches()
        val checkPasswords = cleanPassword == cleanConfirmPassword
        arrayList.add(checkEmail)
        arrayList.add(checkPasswords)
        return arrayList
    }


    data class ApiResponse(
        val message: String
    )


    private fun clickableLink(longText: String) {
        try {
            val wordToSearch = resources.getString(R.string.word_to_search1)
            val wordToSearch2 = resources.getString(R.string.word_to_search2)
            val textStyleForLinks2 =
                TextAppearanceSpan(this, R.style.TheSocialNetwork_TextStyle_Link)
            val textStyleForLinks =
                TextAppearanceSpan(this, R.style.TheSocialNetwork_TextStyle_Link)
            val spannableString = SpannableStringBuilder(longText)
            val startPosition = spannableString.indexOf(wordToSearch)
            val endPosition = spannableString.indexOf(wordToSearch) + wordToSearch.length
            val startPosition2 = spannableString.indexOf(wordToSearch2)
            val endPosition2 = spannableString.indexOf(wordToSearch2) + wordToSearch2.length

            val clickableSpan: ClickableSpan = object : ClickableSpan() {
                override fun onClick(widget: View) {
                    val intent = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse(resources.getString(R.string.src_for_signup))
                    )
                    startActivity(intent)

                }
            }
            val clickableSpan2: ClickableSpan = object : ClickableSpan() {
                override fun onClick(widget: View) {
                    toast()
                }
            }

            spannableString.setSpan(
                clickableSpan,
                startPosition,
                endPosition,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            spannableString.setSpan(
                clickableSpan2,
                startPosition2,
                endPosition2,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )

            val termsAndConditions = findViewById<TextView>(R.id.termsAndConditions)
            spannableString.setSpan(
                textStyleForLinks,
                startPosition,
                endPosition,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            spannableString.setSpan(
                textStyleForLinks2,
                startPosition2,
                endPosition2,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            termsAndConditions.text = spannableString
            termsAndConditions.movementMethod = LinkMovementMethod.getInstance()
            termsAndConditions.paintFlags =
                termsAndConditions.paintFlags and Paint.UNDERLINE_TEXT_FLAG.inv()

        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }

    fun toast() {
        Toast.makeText(this, "you touch me mother fucker ", Toast.LENGTH_LONG).show()
    }
}