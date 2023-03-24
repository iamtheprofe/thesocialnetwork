package com.example.thesocialnetwork.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.thesocialnetwork.R
import com.example.thesocialnetwork.forgotPassword.ForgotPasswordActivity
import com.example.thesocialnetwork.signup.SignUpActivity
import com.google.android.material.textfield.TextInputEditText
import okhttp3.*
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import java.io.IOException

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val login = findViewById<Button>(R.id.login)
        login.setOnClickListener {
            handleLogin()
        }
        findViewById<TextView>(R.id.register).setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }
        findViewById<TextView>(R.id.forgotPassword).setOnClickListener {
            startActivity(Intent(this, ForgotPasswordActivity::class.java))
        }

        Toast.makeText(this, "This is onCreate", Toast.LENGTH_SHORT).show()

    }

    private fun handleLogin() {
        val email = findViewById<TextInputEditText>(R.id.email)
        val password = findViewById<TextInputEditText>(R.id.password)

        val isValidEmail = isValidEmail(email.text.toString())
        val isValidPassword = isValidPassword(password.text.toString())

        if (isValidEmail && isValidPassword) {
            val jsonObject = JSONObject()
            jsonObject.put("email", email.text.toString())
            jsonObject.put("password", password.text.toString())

            val jsonBody = jsonObject.toString()

            val client = OkHttpClient()

            val request = Request.Builder()
                .url("https://reqres.in/api/login")
                .header("Content-Type", "application/json")
                .method("POST", jsonBody.toRequestBody())
                .build()

            client.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    runOnUiThread {
                        Toast.makeText(
                            this@LoginActivity,
                            getString(R.string.feat_sign_up_incorrect_credentials),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

                override fun onResponse(call: Call, response: Response) {
                    val responseString = response.body?.string()
                    Log.d("API RESPONSE", responseString ?: "")
                    runOnUiThread {
                        if (response.isSuccessful) {
                            Toast.makeText(
                                this@LoginActivity,
                                getString(R.string.feat_sign_up_correct_credentials),
                                Toast.LENGTH_SHORT
                            ).show()
                        } else (Toast.makeText(
                            this@LoginActivity,
                            getString(R.string.feat_login_user_name_not_found),
                            Toast.LENGTH_SHORT
                        ).show())
                    }
                }
            })
        } else {
            Toast.makeText(
                this,
                getString(R.string.feat_sign_up_incorrect_credentials),
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun isValidEmail(email: String): Boolean {
        val cleanEmail = email.trim().lowercase()
        return Patterns.EMAIL_ADDRESS.matcher(cleanEmail).matches() && email.isNotEmpty()
    }

    private fun isValidPassword(password: String): Boolean {
        val cleanPassword = password.trim().lowercase()
        return cleanPassword.isNotEmpty()
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "This is onResume", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this, "This is onPause", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "This is onDestroy", Toast.LENGTH_SHORT).show()
    }
}