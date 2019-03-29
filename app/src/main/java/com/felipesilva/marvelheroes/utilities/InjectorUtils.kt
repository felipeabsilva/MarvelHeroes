package com.felipesilva.marvelheroes.utilities

import com.felipesilva.marvelheroes.data.HeroesDatabase
import com.felipesilva.marvelheroes.data.Repository
import com.felipesilva.marvelheroes.ui.list.ListViewModelFactory

object InjectorUtils {
    fun provideListViewModelFactory(): ListViewModelFactory {
        val repository = Repository.getInstance(HeroesDatabase.getInstance().heroesDataDAO)
        return ListViewModelFactory(repository)
    }
}