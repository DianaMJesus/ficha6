package com.example.acalculator

import android.content.ContentValues.TAG
import android.content.Context
import android.graphics.Path
import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import butterknife.ButterKnife
import butterknife.OnClick
import butterknife.Optional
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_calculator.*
import kotlinx.android.synthetic.main.fragment_history.view.*

class HistoryFragment : Fragment() {
    private lateinit var viewModel: HistoryViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view =  inflater.inflate(R.layout.fragment_history,container,false)
        viewModel = ViewModelProviders.of(this).get(HistoryViewModel::class.java)
        view.list_historic.layoutManager = LinearLayoutManager(activity as Context)
        view.list_historic.adapter = HistoryAdapter(activity as Context, R.layout.item_expression,viewModel.historyItems)
        return view
    }


}
