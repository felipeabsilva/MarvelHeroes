package com.felipesilva.marvelheroes.data.db.comics

import androidx.lifecycle.LiveData
import com.felipesilva.marvelheroes.data.model.ComicsDetails

interface ComicsDatabase {
    fun makeCallListComics(id: Int)
    fun loadComics(comicsDetails: List<ComicsDetails>)
    fun getComics(): LiveData<List<ComicsDetails>>
}