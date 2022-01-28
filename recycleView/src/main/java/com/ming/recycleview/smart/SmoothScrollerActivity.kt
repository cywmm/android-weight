package com.ming.recycleview.smart

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.ming.recycleview.BaseActivity
import com.ming.recycleview.OnItemClickListener
import com.ming.recycleview.R
import com.ming.recycleview.databinding.ActivityMainBinding

/**
 * date: 2022/1/28 10:43
 * author: wangming
 * dec:
 */
class SmoothScrollerActivity : BaseActivity(), OnItemClickListener,
    SmoothScrollerLinearOffset.Callback {
    private lateinit var dataListAdapter: SmoothScrollerListAdapter
    private lateinit var binding: ActivityMainBinding

    companion object {
        @JvmStatic
        fun navigation(context: Context, title: String) {
            val intent = Intent(context, SmoothScrollerActivity::class.java)
            intent.putExtra("title", title)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intent.getStringExtra("title")?.let {
            initToolBar(binding.toolbar, it, true)
        }
        dataListAdapter = SmoothScrollerListAdapter(this)
        binding.recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.recyclerView.adapter = dataListAdapter

        initData()
    }

    private fun initData() {
        val dataList = arrayListOf<String>()
        for (i in 0..20) {
            dataList.add("点击置顶 $i")
        }
        dataListAdapter.setDataList(dataList)
    }

    override fun onItemClick(position: Int, data: String) {
        val smoothScroller = SmoothScrollerLinearOffset(this, R.dimen.offsetValue_1, this)
        smoothScroller.setScrollSpeed(1.8f)
        smoothScroller.targetPosition = position
        binding.recyclerView.layoutManager?.startSmoothScroll(smoothScroller)
    }

    override fun onSmoothScrollerStop() {
//        Toast.makeText(this, "滚动结束", Toast.LENGTH_SHORT).show()
    }
}