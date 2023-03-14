package com.quoctran.joblogic.presentation.ui.call

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.quoctran.joblogic.databinding.ItemCallBinding
import com.quoctran.joblogic.presentation.model.PersonUI
import com.quoctran.joblogic.presentation.model.ProductUI

/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */
class CallAdapter(
) : RecyclerView.Adapter<CallAdapter.ViewHolder>() {
    private val values: ArrayList<PersonUI> = arrayListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            ItemCallBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    @SuppressLint("NotifyDataSetChanged")
    fun updatePersonList(personList: List<PersonUI>){
        values.clear()
        values.addAll(personList)
        notifyDataSetChanged()
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.idView.text = item.id.toString()
        holder.contentView.text = item.name
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: ItemCallBinding) : RecyclerView.ViewHolder(binding.root) {
        val idView: TextView = binding.itemNumber
        val contentView: TextView = binding.content

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }

}