package com.example.thesocialnetwork.signup

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject

class SignUpRepository {
    suspend fun signUp(email: String, fullName: String, mobile: String): String? {
        val jsonObject = JSONObject()
        jsonObject.put("email", email)
        jsonObject.put("full name", fullName)
        jsonObject.put("mobile", mobile)

        val jsonBody = jsonObject.toString()

        val client = OkHttpClient()

        val request = Request.Builder()
            .url("https://reqres.in/api/register")
            .header("Content-Type", "application/json")
            .method("POST", jsonBody.toRequestBody())
            .build()
        try {
            val response = client.newCall(request).execute()
            if (response.isSuccessful) {
                val body = response.body?.string()
                val json = JSONObject(body)
                return json.getString("token")
            } else {
                return null
            }
        } catch (exception: Exception) {
            exception.printStackTrace()
            return null
        }

    }
}