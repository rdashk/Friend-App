package com.example.friendchat.ui.all_contacts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.friendchat.ui.DB.Friend
import com.example.friendchat.ui.DB.FriendsData

class AllContactsViewModel : ViewModel() {

    private val _allContacts = MutableLiveData<List<Friend>>().apply {
        value = FriendsData.getAllContacts()
    }

    val allContacts: LiveData<List<Friend>> = _allContacts
}