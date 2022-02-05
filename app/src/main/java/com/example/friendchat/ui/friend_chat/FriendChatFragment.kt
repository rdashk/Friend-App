package com.example.friendchat.ui.friend_chat

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.friendchat.databinding.FriendChatFragmentBinding
import com.example.friendchat.ui.DB.FriendsData
import com.example.friendchat.ui.DB.Message

class FriendChatFragment : Fragment() {

    private lateinit var viewModel: FriendChatViewModel
    private var _binding: FriendChatFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: FriendChatAdapter
    private lateinit var currentFriend: String

    companion object {
        fun newInstance(friend: String): FriendChatFragment {
            val fragment = FriendChatFragment()
            fragment.currentFriend = friend
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FriendChatFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FriendChatViewModel::class.java)
        var allMessages = binding.listAllMessages

        adapter = FriendChatAdapter()
        allMessages.layoutManager = LinearLayoutManager(context)
        allMessages.adapter = adapter

        viewModel.friendMessages.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            var chatList = mutableListOf<Message>()

            for (m in it) {
                //TODO: заменить на имя текущего пользователя
                if (m.from.equals(FriendsData.getProfileData().get(0).name) && m.to.equals(currentFriend)) {
                    chatList.add(m.message)
                }
                if (m.to.equals(FriendsData.getProfileData().get(0).name) && m.from.equals(currentFriend)) {
                    chatList.add(m.message)
                }
            }
            adapter.refreshChat(chatList)
        })

        binding.sendMessage.setOnClickListener{
            val text_message = binding.toTypeText.text
            //TODO: отправление сообщения в бд, его отображение
            Log.d("tag", text_message.toString())

            binding.toTypeText.text.clear()
        }
    }

}