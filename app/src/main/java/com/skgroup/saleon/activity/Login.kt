package com.skgroup.saleon.activity

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.skgroup.saleon.R

class Login : AppCompatActivity() {

    private var mBack: ImageView?=null
    private var mEmail: EditText?=null
    private var mPassword: EditText?=null
    private var mLogin: Button?=null
    private var mSignUp: LinearLayout?=null
    private var mForgetPassword: TextView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        this@Login.runOnUiThread {
            init()
            listeners()
        }
    }
    fun init() {
        mBack = findViewById(R.id.back)
        mEmail = findViewById(R.id.email)
        mPassword = findViewById(R.id.password)
        mLogin = findViewById(R.id.login)
        mSignUp = findViewById(R.id.signup)
        mForgetPassword = findViewById(R.id.forgetpassword)

    }
    fun listeners() {
        mBack?.setOnClickListener {
            finish()
        }
        mLogin?.setOnClickListener {
            startActivity(Intent(this@Login, HomeScreen::class.java))
            finishAffinity()
        }
        mSignUp?.setOnClickListener {
            startActivity(Intent(this@Login, SignUp::class.java))
            finish()
        }
        mForgetPassword?.setOnClickListener {
            startActivity(Intent(this@Login, ForgetPassword::class.java))
            finish()
        }
    }
}