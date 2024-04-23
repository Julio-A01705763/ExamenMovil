package com.example.kotlin.moviles.framework.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.moviles.R
import com.example.kotlin.moviles.framework.adapters.viewholders.NinjaViewHolder
import com.example.kotlin.moviles.data.network.model.NinjaObject

class NinjaAdapter(private var items: List<NinjaObject>) : RecyclerView.Adapter<NinjaViewHolder>() {

    fun updateData(newItems: List<NinjaObject>) {
        items = newItems
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NinjaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_ninja, parent, false)
        return NinjaViewHolder(view)
    }

    override fun onBindViewHolder(holder: NinjaViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size
}
