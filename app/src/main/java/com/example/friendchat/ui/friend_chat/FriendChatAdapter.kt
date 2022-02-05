package com.example.friendchat.ui.friend_chat

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.friendchat.R
import com.example.friendchat.ui.DB.Message
import com.example.friendchat.ui.DB.Talking
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class FriendChatAdapter : RecyclerView.Adapter<FriendChatAdapter.ChatHolder>() {

    private var messages: List<Message>? = ArrayList()

    // create ViewHolder and initialisation views for list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatHolder {
        return ChatHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.message_item, parent, false)
        )
    }

    // link views with data
    override fun onBindViewHolder(holder: ChatHolder, position: Int) {
        messages?.get(position)?.let { holder.bind(it) }
        holder.itemView.setOnClickListener(object : View.OnClickListener {

            override fun onClick(p0: View?) {
                //TODO: сделать возможность удаления сообщения из бд и из списка
                Log.d("tag", "Click on message item!")
            }
        })
    }

    override fun getItemCount(): Int = messages?.size!!

    fun refreshChat(newList: List<Message>) {
        this.messages = newList
        notifyDataSetChanged()
    }

    // ViewHolder describe elements and its binding to RecyclerView
    class ChatHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var textMessage: TextView? = itemView.findViewById(R.id.message_item_text)
        var timeMessage: TextView? = itemView.findViewById(R.id.message_item_time)

        fun bind(m: Message){
            textMessage?.text = m.text.toString()
            timeMessage?.text = m.date.toString()

        }
    }
}
