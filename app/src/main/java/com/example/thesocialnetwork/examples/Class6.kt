package com.example.thesocialnetwork

/**
 * 0. What is an object?
 *       A structure with properties and methods
 *
 * 1.- Inheritance
 * 2.- Polymorphism
 * 3.- Abstraction
 * 4.- Encapsulation
 *
 *
 *                          Electronic
 *                            Device (CLASS)
 *                (brand, model, width, height, color)
 *
 *  Mobile Device: (DATA CLASS) (cameras, battery)               Appliance (kwh)
 *
 * Phone    Tablet                          Washer      Fridge      Microwave
 * +call    +draw                           +wash      +freeze       +heat
 *
 */
enum class Brand {
    Samsung,
    Apple,
    Unknown;

    fun brandInLowerCase(): String {
        return this.toString().lowercase()
    }
}

enum class Color {
    Black,
    Yellow,
    Purple
}

open class ElectronicDevice2(
    val brand: Brand = Brand.Apple,
    val model: String = "Unknown",
    val width: Float = 0F,
    val height: Float = 0F,
    val color: Color = Color.Yellow
)

fun main() {
    val tv = ElectronicDevice(
        brand = Brand.Samsung,
        model = "HD4K95J",
        width = 180F,
        height = 90F,
        color = Color.Black
    )

    val iPhone = ElectronicDevice(
        brand = Brand.Apple,
        model = "iPhone 14 Pro Max",
        width = 8F,
        height = 12F,
        color = Color.Purple
    )

    val iPad = ElectronicDevice(
        brand = Brand.Apple,
        model = "iPad Pro",
        width = 16F,
        height = 10F,
        color = Color.Yellow
    )
    println(tv)
    println(iPhone)

    if (tv.brand == iPhone.brand) {
        println("Device model ${tv.model} and ${iPhone.model} are the same brand")
    }


    if (iPhone.brand == iPad.brand) {
        println("Device model ${iPhone.model} and ${iPad.model} are the same brand")
    }

    val dog = Dog(
        DogBreed.Golden,
        "Firulais",
        "brown",
        true,
        10F,
        20F,
        1
    )
    println(dog)

    println(
        Brand.Samsung.brandInLowerCase()
    )
}


/** Declare a data class Post
 *  and with a property called "type" of an enum with 3 possible values
 */


data class Dog(
    val breed: DogBreed,
    val name: String,
    val color: String,

    var isHungry: Boolean,
    var height: Float,
    var width: Float,
    var age: Int
)

enum class DogBreed {
    Golden
}

enum class PostType {
    Image,
    Text,
}

enum class Reactions {
    Like,
    Hearth,
    Dislike
}

data class User(
    val fullName: String? = null,
    val profilePicture: String? = null
)

data class Creator(
    val user: User
)

data class Post(
    val id: String? = null,
    val text: String? = null,
    val creator: Creator? = null,
    val type: PostType,
    val image: String? = null,
)


/**
 * 2 object of class Human(properties), array of pets, Pet (type, name, age)
 */