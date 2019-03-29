package com.felipesilva.marvelheroes.data.db

class HeroesDatabaseImpl : HeroesDatabase {
    override fun heroesDataDAO() = HeroesDataDAOImpl()
}