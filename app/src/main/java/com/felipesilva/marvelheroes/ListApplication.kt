package com.felipesilva.marvelheroes

import android.app.Application
import com.felipesilva.marvelheroes.data.db.comics.ComicsDataDAO
import com.felipesilva.marvelheroes.data.db.comics.ComicsDataDAOImpl
import com.felipesilva.marvelheroes.data.db.comics.ComicsDatabase
import com.felipesilva.marvelheroes.data.db.comics.ComicsDatabaseImpl
import com.felipesilva.marvelheroes.data.db.heroes.HeroesDataDAO
import com.felipesilva.marvelheroes.data.db.heroes.HeroesDataDAOImpl
import com.felipesilva.marvelheroes.data.db.heroes.HeroesDatabase
import com.felipesilva.marvelheroes.data.db.heroes.HeroesDatabaseImpl
import com.felipesilva.marvelheroes.data.remote.config.RetrofitConfig
import com.felipesilva.marvelheroes.data.repository.Repository
import com.felipesilva.marvelheroes.data.repository.RepositoryImpl
import com.felipesilva.marvelheroes.ui.details.DetailsActivity
import com.felipesilva.marvelheroes.ui.details.DetailsModelFactory
import com.felipesilva.marvelheroes.ui.list.ListViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class ListApplication : Application(), KodeinAware {
    override val kodein: Kodein = Kodein.lazy {
        bind() from provider { RetrofitConfig() }
        bind<HeroesDatabase>() with singleton {
            HeroesDatabaseImpl(
                instance()
            )
        }
        bind<HeroesDataDAO>() with singleton {
            HeroesDataDAOImpl(
                instance()
            )
        }

        bind<ComicsDatabase>() with singleton { ComicsDatabaseImpl(instance()) }

        bind<ComicsDataDAO>() with singleton { ComicsDataDAOImpl(instance()) }

        bind<Repository>() with singleton { RepositoryImpl(instance(), instance()) }

/*        bind<HeroesDatabase>() with singleton { HeroesDatabaseImpl(instance(), instance()) }
        bind<HeroesDataDAO>() with singleton { instance<HeroesDatabase>().heroesDataDAO() }
        bind<Repository>() with singleton { RepositoryImpl(instance()) }*/

        //The same as bind<ListViewModelFactory>() with provider { ListViewModelFactory(instance()) }
        bind() from provider { ListViewModelFactory(instance()) }
        bind() from provider { DetailsModelFactory(instance()) }
    }
}