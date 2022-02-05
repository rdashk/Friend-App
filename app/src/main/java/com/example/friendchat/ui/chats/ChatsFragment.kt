package com.example.friendchat.ui.chats

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.friendchat.databinding.FragmentChatsBinding

class ChatsFragment : Fragment() {

    private lateinit var chatsViewModel: ChatsViewModel
    private var _binding: FragmentChatsBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: ChatsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        chatsViewModel =
            ViewModelProvider(this)[ChatsViewModel::class.java]

        _binding =
            FragmentChatsBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = ChatsAdapter()
        val chatList: RecyclerView = binding.listChats
        chatList.layoutManager = LinearLayoutManager(context)
        chatList.adapter = adapter

        chatsViewModel.list.observe(viewLifecycleOwner, {

            it?.let {
                adapter.refreshFriends(it)
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}