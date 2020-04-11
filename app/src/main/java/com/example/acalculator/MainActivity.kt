package com.example.acalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.fragment_calculator.*

class MainActivity : AppCompatActivity() {

    private val TAG = MainActivity::class.java.simpleName
    private val VISOR_KEY = "visor"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG,"o método onCreate foi invocado")
        setContentView(R.layout.activity_main)
        NavigationManager.goToCalculatorFragment(supportFragmentManager)
        //list_historic.adapter = HistoryAdapter(this, R.layout.item_expression, list_historico)
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


}
