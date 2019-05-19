package com.skgroup.saleon.activity

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.skgroup.saleon.listener.OnItemClickListener
import com.skgroup.saleon.R
import com.skgroup.saleon.activity.loginsignup.SignUp
import com.skgroup.saleon.adapter.HomeItemAdapter
import com.skgroup.saleon.responseModel.saleItemModel
import com.skgroup.saleon.utils.CommonMethods

class HomeScreen : AppCompatActivity(), OnItemClickListener {

    /*ImageView*/
    private var mMenu: ImageView? = null
    /*DrawerLayout*/
    private var mDrawerLayout: DrawerLayout? = null
    /*RecyclerView*/
    private var mItemRecyclerView: RecyclerView? = null
    /*Adapter Click Listener*/
    private var mListener: OnItemClickListener?=null
    /*ArrayList*/
    private var data: ArrayList<saleItemModel> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this@HomeScreen.runOnUiThread {
            init()
            listener()
        }
    }
    private fun init() {
        mListener=this
        mMenu = findViewById(R.id.menu)
        /*DrawerLayout*/
        mDrawerLayout = findViewById(R.id.drawer_layout)

        /*RecyclerView*/
        mItemRecyclerView = findViewById(R.id.recyclerView)
        mItemRecyclerView?.layoutManager = LinearLayoutManager(this)
        mItemRecyclerView?.adapter = HomeItemAdapter(this@HomeScreen,setData(),mListener)
    }
    private fun listener() {
        mMenu?.setOnClickListener { mDrawerLayout?.openDrawer(GravityCompat.START) }
    }
    override fun onItemClick(position: Int) {
        CommonMethods.instance().intent(this, ItemList::class.java, null)
    }
    override fun onBackPressed() {
        if (mDrawerLayout!!.isDrawerOpen(GravityCompat.START))
            mDrawerLayout!!.closeDrawer(GravityCompat.START)
        else
            super.onBackPressed()

    }
   private fun setData() : ArrayList<saleItemModel> {
        data.add(saleItemModel("0","https://images-na.ssl-images-amazon.com/images/G/01/Shopbop/p/pcs/media/3/images/lp/sale/saleclothes/lb_sale_clothing_1-2.jpg"))
        data.add(saleItemModel("1","https://culture.evo.com/wp-content/uploads/2013/06/sale-clothing.jpg"))
        data.add(saleItemModel("0","https://media.apnarm.net.au/media/images/2018/03/13/store-1338629_960_720-gwr3pxppf6l0tdx5xp2_fct953x535_ct677x380.jpg"))
        data.add(saleItemModel("1","https://cdn-static.farfetch-contents.com/content/images/Home_CMS/2018_AW_SALE/VIP/ONSITE/LP/R2/WW_PRIVATE_LANDING-ALL-CLOTHING-PAGE_CATEGORIES-574x252-English.jpg"))
        data.add(saleItemModel("1","https://images-eu.ssl-images-amazon.com/images/G/31/img18/apparel/womens-apparel/ethnicwear/BIBA/new._CB484611619_.jpg"))
    return data
    }
}