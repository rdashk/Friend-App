package com.example.friendchat.ui.DB

object AllMessagesData {

    fun getMessages() = listOf(
        Talking("Maria", "Darya", Message("How are you?")),
        Talking("Darya", "Maria", Message("I'm ok")),
        Talking("Darya", "Maria", Message("And you?")),
        Talking("Darya", "Petr", Message("Hi!!!")),
        Talking("Darya", "Ann", Message("Hello)")),
        Talking("Sofia", "Darya", Message("Sofia, are you remember about our meeting?")),
    )
}