package com.aliozdemir.weatherappui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aliozdemir.weatherappui.R
import com.aliozdemir.weatherappui.databinding.ViewholderHourlyBinding
import com.aliozdemir.weatherappui.domains.Hourly
import com.bumptech.glide.Glide

class HourlyAdapter(private val items: ArrayList<Hourly>) : RecyclerView.Adapter<HourlyAdapter.ViewHolder>() {

    class ViewHolder(val binding: ViewholderHourlyBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HourlyAdapter.ViewHolder {
        return ViewHolder(ViewholderHourlyBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: HourlyAdapter.ViewHolder, position: Int) {
        holder.binding.hourText.text = items[position].hour

        //holder.binding.tempText.text = items[position].temp.toString() + "°"
        val temperatureText = holder.binding.root.context.getString(R.string.temperature_placeholder, items[position].temp)
        holder.binding.tempText.text = temperatureText

        val resourceId = getResourceIdByName(holder.binding.root.context, items[position].picPath)

        Glide.with(holder.binding.pic.context)
            .load(resourceId)
            .into(holder.binding.pic)
    }

    private fun getResourceIdByName(context: Context, name: String): Int {
        return context.resources.getIdentifier(name, "drawable", context.packageName)
    }

}