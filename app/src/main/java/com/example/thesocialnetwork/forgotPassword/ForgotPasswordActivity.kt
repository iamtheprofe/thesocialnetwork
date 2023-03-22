package com.example.thesocialnetwork.forgotPassword

import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.thesocialnetwork.R
import com.google.android.material.textfield.TextInputEditText


class ForgotPasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        val submit = findViewById<Button>(R.id.submit_button)
        submit.setOnClickListener() {
            handleSubmit()
        }
        /* SetOnClicklistener sirve para activar el botón submit
                    email.text.tostring permite leer el texto que edita el usuario en el email.
                    y con el atributo .trin() le quitamos la lectura de los espacio.
                    Toast.makeText() sirve para imprmir un pequeño mensaje en
                    la aplicación
         */


        Toast.makeText(this, "This onCreate", Toast.LENGTH_SHORT).show()
    }

    private fun handleSubmit() {
        val email = findViewById<TextInputEditText>(R.id.edit_email_id_input_layout)
        val isValidEmail = isValidEmails(email.text.toString())
        if (isValidEmail) {
            Toast.makeText(this, "Recovery password was sent on your email", Toast.LENGTH_SHORT)
                .show()
        } else {
            Toast.makeText(this, "Invalid email", Toast.LENGTH_SHORT).show()

        }

    }

    private fun isValidEmails(email: String): Boolean {
        val cleanEmail = email.trim().lowercase()
        /*
        El atributo matcher es para validar la cadena con el patron de EMAILADRRESS
        y el matches nos entrega el resultado si concuerda con el patron de email.
         */
        return Patterns.EMAIL_ADDRESS.matcher(cleanEmail)
            .matches() && cleanEmail == "eve.holt@reqres.in"


    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this, "This onPause", Toast.LENGTH_SHORT).show()

    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "This onResume", Toast.LENGTH_SHORT).show()

    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "This onDestroy", Toast.LENGTH_SHORT).show()

    }
}