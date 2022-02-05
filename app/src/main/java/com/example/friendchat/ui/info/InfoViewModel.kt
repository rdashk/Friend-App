package com.example.friendchat.ui.info

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InfoViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This app created for chatting with your friends" +
                "\nCreated by Razmanova Darya" + "\nin 2022"
    }
    val text: LiveData<String> = _text
}