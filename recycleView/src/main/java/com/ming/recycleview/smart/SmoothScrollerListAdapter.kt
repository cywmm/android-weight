package com.ming.recycleview.smart

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ming.recycleview.OnItemClickListener
import com.ming.recycleview.R
import com.ming.recycleview.databinding.ItemSmartScrollDataBinding

/**
 * date: 2022/1/28 10:43
 * author: wangming
 * dec:
 */
class SmoothScrollerListAdapter(private val listener: OnItemClickListener? = null) :
    RecyclerView.Adapter<SmoothScrollerListAdapter.DataViewHolder>() {

    private val dataList = arrayListOf<String>()

    fun setDataList(dataList: ArrayList<String>) {
        if (!dataList.isNullOrEmpty()) {
            this.dataList.clear()
            this.dataList.addAll(dataList)
            notifyItemRangeChanged(0, this.dataList.size - 1)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        return DataViewHolder(
            ItemSmartScrollDataBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    inner class DataViewHolder(private val binding: ItemSmartScrollDataBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.item.setOnClickListener {
                listener?.onItemClick(layoutPosition, dataList[layoutPosition])
            }
        }

        fun bind(data: String?) {
            data?.apply {
                binding.tvName.text = this
                binding.tvName.setTextColor(if (layoutPosition % 2 == 0) Color.BLACK else Color.WHITE)
                binding.root.setBackgroundResource(
                    if (layoutPosition % 2 == 0) R.color.bg_item_click else R.color.bg_item_click2
                )
            }
        }
    }
}