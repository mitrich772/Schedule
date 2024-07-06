package com.example.schedule

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.schedule.data.DataManager
import com.example.schedule.databinding.ActivitySheduleListBinding

class SсheduleList : AppCompatActivity() {
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
            rcViewShedule.layoutManager = LinearLayoutManager(this@SсheduleList)
            rcViewShedule.adapter = adapter
            adapter.newDaysFromWeek(dayList)
        }
    }
}