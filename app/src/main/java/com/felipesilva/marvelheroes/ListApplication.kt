package com.felipesilva.marvelheroes

import android.app.Application
import com.felipesilva.marvelheroes.data.db.HeroesDataDAO
import com.felipesilva.marvelheroes.data.db.HeroesDataDAOImpl
import com.felipesilva.marvelheroes.data.db.HeroesDatabase
import com.felipesilva.marvelheroes.data.db.HeroesDatabaseImpl
import com.felipesilva.marvelheroes.data.repository.Repository
import com.felipesilva.marvelheroes.data.repository.RepositoryImpl
import com.felipesilva.marvelheroes.ui.list.ListViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class ListApplication : Application(), KodeinAware {
    override val kodein: Kodein = Kodein.lazy {
        bind<HeroesDatabase>() with singleton { HeroesDatabaseImpl() }
        bind<HeroesDataDAO>() with singleton { instance<HeroesDatabase>().heroesDataDAO() }
        bind<Repository>() with singleton { RepositoryImpl(instance()) }

        //The same as bind<ListViewModelFactory>() with provider { ListViewModelFactory(instance()) }
        bind() from provider { ListViewModelFactory(instance()) }
    }
}