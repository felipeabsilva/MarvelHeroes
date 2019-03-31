package com.felipesilva.marvelheroes.ui.list

import androidx.lifecycle.ViewModelProvider
import com.felipesilva.marvelheroes.data.repository.Repository
import androidx.lifecycle.ViewModel

class ListViewModelFactory(private val repository: Repository) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ListViewModel(repository) as T
    }

}