package com.skgroup.saleon.activity

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.skgroup.saleon.listener.OnItemClickListener
import com.skgroup.saleon.R
import com.skgroup.saleon.adapter.ItemAdapter
import com.skgroup.saleon.listener.OnFilterItemSelectListener
import com.skgroup.saleon.responseModel.saleItemModel
import com.skgroup.saleon.utils.CommonMethods
import com.skgroup.saleon.utils.DialogMethods

class ItemList : AppCompatActivity(), OnItemClickListener, OnFilterItemSelectListener {

    /*RecyclerView*/
    private var mRecyclerView: RecyclerView? = null
    /*ImageView*/
    private var mBack: ImageView? = null
    private var mFilter: ImageView? = null
    /*TextView*/
    private var mHeader: TextView? = null
    /*ArrayList*/
    private var data: ArrayList<saleItemModel> = ArrayList()
    /*Adapter Click Listener*/
    private var mListener: OnItemClickListener? = null
    private var mFilterItemSelectListener: OnFilterItemSelectListener? = null
    /*Adapter*/
    private var mAdapter: ItemAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ativity_item_list)
        this@ItemList.runOnUiThread {
            init()
            listener()
        }
    }

    private fun init() {

        /*Listener*/
        mListener = this
        mFilterItemSelectListener = this

        mBack = findViewById(R.id.back)
        mHeader = findViewById(R.id.header)
        mFilter = findViewById(R.id.filter)

        /*Adapter*/
        mAdapter = ItemAdapter(this@ItemList)
        mAdapter?.setListener(mListener)

        /*RecyclerView*/
        mRecyclerView = findViewById(R.id.recyclerView)
        mRecyclerView?.isNestedScrollingEnabled = false
        mRecyclerView?.layoutManager = GridLayoutManager(this, 2)
        mRecyclerView?.adapter = mAdapter
        mAdapter?.setData(setData())

    }

    private fun listener() {
        mBack?.setOnClickListener { onBackPressed() }
        mFilter?.setOnClickListener {
            DialogMethods.instance().dialogFilter(this, mFilterItemSelectListener)
        }
    }

    /*item click listener*/
    override fun onItemClick(position: Int) {
        Toast.makeText(this, "$position", Toast.LENGTH_LONG).show()
    }

    /*Item Selected*/
    override fun onFilterItemSelectListener(type: String) {
        Toast.makeText(this, type, Toast.LENGTH_LONG).show()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        CommonMethods.instance().finish(this)
    }

    private fun setData(): ArrayList<saleItemModel> {
        data.add(
            saleItemModel(
                "0",
                "https://images-na.ssl-images-amazon.com/images/G/01/Shopbop/p/pcs/media/3/images/lp/sale/saleclothes/lb_sale_clothing_1-2.jpg"
            )
        )
        data.add(saleItemModel("1", "https://culture.evo.com/wp-content/uploads/2013/06/sale-clothing.jpg"))
        data.add(
            saleItemModel(
                "0",
                "https://media.apnarm.net.au/media/images/2018/03/13/store-1338629_960_720-gwr3pxppf6l0tdx5xp2_fct953x535_ct677x380.jpg"
            )
        )
        data.add(
            saleItemModel(
                "1",
                "https://cdn-static.farfetch-contents.com/content/images/Home_CMS/2018_AW_SALE/VIP/ONSITE/LP/R2/WW_PRIVATE_LANDING-ALL-CLOTHING-PAGE_CATEGORIES-574x252-English.jpg"
            )
        )
        data.add(
            saleItemModel(
                "1",
                "https://images-eu.ssl-images-amazon.com/images/G/31/img18/apparel/womens-apparel/ethnicwear/BIBA/new._CB484611619_.jpg"
            )
        )
        return data
    }
}