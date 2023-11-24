package com.aliozdemir.weatherappui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.aliozdemir.weatherappui.R
import com.aliozdemir.weatherappui.adapters.FutureAdapter
import com.aliozdemir.weatherappui.adapters.HourlyAdapter
import com.aliozdemir.weatherappui.databinding.ActivityFutureBinding
import com.aliozdemir.weatherappui.databinding.ActivityMainBinding
import com.aliozdemir.weatherappui.domains.FutureDomain
import com.aliozdemir.weatherappui.domains.Hourly

class FutureActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFutureBinding
    private lateinit var futureAdapter: FutureAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFutureBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.recyclerView2.layoutManager = layoutManager

        binding.previousButton.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        initRecyclerView()
    }

    private fun initRecyclerView() {
        val items: ArrayList<FutureDomain> = ArrayList()

        items.add(FutureDomain("Wed", "windy", "Windy", 20, 11))
        items.add(FutureDomain("Thu", "storm", "Stormy", 22, 15))
        items.add(FutureDomain("Fri", "snowy", "Snowy", 15, 13))
        items.add(FutureDomain("Sat", "cloudy", "Cloudy", 19, 12))
        items.add(FutureDomain("Sun", "rain", "Rainy", 18, 14))
        items.add(FutureDomain("Mon", "wind", "Windy", 16, 10))
        items.add(FutureDomain("Tue", "rainy", "Rainy", 17, 10))

        futureAdapter = FutureAdapter(items)
        binding.recyclerView2.adapter = futureAdapter
    }
}