package com.skgroup.saleon.utils

import android.app.Activity
import android.app.Dialog
import android.graphics.Point
import android.view.Display
import android.view.Window
import android.widget.Button
import android.widget.LinearLayout
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
            override fun onFilterItemClick(type: String) {
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

        val dialog = Dialog(activity)
        dialog.window?.requestFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.dialog_message)
        val mLayout = dialog.findViewById<LinearLayout>(R.id.lay)
        mLayout.layoutParams.width = getWidth(activity)
        val mCancel = dialog.findViewById<Button>(R.id.cancel)
        mCancel.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }

    private fun getWidth(activity: Activity): Int {
        val display: Display = activity.windowManager.defaultDisplay
        val point = Point()
        display.getSize(point)
        return (point.x * 0.8).toInt()
    }
}