package com.example.schedule

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.gson.Gson


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var mainTextView = findViewById<TextView>(R.id.mainTextView)
        var guestButton = findViewById<Button>(R.id.guestButton)
        var registrationButton = findViewById<Button>(R.id.registrationButton)
        var registrationText  = findViewById<EditText>(R.id.registrationText)

        guestButton.setOnClickListener {
            val intentSchedule = Intent(this,SheduleList::class.java)
            startActivity(intentSchedule)
        }

    }
}