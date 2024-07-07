package com.example.schedule

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {

    var pref : SharedPreferences? = null
    var group : String = "Без группы"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        pref = getSharedPreferences("DATA", Context.MODE_PRIVATE)
        group = pref?.getString("group","Не найдена группа")!!
        val mainTextView = findViewById<TextView>(R.id.mainTextView)
        val guestButton = findViewById<Button>(R.id.guestButton)
        val registrationButton = findViewById<Button>(R.id.registrationButton)
        val registrationText  = findViewById<EditText>(R.id.registrationText)

        mainTextView.text = when(group.isEmpty()){true-> "Без группы" ;false-> group}


        registrationButton.setOnClickListener {
            var gettedText = registrationText.text.toString()
            group = gettedText
            mainTextView.text = gettedText
            saveData(group) // тут работает
        }
        guestButton.setOnClickListener {
            val intentSchedule = Intent(this,SсheduleList::class.java)
            startActivity(intentSchedule)
        }

    }
    fun saveData(dataToSave : String){
        val editor = pref?.edit()
        editor?.putString("group",dataToSave)
        editor?.apply()
    }

    override fun onDestroy() {
        saveData(group) // не работает
        super.onDestroy()
    }
}