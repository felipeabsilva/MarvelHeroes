package com.felipesilva.marvelheroes.utilities

import java.util.*

object MarvelApiParam {
    val URL_BASE = "https://gateway.marvel.com/v1/public/"
    val OFFSET = 0
    val LIMIT = 20
    val TS = (Calendar.getInstance(TimeZone.getTimeZone("UTC")).timeInMillis / 1000L).toString()
    val PUBLIC_KEY = "13e7bfaffd3dc94a70c5c4fd44c4b32d"
    val PRIVATE_KEY = "583636d2a31a8126a2cb72a0716181a04d3bbb64"
    val HASH = (TS + PRIVATE_KEY + PUBLIC_KEY).md5()
}
