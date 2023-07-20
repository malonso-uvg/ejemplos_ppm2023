package com.example.a01_kotlinexamples

data class MyClass(
    val firstname: String,
    val lastname: String
)

fun String.ascending() : String {
    return toMutableList().sorted().joinToString("")
}

fun Int.doubleNumber() = this * 2

fun Int.tripleNumber() = this * 3

fun MyClass.getFullName() = "$firstname $lastname"

fun main() {
    val myObject = MyClass("Juan", "Carlos")
    var lista: List<Any> = listOf(1, "UVG", 3.1416, 'c', true, myObject)

    for (elemento in lista){
        println(elemento)

        if (elemento is String){
            println("Es una cadena")
        } else if (elemento is Int){
            println("Es un numero entero")
        } else if (elemento is Char){
            println("Es un caracter")
        } else if (elemento is Boolean){
            println("Es un boleano")
        } else if (elemento is Double){
            println("Es un double")
        } else {
            println("La clase es: " + elemento::class.simpleName)
        }

    }

    val myString = "JuanCarlos"
    println(myString.ascending())

    val myNumber = 10
    println(myNumber.doubleNumber())

    println(myNumber.tripleNumber())


    println(myObject.getFullName())
}