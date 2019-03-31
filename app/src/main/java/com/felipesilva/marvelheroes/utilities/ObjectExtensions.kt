package com.felipesilva.marvelheroes.utilities

import java.security.MessageDigest
import java.text.SimpleDateFormat
import java.util.*

fun String.md5(): String {
    val md = MessageDigest.getInstance("MD5")
    val digested = md.digest(toByteArray())
    return digested.joinToString("") {
        String.format("%02x", it)
    }
}

fun Date.formatDate() : String {
    val format = SimpleDateFormat("dd/MM/yyyy")
    return format.format(this)
}
