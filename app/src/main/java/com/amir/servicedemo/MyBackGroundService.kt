package com.amir.servicedemo

import android.app.Service
import android.content.ComponentName
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyBackGroundService : Service() {

    //every time we create service we must implement onBind function
    //for this example we are not going to use it thats why the return value null is
    //You know, in kotlin language, when there is only one return
    //statement in a function body, we can write the function body using the equal sign, without curly braces.
//    override fun onBind(intent: Intent?): IBinder? {
//        return null
//    }
    override fun onBind(intent: Intent?): IBinder? = null

    init {
        Log.i(TAG, "Service has been created.")
    }

    //to start that service, we need to invoke its startService() function.
    // We will do that inside the start button’s click listener of the MainActivity.

    //onStartCommand() function of the Service , is called every time a client starts the service invoking the startService function.
    //we should write codes, to do the things that are needed each time a client requests something from  the service.
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.i(TAG, "Service started.")
        val name = intent?.getStringExtra(NAME)
        //for this function we need to add a default value
        val soqrat = intent?.getIntExtra(SOQRAT,0)
        Log.i(TAG, "MY NAME is $name and I am $SOQRAT years old.")
        //here we need to change the default return value.
        //This return value, will be used by android system, to decide, how the system restarts the service after being  destroyed by it.
        //START_REDELIVER_INTENT, system will pass the last intent to the service when restarting.
        // If we choose START STICKY system will not pass the last intent when restarting.
        //If we choose START NOT STICKY system will not restart the service
        return START_STICKY
    }

    override fun onDestroy() {
        Log.i(TAG, "Destroying.....")
        super.onDestroy()
    }
companion object{
    const val TAG ="MYTAG"
    const val NAME= "NAME"
    const val SOQRAT="SOQRAT"
}
}
