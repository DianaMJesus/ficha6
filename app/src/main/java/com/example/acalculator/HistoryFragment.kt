package com.example.acalculator

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_history.view.*

class HistoryFragment : Fragment(), HistoryAdapter.OnNoteListener {
    private lateinit var viewModel: HistoryViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view =  inflater.inflate(R.layout.fragment_history,container,false)
        viewModel = ViewModelProviders.of(this).get(HistoryViewModel::class.java)
        view.list_historic.layoutManager = LinearLayoutManager(activity as Context)
        view.list_historic.adapter = HistoryAdapter(activity as Context, R.layout.item_expression,viewModel.historyItems,this)
        return view
    }

    override fun onNoteClick(position: Int) {
        val posicao = viewModel.historyItems.get(position)
        Toast.makeText(activity as Context,"Clicou no botão do historico e posicao $posicao", Toast.LENGTH_SHORT).show()
    }


}
