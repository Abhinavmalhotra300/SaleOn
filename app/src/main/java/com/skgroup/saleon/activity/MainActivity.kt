package com.skgroup.saleon.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.demono.AutoScrollViewPager
import com.skgroup.saleon.R
import com.skgroup.saleon.adapter.Home_Adapter
import com.skgroup.saleon.utils.InfinitePager.InfinitePager

class MainActivity : AppCompatActivity() {
    var array:ArrayList<Int>?=ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_signup)
        array?.add(R.drawable.welcome)
        array?.add(R.drawable.welcome2)
        array?.add(R.drawable.welcome3)

        val mViewPager = findViewById<AutoScrollViewPager>(R.id.viewPager)
        val adapter = InfinitePager(Home_Adapter(this,array))
        mViewPager.adapter = adapter
        mViewPager.startAutoScroll()
    }
}
