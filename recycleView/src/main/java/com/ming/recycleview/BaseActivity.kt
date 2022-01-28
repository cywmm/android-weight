package com.ming.recycleview

import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

abstract class BaseActivity : AppCompatActivity() {

    fun initToolBar(toolbar: Toolbar, title: String, isBack: Boolean? = true) {
        toolbar.title = title
        initToolBar(toolbar, isBack)
    }

    fun initToolBar(toolbar: Toolbar, isBack: Boolean? = true) {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(isBack ?: true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}