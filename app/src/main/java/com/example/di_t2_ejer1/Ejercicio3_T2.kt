package com.example.di_t2_ejer1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class Ejercicio3_T2 : AppCompatActivity() {

    lateinit var corl: TextInputLayout
    lateinit var conl: TextInputLayout
    lateinit var noml: TextInputLayout
    lateinit var cpl: TextInputLayout
    lateinit var fel: TextInputLayout
    lateinit var bo: Button
    lateinit var intento: Intent
    lateinit var cort: TextInputEditText
    lateinit var cont: TextInputEditText
    lateinit var nomt: TextInputEditText
    lateinit var cpt: TextInputEditText
    lateinit var fet: TextInputEditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio3_t2)

        corl= findViewById<TextInputLayout>(R.id.textinputlayoutcor)
        conl= findViewById<TextInputLayout>(R.id.textinputlayoutcon)
        noml= findViewById<TextInputLayout>(R.id.textinputlayoutnom)
        cpl= findViewById<TextInputLayout>(R.id.textinputlayoutcp)
        fel= findViewById<TextInputLayout>(R.id.textinputlayoutfec)
        bo= findViewById<Button>(R.id.buttonin)
        cort= findViewById<TextInputEditText>(R.id.textinputedittextcor)
        cont= findViewById<TextInputEditText>(R.id.textinputedittextcon)
        nomt= findViewById<TextInputEditText>(R.id.textinputedittextnom)
        cpt= findViewById<TextInputEditText>(R.id.textinputedittextcp)
        fet= findViewById<TextInputEditText>(R.id.textinputedittextfec)

        bo.setOnClickListener {
            validacion(corl, conl, noml, cpl, fel, cort, cont, nomt, cpt, fet)
        }

        intento = Intent(this, MainActivity::class.java)

        val materialDatePicker = MaterialDatePicker.Builder.datePicker().setTitleText("Seleccionar fecha").build()

        materialDatePicker.addOnPositiveButtonClickListener {
            fet.setText(materialDatePicker.headerText)
        }
        fet.setOnClickListener {
            materialDatePicker.show(supportFragmentManager, materialDatePicker.toString())
        }
    }

    fun validacion(corrl:TextInputLayout, contl:TextInputLayout, nombl:TextInputLayout, codl:TextInputLayout, fechl:TextInputLayout, corrt:TextInputEditText, contt:TextInputEditText, nombt:TextInputEditText, codp:TextInputEditText, fecht:TextInputEditText){

//        println(fecht.text)
//        var arrayFecha= fecht.text.toString().split("/")


        var anio = fecht.text.toString().slice(fecht.text.toString().length-4..fecht.text.toString().length-1)
//        println(anio)

        if(corrt.text.toString().contains("@") && corrt.text.toString().contains(".") && contt.text.toString().length > 7 && contt.text.toString().contains("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])".toRegex()) && (codp.text.toString()=="" || codp.text.toString().length == 5) && anio.toInt() <= 2005){
            startActivity(intento)
        }else{
            if(!corrt.text.toString().contains("@") || !corrt.text.toString().contains(".")){
               println("entra")
                corrl.setError("el correo debe contener @ y un punto")
            }else if(contt.text.toString().length <= 7 || !contt.text.toString().contains("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])".toRegex())){
                contl.setError("la contrasena debe contener al menos 8 caracteres, un numero, una letra mayuscula y otra minuscula")
            }else if(codp.text.toString().length != 5 && codp.text.toString()!="" ){
                codl.setError("el codigo postal debe tener 5 digitos de ser introducido")
            }else if(anio.toInt() > 2005){
                fechl.setError("debes ser mayor de edad")
            }
        }
    }
}