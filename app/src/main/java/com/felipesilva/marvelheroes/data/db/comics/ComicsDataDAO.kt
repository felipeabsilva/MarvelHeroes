package com.felipesilva.marvelheroes.data.db.comics

import androidx.lifecycle.LiveData
import com.felipesilva.marvelheroes.data.model.ComicsDetails

interface ComicsDataDAO {
    fun makeCallListComics(id: Int)
    fun getComics() : LiveData<List<ComicsDetails>>
}