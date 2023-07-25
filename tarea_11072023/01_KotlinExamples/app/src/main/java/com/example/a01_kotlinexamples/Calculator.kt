package com.example.a01_kotlinexamples

class Calculator {

    fun suma(num1: Int, num2: Int): Int{
        return num1 + num2;
    }

    fun resta(minuendo: Int, sustraendo: Int): Int{
        return minuendo - sustraendo
    }

    fun multiplicacion(factor1: Int, factor2: Int): Int{
        return factor1 * factor2
    }

    fun division(dividendo: Int, divisor: Int): Int{
        return dividendo / divisor
    }

    fun residuo(dividendo: Int, divisor: Int): Int{
        return dividendo % divisor
    }
}