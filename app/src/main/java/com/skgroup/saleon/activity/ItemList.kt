package com.skgroup.saleon.activity

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.skgroup.saleon.OnItemClickListener
import com.skgroup.saleon.R
import com.skgroup.saleon.adapter.ItemAdapter
import com.skgroup.saleon.responseModel.saleItemModel

class ItemList : AppCompatActivity() ,OnItemClickListener{


    var mRecyclerView:RecyclerView?=null
    var mBack:ImageView?=null
    var mHeader:TextView?=null

    var data: ArrayList<saleItemModel> = ArrayList()

    /*Adapter Click Listener*/
    var mListener: OnItemClickListener?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ativity_item_list)
        this@ItemList.runOnUiThread {
            init()
            listener()
        }
    }
    fun init()
    {
        mBack=findViewById(R.id.back)
        mHeader=findViewById(R.id.header)

        mRecyclerView=findViewById(R.id.recyclerView)
        mRecyclerView?.layoutManager=GridLayoutManager(this,2)
        mRecyclerView?.adapter= ItemAdapter(this@ItemList,setData(),mListener)
    }
    fun listener()
    {
        mBack?.setOnClickListener { finish() }
    }
    override fun onItemClick(position: Int) {
    }
    fun setData() : ArrayList<saleItemModel> {
        data.add(saleItemModel("0","https://images-na.ssl-images-amazon.com/images/G/01/Shopbop/p/pcs/media/3/images/lp/sale/saleclothes/lb_sale_clothing_1-2.jpg"))
        data.add(saleItemModel("1","https://culture.evo.com/wp-content/uploads/2013/06/sale-clothing.jpg"))
        data.add(saleItemModel("0","https://media.apnarm.net.au/media/images/2018/03/13/store-1338629_960_720-gwr3pxppf6l0tdx5xp2_fct953x535_ct677x380.jpg"))
        data.add(saleItemModel("1","https://cdn-static.farfetch-contents.com/content/images/Home_CMS/2018_AW_SALE/VIP/ONSITE/LP/R2/WW_PRIVATE_LANDING-ALL-CLOTHING-PAGE_CATEGORIES-574x252-English.jpg"))
        data.add(saleItemModel("1","https://images-eu.ssl-images-amazon.com/images/G/31/img18/apparel/womens-apparel/ethnicwear/BIBA/new._CB484611619_.jpg"))
        return data
    }
}