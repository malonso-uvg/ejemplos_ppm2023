package com.example.a01_kotlinexamples

import org.junit.Test

import org.junit.Assert.*

import com.example.a01_kotlinexamples.Calculator;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun suma_isCorrect() {
        val miCalculator = Calculator()
        assertEquals(4, miCalculator.suma(2,2))
    }

    @Test
    fun resta_isCorrect(){
        val miCaculadora = Calculator()
        assertEquals(4, miCaculadora.resta(6, 2))
    }

    @Test
    fun multiplicacion_isCorrect(){
        val miCalculadora = Calculator()
        assertEquals(4, miCalculadora.multiplicacion(2, 2))
    }

    @Test
    fun division_isCorrect(){
        val miCalculadora = Calculator();
        assertEquals(2, miCalculadora.division(6, 3))
    }

    @Test
    fun residuo_isCorrect(){
        val miCalculadora = Calculator();
        assertEquals(2, miCalculadora.residuo(5, 3))
    }
}