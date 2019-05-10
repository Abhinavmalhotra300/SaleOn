package com.skgroup.saleon.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.github.demono.AutoScrollViewPager
import com.skgroup.saleon.R
import com.skgroup.saleon.adapter.Home_Adapter
import com.skgroup.saleon.utils.InfinitePager.InfinitePager
import kotlinx.android.synthetic.main.activity_login_signup.*

class LoginRegister : AppCompatActivity() {

    var arrayBanner: ArrayList<Int>? = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_signup)

       this@LoginRegister.runOnUiThread {
           setBanner()
           init()
       }
    }
    fun init()
    {
        /*View Pager*/
        val mViewPager = findViewById<AutoScrollViewPager>(R.id.viewPager)
        val adapter = InfinitePager(Home_Adapter(this, arrayBanner))
        mViewPager.adapter = adapter
        mViewPager.startAutoScroll()

        /*ClickListener*/
        mLogin.setOnClickListener { startActivity(Intent(this@LoginRegister,Login::class.java)) }
        mSignup.setOnClickListener { startActivity(Intent(this@LoginRegister,Login::class.java)) }
        mAsGuest.setOnClickListener { startActivity(Intent(this@LoginRegister,Login::class.java)) }
    }
    fun setBanner()
    {
        arrayBanner?.add(R.drawable.welcome)
        arrayBanner?.add(R.drawable.welcome2)
        arrayBanner?.add(R.drawable.welcome3)
    }
}
