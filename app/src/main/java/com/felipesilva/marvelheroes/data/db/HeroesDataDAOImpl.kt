package com.felipesilva.marvelheroes.data.db

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.felipesilva.marvelheroes.data.model.CharactersData

class HeroesDataDAOImpl : HeroesDataDAO {
    private val heroesList = mutableListOf<CharactersData>()
    private val heroes = MutableLiveData<List<CharactersData>>()

    init {
        heroes.value = heroesList
    }

    override fun addCharacter(charactersData: CharactersData) {
        heroesList.add(charactersData)
        heroes.value = heroesList
    }

    override fun getHeroes(): LiveData<List<CharactersData>> = heroes

}