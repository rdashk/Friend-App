package com.example.friendchat.ui.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.friendchat.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private lateinit var profileViewModel: ProfileViewModel
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    private lateinit var imageProfie: ImageButton

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        profileViewModel =
                ViewModelProvider(this).get(ProfileViewModel::class.java)

        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var name: TextView = binding.profileName
        var phone: TextView = binding.profilePhone
        var image: ImageView = binding.profileImage

        profileViewModel.profileData.observe(viewLifecycleOwner, Observer {
            name.text = it.get(0).name
            phone.text = it.get(0).phone.toString()
            // TODO: загрузка фото профиля

        })

        binding.saveProfile.setOnClickListener{

            //TODO: обновить данные профиля в БД

            val dialogFr = SaveProfileDialog
            fragmentManager?.let { it1 ->
                dialogFr.newInstance("Ok", "Cancel").show(it1,"dialog") }

        }

        imageProfie = binding.profileImage
        imageProfie.setOnClickListener {
            pickImageFromGallery()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun pickImageFromGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_REQUEST_CODE)
    }

    companion object {
        private const val IMAGE_REQUEST_CODE = 100;
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == IMAGE_REQUEST_CODE && resultCode == AppCompatActivity.RESULT_OK){
            imageProfie.setImageURI(data?.data)
        }
    }
}