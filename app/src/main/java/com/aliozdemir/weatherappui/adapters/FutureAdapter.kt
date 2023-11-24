package com.aliozdemir.weatherappui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aliozdemir.weatherappui.R
import com.aliozdemir.weatherappui.databinding.ViewholderFutureBinding
import com.bumptech.glide.Glide
import com.aliozdemir.weatherappui.domains.FutureDomain

class FutureAdapter (private val items: ArrayList<FutureDomain>) : RecyclerView.Adapter<FutureAdapter.ViewHolder>(){

    class ViewHolder (val binding: ViewholderFutureBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ViewholderFutureBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.dayText.text = items[position].day
        holder.binding.statusText.text = items[position].status

        val temperatureHighText = holder.binding.root.context.getString(R.string.temperature_placeholder, items[position].highTemp)
        holder.binding.highText.text = temperatureHighText

        val temperatureLowText = holder.binding.root.context.getString(R.string.temperature_placeholder, items[position].lowTemp)
        holder.binding.lowText.text = temperatureLowText

        val resourceId = getResourceIdByName(holder.binding.root.context, items[position].picPath)

        Glide.with(holder.binding.picture.context)
            .load(resourceId)
            .into(holder.binding.picture)
    }

    private fun getResourceIdByName(context: Context, name: String): Int {
        return context.resources.getIdentifier(name, "drawable", context.packageName)
    }

}