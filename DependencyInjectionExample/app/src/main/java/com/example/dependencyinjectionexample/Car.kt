package com.example.dependencyinjectionexample
/*
interface Engine{
    fun start(){

    }
}

class FuelEngine: Engine{
    override fun start(){

    }
}

class ElectricEngine: Engine{
    override fun start(){

    }
}

class TestEngine: Engine{
    override fun start(){

    }
}

/* Dependency a través del constructor
class Car(private val engine: Engine) {
    fun start() {
        engine.start()
    }
}
*/

class Car {
    lateinit var engine: Engine

    fun start() {
        engine.start()
    }
}


fun main1() {

    var isTest = true


    if (isTest){
        var car = Car()
        car.engine = TestEngine()
        car.start()
    } else {

        var car = Car()
        car.engine = ElectricEngine()
        car.start()
    }



}

*/