package com.felipesilva.marvelheroes.data.remote.config

import com.felipesilva.marvelheroes.utilities.MarvelApiParam.URL_BASE
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitConfig {
    fun buildRetrofit() = Retrofit.Builder()
        .baseUrl(URL_BASE)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}