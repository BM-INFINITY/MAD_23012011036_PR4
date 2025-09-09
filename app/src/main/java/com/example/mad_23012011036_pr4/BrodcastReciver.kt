package com.example.mad_23012011036_pr4

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class BrodcastReciver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val str1= intent.getStringExtra("Service1")
        if (str1== "Start" || str1=="Stop"){
            val intentService =Intent(context,alarmservice::class.java)
            if (str1== "Start"){
                context.startService(intentService)

            }
if (str1=="Stop"){
    context.stopService(intentService)
}
        }
    }
}