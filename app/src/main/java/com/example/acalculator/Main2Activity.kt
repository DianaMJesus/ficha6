package com.example.acalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val list = intent.getStringArrayListExtra(EXTRA_HISTORY)
        //list_historico_page.adapter = HistoryAdapter(this,R.layout.item_expression,list)

        button_back.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }

        list_historico_page.setOnItemClickListener{parent, view, position, id -> Toast.makeText(this, "${parent.getItemAtPosition(position)}",Toast.LENGTH_SHORT).show()}

    }
}
