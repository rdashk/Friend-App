package com.example.friendchat

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings_activity)

        // add action bar with back button
        val actionBar = supportActionBar
        actionBar!!.title = "Settings"
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayHomeAsUpEnabled(true)

        // TODO: add different settings
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}