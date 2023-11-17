package com.example.di_t2_ejer1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class Ejercicio2_t2 : AppCompatActivity() {

    lateinit var texto_nombre: TextInputEditText
    lateinit var correo: TextInputEditText
    lateinit var contrasena: TextInputEditText
    lateinit var nombrelayout: TextInputLayout
    lateinit var boton: Button
    lateinit var intento: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio2_t2)

        texto_nombre = findViewById<TextInputEditText>(R.id.textinputedittextnom)
        correo = findViewById<TextInputEditText>(R.id.textinputedittextcor)
        contrasena = findViewById<TextInputEditText>(R.id.textinputedittextcon)
        nombrelayout = findViewById<TextInputLayout>(R.id.textinputlayoutnom)
        boton = findViewById<Button>(R.id.button)

        boton.setOnClickListener {
            validar(texto_nombre, correo, contrasena, nombrelayout)
        }

        intento = Intent(this, MainActivity::class.java)
    }

    fun validar(nom:TextInputEditText, cor:TextInputEditText, con:TextInputEditText, nl:TextInputLayout){
        if(nom.text.toString() != ""){
            nl.boxStrokeColor = getColor(R.color.black00)
            nl.defaultHintTextColor = getColorStateList(R.color.black00)
            nl.hintTextColor = getColorStateList(R.color.black00)
        }
        if(nom.text.toString() != "" && cor.text.toString().contains("@") && cor.text.toString().contains(".") && con.text.toString().length >= 6){
            startActivity(intento)
        }else{
            if(nom.text.toString() == ""){
                nom.error="el nombre no puede estar vacio"
            }else if(!cor.text.toString().contains("@") && !cor.text.toString().contains(".")){
                cor.error="el correo debe contener @ y un punto"
            }else if(con.text.toString().length < 6){
                con.error="la contrasena debe contener al menos 6 caracteres"
            }
        }
    }
}