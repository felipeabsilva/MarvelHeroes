package com.felipesilva.marvelheroes.ui.list

import androidx.lifecycle.ViewModelProvider
import com.felipesilva.marvelheroes.data.Repository

class ListViewModelFactory(private val repository: Repository) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : androidx.lifecycle.ViewModel?> create(modelClass: Class<T>): T {
        return ListViewModel(repository) as T
    }

}