package com.example.friendchat.ui.chats

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.friendchat.ui.DB.Friend
import com.example.friendchat.ui.DB.FriendsData

class ChatsViewModel : ViewModel() {

    private val _friensList = MutableLiveData<List<Friend>>().apply {
        value = FriendsData.getChats()
    }

    val list: LiveData<List<Friend>> = _friensList
}