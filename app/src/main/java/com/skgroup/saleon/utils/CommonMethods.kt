package com.skgroup.saleon.utils

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.skgroup.saleon.R

object CommonMethods {
    var instance: CommonMethods? = null
    fun instance(): CommonMethods {
        if (instance == null)
            instance = CommonMethods
        return instance as CommonMethods
    }

    fun intent(activity: Activity, intentClass: Class<*>, bundle: Bundle?) {
        activity.runOnUiThread {
            activity.startActivity(Intent(activity, intentClass))
            activity.overridePendingTransition(R.anim.slide_in_left, R.anim.slide_in_right)
        }
    }

    fun finish(activity: Activity) {
        activity.runOnUiThread {
            activity.overridePendingTransition(R.anim.slide_out_left, R.anim.slide_out_right)
        }
    }

    fun imageLoader(activity: Activity, imageUrl: String, imageView: ImageView) {
        activity.runOnUiThread {
            Glide.with(activity).load(imageUrl).into(imageView)
        }
    }
}