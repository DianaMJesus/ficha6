package com.example.acalculator

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_expression.view.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class HistoryAdapter(context: Context, private val layout: Int, items: ArrayList<String>) : ArrayAdapter<String>(context,layout,items){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(layout,parent,false)
        val expressionParts = getItem(position)?.split("=")
        view.text_expression.text = expressionParts?.get(0)
        view.text_result.text = expressionParts?.get(1)
        return view
    }
}

class MainActivity : AppCompatActivity() {

    private val TAG = MainActivity::class.java.simpleName
    private  val VISOR_KEY = "visor"
    private var historico = ""
    private var horario = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG,"o método onCreate foi invocado")
        setContentView(R.layout.activity_main)
        list_historic.adapter = HistoryAdapter(this, R.layout.item_expression, arrayListOf("1+1=2", "2+3=5"))

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

        button_menos.setOnClickListener { onClickCalculation ("-") }

        button_mult.setOnClickListener { onClickCalculation("*") }

        button_div.setOnClickListener { onClickCalculation("/") }

        button_CE.setOnClickListener { onClickClearAll() }

        button_backspace.setOnClickListener{ onClickClearOne() }

        button_equals.setOnClickListener { onClickEquals() }

        button_lastOne.setOnClickListener { onClickHistorico() }
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

    @SuppressLint("SimpleDateFormat")
    private fun onClickCalculation(symbol: String){
        horario = SimpleDateFormat("HH:mm:ss").format(Date())
        Toast.makeText(this,"setOnClickListener $horario",Toast.LENGTH_SHORT).show()
        Log.i(TAG, "Click no botão $symbol")
        text_visor.append(symbol)
    }

    @SuppressLint("SimpleDateFormat")
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

    @SuppressLint("SimpleDateFormat")
    private fun onClickEquals(){
        horario = SimpleDateFormat("HH:mm:ss").format(Date())
        Toast.makeText(this,"button_equals.setOnClickListener $horario",Toast.LENGTH_SHORT).show()
        historico = text_visor.text.toString()
        Log.i(TAG, "Click no botão =")
        val expression = ExpressionBuilder(text_visor.text.toString()).build()
        text_visor.text = expression.evaluate().toString()
        Log.i(TAG,"O resultado da expressão é ${text_visor.text}")
    }

    @SuppressLint("SimpleDateFormat")
    private fun onClickHistorico(){
        horario = SimpleDateFormat("HH:mm:ss").format(Date())
        Toast.makeText(this,"button_historico.setOnClickListener $horario",Toast.LENGTH_SHORT).show()
        Log.i(TAG, "Click no botão Historico")
        text_visor.text = historico
    }

    @SuppressLint("SimpleDateFormat")
    private fun onClickClearAll(){
        horario = SimpleDateFormat("HH:mm:ss").format(Date())
        Toast.makeText(this,"button_CE.setOnClickListener $horario",Toast.LENGTH_SHORT).show()
        Log.i(TAG, "Click no botão C")
        text_visor.text = "0"
    }

    @SuppressLint("SimpleDateFormat")
    private fun onClickClearOne(){
        horario = SimpleDateFormat("HH:mm:ss").format(Date())
        Toast.makeText(this,"button_backspace.setOnClickListener $horario",Toast.LENGTH_SHORT).show()
        Log.i(TAG, "Click no botão <")
        if(text_visor.text.length == 1){
            text_visor.text = "0"
        }else{
            text_visor.text = text_visor.text.dropLast(1)
        }
    }
}
