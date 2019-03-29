package com.felipesilva.marvelheroes.data.repository

import androidx.lifecycle.LiveData
import com.felipesilva.marvelheroes.data.model.CharactersData

interface Repository {
    fun addCharacter(charactersData: CharactersData)
    fun getHeroes(): LiveData<List<CharactersData>>
}