package com.skgroup.saleon.activity

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.skgroup.saleon.R
import com.skgroup.saleon.activity.loginsignup.LoginRegister
import com.skgroup.saleon.utils.CommonMethods

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed({
            CommonMethods.instance().intent(this, LoginRegister::class.java, null)
            finish()
        }, 1500)
    }
}