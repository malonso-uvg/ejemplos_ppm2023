package com.example.a01_kotlinexamples

// class Car(var brand: String, var model: String, var year: Int)

class Car{
    var price : Double
    var brand : String = ""
    var model : String = ""
    var year : Int = 0

    constructor(_brand: String, _model: String, _year:Int){

        brand = _brand
        model = _model
        year = _year

        if (year >= 2010){
            price = 120000.00
        } else {
            price = 75000.00
        }
    }

    fun getInformation(): String {
        return "Marca: " + brand + " Modelo: " + model + " año: " + year + " precio: " + price
    }
}



//One line commemnts
/*
* Este es un comentario de varias lineas
* similar a java
* */
fun main(){

    var numero = 10  //declaro la variable y le asigno un valor de una vez
    val numero_const = 15 //Declarando una constante
    var cadena_ejemplo = "Moises Alonso"  //Kotlin identifica el tipo de dato
    var numero_tipado : Int = 120 //Declaro la variable y su tipo
    var cadena_tipada : String = "Hola mundo" //Variable cadena tipada
    val PI: Double = 3.14159 //Aca guardo valores con punto flotante
    var isEmpty: Boolean = true //Variables logicas
    var onlyOneChar: Char = 'A' //CAracters
    val anioActual: Int = 2023

    var i = 0
    while (i <= 10){
        println("2 * " + i + " = " + (i * 2))
        i++
    }

    var auto1 = Car("Nissan", "sentra", 1992)
    var auto2 = Car("Mazda", "Protege", 1998)

    var automoviles = ArrayList<Car>()

    automoviles.add(auto1)
    automoviles.add(auto2)

    for (x in automoviles){
        println(x.getInformation())
    }


    println("Marca del auto: " + auto1.brand + " precio = " + auto1.price)

    println("Ingrese su nombre")
    var nombreUsuario: String = readLine()!!
    println("Bienvenido: " + nombreUsuario + " longitud caracteres = " + nombreUsuario.length)
    println("posicion 0 -> " + nombreUsuario[0])
    println("posicion 1 -> " + nombreUsuario[1])
    println("posicion 2 -> " + nombreUsuario[2])

    println("Ingrese su PASSWORD")
    var passWord = readLine()!!
    //println("Hola123".compareTo(passWord))


    //Asi es como manejo un if - else tambien se puede usar solo la parte del if
    if ("Hola123".compareTo(passWord) == 0){
        println("Password correcto")
    } else {
        println("Password INCORRECTO")
    }

    var estudiantes = arrayOf("Estudiante1", "Estudiante2", "Estudiante3")
    for (x in estudiantes){ //El ciclo for funciona como el foreach de otros lenguajes
        println(x)
    }


    //Esto es el switch case de java
    val dia = 5
    val resultado = when (dia){
        1 -> "Lunes"
        2 -> "Martes"
        3 -> "Miercoles"
        4 -> "Jueves"
        5 -> "Viernes"
        6 -> "Sabado"
        7 -> "Domingo"
        else -> "Dia no encontrado"
    }

    println("Dia resultado " + resultado)


    println("Ingrese su edad en anios")
    var entrada: String = readLine()!!
    var edadActual = entrada.toInt()   //Conversion de cadena a entero
    println("Usted nacio en: " + (anioActual - edadActual)) //Concatenar una cadena con el resultado de una operacion aritmetica

    var suma = 3 + 4
    println("3 + 4 = " + suma)
    var resta = 5 - 8
    println("5 - 8 = " + resta)
    var multiplicacion = 4 * 5
    println("4 * 5 = " + multiplicacion)
    var cociente = 6 / 3
    println("6 / 3 = " + cociente)
    var residuo = 5 % 3
    println("5 % 3 = " + residuo)

}