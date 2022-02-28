package com.vv.zeldaapp

import android.os.Bundle

class DetailsActivity : BaseActivity() {

    override val TAG = "Activity: DetailsActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
    }

}