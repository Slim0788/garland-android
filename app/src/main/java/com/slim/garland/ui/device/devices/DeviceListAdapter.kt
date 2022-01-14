package com.slim.garland.ui.device.devices

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.slim.garland.databinding.FragmentDeviceListItemBinding

class DeviceListAdapter : RecyclerView.Adapter<DeviceListAdapter.ViewHolder>() {

    private val items = mutableListOf<DeviceEntity>()

    private var onItemClickListener: ((item: DeviceEntity) -> Unit)? = null

    fun setOnItemClickListener(listener: (item: DeviceEntity) -> Unit) {
        onItemClickListener = listener
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(items: List<DeviceEntity>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            FragmentDeviceListItemBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
        ).apply {
            itemView.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    onItemClickListener?.invoke(items[adapterPosition])
                }
            }
        }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount() = items.size

    inner class ViewHolder(
        private val binding: FragmentDeviceListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            val item = items[adapterPosition]
            binding.apply {
                textName.text = item.name
            }
        }
    }
}
