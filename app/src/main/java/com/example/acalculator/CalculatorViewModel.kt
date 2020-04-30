package com.example.acalculator

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel(){
    private val calculatorLogic = CalculatorLogic()
    private var listener: OnDisplayChanged? = null
    var display: String = ""

    private fun notifyOnDisplayChanged(){
        Log.i(TAG,"display: $display")
        listener?.onDisplayChanged(display)
    }

    fun registerListener (listener: OnDisplayChanged){
        this.listener = listener
        listener.onDisplayChanged(display)
    }

    fun unregisterListener(){
        listener = null
    }

    fun onClickSymbol (symbol: String){
        display = calculatorLogic.insertSymbol(display,symbol)
        notifyOnDisplayChanged()
    }

    fun onClickEquals(){
        val result = calculatorLogic.performOperation(display)
        display = result.toString()
        notifyOnDisplayChanged()
    }

    fun onClickClearAll(){
        display = "0"
        notifyOnDisplayChanged()
    }

    fun onClickClearOne(){
        display = calculatorLogic.deleteSymbol(display)
        notifyOnDisplayChanged()
    }


}