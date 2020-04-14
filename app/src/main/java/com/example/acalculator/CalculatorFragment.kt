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
import butterknife.ButterKnife
import butterknife.OnClick
import butterknife.Optional
import kotlinx.android.synthetic.main.fragment_calculator.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.text.SimpleDateFormat
import java.util.*

const val EXTRA_HISTORY = "com.example.acalculator.HIST"

class CalculatorFragment : Fragment() {

    private val TAG = MainActivity::class.java.simpleName
    private var historico = ""
    private var operations = arrayListOf<Operation>()
    private var horario = ""

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_calculator, container, false)
        ButterKnife.bind(this,view)
        return view
    }

    @Optional
    @OnClick(R.id.button_0, R.id.button_00,R.id.button_1, R.id.button_2, R.id.button_3, R.id.button_4, R.id.button_42, R.id.button_5,R.id.button_6, R.id.button_7, R.id.button_8, R.id.button_9, R.id.button_adition, R.id.button_div, R.id.button_point, R.id.button_mult, R.id.button_menos)
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

    @OnClick(R.id.button_equals)
    @SuppressLint("SimpleDateFormat")
    fun onClickEquals(view: View){
        horario = SimpleDateFormat("HH:mm:ss").format(Date())
        Toast.makeText(activity as Context,"button_equals.setOnClickListener $horario", Toast.LENGTH_SHORT).show()
        historico = text_visor.text.toString()
        Log.i(TAG, "Click no botão =")
        val expression = ExpressionBuilder(text_visor.text.toString()).build()
        text_visor.text = expression.evaluate().toString()
        operations.add(Operation(historico,text_visor.text.toString().toDouble()))
        Log.i(TAG,"O resultado da expressão é ${text_visor.text}")
    }

    @OnClick(R.id.button_CE)
    @SuppressLint("SimpleDateFormat")
    fun onClickClearAll(view: View){
        horario = SimpleDateFormat("HH:mm:ss").format(Date())
        Toast.makeText(activity as Context,"button_CE.setOnClickListener $horario", Toast.LENGTH_SHORT).show()
        Log.i(TAG, "Click no botão C")
        text_visor.text = "0"
    }

    @OnClick(R.id.button_backspace)
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

    @OnClick(R.id.button_lastOne)
    @SuppressLint("SimpleDateFormat")
    fun onClickLastOperation(view: View){
        horario = SimpleDateFormat("HH:mm:ss").format(Date())
        Toast.makeText(activity as Context,"button_historico.setOnClickListener $horario", Toast.LENGTH_SHORT).show()
        Log.i(TAG, "Click no botão Historico")
        text_visor.text = historico
    }

}
