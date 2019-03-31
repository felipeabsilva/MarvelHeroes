package com.felipesilva.marvelheroes.ui.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.felipesilva.marvelheroes.data.repository.Repository

class DetailsModelFactory(val repository: Repository) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DetailsViewModel(repository) as T
    }
}