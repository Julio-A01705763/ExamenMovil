package com.example.kotlin.moviles.framework.adapters.viewholders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.moviles.R
import com.example.kotlin.moviles.data.network.model.NinjaObject

class NinjaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val textViewRecordType: TextView = itemView.findViewById(R.id.textViewRecordType)
    private val textViewValue: TextView = itemView.findViewById(R.id.textViewValue)

    fun bind(item: NinjaObject) {
        textViewRecordType.text = item.record_type
        textViewValue.text = item.value ?: "N/A"  // Display "N/A" if value is null
    }
}

