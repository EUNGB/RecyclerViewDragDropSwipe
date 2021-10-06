package com.meltingb.recyclerviewtouchhelper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val recyclerView2 = findViewById<RecyclerView>(R.id.recyclerView_grid)
        val list = mutableListOf("1", "2", "3", "4", "5", "6", "7")

        // LinearLayout RecyclerView
        val adapter = LinearListViewAdapter(list)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val callback = ItemTouchHelperCallback(adapter)
        val touchHelper = ItemTouchHelper(callback)
        touchHelper.attachToRecyclerView(recyclerView)
        recyclerView.adapter = adapter
        adapter.startDrag(object : LinearListViewAdapter.OnStartDragListener {
            override fun onStartDrag(viewHolder: RecyclerView.ViewHolder) {
                touchHelper.startDrag(viewHolder)
            }
        })


        // GridLayout RecyclerView
        val adapter2 = GridListViewAdapter(list)
        recyclerView2.layoutManager = GridLayoutManager(this, 4)
        val callback2 = ItemTouchHelperCallback(adapter)
        val touchHelper2 = ItemTouchHelper(callback2)
        touchHelper2.attachToRecyclerView(recyclerView2)
        recyclerView2.adapter = adapter
        adapter2.startDrag(object : GridListViewAdapter.OnStartDragListener {
            override fun onStartDrag(viewHolder: RecyclerView.ViewHolder) {
                touchHelper2.startDrag(viewHolder)
            }
        })

    }
}