package com.aliozdemir.weatherappui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.aliozdemir.weatherappui.adapters.HourlyAdapter
import com.aliozdemir.weatherappui.databinding.ActivityMainBinding
import com.aliozdemir.weatherappui.domains.Hourly

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var hourlyAdapter: HourlyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerView1.layoutManager = layoutManager

        binding.nextButton.setOnClickListener{
            val intent = Intent(this, FutureActivity::class.java)
            startActivity(intent)
        }

        initRecyclerView()
    }

    private fun initRecyclerView() {
        val items: ArrayList<Hourly> = ArrayList()

        items.add(Hourly("9 pm", 18, "cloudy"))
        items.add(Hourly("10 pm", 19, "sunny"))
        items.add(Hourly("11 pm", 20, "wind"))
        items.add(Hourly("12 pm", 21, "rainy"))
        items.add(Hourly("1 pm", 22, "storm"))

        hourlyAdapter = HourlyAdapter(items)
        binding.recyclerView1.adapter = hourlyAdapter

    }
}