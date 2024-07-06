package com.example.schedule.data

data class Week(var number : Int,var days: List<Day>) {
    fun getDayByNumber(dayNumber: Int): Day {
        return days[dayNumber]
    }
}