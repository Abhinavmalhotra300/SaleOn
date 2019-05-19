package com.skgroup.saleon.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.skgroup.saleon.listener.OnItemClickListener
import com.skgroup.saleon.R
import com.skgroup.saleon.responseModel.saleItemModel
import com.skgroup.saleon.utils.CommonMethods

class ItemAdapter(private var mContext: Activity) :
    RecyclerView.Adapter<ItemAdapter.ViewHolder>() {


    private var dataList: ArrayList<saleItemModel> = ArrayList()
    private var mListener: OnItemClickListener? = null


    fun setData(data: ArrayList<saleItemModel>) {
        dataList.clear()
        dataList.addAll(data)
        this.notifyDataSetChanged()
    }
    fun setListener(listener: OnItemClickListener?) {
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_row, parent, false))
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        /*ImageLoader*/
        CommonMethods.instance().imageLoader(mContext, dataList[position].Image, holder.mImage)

        holder.mClickable.setOnClickListener {
            mListener?.onItemClick(position)
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mImage: ImageView = itemView.findViewById(R.id.image)
        var mClickable: LinearLayout = itemView.findViewById(R.id.clickable)
    }
}