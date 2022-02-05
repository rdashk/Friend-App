package com.example.friendchat.ui.DB

import java.text.SimpleDateFormat
import java.util.*

data class Message(
    var text: String = "",
    var date: String = SimpleDateFormat("dd/M/yyyy hh:mm:ss").format(Date())
)