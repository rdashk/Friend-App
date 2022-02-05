package com.example.friendchat.ui.profile

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.example.friendchat.databinding.FragmentSaveProfileDialogBinding
import android.graphics.drawable.ColorDrawable

import android.R
import android.content.DialogInterface
import android.graphics.Color
import android.util.Log

import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.friendchat.ui.MAIN


private const val ARG_PARAM1 = "Ok"
private const val ARG_PARAM2 = "Cancel"

class SaveProfileDialog : DialogFragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var viewModel: ProfileViewModel
    private var _binding: FragmentSaveProfileDialogBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel =
            ViewModelProvider(this).get(ProfileViewModel::class.java)

        _binding = FragmentSaveProfileDialogBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle("Profile was changed")
                .setMessage("Save changes?")
                .setCancelable(true)
                .setPositiveButton("Ok") { dialog, id ->
                    Log.d("tag", "Profile was changed")
                }
                .setNegativeButton("Cancel"
                ) { dialog, id ->
                    Toast.makeText(
                        activity, "Cancel",
                        Toast.LENGTH_LONG
                    ).show()
                }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SaveProfileDialog().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}