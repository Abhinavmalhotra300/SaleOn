package com.skgroup.saleon.activity

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.skgroup.saleon.R

class ForgetPassword : AppCompatActivity() {

    private var mBack: ImageView?=null
    private var mEmail: EditText?=null
    private var mSubmit: Button?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgetpassword)
        this@ForgetPassword.runOnUiThread {
            init()
            listeners()
        }
    }
    fun init() {
        mBack = findViewById(R.id.back)
        mEmail = findViewById(R.id.email)
        mSubmit = findViewById(R.id.submit)
    }
    fun listeners() {
        mBack?.setOnClickListener {
            finish()
        }
        mSubmit?.setOnClickListener {

        }
    }
}