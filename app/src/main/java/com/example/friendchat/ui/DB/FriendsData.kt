package com.example.friendchat.ui.DB

object FriendsData {
    fun getChats() = listOf(
        Friend("Maria", 123),
        Friend("Ann", 456),
        Friend("Petr", 789),
        Friend("Sofia", 159),
    )

    fun getAllContacts() = listOf(
        Friend("Maria", 123),
        Friend("Ann", 456),
        Friend("Petr", 789),
        Friend("Sofia", 159),
        Friend("Mom", 111),
        Friend("Dad", 222),
        Friend("Brother", 333),
        Friend("Sister", 444)
    )

    fun getProfileData() = listOf(
        Friend("Darya",+788)
    )
}
