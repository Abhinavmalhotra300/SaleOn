package com.skgroup.saleon.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.skgroup.saleon.R
import com.skgroup.saleon.listener.OnFilterItemClickListener

class FilterAdapter(
    private var mContext: Activity,
    private var mFilterItemListener: OnFilterItemClickListener?)
    : RecyclerView.Adapter<FilterAdapter.ViewHolder>() {

    private var mSelectedPosition = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_list_filter_row, parent, false))
    }
    override fun getItemCount(): Int {
        return 5
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        if (mSelectedPosition == position) {
            holder.mText.setTextColor(ContextCompat.getColor(mContext, R.color.colorPrimary))
            holder.mText.setBackgroundResource(R.drawable.fill_filter_background)
        } else {
            holder.mText.setTextColor(ContextCompat.getColor(mContext, R.color.colorPrimaryDark))
            holder.mText.setBackgroundResource(R.drawable.unfill_filter_background)
        }

        holder.mClickable.setOnClickListener {
            mSelectedPosition = position
            this.notifyDataSetChanged()
            mFilterItemListener?.onFliterItemClick("$position")
        }
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mClickable: LinearLayout = itemView.findViewById(R.id.clickable)
        var mText: TextView = itemView.findViewById(R.id.text)
    }
}