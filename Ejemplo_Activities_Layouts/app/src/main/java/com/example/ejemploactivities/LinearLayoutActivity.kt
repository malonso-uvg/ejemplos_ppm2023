package com.example.ejemploactivities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast

class LinearLayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_linear_layout)

        var cantidad_botones: Int = 0

        while (cantidad_botones < 5){

            //Creo el objeto de tipo Boton
            val miBoton = Button(this)
            miBoton.text = "Buton Generado " + cantidad_botones
            miBoton.setBackgroundColor(getResources().getColor(R.color.azul))
            miBoton.setOnClickListener{
                val toast = Toast.makeText(this, "Boton presionado", Toast.LENGTH_SHORT)
                toast.show()
            }

            //Busco el Layout y agrego el boton creado
            val miLayout = findViewById<LinearLayout>(R.id.linearLayout1)
            miLayout.addView(miBoton)

            cantidad_botones++
        }

    }
}