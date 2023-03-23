package com.example.thesocialnetwork.commons

import android.util.Patterns

fun isValidEmail(email: String): Boolean {
    val cleanEmail = email.trim().lowercase()
    return Patterns.EMAIL_ADDRESS.matcher(cleanEmail).matches()
}
