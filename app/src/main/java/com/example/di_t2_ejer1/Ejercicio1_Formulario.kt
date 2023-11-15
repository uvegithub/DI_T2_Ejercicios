package com.example.di_t2_ejer1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText

class Ejercicio1_Formulario : AppCompatActivity() {

    lateinit var texto_nombre: TextInputEditText
    lateinit var edad_texto: TextInputEditText
    lateinit var boton: Button
    lateinit var intento: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio1_formulario)

        texto_nombre = findViewById<TextInputEditText>(R.id.textinputedittext)
        edad_texto = findViewById<TextInputEditText>(R.id.textinputedittext2)
        boton = findViewById<Button>(R.id.button)

        boton.setOnClickListener {
            validarNombreyEdad(texto_nombre, edad_texto)
        }

        intento = Intent(this, MainActivity::class.java)
    }

    fun validarNombreyEdad(nom:TextInputEditText, edad:TextInputEditText){
        if(nom.text.toString().length>2 && edad.text.toString().toInt()>=18){
            startActivity(intento)
        }else{
            if(nom.text.toString().length<2){
                nom.error = "el nombre debe tener un minimo de 2 caracteres"
            }else if(edad.text.toString().toInt()<18){
                edad.error = "la edad debe ser mayor de 18 o igual"
            }
        }
    }



}