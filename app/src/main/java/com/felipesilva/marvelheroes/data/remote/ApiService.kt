package com.felipesilva.marvelheroes.data.remote

import com.felipesilva.marvelheroes.data.model.ComicsData
import com.felipesilva.marvelheroes.data.model.Data
import com.felipesilva.marvelheroes.utilities.MarvelApiParam.HASH
import com.felipesilva.marvelheroes.utilities.MarvelApiParam.LIMIT
import com.felipesilva.marvelheroes.utilities.MarvelApiParam.OFFSET
import com.felipesilva.marvelheroes.utilities.MarvelApiParam.PUBLIC_KEY
import com.felipesilva.marvelheroes.utilities.MarvelApiParam.TS
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("characters")
    fun makeCallListHeroes(
        @Query("offset") offset: Int = OFFSET,
        @Query("limit") limit: Int = LIMIT,
        @Query("ts") ts: String = TS,
        @Query("apikey") apikey: String = PUBLIC_KEY,
        @Query("hash") hash: String = HASH
    ) : Call<Data>

    @GET("characters/{id}/comics")
    fun makeCallListComics(
        @Path("id") id: Int,
        @Query("ts") ts: String = TS,
        @Query("apikey") apikey: String = PUBLIC_KEY,
        @Query("hash") hash: String = HASH
    ) : Call<ComicsData>
}