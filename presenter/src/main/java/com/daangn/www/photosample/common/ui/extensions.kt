package com.daangn.www.photosample.common.ui

import android.content.Context
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView

fun <T : RecyclerView.ViewHolder> T.listen(event: (context: Context, position: Int, itemViewType: Int) -> Unit): T {
    itemView.setOnClickListener {
        if (adapterPosition != AdapterView.INVALID_POSITION) {
            event.invoke(it.context, adapterPosition, itemViewType)
        }
    }
    return this
}