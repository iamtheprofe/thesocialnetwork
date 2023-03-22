package com.example.thesocialnetwork.forgotPassword

import okhttp3.*
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.IOException

fun main() {

    val client = OkHttpClient()
    val forgotPasswordActivity = ForgotPasswordActivity()
    val body = "{\"email\":   \" $forgotPasswordActivity\"}"
    val request = Request.Builder().url("https://reqres.in//api/login")
        .method("POST", body.toRequestBody())
        .build()

    val call = client.newCall(request)
    call.enqueue(object : Callback {
        override fun onFailure(call: Call, e: IOException) {
            println(e)
        }

        override fun onResponse(call: Call, response: Response) {
            print(response)
        }
    })
}
