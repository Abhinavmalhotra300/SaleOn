package com.skgroup.saleon.activity.loginsignup

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.skgroup.saleon.R
import com.skgroup.saleon.activity.HomeScreen
import com.skgroup.saleon.utils.CommonMethods

class SignUp : AppCompatActivity() {

    /*ImageView*/
    private var mBack: ImageView? = null
    /*EditText*/
    private var mFirstName: EditText? = null
    private var mLastName: EditText? = null
    private var mEmail: EditText? = null
    private var mPhone: EditText? = null
    private var mPassword: EditText? = null
    private var mConfirmPassword: EditText? = null
    /*Button*/
    private var mSignUp: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        this.runOnUiThread {
            init()
            listener()
        }
    }

    private fun init() {
        mBack = findViewById(R.id.back)
        mFirstName = findViewById(R.id.firstname)
        mLastName = findViewById(R.id.lastname)
        mEmail = findViewById(R.id.email)
        mPassword = findViewById(R.id.password)
        mSignUp = findViewById(R.id.signup)
        mPhone = findViewById(R.id.mobile)
        mConfirmPassword = findViewById(R.id.confirmPassword)
    }

    private fun listener() {
        mBack?.setOnClickListener {
            onBackPressed()
        }
        mSignUp?.setOnClickListener {
            CommonMethods.instance().intent(this, HomeScreen::class.java, null)
            finishAffinity()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        CommonMethods.instance().finish(this)
    }
}