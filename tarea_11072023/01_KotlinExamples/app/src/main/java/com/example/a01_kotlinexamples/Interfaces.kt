package com.example.a01_kotlinexamples


/*
https://kotlinlang.org/docs/tutorials/kotlin-for-py/inheritance.html#polymorphism

"The single-parent rule often becomes too limiting,
as you'll often find commonalities between classes in
different branches of a class hierarchy.
These commonalities can be expressed in interfaces.

An interface is essentially a contract that a
class may choose to sign; if it does, the class
is obliged to provide implementations of the properties
and functions of the interface.
However, an interface may (but typically doesn't)
provide a default implementation of some or all
of its properties and functions. If a property or
function has a default implementation,
the class may choose to override it,
but it doesn't have to.
*/

interface Driveable {
    val maxSpeed: Double
    fun drive(): String
    fun brake(){
        println("The drivable is braking")
    }
}

// Class Car which extends the interface
open class Car(override val maxSpeed: Double,
          open val brandName: String
) : Driveable {
    // open so it can be overriden by inhereting classes
    open var range: Double = 0.0

    open fun extendRange(amount: Double) {
        if (amount > 0) {
            range += amount
        }

    }

    override fun drive(): String {
        println("Drove for $range KM")
        return range.toString()
    }

    // overridden functions are implicitly open:
    override fun brake() {
        println("The car is breaking")
    }
}
    // In case there is no primary Constructor
class ElectricCar(override val maxSpeed: Double,
                      override val brandName: String,
                      batteryLife: Double) : Car(maxSpeed, brandName) {

    // in KM
    override var range = batteryLife/6

    override fun drive() = "Overriding the drive of my Car"

    fun drive(distance: Double){
        println("Drove for $distance KM on electricity")
    }
    override fun brake(){
        println("The electirc car is breaking")
    }
}



fun main(args: Array<String>){
    var audiA3 = Car(200.0, "Audi")
    var teslaS = ElectricCar(250.0, "Tesla", 85.0)

    // Polymorphism is the ability to treat objects
    // with similar traits in a common way
    audiA3.drive()
    // Only works because ElectricCar is a Subclass of Car
    // Or alternatively works if Car was an Interface and ElectricCar would inherit from it
    teslaS.drive()
    teslaS.drive(200.0)
}
// Subclasses of a class that implements an interface
// (in this case, ElectricCar) are also considered
// to be implementing the interface.


