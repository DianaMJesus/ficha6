package com.example.acalculator

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_history.view.*

class HistoryFragment : Fragment() {
    val operations = arrayListOf(Operation("2+3",5.0))

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view =  inflater.inflate(R.layout.fragment_history,container,false)
        view.list_historic.layoutManager = LinearLayoutManager(activity as Context)
        view.list_historic.adapter = HistoryAdapter(activity as Context, R.layout.item_expression,operations)
        return view
    }
}
