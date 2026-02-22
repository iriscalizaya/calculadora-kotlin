package com.example.calculadora

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var num1: EditText
    lateinit var num2: EditText
    lateinit var resultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        num1 = findViewById(R.id.etNum1)
        num2 = findViewById(R.id.etNum2)
        resultado = findViewById(R.id.etResultado)

        val botonSuma = findViewById<Button>(R.id.btnSuma)
        val botonResta = findViewById<Button>(R.id.btnResta)
        val botonM = findViewById<Button>(R.id.btnMulti)
        val botonDiv = findViewById<Button>(R.id.btnDiv)

        botonSuma.setOnClickListener { suma() }
        botonResta.setOnClickListener { resta() }
        botonM.setOnClickListener { multiplicar() }
        botonDiv.setOnClickListener { dividir() }
    }

    fun limpiarErrores(){
        num1.error = null
        num2.error = null
    }

    fun limpiarResultado(){
        resultado.setText("")
    }

    fun validarCampos(): Boolean {

        val texto1 = num1.text.toString()
        val texto2 = num2.text.toString()

        if(texto1.isEmpty()){
            num1.error = "Ingrese un número"
            limpiarResultado()
            return false
        }

        if(texto2.isEmpty()){
            num2.error = "Ingrese un número"
            limpiarResultado()
            return false
        }

        if(texto1 == "-" || texto1 == "." || texto1 == "-."){
            num1.error = "Número inválido"
            limpiarResultado()
            return false
        }

        if(texto2 == "-" || texto2 == "." || texto2 == "-."){
            num2.error = "Número inválido"
            limpiarResultado()
            return false
        }

        return true
    }

    fun mostrarResultado(res: Double){

        if(res.isInfinite() || res.isNaN()){
            resultado.setText("Resultado inválido")
            return
        }

        if(res % 1 == 0.0){
            resultado.setText(res.toLong().toString())
        }else{
            resultado.setText(res.toString())
        }
    }

    fun suma(){

        limpiarErrores()

        try{

            if(!validarCampos()){
                return
            }

            val valor1 = num1.text.toString().toDouble()
            val valor2 = num2.text.toString().toDouble()

            val res = valor1 + valor2

            mostrarResultado(res)

        }catch(e: Exception){

            num1.error = "Valor inválido"
            num2.error = "Valor inválido"
            limpiarResultado()

        }
    }

    fun resta(){

        limpiarErrores()

        try{

            if(!validarCampos()){
                return
            }

            val valor1 = num1.text.toString().toDouble()
            val valor2 = num2.text.toString().toDouble()

            val res = valor1 - valor2

            mostrarResultado(res)

        }catch(e: Exception){

            num1.error = "Valor inválido"
            num2.error = "Valor inválido"
            limpiarResultado()

        }
    }

    fun multiplicar(){

        limpiarErrores()

        try{

            if(!validarCampos()){
                return
            }

            val valor1 = num1.text.toString().toDouble()
            val valor2 = num2.text.toString().toDouble()

            val res = valor1 * valor2

            mostrarResultado(res)

        }catch(e: Exception){

            num1.error = "Valor inválido"
            num2.error = "Valor inválido"
            limpiarResultado()

        }
    }

    fun dividir(){

        limpiarErrores()

        try{

            if(!validarCampos()){
                return
            }

            val valor1 = num1.text.toString().toDouble()
            val valor2 = num2.text.toString().toDouble()

            if(valor2 == 0.0){
                num2.error = "No se puede dividir entre 0"
                limpiarResultado()
                return
            }

            val res = valor1 / valor2

            mostrarResultado(res)

        }catch(e: Exception){

            num1.error = "Valor inválido"
            num2.error = "Valor inválido"
            limpiarResultado()

        }
    }
}