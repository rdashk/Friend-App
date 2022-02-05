package com.example.friendchat

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.forEach
import androidx.core.view.size
import androidx.fragment.app.findFragment
import com.example.friendchat.databinding.ActivityMainBinding
import com.example.friendchat.ui.MAIN

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.appBarMain.toolbar)

        // add new contact
        binding.appBarMain.addNewChat.setOnClickListener {
            startActivity(Intent(this, AllContactsActivity::class.java))
        }

        MAIN = this

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)

        // Hiding the add chat button
        binding.navView.menu.forEach { it ->
            it.setOnMenuItemClickListener {
                when(it.itemId) {
                    R.id.nav_info -> binding.appBarMain.addNewChat.hide()
                    R.id.nav_profile -> binding.appBarMain.addNewChat.hide()
                    R.id.nav_chats -> binding.appBarMain.addNewChat.show()
                }
                super.onOptionsItemSelected(it)
            }
        }

        appBarConfiguration = AppBarConfiguration(setOf(
                R.id.nav_profile, R.id.nav_chats, R.id.nav_info), drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.action_settings -> {
                val intent = Intent(this, SettingsActivity::class.java)
                startActivity(intent)
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}