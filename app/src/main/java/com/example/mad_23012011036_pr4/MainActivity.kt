package com.example.mad_23012011036_pr4

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textCurrentTime: TextView = findViewById(R.id.textCurrentTime)

        // Show current time
        val sdf = SimpleDateFormat("hh:mm:ss a MMM,d yyyy", Locale.getDefault())
        val currentTime = sdf.format(Date())
        textCurrentTime.text = currentTime

        // Button click to open time picker
        findViewById<Button>(R.id.btnPickTime).setOnClickListener {
            showTimePicker()
        }
    }

    private fun showTimePicker() {
        val picker = MaterialTimePicker.Builder()
            .setTimeFormat(TimeFormat.CLOCK_12H) // or TimeFormat.CLOCK_24H
            .setHour(11)
            .setMinute(46)
            .setTitleText("Select Time")
            .build()

        picker.show(supportFragmentManager, "TIME_PICKER")

        picker.addOnPositiveButtonClickListener {
            val selectedHour = picker.hour
            val selectedMinute = picker.minute

            // Example: update the TextView with the selected time
            val selectedTime = String.format("%02d:%02d", selectedHour, selectedMinute)
            findViewById<TextView>(R.id.textCurrentTime).text = "Selected: $selectedTime"
        }
    }
}

