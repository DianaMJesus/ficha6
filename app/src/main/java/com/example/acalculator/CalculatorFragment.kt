package com.example.acalculator

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_calculator.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.text.SimpleDateFormat
import java.util.*

const val EXTRA_HISTORY = "com.example.acalculator.HIST"

class CalculatorFragment : Fragment() {

    private val TAG = MainActivity::class.java.simpleName
    private val VISOR_KEY = "visor"
    private var historico = ""
    private var operations = arrayListOf<Operation>()
    //private var list_history = arrayListOf("1+1=2","2+3=5")
    private var horario = ""

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calculator, container, false)
    }

    @SuppressLint("SimpleDateFormat")
    fun onClickSymbol (view: View){
        var symbol = view.tag.toString()
        horario = SimpleDateFormat("HH:mm:ss").format(Date())
        Toast.makeText(activity as Context,"onClickSymbol $horario", Toast.LENGTH_SHORT).show()
        Log.i(TAG,"Click no botão $symbol")
        if(text_visor.text == "0") {
            text_visor.text = symbol
        } else {
            text_visor.append(symbol)
        }
    }

    @SuppressLint("SimpleDateFormat")
    fun onClickEquals(view: View){
        horario = SimpleDateFormat("HH:mm:ss").format(Date())
        Toast.makeText(activity as Context,"button_equals.setOnClickListener $horario", Toast.LENGTH_SHORT).show()
        historico = text_visor.text.toString()
        Log.i(TAG, "Click no botão =")
        val expression = ExpressionBuilder(text_visor.text.toString()).build()
        text_visor.text = expression.evaluate().toString()
        //list_history.add("$historico=${text_visor.text}")
        operations.add(Operation(historico,text_visor.text.toString().toDouble()))
        Log.i(TAG,"O resultado da expressão é ${text_visor.text}")
    }

    @SuppressLint("SimpleDateFormat")
    fun onClickClearAll(view: View){
        horario = SimpleDateFormat("HH:mm:ss").format(Date())
        Toast.makeText(activity as Context,"button_CE.setOnClickListener $horario", Toast.LENGTH_SHORT).show()
        Log.i(TAG, "Click no botão C")
        text_visor.text = "0"
    }

    @SuppressLint("SimpleDateFormat")
    fun onClickClearOne(view: View){
        horario = SimpleDateFormat("HH:mm:ss").format(Date())
        Toast.makeText(activity as Context,"button_backspace.setOnClickListener $horario", Toast.LENGTH_SHORT).show()
        Log.i(TAG, "Click no botão <")
        if(text_visor.text.length == 1){
            text_visor.text = "0"
        }else{
            text_visor.text = text_visor.text.dropLast(1)
        }
    }

    @SuppressLint("SimpleDateFormat")
    fun onClickHistorico(view: View){
        horario = SimpleDateFormat("HH:mm:ss").format(Date())
        Toast.makeText(activity as Context,"button_historico.setOnClickListener $horario", Toast.LENGTH_SHORT).show()
        Log.i(TAG, "Click no botão Historico")
        text_visor.text = historico
    }

    /*@SuppressLint("SimpleDateFormat")
    fun onClickHistory(view: View){
        horario = SimpleDateFormat("HH:mm:ss").format(Date())
        Toast.makeText(this,"button_backspace.setOnClickListener $horario",Toast.LENGTH_SHORT).show()
        Log.i(TAG, "Click no botão Historico Total")
        val intent = Intent(this,Main2Activity::class.java)
        intent.apply { putStringArrayListExtra(EXTRA_HISTORICO,list_historico) }
        startActivity(intent)
        finish()
    }*/

    fun onClickHistory(view: View){

    }

}
