package com.felipesilva.marvelheroes.ui.list

import androidx.lifecycle.ViewModel
import com.felipesilva.marvelheroes.data.CharactersData
import com.felipesilva.marvelheroes.data.repository.Repository

class ListViewModel(private val repository: Repository) : ViewModel() {
    fun getHeroes() = repository.getHeroes()
    fun addCharacter(character: CharactersData) = repository.addCharacter(character)
}