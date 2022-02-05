package com.example.friendchat.ui.all_contacts

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.friendchat.AddNewContactActivity
import com.example.friendchat.AllContactsActivity
import com.example.friendchat.R
import com.example.friendchat.databinding.FragmentAllContactsBinding

class AllContactsFragment : Fragment() {

    private lateinit var viewModel: AllContactsViewModel
    private var _binding: FragmentAllContactsBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: AllContactsAdapter

    companion object {
        fun newInstance() = AllContactsFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        viewModel = ViewModelProvider(this)[AllContactsViewModel::class.java]

        _binding = FragmentAllContactsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = AllContactsAdapter()
        val allContactsList = binding.listAllContacts
        allContactsList.layoutManager = LinearLayoutManager(context)
        allContactsList.adapter = adapter

        viewModel.allContacts.observe(viewLifecycleOwner, Observer {

            it?.let {
                adapter.refreshFriends(it)
            }
        })

        binding.addNewContact.setOnClickListener{
            startActivity(Intent(context, AddNewContactActivity::class.java))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}