package com.example.acalculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private val TAG = MainActivity::class.java.simpleName
    private  val VISOR_KEY = "visor"
    var historico = ""
    private var horario = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG,"o método onCreate foi invocado")
        setContentView(R.layout.activity_main)

        //definir funcao dos botoes dos numeros
        button_1.setOnClickListener{ onClickSymbol("1") }

        button_2.setOnClickListener{ onClickSymbol("2") }

        button_3.setOnClickListener{ onClickSymbol("3") }

        button_4.setOnClickListener{ onClickSymbol("4") }

        button_5.setOnClickListener{ onClickSymbol("5") }

        button_6.setOnClickListener{ onClickSymbol("6") }

        button_7.setOnClickListener{ onClickSymbol("7") }

        button_8.setOnClickListener{ onClickSymbol("8") }

        button_9.setOnClickListener{ onClickSymbol("9") }

        button_point.setOnClickListener { onClickCalculation(".") }

        button_adition.setOnClickListener { onClickCalculation("+") }

        button_subtration.setOnClickListener { onClickCalculation ("-") }

        button_mult.setOnClickListener { onClickCalculation("*") }

        button_div.setOnClickListener { onClickCalculation("/") }

        button_deleteAll.setOnClickListener { onClickDeleteAll() }

        button_equals.setOnClickListener { onClickEquals() }

        button_historico.setOnClickListener { onClickHistorico() }
    }

    override fun onDestroy() {
        Log.i(TAG,"o método onDestroy foi invocado")
        super.onDestroy()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        text_visor.text = savedInstanceState?.getString(VISOR_KEY)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.run { putString(VISOR_KEY, text_visor.text.toString()) }
        super.onSaveInstanceState(outState)
    }

    private fun onClickCalculation(symbol: String){
        horario = SimpleDateFormat("HH:mm:ss").format(Date())
        Toast.makeText(this,"setOnClickListener $horario",Toast.LENGTH_SHORT).show()
        Log.i(TAG, "Click no botão $symbol")
        text_visor.append(symbol)
    }

    private fun onClickSymbol (symbol: String){
        horario = SimpleDateFormat("HH:mm:ss").format(Date())
        Toast.makeText(this,"onClickSymbol $horario",Toast.LENGTH_SHORT).show()
        Log.i(TAG,"Click no botão $symbol")
        if(text_visor.text == "0") {
            text_visor.text = symbol
        } else {
            text_visor.append(symbol)
        }
    }

    private fun onClickEquals(){
        horario = SimpleDateFormat("HH:mm:ss").format(Date())
        Toast.makeText(this,"button_equals.setOnClickListener $horario",Toast.LENGTH_SHORT).show()
        historico = text_visor.text.toString()
        Log.i(TAG, "Click no botão =")
        val expression = ExpressionBuilder(text_visor.text.toString()).build()
        text_visor.text = expression.evaluate().toString()
        Log.i(TAG,"O resultado da expressão é ${text_visor.text}")
    }

    private fun onClickHistorico(){
        horario = SimpleDateFormat("HH:mm:ss").format(Date())
        Toast.makeText(this,"button_historico.setOnClickListener $horario",Toast.LENGTH_SHORT).show()
        Log.i(TAG, "Click no botão Historico")
        text_visor.text = historico
    }

    private fun onClickDeleteAll(){
        horario = SimpleDateFormat("HH:mm:ss").format(Date())
        Toast.makeText(this,"button_deleteAll.setOnClickListener $horario",Toast.LENGTH_SHORT).show()
        Log.i(TAG, "Click no botão C")
        text_visor.text = "0"
    }
}
