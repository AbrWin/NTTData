package com.abrsoftware.userapptest.presentation.extentions

import java.text.SimpleDateFormat
import java.util.Locale

fun String.formatDate(): String {
    val inputDateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())

    try {
        val date = inputDateFormat.parse(this)
        return inputDateFormat.format(date)
    } catch (e: Exception) {
        e.printStackTrace()
        return this // Si hay un error, devuelve la cadena original
    }
}