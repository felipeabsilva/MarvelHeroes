package com.felipesilva.marvelheroes.data.db

import androidx.lifecycle.LiveData
import com.felipesilva.marvelheroes.data.model.CharactersData


interface HeroesDataDAO {
    fun addCharacter(charactersData: CharactersData)
    fun getHeroes(): LiveData<List<CharactersData>>
}