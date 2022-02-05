package com.example.friendchat.ui.DB

import android.media.Image

data class Friend(
    var name: String = "",
    var phone: Int = 0,
    // TODO: change to Image
    var photo: String = ""
)
