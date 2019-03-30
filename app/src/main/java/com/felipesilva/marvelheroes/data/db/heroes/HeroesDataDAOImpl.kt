package com.felipesilva.marvelheroes.data.db.heroes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.felipesilva.marvelheroes.data.model.CharactersData

class HeroesDataDAOImpl(private val heroesDatabase: HeroesDatabase) :
    HeroesDataDAO {
    private val heroesList = mutableListOf<CharactersData>()
    private val heroes = MutableLiveData<List<CharactersData>>()

    init {
        heroesDatabase.makeCallListHeroes()

        heroesDatabase.getHeroes().observeForever { mHeroes ->
            if (heroesList.isNotEmpty())
                heroesList.clear()

            heroesList.addAll(mHeroes)
            heroes.value = heroesList
        }
    }

    override fun getHeroes(): LiveData<List<CharactersData>> = heroes
}