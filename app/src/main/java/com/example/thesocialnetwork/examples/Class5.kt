package com.example.thesocialnetwork

data class Phone(
    val width: Float,
    val height: Float,
    val brand: String,
    val model: String,
    val color: String,
    val numberOfCameras: Int,

    var battery: Int,
    var signalStrength: Int
) {
    fun call(phone: String) {
        println("The phone $brand - $model is calling the number $phone")
    }

    override fun toString(): String {
        return "Brand: $brand \nModel: $model\nColor: $color\n======================\n"
    }
}

data class Tablet(
    val width: Float,
    val height: Float,
    val brand: String,
    val model: String,
    val color: String,

    val numberOfCameras: Int,
    var battery: Int,
    var signalStrength: Int
) {
    override fun toString(): String {
        return "TABLET\nBrand: $brand \nModel: $model\nColor: $color\n======================\n"
    }
}

fun main() {
    val iPhone14 = Phone(
        140F,
        180F,
        "Apple",
        "iPhone 14 Pro Max",
        "Purple",
        3,
        100,
        80
    )
    iPhone14.call("111-111-111")
    iPhone14.call("555-5555-555")

    println(iPhone14)

    val samsungS23 = Phone(
        160F,
        190F,
        "Samsung",
        "Samsung Galaxy S23 Ultra",
        "Green",
        5,
        70,
        0
    )
    println(samsungS23)

    val iPad = Tablet(
        160F,
        190F,
        "apple",
        "iPad Pro",
        "Silver",
        1,
        70,
        0
    )
    println(iPad)


    if (iPhone14.brand == iPad.brand) {
        println("These are devices of the same brand")
    }
}