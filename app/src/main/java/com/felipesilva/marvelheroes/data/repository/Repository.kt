package com.felipesilva.marvelheroes.data.repository

import androidx.lifecycle.LiveData
import com.felipesilva.marvelheroes.data.model.CharactersData
import com.felipesilva.marvelheroes.data.model.ComicsDetails

interface Repository {
    fun getHeroes(): LiveData<List<CharactersData>>
    fun getComics(): LiveData<List<ComicsDetails>>
    fun makeCallListComics(id: Int)
    fun makeCallListHeroes()
}