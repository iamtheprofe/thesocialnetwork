package com.example.thesocialnetwork.examples

object Calculator {
    var count: Int = 0

    fun sum() {
        count = count + 1
    }
}

fun main() {
    val calculator = Calculator
    val calculator2 = Calculator

    println(calculator.count)

    calculator.sum()

    println("Calculator 1: ${calculator.count}")
    println("Calculator 2: ${calculator2.count}")
}