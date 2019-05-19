package com.skgroup.saleon.activity.loginsignup

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.skgroup.saleon.R
import com.skgroup.saleon.activity.HomeScreen
import com.skgroup.saleon.utils.CommonMethods

class Login : AppCompatActivity() {

    /*ImageView*/
    private var mBack: ImageView?=null
    /*EditText*/
    private var mEmail: EditText?=null
    private var mPassword: EditText?=null
    /*Button*/
    private var mLogin: Button?=null
    /*TextView*/
    private var mForgetPassword: TextView?=null
    /*LinearLayout*/
    private var mSignUp: LinearLayout?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        this@Login.runOnUiThread {
            init()
            listeners()
        }
    }
    private fun init() {
        mBack = findViewById(R.id.back)
        mEmail = findViewById(R.id.email)
        mPassword = findViewById(R.id.password)
        mLogin = findViewById(R.id.login)
        mSignUp = findViewById(R.id.signup)
        mForgetPassword = findViewById(R.id.forgetpassword)
    }
    private fun listeners() {
        mBack?.setOnClickListener {
            onBackPressed()
        }
        mLogin?.setOnClickListener {
            CommonMethods.instance().intent(this, HomeScreen::class.java, null)
            finishAffinity()
        }
        mSignUp?.setOnClickListener {
            CommonMethods.instance().intent(this, SignUp::class.java, null)
            finish()
        }
        mForgetPassword?.setOnClickListener {
            CommonMethods.instance().intent(this, ForgetPassword::class.java, null)
            finish()
        }
    }
    override fun onBackPressed() {
        super.onBackPressed()
        CommonMethods.instance().finish(this)
    }
}