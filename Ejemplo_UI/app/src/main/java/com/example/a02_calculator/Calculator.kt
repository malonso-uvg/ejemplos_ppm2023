package com.example.a02_calculator

class Calculator {
    fun suma(sumando1: Int, sumando2: Int): Int{
        return sumando1 + sumando2
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