package com.example.thesocialnetwork

enum class SkinColor {
    Brown,
    Black,
    White;
}

enum class Pet {
    Cat,
    Dog;
}

data class PetsInfo(
    val breed: Pet,
    val age: String,
    val name: String
) {
    override fun toString(): String {
        return "Breed: $breed \nAge: $age \nName $name \n=====================\n"
    }
}

data class Human(
    val name: String,
    val skinColor: SkinColor,
    val pets: ArrayList<Pet>,
    val petsInfo: ArrayList<PetsInfo>
) {
    override fun toString(): String {
        return "Name: $name \nSkinColor: $skinColor \nPets $pets \nPetsInfo $petsInfo \n=====================\n"
    }
}

fun main() {

    val muriDog = PetsInfo(
        Pet.Cat,
        "12 years old",
        "Simon"
    )
    val katheDog = PetsInfo(
        Pet.Dog,
        "9 years old",
        "Kihara"
    )
    val katheCat = PetsInfo(
        Pet.Cat,
        "7 years old",
        "Patuleco"
    )

    val murillo = Human(
        "Murillo",
        SkinColor.Brown,
        arrayListOf(
            Pet.Dog,
        ),
        arrayListOf(muriDog)
    )

    val kathe = Human(
        "Kathe",
        SkinColor.White,
        arrayListOf(
            Pet.Cat,
            Pet.Dog,
        ),
        arrayListOf(
            katheCat,
            katheDog
        ),
    )
    println(murillo)
    println(kathe)
}
