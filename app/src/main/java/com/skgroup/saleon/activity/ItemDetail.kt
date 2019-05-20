package com.skgroup.saleon.activity

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.skgroup.saleon.R
import com.skgroup.saleon.utils.CommonMethods

class ItemDetail : AppCompatActivity() {

    /*ImageView*/
    private lateinit var mImage: ImageView
    private lateinit var mBack: ImageView

    /*Button*/
    private lateinit var mSelect: TextView

    /*String*/
    var id="hello"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_detail)
        this.runOnUiThread {
            init()
            clickListener()
        }
    }

    private fun init() {
        val bundle: Bundle = intent.extras!!
        id = bundle.getString("id","")


        mImage = findViewById(R.id.image)
        mBack = findViewById(R.id.back)
        mSelect=findViewById(R.id.select)
        /*ImageLoader*/
        CommonMethods.instance()
            .imageLoader(this, "https://culture.evo.com/wp-content/uploads/2013/06/sale-clothing.jpg", mImage)

    }

    private fun clickListener() {
        mBack.setOnClickListener {
            onBackPressed()
        }
        mSelect.setOnClickListener {
            val intent=Intent()
            intent.putExtra("id",id)
            setResult(RESULT_OK,intent)
            finish()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        CommonMethods.instance().finish(this)
    }
}