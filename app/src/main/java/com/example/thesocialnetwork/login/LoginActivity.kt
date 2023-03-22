package com.example.thesocialnetwork.login

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.thesocialnetwork.R
import com.google.android.material.textfield.TextInputLayout
import okhttp3.*
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.IOException

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val email = findViewById<TextInputLayout>(R.id.emailInputLayout)
        val password = findViewById<TextInputLayout>(R.id.passwordInputLayout)

        val emailString = email.editText?.text.toString()
        val passwordString = password.editText?.text.toString()


        val submit = findViewById<Button>(R.id.login)
        submit.setOnClickListener {
            val body = "{\"email\":\"$emailString\",\"password\":\"$passwordString\"}"
            val client = OkHttpClient()
            val request = Request.Builder().url("https://reqres.in/api/login")
                .header("content-type", "application/json")
                .method("POST", body.toRequestBody())
                .build()
            val call = client.newCall(request)

            call.enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    runOnUiThread {
                        Toast.makeText(
                            applicationContext,
                            "an error has occurred with the server",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

                override fun onResponse(call: Call, response: Response) {
                    if (response.isSuccessful) {
                        runOnUiThread {
                            Toast.makeText(applicationContext,"successful login ", Toast.LENGTH_SHORT).show()
                        }
                    } else {
                        runOnUiThread {
                            Toast.makeText(applicationContext, "email or password are incorrect", Toast.LENGTH_SHORT).show()
                        }
                    }

                    }
                })
            }
        }
    }