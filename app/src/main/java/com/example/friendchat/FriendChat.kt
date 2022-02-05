package com.example.friendchat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.friendchat.ui.friend_chat.FriendChatFragment

class FriendChat : AppCompatActivity() {

    private lateinit var currentFriend: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.friend_chat_activity)

        currentFriend = intent.getStringExtra("PersonName").toString()

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.chat_container, FriendChatFragment.newInstance(currentFriend))
                .commitNow()
        }

        // add action bar with back button
        val actionbar = supportActionBar
        actionbar!!.title = currentFriend
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        startActivity(Intent(this, MainActivity::class.java))
        return true
    }
}