package com.example.thesocialnetwork.examples

import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import java.io.IOException

fun main() {
    val client = OkHttpClient()

    val body = "{\"email\": \"eve.holt@reqres.in\",\"password\": \"cityslicka\"}"

    val request = Request.Builder()
        .url("https://reqres.in/api/login")
        .header("Content-Type", "application/json")
        .method("POST", body.toRequestBody())
        .build()

    val call = client.newCall(request)
    call.enqueue(object : Callback {
        override fun onFailure(call: Call, e: IOException) {
            println(e.message)
        }

        override fun onResponse(call: Call, response: Response) {
            println(response.body?.string())
        }
    })
}