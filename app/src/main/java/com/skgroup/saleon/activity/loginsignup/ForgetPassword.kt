package com.skgroup.saleon.activity.loginsignup

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.skgroup.saleon.R
import com.skgroup.saleon.utils.CommonMethods

class ForgetPassword : AppCompatActivity() {

    /*ImageView*/
    private var mBack: ImageView? = null
    /*EditText*/
    private var mEmail: EditText? = null
    /*Button*/
    private var mSubmit: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgetpassword)
        this@ForgetPassword.runOnUiThread {
            init()
            listeners()
        }
    }
    private fun init() {
        mBack = findViewById(R.id.back)
        mEmail = findViewById(R.id.email)
        mSubmit = findViewById(R.id.submit)
    }
    private fun listeners() {
        mBack?.setOnClickListener {
            onBackPressed()
        }
        mSubmit?.setOnClickListener {

        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        CommonMethods.instance().finish(this)
    }
}