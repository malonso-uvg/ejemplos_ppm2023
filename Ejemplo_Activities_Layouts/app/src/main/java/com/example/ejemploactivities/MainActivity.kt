package com.example.ejemploactivities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val linearLayoutBtn : Button = findViewById(R.id.btnLinearLayout)
        linearLayoutBtn.setOnClickListener{
            openActivityLinearLayout()
        }

        val gridLayoutBtn : Button = findViewById(R.id.btnGridLayout)
        gridLayoutBtn.setOnClickListener{
            openActivityGridLayout()
        }

        val frameLayoutBtn : Button = findViewById(R.id.btnFrameLayout)
        frameLayoutBtn.setOnClickListener {
            openActivityFrameLayout()
        }

    }

    private fun openActivityLinearLayout() {
        // Crear una intención para abrir ActivityB
        val intent = Intent(this, LinearLayoutActivity::class.java)

        // Iniciar ActivityB
        startActivity(intent)
    }

    private fun openActivityGridLayout() {
        // Crear una intención para abrir ActivityB
        val intent = Intent(this, GridLayoutActivity::class.java)

        // Iniciar ActivityB
        startActivity(intent)
    }

    private fun openActivityFrameLayout() {
        // Crear una intención para abrir ActivityB
        val intent = Intent(this, FrameLayoutActivity::class.java)

        // Iniciar ActivityB
        startActivity(intent)
    }
}