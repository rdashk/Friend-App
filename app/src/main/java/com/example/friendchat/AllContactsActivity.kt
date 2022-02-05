package com.example.friendchat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.friendchat.databinding.ActivityAllContactsBinding
import com.example.friendchat.ui.all_contacts.AllContactsAdapter
import com.example.friendchat.ui.all_contacts.AllContactsFragment
import com.example.friendchat.ui.all_contacts.AllContactsViewModel
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.friendchat.ui.friend_chat.FriendChatFragment


class AllContactsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAllContactsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_contacts)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.all_contacts_container, AllContactsFragment.newInstance())
                .commitNow()
        }

        // add action bar with back button
        val actionbar = supportActionBar
        actionbar!!.title = "All contacts"
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}