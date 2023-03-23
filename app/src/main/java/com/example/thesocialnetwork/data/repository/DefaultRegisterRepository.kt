package com.example.thesocialnetwork.data.repository
import com.example.thesocialnetwork.data.api.RegisterApi
import com.example.thesocialnetwork.data.api.dto.register.RegisterRequest
import com.example.thesocialnetwork.model.RegisterData
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class DefaultRegisterRepository : RegisterRepository {
    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY // o Level.NONE si no quieres logs
    }


    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://reqres.in/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val api = retrofit.create(RegisterApi::class.java)



    override suspend fun register(email: String, password: String): RegisterData {
        val response = api.register(RegisterRequest(email, password)).execute()
        if (response.isSuccessful) {
            return (
                    RegisterData(
                        response.body()?.token ?: "",
                        response.body()?.id.toString()))
        } else {
            throw Exception("Error")
        }
    }


}

