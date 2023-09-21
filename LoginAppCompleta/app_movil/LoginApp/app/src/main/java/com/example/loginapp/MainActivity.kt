package com.example.loginapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject


class MainActivity : AppCompatActivity() {

    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Obtener referencias a los elementos del diseño XML
        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)

        // Configurar un clic de botón
        btnLogin.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()
            // Llamar a la función loginAndStoreJwt en un contexto de GlobalScope para realizar la operación de forma asincrónica
            GlobalScope.launch(Dispatchers.Main) {
                val jwt = loginAndStoreJwt(applicationContext, username, password)
                if (jwt != null) {
                    val intent = Intent(applicationContext, ContentActivity::class.java)
                    intent.putExtra("jwt", jwt) // Reemplaza "clave" y "valor" con tus datos
                    startActivity(intent)
                } else {
                    val toast = Toast.makeText(applicationContext, "Credenciales invalidas", Toast.LENGTH_SHORT)
                    toast.show()
                }
            }

        }


    }

    suspend fun loginAndStoreJwt(context: Context, username: String, password: String): String? {
        val json = JSONObject()
        json.put("username", username)
        json.put("password", password)

        val mediaType = "application/x-www-form-urlencoded; charset=UTF-8".toMediaType()
        val requestBody = json.toString().toRequestBody(mediaType)

        println(username)
        println(password)
        println(json.toString())

        val request = Request.Builder()
            .url("http://10.0.2.2/basic-php-jwt-auth-example/public/authenticate.php") // Reemplaza con la URL de tu servidor
            .post(requestBody)
            .build()

        return withContext(Dispatchers.IO) {
            val response = OkHttpClient().newCall(request).execute()
            val responseBody = response.body?.string()

            if (response.isSuccessful && responseBody != null && !responseBody.equals("error_bad_credentials")) {
                //val jwt = JSONObject(responseBody).getString("jwt")
                val jwt = responseBody
                println(jwt)
                return@withContext jwt
            } else {
                // Manejar error de autenticación u otra situación
                return@withContext null
            }
        }
    }

}