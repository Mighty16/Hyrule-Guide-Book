package com.vv.zeldaapp

import android.content.Intent
import android.os.Bundle
import com.vv.zeldaapp.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {

    override val TAG = "Activity: MainActivity"

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.openDetailsButton.setOnClickListener {
            val intent  = Intent(this,DetailsActivity::class.java)
            startActivity(intent)
        }
    }

}