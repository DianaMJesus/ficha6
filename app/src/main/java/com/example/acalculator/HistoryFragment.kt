package com.example.acalculator

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_history.view.*

class HistoryFragment : Fragment(), ItemOnClickListener,OnHistoricChanged {
    private lateinit var viewModel: HistoryViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view =  inflater.inflate(R.layout.fragment_history,container,false)
        viewModel = ViewModelProviders.of(this).get(HistoryViewModel::class.java)
        view.list_historic.layoutManager = LinearLayoutManager(activity as Context)
        view.list_historic.adapter = HistoryAdapter(activity as Context, R.layout.item_expression,viewModel.historyItems,this)
        return view
    }

    override fun onStart() {
        viewModel.registerListener(this)
        super.onStart()
    }

    override fun onHistoricChanged(historic: List<Operation>) {
        historic.let { }
    }

    override fun onDestroy() {
        viewModel.unregisterListener()
        super.onDestroy()
    }

    override fun onItemClick(items: Operation, position: Int) {
        viewModel.onClick(items,position)
        Toast.makeText(activity as Context, "id: ${items.uuid}", Toast.LENGTH_SHORT).show()
    }

}
