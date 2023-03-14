package com.quoctran.joblogic.presentation.ui.buy

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.quoctran.joblogic.R
import com.quoctran.joblogic.databinding.ItemSellBinding
import com.quoctran.joblogic.presentation.model.ProductUI


/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */
class BuyAdapter(

) : RecyclerView.Adapter<BuyAdapter.ViewHolder>() {
    private val values: ArrayList<ProductUI> = arrayListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            ItemSellBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }


    @SuppressLint("NotifyDataSetChanged")
    fun updateProductList(productList: List<ProductUI>){
        values.clear()
        values.addAll(productList)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]

        holder.tvName.text = String.format(holder.itemView.context.getString(R.string.item_buy_name), item.name)
        holder.tvPrice.text =  String.format(holder.itemView.context.getString(R.string.item_buy_price), item.price)
        holder.tvQuantity.text =  String.format(holder.itemView.context.getString(R.string.item_buy_quantity), item.quantity)
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: ItemSellBinding) : RecyclerView.ViewHolder(binding.root) {
        val tvName: TextView = binding.tvName
        val tvPrice: TextView = binding.tvPrice
        val tvQuantity: TextView = binding.tvQuantity

    }

}