package com.skgroup.saleon.activity

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.skgroup.saleon.R

class SignUp : AppCompatActivity() {

    private var mBack: ImageView? = null
    private var mFirstname: EditText? = null
    private var mLastname: EditText? = null
    private var mEmail: EditText? = null
    private var mPhone: EditText? = null
    private var mPassword: EditText? = null
    private var mConfirmPassword: EditText? = null
    private var mSignup: Button? = null
    private var mLogin: LinearLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        this@SignUp.runOnUiThread {
            init()
            listener()
        }
    }

    fun init() {
        mBack = findViewById(R.id.back)
        mFirstname = findViewById(R.id.firstname)
        mLastname = findViewById(R.id.lastname)
        mEmail = findViewById(R.id.email)
        mPassword = findViewById(R.id.password)
        mLogin = findViewById(R.id.login)
        mSignup = findViewById(R.id.signup)
        mPhone = findViewById(R.id.mobile)
        mConfirmPassword = findViewById(R.id.confirmPassword)
    }

    fun listener() {
        mBack?.setOnClickListener { finish() }
        mSignup?.setOnClickListener { startActivity(Intent(this@SignUp, HomeScreen::class.java)) }
        mLogin?.setOnClickListener { startActivity(Intent(this@SignUp, Login::class.java)) }
    }
}