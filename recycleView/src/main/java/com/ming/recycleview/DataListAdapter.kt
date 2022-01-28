package com.ming.recycleview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ming.recycleview.databinding.ItemDataBinding

/**
 * date: 2022/1/28 10:43
 * author: wangming
 * dec:
 */
class DataListAdapter(private val listener: OnItemClickListener? = null) :
    RecyclerView.Adapter<DataListAdapter.DataViewHolder>() {

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
            ItemDataBinding.inflate(
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

    inner class DataViewHolder(private val binding: ItemDataBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                listener?.onItemClick(layoutPosition, dataList[layoutPosition])
            }
        }

        fun bind(data: String?) {
            data?.apply {
                binding.tvName.text = this
                binding.root.setBackgroundResource(
                    if (layoutPosition % 2 != 0) R.color.white else R.color.grey_100
                )
            }
        }
    }
}