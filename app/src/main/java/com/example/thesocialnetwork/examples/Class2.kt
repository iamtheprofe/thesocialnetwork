package com.example.thesocialnetwork.examples

fun main2() {
    println("Hello world!")

    val size = 10 // Int/Integer Aqui esta una constante y almacena valores que no pueden cambiar
    println(size)

    var temperature = 37.5 // Float Aqui esta una variable y almacena valores que SI pueden cambiar
    println(temperature)

    temperature = 36.0
    temperature = 36.0
    temperature = 37.0
    temperature = 38.0
    temperature = 39.0
    temperature = 40.0
    println(temperature)

    var turnOn = true // Boolean
    turnOn = true // Boolean
    println(turnOn)
    // Pepito se fue a su casa
    val message = "Hello World!"
    println(message)
}

fun main3() {
    /**
     * 1.- Constante con Usuario de Twitch
     * 2.- Constante con fecha de nacimiento (aleatoria)
     * 3.- Edad (random)
     * 4.- ¿Eres programador?
     * 5.- Temperatura
     *
     * En medio de cada declaración imprimen el valor de la constante
     */
    val name = "Daniel Garcia"
    println(name)

    val birthDate = "12/12/1000"
    println(birthDate)

    val age = 29
    println(age)

    val isDeveloper = true
    println(isDeveloper)

    val temperature = 26.5
    println(temperature)

    var animal: String = ""
    println(animal)

    if (isDeveloper) {
        println("You will be a fucking millionaire")
        println("1")
        println("2")
        animal = "Dog"
        println(animal)
    } else {
        println("You can still learn")
        println("5")
        println("6")
        animal = "Cat"
        println(animal)
    }
    println(animal)

    /**
     * 1. Escribir un bloque de código que pregunte si la edad es menor de 25 Imprima (Estas joven) y si no (Ya no estas viejo para fiesta)
     * 2. Qué es un switch en kotlin when
     */
}