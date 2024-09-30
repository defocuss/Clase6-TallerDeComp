package com.example.clase5

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonShowMessage: Button = findViewById(R.id.buttonShowMessage)
        val textViewMessage: TextView = findViewById(R.id.textViewMessage)
        val imageViewIcon: ImageView = findViewById(R.id.imageViewIcon)

        // Configura el listener del botón
        buttonShowMessage.setOnClickListener {
            fetchUserData(textViewMessage)
        }
    }

    private fun fetchUserData(textView: TextView) {
        val client = OkHttpClient()

        val request = Request.Builder()
            .url("http://52.20.198.214:5050/user")  // Reemplaza con la IP pública de tu EC2
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                runOnUiThread {
                    Toast.makeText(this@MainActivity, "Error en la conexión", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onResponse(call: Call, response: Response) {
                response.body?.string()?.let {
                    val jsonObject = JSONObject(it)
                    val name = jsonObject.getString("name")
                    val email = jsonObject.getString("email")
                    val matricula = jsonObject.getString("matricula")

                    val userInfo = "Nombre: $name\nEmail: $email\nMatricula: $matricula"

                    runOnUiThread {
                        textView.text = userInfo
                    }
                }
            }
        })
    }
}
