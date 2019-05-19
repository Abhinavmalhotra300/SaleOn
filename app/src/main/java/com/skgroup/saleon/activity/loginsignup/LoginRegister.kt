package com.skgroup.saleon.activity.loginsignup

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.skgroup.saleon.R
import com.skgroup.saleon.activity.HomeScreen
import com.skgroup.saleon.utils.CommonMethods
import kotlinx.android.synthetic.main.activity_login_signup.*

class LoginRegister : AppCompatActivity() {

    /*ImageView*/
    private lateinit var mBannerImage: ImageView
    /*ArrayList*/
    private var arrayBanner: ArrayList<Int>? = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_signup)
        this@LoginRegister.runOnUiThread {
            setBanner()
            init()
        }
    }

    private fun init() {
        /*ImageView*/
        mBannerImage = findViewById(R.id.bannerImage)

        /* val mViewPager = findViewById<AutoScrollViewPager>(R.id.viewPager)
         val adapter = InfinitePager(Slider_Adapter(this, arrayBanner))
         mViewPager.adapter = adapter
         mViewPager.startAutoScroll()*/

        /*ClickListener*/
        mLogin.setOnClickListener {
            CommonMethods.instance().intent(this@LoginRegister,Login::class.java,null)
        }
        mSignup.setOnClickListener {
            CommonMethods.instance().intent(this@LoginRegister,SignUp::class.java,null)
        }
        mAsGuest.setOnClickListener {
            CommonMethods.instance().intent(this@LoginRegister,HomeScreen::class.java,null)
            finishAffinity()
        }
    }
    private fun setBanner() {
        arrayBanner?.add(R.drawable.welcome)
        arrayBanner?.add(R.drawable.welcome2)
        arrayBanner?.add(R.drawable.welcome3)
    }
}