package com.akvelon.todolist.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.akvelon.todolist.R
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCenter.start(
            application,
            "d2a067b2-967b-4f2c-9c17-bf199d84fa06",
            Analytics::class.java,
            Crashes::class.java
        )
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        bottomNavigation.setupWithNavController(findNavController(R.id.nav_host_fragment))
    }
}