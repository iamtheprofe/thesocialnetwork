package com.example.thesocialnetwork

/**
 * Day 4
 * When, Function, if-else, cycles
 *
 * Program kitchen
 */


data class Book(
    val author: String
)

class Library(
    val book: ArrayList<Book>
)

enum class Topic {
    Avocado,
    Mayo,
    Salt,
    Pepper
}

fun main() {
    println("Welcome to Lords")
    println("Do you want a milkshake?")
    // Un igual (=) es asignación
    var answer = readLine()
    // Dos igual (==) es COMPARACION DE IGUAL
    if (answer == "YES" || answer == "yes") {
        println("What flavor?")
        val flavor = readLine()
        milkshake(flavor!!)
    }

    println("Do you want a sandwich?")
    answer = readLine()
    if (answer == "YES") {
        println("What protein?")
        val protein = readLine()
        if (protein == "Proscuitto") {
            println("This sandwich is more expensive, do you want to confirm?")
            val confirmation = readLine()
            if (confirmation == "Yes") {
                sandwich(protein)
            }
        } else {
            sandwich(protein!!)
        }
    }

    println("Thank you for your visit")

    val huaweii = Phone(
        140F,
        180F,
        "Huaweii",
        "Mate Pro",
        "Tornasol",
        6,
        90,
        100
    )
    println(huaweii)
}

fun milkshake(fruit: String) {
    println("Starting a milkshake")
    println("The milkshake of $fruit is done")
    println("----------------------------")
}

fun sandwich(protein: String) {
    println("Starting a sandwich")
    println("The sandwich of $protein is done")
    println("----------------------------")
}