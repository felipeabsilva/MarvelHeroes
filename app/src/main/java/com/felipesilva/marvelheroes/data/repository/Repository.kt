package com.felipesilva.marvelheroes.data.repository

import androidx.lifecycle.LiveData
import com.felipesilva.marvelheroes.data.CharactersData

interface Repository {
    fun addCharacter(charactersData: CharactersData)
    fun getHeroes(): LiveData<List<CharactersData>>
}