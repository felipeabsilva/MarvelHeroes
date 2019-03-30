package com.felipesilva.marvelheroes.data.db.comics

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.felipesilva.marvelheroes.data.model.ComicsDetails

class ComicsDataDAOImpl(val comicsDatabase: ComicsDatabase) : ComicsDataDAO {
    private val comicsList = mutableListOf<ComicsDetails>()
    private val comics=  MutableLiveData<List<ComicsDetails>>()

    override fun makeCallListComics(id: Int) {
        comicsDatabase.makeCallListComics(id)

        comicsDatabase.getComics().observeForever { mComics ->
            if(comicsList.isNotEmpty())
                comicsList.clear()

            comicsList.addAll(mComics)
            comics.value = comicsList
        }
    }

    override fun getComics(): LiveData<List<ComicsDetails>> = comics



}