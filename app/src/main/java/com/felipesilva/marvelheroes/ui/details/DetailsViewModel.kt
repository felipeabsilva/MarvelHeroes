package com.felipesilva.marvelheroes.ui.details

import androidx.lifecycle.ViewModel
import com.felipesilva.marvelheroes.data.repository.Repository

class DetailsViewModel(private val repository: Repository) : ViewModel() {
    fun getComics() = repository.getComics()
    fun makeCallListComics(id: Int) = repository.makeCallListComics(id)
}