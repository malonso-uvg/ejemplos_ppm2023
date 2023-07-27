package com.example.a02_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var btnEjecutar: Button
    private lateinit var txtNumero1: TextView
    private lateinit var txtNumero2: TextView
    private lateinit var cmbOperaciones : Spinner


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Elementos UI
        btnEjecutar = findViewById(R.id.btnEjecutar)
        txtNumero1 = findViewById(R.id.txtNumero1)
        txtNumero2 = findViewById(R.id.txtNumero2)
        cmbOperaciones = findViewById(R.id.spinnerOperations)

        btnEjecutar.setOnClickListener{
            calculate()
        }

    }



    private fun calculate(){

        val operacion = cmbOperaciones.selectedItem
        val numero1 = txtNumero1.text.toString().toInt()
        val numero2 = txtNumero2.text.toString().toInt()
        val calculadora : Calculator = Calculator()

        val result = when (operacion) {
            "Suma" -> Toast.makeText(this, "" + numero1 + " + " + numero2 + " = " + calculadora.suma(numero1, numero2), Toast.LENGTH_SHORT).show()
            "Resta" -> Toast.makeText(this, "" + numero1 + " - " + numero2 + " = " + calculadora.resta(numero1, numero2), Toast.LENGTH_SHORT).show()
            "Multiplicacion" -> Toast.makeText(this, "" + numero1 + " * " + numero2 + " = " + calculadora.multiplicacion(numero1, numero2), Toast.LENGTH_SHORT).show()
            "División" -> Toast.makeText(this, "" + numero1 + " / " + numero2 + " = " + calculadora.division(numero1, numero2), Toast.LENGTH_SHORT).show()
            "Residuo" -> Toast.makeText(this, "" + numero1 + " % " + numero2 + " = " + calculadora.residuo(numero1, numero2), Toast.LENGTH_SHORT).show()
            else -> Toast.makeText(this, "Operación inválida", Toast.LENGTH_SHORT).show()
        }

    }

}