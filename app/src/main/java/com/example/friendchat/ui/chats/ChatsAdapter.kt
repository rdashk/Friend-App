package com.example.friendchat.ui.chats

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.friendchat.FriendChat
import com.example.friendchat.R
import com.example.friendchat.ui.DB.Friend

class ChatsAdapter(): RecyclerView.Adapter<ChatsAdapter.FriendHolder>() {

    private var friends: List<Friend>? = ArrayList()

    // create ViewHolder and initialisation views for list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendHolder {
        return FriendHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item, parent, false)
        )
    }

    // link views with data
    override fun onBindViewHolder(holder: FriendHolder, position: Int) {
        friends?.get(position)?.let { holder.bind(it) }
        holder.itemView.setOnClickListener(object :View.OnClickListener {

            override fun onClick(p0: View?) {
                val intent = Intent(p0!!.context, FriendChat::class.java)
                intent.putExtra("PersonName", friends?.get(position)?.name)
                startActivity(p0.context,intent, Bundle())
            }
        })
    }

    override fun getItemCount(): Int = friends?.size!!

    fun refreshFriends(newList: List<Friend>) {
        this.friends = newList
        notifyDataSetChanged()
    }

    // ViewHolder describe elements and its binding to RecyclerView
    class FriendHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var friendName: TextView? = itemView.findViewById(R.id.friend_name)
        var friendPhone: TextView? = itemView.findViewById(R.id.friend_phone)

        fun bind(friend: Friend){
            friendName?.text = friend.name
            friendPhone?.text = friend.phone.toString()

        }
    }
}