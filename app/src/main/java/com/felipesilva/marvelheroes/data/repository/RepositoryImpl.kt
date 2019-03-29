package com.felipesilva.marvelheroes.data.repository

import com.felipesilva.marvelheroes.data.model.CharactersData
import com.felipesilva.marvelheroes.data.db.HeroesDataDAO

class RepositoryImpl (private val heroesDataDAO: HeroesDataDAO) : Repository {
    override fun addCharacter(charactersData: CharactersData) = heroesDataDAO.addCharacter(charactersData)
    override fun getHeroes() = heroesDataDAO.getHeroes()
}