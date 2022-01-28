package com.ming.recycleview

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.ming.recycleview.databinding.ActivityMainBinding
import com.ming.recycleview.smart.SmoothScrollerActivity

/**
 * date: 2022/1/28 10:43
 * author: wangming
 * dec:
 */
class MainActivity : BaseActivity(), OnItemClickListener {
    private lateinit var dataListAdapter: DataListAdapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initToolBar(binding.toolbar, false)
        dataListAdapter = DataListAdapter(this)
        binding.recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.recyclerView.adapter = dataListAdapter


        val dataList =
            arrayListOf("SmartScrollToPosition", "StickyGroupTitle...", "ExpandableList...")
        dataListAdapter.setDataList(dataList)
    }

    override fun onItemClick(position: Int, data: String) {
        SmoothScrollerActivity.navigation(this, data)
    }
}