package com.example.retrofittest

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


//3 - Retrofit Instance
class RetrofitInstance {

    // Singleton Pattern
    companion object{
        val BASE_URL = "https://jsonplaceholder.typicode.com"
        fun getRetrofitInstance () : Retrofit{
            //Building Retrofit Instance
            return Retrofit.Builder()

                //Giving base url
                .baseUrl(BASE_URL)
                //Giving what converter to use
                .addConverterFactory(
                    //Setting up converter
                    GsonConverterFactory
                        .create(GsonBuilder()
                            .create())
                )
                //build
                .build()
        }
    }
}