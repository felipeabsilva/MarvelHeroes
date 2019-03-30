package com.felipesilva.marvelheroes.data.repository

import com.felipesilva.marvelheroes.data.db.heroes.HeroesDataDAO

class RepositoryImpl (private val heroesDataDAO: HeroesDataDAO) : Repository {
    override fun getHeroes() = heroesDataDAO.getHeroes()
}