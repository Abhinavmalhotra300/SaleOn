package com.skgroup.saleon.utils

import android.app.Activity
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.skgroup.saleon.R
import com.skgroup.saleon.adapter.FilterAdapter
import com.skgroup.saleon.listener.OnFilterItemClickListener
import com.skgroup.saleon.listener.OnFilterItemSelectListener

object DialogMethods {
    var instance: DialogMethods? = null

    fun instance(): DialogMethods {
        if (instance == null)
            instance = DialogMethods
        return instance as DialogMethods
    }

    fun dialogFilter(activity: Activity, mFilterItemSelectListener: OnFilterItemSelectListener?) {
        var mType = "All"
        val dialog = BottomSheetDialog(activity)
        dialog.setContentView(R.layout.dialog_filter)
        val mDone = dialog.findViewById<Button>(R.id.done)

        val mRecyclerViewFilter = dialog.findViewById<RecyclerView>(R.id.recyclerViewFilter)
        mRecyclerViewFilter?.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        mRecyclerViewFilter?.adapter = FilterAdapter(activity, object : OnFilterItemClickListener {
            override fun onFliterItemClick(type: String) {
                mType = type
            }
        })
        mDone?.setOnClickListener {
            mFilterItemSelectListener?.onFilterItemSelectListener(mType)
            dialog.dismiss()
        }
        dialog.show()
    }

    fun dialogWaitForSometime(activity: Activity) {
        Toast.makeText(activity, "Wait For SomeTime", Toast.LENGTH_LONG).show()
    }
}