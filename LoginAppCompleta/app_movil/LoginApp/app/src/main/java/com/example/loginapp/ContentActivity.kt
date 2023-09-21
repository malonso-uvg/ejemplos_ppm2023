package com.example.loginapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
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


class ContentActivity : AppCompatActivity() {

    private lateinit var tvMensaje: TextView
    private lateinit var btnDate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_content)

        tvMensaje = findViewById(R.id.tvMensaje)
        btnDate = findViewById(R.id.getDate)

        // Recupera el valor de "jwt" de los extras del Intent
        val jwt = intent.getStringExtra("jwt")

        // Verifica si se encontró el valor de "jwt"
        if (jwt != null) {
            // Haz lo que necesites hacer con la variable "jwt" aquí
            // Por ejemplo, puedes mostrarlo en un TextView

        } else {
            // implementar bandera para no hacer el request
        }

        // Configurar un clic de botón
        btnDate.setOnClickListener {

            // Llamar a la función loginAndStoreJwt en un contexto de GlobalScope para realizar la operación de forma asincrónica
            GlobalScope.launch(Dispatchers.Main) {
                val unixtime = jwt?.let { it1 -> getUnixTimeFromService(applicationContext, it1) }
                if (unixtime != null) {
                    tvMensaje.text = "" + unixtime
                } else {
                    val toast = Toast.makeText(applicationContext, "Credenciales invalidas", Toast.LENGTH_SHORT)
                    toast.show()
                }
            }

        }

    }

    suspend fun getUnixTimeFromService(context: Context, jwt: String): String? {
        val json = JSONObject()

        val mediaType = "application/x-www-form-urlencoded; charset=UTF-8".toMediaType()
        val requestBody = json.toString().toRequestBody(mediaType)

        val request = Request.Builder()
            .url("http://10.0.2.2/basic-php-jwt-auth-example/public/resource.php") // Reemplaza con la URL de tu servidor
            .get()
            .addHeader("Authorization", "Bearer $jwt")
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