package com.example.schedule

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.SimpleAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.schedule.data.DataManager
import com.example.schedule.databinding.ActivityMainBinding
import com.example.schedule.databinding.ActivitySheduleListBinding

class SheduleList : AppCompatActivity() {
    lateinit var binding: ActivitySheduleListBinding
    private val adapter = DayAdapter()
    var dayList = DataManager.weekObjectFromJsonString().days
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySheduleListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }
    private fun init(){
        binding.apply {
            rcViewShedule.layoutManager = LinearLayoutManager(this@SheduleList)
            rcViewShedule.adapter = adapter
            adapter.newDaysFromWeek(dayList)
        }
    }
}