package com.felipesilva.marvelheroes.data.db.heroes

import androidx.lifecycle.LiveData
import com.felipesilva.marvelheroes.data.model.CharactersData


interface HeroesDataDAO {
    fun makeCallListHeroes()
    fun getHeroes(): LiveData<List<CharactersData>>
}