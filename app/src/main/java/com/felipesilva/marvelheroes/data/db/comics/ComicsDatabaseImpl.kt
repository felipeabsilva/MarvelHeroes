package com.felipesilva.marvelheroes.data.db.comics

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.felipesilva.marvelheroes.data.model.ComicsData
import com.felipesilva.marvelheroes.data.model.ComicsDetails
import com.felipesilva.marvelheroes.data.remote.ApiService
import com.felipesilva.marvelheroes.data.remote.config.RetrofitConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ComicsDatabaseImpl(val retrofit: RetrofitConfig) : ComicsDatabase {
    private val comicsList = mutableListOf<ComicsDetails>()
    private val comics = MutableLiveData<List<ComicsDetails>>()

    private val api = retrofit.buildRetrofit()
        .create(ApiService::class.java)

    override fun makeCallListComics(id: Int) {
        api.makeCallListComics(id).enqueue(object : Callback<ComicsData> {
            override fun onResponse(call: Call<ComicsData>, response: Response<ComicsData>) {
                response.body()?.let {
                    loadComics(it.data.results)
                }
            }

            override fun onFailure(call: Call<ComicsData>, t: Throwable) {
                Log.d("123felipe", "Connection comics failed!")
            }

        })
    }

    override fun loadComics(comicsDetails: List<ComicsDetails>) {
        if (comicsList.isNotEmpty())
            comicsList.clear()

        comicsList.addAll(comicsDetails)
        comics.value = comicsList
    }

    override fun getComics(): LiveData<List<ComicsDetails>> = comics

}