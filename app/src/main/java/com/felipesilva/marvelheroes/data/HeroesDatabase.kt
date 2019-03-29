package com.felipesilva.marvelheroes.data

class HeroesDatabase private constructor() {

    companion object {
        @Volatile private var instance: HeroesDatabase? = null

        fun getInstance() =
            instance ?: synchronized(this) {
                instance ?: HeroesDatabase().also { instance = it }
            }
    }

    val heroesDataDAO = HeroesDataDAO()

}