package com.skye.practica2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val calcularBoton:Button = findViewById(R.id.calculate_button);
        val cantidad:EditText = findViewById(R.id.cost_of_service);
        val radioGroup:RadioGroup=findViewById(R.id.tip_options)
        val switch:Switch = findViewById(R.id.round_up_switch);
        val resultado:TextView = findViewById(R.id.tip_result);
        var porcentaje:Double = 0.0;
        var resultadoOperacion:Double = 0.0;

        calcularBoton.setOnClickListener {
            val seleccionadoRadioButtonId = radioGroup.checkedRadioButtonId

            if (seleccionadoRadioButtonId != -1) {
                // Obtiene el RadioButton seleccionado
                val seleccionadoRadioButton = findViewById<RadioButton>(seleccionadoRadioButtonId)
                when (seleccionadoRadioButton) {
                    findViewById<RadioButton>(R.id.option_twenty_percent) -> porcentaje = 0.20
                    findViewById<RadioButton>(R.id.option_eighteen_percent) -> porcentaje = 0.18
                    findViewById<RadioButton>(R.id.option_fifteen_percent) -> porcentaje = 0.15
                }
                val cantidadTexto = cantidad.text.toString()
                if (cantidadTexto.isNotEmpty()) {
                    val cantidadDouble = cantidadTexto.toDouble()
                    resultadoOperacion = cantidadDouble * porcentaje
                    if (switch.isChecked) {
                        resultadoOperacion = kotlin.math.ceil(resultadoOperacion)
                    }
                    resultado.text = resultadoOperacion.toString()
                } else {
                    Toast.makeText(this, "Ingresa una cantidad válida", Toast.LENGTH_SHORT).show()
                }
            } else {
                // Si ningún RadioButton está seleccionado, puedes mostrar un mensaje de error o tomar alguna otra acción.
                Toast.makeText(this, "Seleciona una opcion", Toast.LENGTH_SHORT).show();
            }
        }
    }
}