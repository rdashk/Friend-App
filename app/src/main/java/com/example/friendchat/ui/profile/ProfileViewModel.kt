package com.example.friendchat.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.friendchat.ui.DB.Friend
import com.example.friendchat.ui.DB.FriendsData

class ProfileViewModel : ViewModel() {

    private val _profileData = MutableLiveData<List<Friend>>().apply {
        value = FriendsData.getProfileData()
    }
    val profileData: LiveData<List<Friend>> = _profileData
}