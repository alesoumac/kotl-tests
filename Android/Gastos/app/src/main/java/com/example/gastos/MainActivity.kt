package com.example.gastos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception
import java.lang.Math.round
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnCalcular.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {

            // botão Calcular
            R.id.btnCalcular -> calcularPreco()
        }
    }

    private fun calcularPreco() {
        try {
            if (validationOK()) {
                val auto: Float = edtAutonomia.text.toString().toFloat()
                val distancia: Float = edtDistancia.text.toString().toFloat()
                val preco: Float = edtPreco.text.toString().toFloat()
                var totalValue: Float
                if (auto.compareTo(0) == 0 ) {
                    totalValue = 0.0F
                    Toast.makeText(this, getString(R.string.msg_autonomia_nao_zero), Toast.LENGTH_SHORT).show()
                }
                else {
                    totalValue = distancia * preco / auto
                }
                lblValor.text = "R$ ${"%.2f".format(totalValue)}"
            }
            else {
                Toast.makeText(this, getString(R.string.msg_preencher_todos_parametros), Toast.LENGTH_LONG).show()
            }
        } catch (exc: Exception) {
            Toast.makeText(this, "ERRO: ${exc.toString()}", Toast.LENGTH_SHORT).show()
        }
    }
    private fun validationOK(): Boolean {
        if (edtAutonomia.text.isEmpty() || edtDistancia.text.isEmpty() || edtPreco.text.isEmpty())
            return false
        return true
    }
}