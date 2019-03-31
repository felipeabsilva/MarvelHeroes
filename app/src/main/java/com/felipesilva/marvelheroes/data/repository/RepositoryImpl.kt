package com.felipesilva.marvelheroes.data.repository

import androidx.lifecycle.LiveData
import com.felipesilva.marvelheroes.data.db.comics.ComicsDataDAO
import com.felipesilva.marvelheroes.data.db.heroes.HeroesDataDAO
import com.felipesilva.marvelheroes.data.model.ComicsDetails

class RepositoryImpl (private val heroesDataDAO: HeroesDataDAO, private val comicsDataDAO: ComicsDataDAO) : Repository {
    override fun getHeroes() = heroesDataDAO.getHeroes()

    override fun makeCallListHeroes() = heroesDataDAO.makeCallListHeroes()

    override fun getComics(): LiveData<List<ComicsDetails>> = comicsDataDAO.getComics()

    override fun makeCallListComics(id: Int) = comicsDataDAO.makeCallListComics(id)

}