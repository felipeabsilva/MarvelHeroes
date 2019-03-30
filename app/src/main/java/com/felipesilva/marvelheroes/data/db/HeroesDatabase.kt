package com.felipesilva.marvelheroes.data.db

import androidx.lifecycle.LiveData
import com.felipesilva.marvelheroes.data.model.CharactersData

interface HeroesDatabase {
    fun makeCallListHeroes()
    fun loadHeroes(charactersData: List<CharactersData>)
    fun getHeroes(): LiveData<List<CharactersData>>
}