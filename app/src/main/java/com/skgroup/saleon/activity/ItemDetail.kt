package com.skgroup.saleon.activity

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.skgroup.saleon.R
import com.skgroup.saleon.utils.CommonMethods

class ItemDetail :AppCompatActivity(){

    /*ImageView*/
    private lateinit var mImage:ImageView
    private lateinit var mBack:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_detail)
        this.runOnUiThread {
            init()
            clickListener()
        }
    }
    private fun init()
    {
        mImage=findViewById(R.id.image)
        mBack=findViewById(R.id.back)
        /*ImageLoader*/
        CommonMethods.instance().imageLoader(this, "https://culture.evo.com/wp-content/uploads/2013/06/sale-clothing.jpg", mImage)

    }
    private fun clickListener()
    {
        mBack.setOnClickListener {
            onBackPressed()
        }
    }
    override fun onBackPressed() {
        super.onBackPressed()
        CommonMethods.instance().finish(this)
    }
}