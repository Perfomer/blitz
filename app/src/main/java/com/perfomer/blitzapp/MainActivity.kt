package com.perfomer.blitzapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.perfomer.blitz.setTimeAgo
import com.perfomer.blitzapp.data.DATES
import com.perfomer.blitzapp.recycler.MainAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val startTime = System.currentTimeMillis()
    private val adapter = MainAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        blitz_maintext.setTimeAgo(startTime, showSeconds = true)

        blitz_recycler.layoutManager = LinearLayoutManager(this)
        blitz_recycler.adapter = adapter

        adapter.items = DATES
    }

}