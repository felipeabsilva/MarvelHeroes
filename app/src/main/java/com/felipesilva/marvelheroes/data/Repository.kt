package com.felipesilva.marvelheroes.data

class Repository private constructor(private val heroesDataDAO: HeroesDataDAO) {

    companion object {
        @Volatile private var instance: Repository? = null

        fun getInstance(heroesDataDAO: HeroesDataDAO) =
            instance ?: synchronized(this) {
                instance ?: Repository(heroesDataDAO).also { instance = it }
            }
    }

    fun addCharacter(character: CharactersData) = heroesDataDAO.addCharacter(character)

    fun getHeroes() = heroesDataDAO.getHeroes()

}