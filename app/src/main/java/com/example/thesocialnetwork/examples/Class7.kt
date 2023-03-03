package com.example.thesocialnetwork

open class ElectronicDevice(
    var brand: Brand = Brand.Unknown,
    open val height: Float,
    open val width: Float,
    var model: String = "",
    var color: Color = Color.Black
) {
    override fun toString(): String {
        return "Brand: $brand, Height: $height, Width: $width, Model: $model, Color: $color"
    }
}

data class MobileDevice(
    val numberOfCameras: Int,
    val battery: Int,
    override var width: Float = 0F,
    override val height: Float
) : ElectronicDevice(width = width, height = height) {

    override fun toString(): String {
        return super.toString() + ", Number of cameras: $numberOfCameras, Battery: $battery"
    }

    fun describe(): String {
        return "Brand: $brand, Number of cameras: $numberOfCameras"
    }
}

fun main() {
    val device = ElectronicDevice(
        width = 20F,
        height = 30F
    )

    val iPhone = MobileDevice(numberOfCameras = 3, battery = 100, height = 120F)
    iPhone.brand = Brand.Apple
    iPhone.model = "iPhone 14 Pro Max"
    iPhone.color = Color.Purple
    iPhone.width = 110F

    println(device)
    println(iPhone)
}

/**
 * Create a parent class with both constant and variable properties and two level classes, the last
 * one has to be a data class
 *
 * That means, 3 hierarchy levels.
 * 1.- Use val, var,
 * 2.- Use override
 * 3.- Use data class in the last level
 * 4.- Create custom objects of each level
 * 5.- (Optional) Use of arrays and enum classes
 */