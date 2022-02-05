package com.example.friendchat

import android.Manifest
import android.Manifest.permission.*
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Build.*
import android.os.Build.VERSION.SDK_INT
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton

class AddNewContactActivity : AppCompatActivity() {

    private lateinit var saveContact: FloatingActionButton
    private lateinit var contactImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_new_contact)

        // add action bar with back button
        val actionbar = supportActionBar
        actionbar!!.title = "Add new contact"
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)

        contactImage = findViewById(R.id.new_contact_image)
        contactImage.setOnClickListener{
            pickImageFromGallery()
        }

        saveContact = findViewById(R.id.save_contact)
        saveContact.setOnClickListener{

            // TODO: сохраняем данные в БД
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
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
        if (requestCode == IMAGE_REQUEST_CODE && resultCode == RESULT_OK){
            contactImage.setImageURI(data?.data)
        }
    }
}