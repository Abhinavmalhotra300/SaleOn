package com.skgroup.saleon.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import com.skgroup.saleon.listener.OnItemClickListener
import com.skgroup.saleon.R
import com.skgroup.saleon.responseModel.SaleItemModel
import com.skgroup.saleon.utils.CommonMethods
import com.skgroup.saleon.utils.DialogMethods

class HomeItemAdapter(
    private var mContext: Activity,
    private var data: ArrayList<SaleItemModel>,
    private var mListener: OnItemClickListener?
) : RecyclerView.Adapter<HomeItemAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_home_row, parent, false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        /*ImageLoader*/
        CommonMethods.instance().imageLoader(mContext, data[position].Image, holder.mImage)


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
                DialogMethods.instance().dialogWaitForSometime(mContext)
            else
                mListener?.onItemClick(position)
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mImage: ImageView = itemView.findViewById(R.id.image)
        var mClockAnim:LottieAnimationView = itemView.findViewById(R.id.animation)
        var mTime :TextView = itemView.findViewById(R.id.time)
        var mSaleTill :TextView = itemView.findViewById(R.id.saleTill)
        var mClickable :LinearLayout = itemView.findViewById(R.id.clickable)
    }
}