package com.felipesilva.marvelheroes.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData


class HeroesDataDAO {
    private val listHeroes = mutableListOf<CharactersData>()
    private val heroes = MutableLiveData<List<CharactersData>>()

    init {
        heroes.value = listHeroes
    }

    fun addCharacter(character: CharactersData) {
        listHeroes.add(character)
        heroes.value = listHeroes
    }

    fun getHeroes() = heroes as LiveData<List<CharactersData>>
}