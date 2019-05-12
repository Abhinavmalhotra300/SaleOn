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

class HomeItemAdapter(
    var mContext: Context,
    var data: ArrayList<saleItemModel>,
    var mListener: OnItemClickListener?
) : RecyclerView.Adapter<HomeItemAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_home_row, parent, false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.mImage.context).load(data[position].Image).into(holder.mImage)
        if (data[position].saleType == "0") {
            holder.mClockAnim.visibility = View.VISIBLE
            holder.mTime.visibility = View.VISIBLE
            holder.mSaleTill.visibility = View.GONE
            /*holder.mAlphaview.visibility = View.VISIBLE*/
        } else {
            holder.mClockAnim.visibility = View.GONE
            holder.mTime.visibility = View.GONE
            holder.mSaleTill.visibility = View.VISIBLE
            /*holder.mAlphaview.visibility = View.GONE*/
        }
        holder.mClickable.setOnClickListener {
            if (data[position].saleType == "0")
                Toast.makeText(mContext, "Wait For SomeTime", Toast.LENGTH_LONG).show()
            else
                mListener?.onItemClick(position)
        }
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mImage = itemView.findViewById<ImageView>(R.id.image)
        var mClockAnim = itemView.findViewById<LottieAnimationView>(R.id.animation)
        var mTime = itemView.findViewById<TextView>(R.id.time)
        var mSaleTill = itemView.findViewById<TextView>(R.id.saleTill)
        var mClickable = itemView.findViewById<LinearLayout>(R.id.clickable)


    }
}