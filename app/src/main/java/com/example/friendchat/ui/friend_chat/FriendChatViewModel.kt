package com.example.friendchat.ui.friend_chat

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.friendchat.ui.DB.*

class FriendChatViewModel : ViewModel() {

    private val _friendMessages = MutableLiveData<List<Talking>>().apply {
        value = AllMessagesData.getMessages()
    }

    val friendMessages: LiveData<List<Talking>> = _friendMessages
}