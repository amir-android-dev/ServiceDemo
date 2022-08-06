package com.amir.servicedemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.amir.servicedemo.MyBackGroundService.Companion.NAME
import com.amir.servicedemo.MyBackGroundService.Companion.SOQRAT
import com.amir.servicedemo.MyBackGroundService.Companion.TAG
import com.amir.servicedemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val serviceIntent = Intent(this, MyBackGroundService::class.java)
        serviceIntent.putExtra(NAME,"EMA")
        serviceIntent.putExtra(SOQRAT,70)
        binding.btnStart.setOnClickListener {
            Log.i(TAG, "Starting Service.")
            startService(serviceIntent)
        }

        binding.btnStop.setOnClickListener {
            Log.i(TAG, "Stopping Service.")
            stopService(serviceIntent)
        }
    }
}

/*
In android every time we create a service, we need to add that to the manifest file.
Open a AndroidManifest.xml file, just above the ending application tag , add the service.
 */