package com.skgroup.saleon.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import com.bumptech.glide.Glide
import com.skgroup.saleon.OnItemClickListener
import com.skgroup.saleon.R
import com.skgroup.saleon.responseModel.saleItemModel

class ItemAdapter(
    var mContext: Context,
    var data: ArrayList<saleItemModel>,
    var mListener: OnItemClickListener?) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_row, parent, false))
    }
    override fun getItemCount(): Int {
        return data.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.mImage.context).load(data[position].Image).into(holder.mImage)
        holder.mClickable.setOnClickListener {
            mListener?.onItemClick(position)
        }
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mImage = itemView.findViewById<ImageView>(R.id.image)
        var mClickable = itemView.findViewById<LinearLayout>(R.id.clickable)
    }
}