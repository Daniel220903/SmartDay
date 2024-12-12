package com.example.smartdays

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val usernameInput: EditText = findViewById(R.id.username_input)
        val passwordInput: EditText = findViewById(R.id.password_input)
        val loginButton: Button = findViewById(R.id.Login_btn)

        loginButton.setOnClickListener {
            val username = usernameInput.text?.toString()?.trim()
            val password = passwordInput.text?.toString()?.trim()

            if (username.isNullOrEmpty() || username.length <= 6) {
                AlertDialog.Builder(this)
                    .setTitle("Nombre de usuario inválido")
                    .setMessage("El nombre de usuario debe tener más de 6 caracteres.")
                    .setPositiveButton("OK", null)
                    .show()
            }
            else if (password.isNullOrEmpty() || password.length <= 8 || !password.matches(".*[a-z].*".toRegex()) || !password.matches(".*[A-Z].*".toRegex()) || !password.matches(".*[!@#$%^&*(),.?\":{}|<>].*".toRegex())) {
                AlertDialog.Builder(this)
                    .setTitle("Contraseña inválida")
                    .setMessage("La contraseña debe tener más de 8 caracteres, incluir una letra minúscula, una mayúscula y un carácter especial.")
                    .setPositiveButton("OK", null)
                    .show()
            } else {
                AlertDialog.Builder(this)
                    .setTitle("Inicio de Sesión")
                    .setMessage("¡Bienvenid@, $username!")
                    .setPositiveButton("OK", null)
                    .show()

                GlobalScope.launch {
                    delay(1200)

                    val intent = Intent(this@MainActivity, RoutineActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        }
    }
}
