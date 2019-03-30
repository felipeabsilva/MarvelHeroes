package com.felipesilva.marvelheroes.data.db

import android.util.Log.d
import androidx.lifecycle.MutableLiveData
import com.felipesilva.marvelheroes.data.model.CharactersData
import com.felipesilva.marvelheroes.data.model.Data
import com.felipesilva.marvelheroes.data.remote.ApiService
import com.felipesilva.marvelheroes.data.remote.config.RetrofitConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HeroesDatabaseImpl(val retrofit: RetrofitConfig) : HeroesDatabase {
    private val heroesList = mutableListOf<CharactersData>()
    private val heroes = MutableLiveData<List<CharactersData>>()

    private val api = retrofit.buildRetrofit()
        .create(ApiService::class.java)

    override fun makeCallListHeroes() {
        api.makeCallListHeroes().enqueue(object: Callback<Data> {
            override fun onResponse(call: Call<Data>, response: Response<Data>) {
                response.body()?.let {
                    loadHeroes(it.data.results)
                }
            }

            override fun onFailure(call: Call<Data>, t: Throwable) {
                d("123felipe", "Connection failed!")
            }
        })
    }

    override fun loadHeroes(charactersData: List<CharactersData>) {
        if (heroesList.isNotEmpty())
            heroesList.clear()

        heroesList.addAll(charactersData)
        heroes.value = heroesList
    }

    override fun getHeroes(): MutableLiveData<List<CharactersData>> = heroes
}