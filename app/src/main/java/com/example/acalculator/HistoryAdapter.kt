package com.example.acalculator

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_expression.view.*


class HistoryAdapter(private val context: Context, private val layout: Int, private val items: List<Operation>, private val mOnNoteListener: OnNoteListener) : RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>(){

    class HistoryViewHolder(view: View, onNoteListener: OnNoteListener) : RecyclerView.ViewHolder(view),View.OnClickListener {
        val expression: TextView = view.text_expression
        val result: TextView = view.text_result
        val onNoteListene: OnNoteListener = onNoteListener

        override fun onClick(view: View?) {
            onNoteListene.onNoteClick(adapterPosition)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        return HistoryViewHolder(LayoutInflater.from(context).inflate(layout,parent,false),mOnNoteListener)
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.expression.text = items[position].expression
        holder.result.text = items[position].result.toString()
    }

    override fun getItemCount() = items.size

    interface OnNoteListener{
        fun onNoteClick(position: Int)
    }

}