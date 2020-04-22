package com.example.acalculator

import android.content.Context
import android.graphics.Path
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import butterknife.ButterKnife
import kotlinx.android.synthetic.main.fragment_calculator.*
import kotlinx.android.synthetic.main.fragment_history.view.*

class HistoryFragment : Fragment() {
    var operations = arrayListOf<Operation>(Operation("2+2",4.0))

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view =  inflater.inflate(R.layout.fragment_history,container,false)
        view.list_historic.layoutManager = LinearLayoutManager(activity as Context)
        view.list_historic.adapter = HistoryAdapter(activity as Context, R.layout.item_expression,operations)
        return view
    }

}
